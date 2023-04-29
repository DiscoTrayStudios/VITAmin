package model;

import SQLite.DB;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.*;
import java.util.regex.Pattern;

public class DataBase {

    /**
     * Called when the program is started to make a database if one does not exist
     * @throws SQLException
     */

    public static void initializeDB() throws SQLException {
        if(!DB.dbExists()){
            String Table1 = "CREATE TABLE CLIENT(ID text NOT NULL , SIDN text, L4SSN text, FIRSTNAME text, LASTNAME text, DOB text, EFIN text, PRIMARY KEY(ID));";
            String Table2 = "CREATE TABLE DEMOGRAPHIC(CLIENTID text NOT NULL , TAXYEAR numeric NOT NULL , CITY text, STATE text, ZIP text, PRIMARYSECONDARY60PLUS numeric, RESIDENCY text, PRIMARY KEY(CLIENTID, TAXYEAR), FOREIGN KEY(CLIENTID) REFERENCES CLIENT(ID), FOREIGN KEY(TAXYEAR) REFERENCES TAXYEAR(TAXYEAR));";
            String Table3 = "CREATE TABLE RETURNDATA(CLIENTID text NOT NULL , TAXYEAR numeric NOT NULL , FEDERAL numeric NOT NULL , ACCEPTEDDATE text, RETURNTYPE text, FILINGSTATUS text, TOTALIRSEXEMPTIONS numeric, REFUND numeric, PAPERSTATE numeric, PAPERFED numeric, REQUESTINGDD numeric, AGI numeric, CREATEDDATE text, ADDCTC numeric, POUNDSAVINGSBONDS text, SAVINGSBONDS text, EIC numeric, CHILDTAXCREDIT numeric, EDUCATIONTAXCREDIT numeric, ELDERLYCREDIT numeric, TOTALRESPPAYMENT numeric, TOTALADVPTCREPAYMENT numeric, AVERAGEADVPTCPAYMENT numeric, TOTALPTC numeric, BALANCEDUE numeric, ITIN numeric, EXEMPTION7 numeric, FULLYEARCOVERAGE numeric, FORM8888 numeric, SCHEDULEA numeric, SCHEDULEB numeric, SCHEDULEC numeric, SCHEDULECEZ numeric, SCHEDULED numeric, SCHEDULEE numeric, SCHEDULEF numeric, SCHEDULEH numeric, SCHEDULER numeric, SCHEDULESETP numeric, SCHEDULESESP numeric, AGENCYID text, STATEWITHHOLDING numeric, STATETAXLIABILITY numeric, AAMOUNTTAXPAYERISPLANNINGTOSAVE numeric, PRIMARY KEY(CLIENTID, TAXYEAR, FEDERAL), FOREIGN KEY(CLIENTID) REFERENCES CLIENT(ID), FOREIGN KEY(TAXYEAR) REFERENCES TAXYEAR(TAXYEAR));";
            String Table4 = "CREATE TABLE QUESTION(CLIENTID text NOT NULL , TAXYEAR numeric NOT NULL , CONSENTTODISCLOSETAXRETURN numeric, CONSENTTODISCLOSETAXPAYERD numeric, CONSENTTOUSETAXPAYERDATA numeric, CONSENTTODISCLOSETAXRETURN1 numeric, CONSENTTODISCLOSETAXRETURN2 numeric, CONSENTTODISCLOSETAXRETURN3 numeric, CONSENTTODISCLOSETAXRETURN4 numeric, QUESTIONS1 text, QUESTIONS2 text, QUESTIONS3 text, QUESTIONS4 text, QUESTIONS5 text, QUESTIONS6 text, QUESTIONS7 text, QUESTIONS8 text, QUESTIONS9 text, QUESTIONA text, QUESTIONB text, QUESTIONC text, QUESTIOND text, QUESTIONE text, QUESTIONF text, QUESTIONG text, QUESTIONH text, QUESTIONI text, QUESTIONJ text, QUESTIONK text, PERSONS5ANDUNDER numeric, PERSONSAGE6TO18 numeric, PERSONSAGE65PLUS numeric, PRIMARY KEY(CLIENTID, TAXYEAR), FOREIGN KEY(CLIENTID) REFERENCES CLIENT(ID), FOREIGN KEY(TAXYEAR) REFERENCES TAXYEAR(TAXYEAR));";
            String Table5 = "CREATE TABLE TAXYEAR(TAXYEAR numeric NOT NULL , PRIMARY KEY(TAXYEAR));";

            DB.executeCreateQuery(Table1);
            DB.executeCreateQuery(Table2);
            DB.executeCreateQuery(Table3);
            DB.executeCreateQuery(Table4);
            DB.executeCreateQuery(Table5);
        }
    }


    // Regex code from: https://codeahoy.com/q/11/check-if-a-string-is-numeric-in-java
    private static final Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");

    /**
     * Check if a String is a number.
     * Utility function for checking a String to insert as an integer into the
     * SQLite database.
     * @param str Input string
     * @return boolean determining if the input string is an integer.
     */
    public static boolean isNumeric(String str) {
        if (str == null) {
            return false;
        }

        return pattern.matcher(str).matches();
    }

    /*
     * ==================================================================================
     * CLIENT FUNCTIONS
     * ==================================================================================
     */

    /**
     * Insert a client into the Client table of the database.
     * Inserts a client if the client associated with the clientID
     * does not already exist, otherwise the client with the associated
     * clientID is updated.
     * @param clientData Properties associated with the client.
     * @param clientID ID of the client.
     */
    public static void insertClient(HashMap<String, String> clientData, String clientID) {
        // Grab client data for new or existing client in the table.
        String EFIN = clientData.get("EFIN");
        String SIDN = "";
        String firstName = clientData.get("FIRSTNAME");
        String lastName = clientData.get("LASTNAME");
        int last4SS;
        if (clientData.containsKey("SIDN")){
            SIDN = clientData.get("SIDN");
        }
        if (clientData.containsKey("LAST4")){
            last4SS = Integer.parseInt(clientData.get("LAST4"));
        }else if (clientData.containsKey("LAST4SS")){
            last4SS = Integer.parseInt(clientData.get("LAST4SS"));
        } else{
            last4SS = Integer.parseInt(clientData.get("L4SSN"));
        }
        // Not all CSVs contain the DoB of a client.
        String dob = "";
        if (clientData.containsKey("DOB") || clientData.containsKey("DATEOFBIRTH")) {
            dob = clientData.containsKey("DOB")
                    ? clientData.get("DOB")
                    : clientData.get("DATEOFBIRTH");
        }
        // Get the row where the clientID exists in the Client table (if it does exist).
        try (ResultSet query = DB.executeQuery(String.format("SELECT * FROM CLIENT WHERE ID = '%s';", clientID))) {
            // If the client already exists, update the necessary fields.
            if (query.next()){
                // Reset pointer of the ResultSet (somewhat redundant since there should only be one or no elements
                // but a good habit nonetheless).
                query.beforeFirst();

                // Update the fields.
                if (firstName != null){
                    updateFirstName(clientID, firstName);
                }
                if (lastName != null){
                    updateLastName(clientID, lastName);
                }
                if (dob != null){
                    updateDOB(clientID, dob);
                }
                if (EFIN != null){
                    updateEFIN(clientID, EFIN);
                }
                if (SIDN != null){
                    updateSIDN(clientID, SIDN);
                }
                updateLast4SS(clientID, String.valueOf(last4SS));
            }else {
                // Create an update SQL command to insert a new row into the Client table.
                String sqlStmt = String.format("INSERT INTO CLIENT (ID, FIRSTNAME, LASTNAME, DOB, L4SSN, EFIN, SIDN)"
                                + "\n" + "VALUES ('%1$s', '%2$s', '%3$s', '%4$s', %5$d, '%6$s', '%7$s');", clientID,
                                firstName, lastName, dob, last4SS, EFIN, SIDN);
                try {
                    // Execute the SQL statement.
                    DB.update(sqlStmt);
                } catch (Exception e) {
                    System.out.print("Error occurred while UPDATE Operation: " + e);
                    throw e;
                }
            }
        }catch (Exception e){
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
        }
    }

    /**
     * Update first name of a Client.
     * @param clientID String, the ID of the Client.
     * @param firstName String, name that the first name will be changed to.
     * @throws SQLException Unable to retrieve data, loss of connection, or other errors.
     */
    private static void updateFirstName(String clientID, String firstName) throws SQLException{
        String updateStmt =
                "UPDATE CLIENT\n" +
                        "SET FIRSTNAME = '" + firstName + "'\n" +
                        "WHERE ID = '" + clientID + "';";
        System.out.println(updateStmt);
        try{
            DB.update(updateStmt);
        }catch(Exception e){
            System.out.print("Error occurred while UPDATE Operation: " + e);
            throw e;
        }
    }

    /**
     * Update last name of a Client.
     * @param clientID String, the ID of the Client.
     * @param lastName String, name that the last name will be changed to.
     * @throws SQLException Unable to retrieve data, loss of connection, or other errors.
     */
    private static void updateLastName(String clientID, String lastName) throws SQLException{
        String updateStmt =
                "UPDATE CLIENT\n" +
                        "SET LASTNAME = '" + lastName + "'\n" +
                        "WHERE ID = '" + clientID + "';";
        try{
            DB.update(updateStmt);
        }catch(Exception e){
            System.out.print("Error occurred while UPDATE Operation: " + e);
            throw e;
        }
    }

    /**
     * Update Date of Birth of a Client.
     * @param clientID String, the ID of the Client.
     * @param dob String, date that the date of birth will be changed to.
     * @throws SQLException Unable to retrieve data, loss of connection, or other errors.
     */
    private static void updateDOB(String clientID, String dob) throws SQLException{
        String updateStmt =
                "UPDATE CLIENT\n" +
                        "SET DOB = '" + dob + "'\n" +
                        "WHERE ID = '" + clientID + "';";
        try{
            DB.update(updateStmt);
        }catch(Exception e){
            System.out.print("Error occurred while UPDATE Operation: " + e);
            throw e;
        }
    }

    /**
     * Update Last4SS of a Client.
     * @param clientID String, the ID of the Client.
     * @param last4SS String, number that the last 4 SS numbers will be changed to.
     * @throws SQLException Unable to retrieve data, loss of connection, or other errors.
     */
    private static void updateLast4SS(String clientID, String last4SS) throws SQLException{
        String updateStmt =
                "UPDATE CLIENT\n" +
                        "SET L4SSN = " + last4SS + "\n" +
                        "WHERE ID = '" + clientID + "';";
        try{
            DB.update(updateStmt);
        }catch(Exception e){
            System.out.print("Error occurred while UPDATE Operation: " + e);
            throw e;
        }
    }

    /**
     * Update EFIN of a Client.
     * @param clientID String, the ID of the Client.
     * @param efin String, EFIN that the last EFIN will be changed to.
     * @throws SQLException Unable to retrieve data, loss of connection, or other errors.
     */
    private static void updateEFIN(String clientID, String efin) throws SQLException{
        String updateStmt =
                "UPDATE CLIENT\n" +
                        "SET EFIN = '" + efin + "'\n" +
                        "WHERE ID = '" + clientID + "';";
        try{
            DB.update(updateStmt);
        }catch(Exception e){
            System.out.print("Error occurred while UPDATE Operation: " + e);
            throw e;
        }
    }

    /**
     * Update last name of a Client.
     * @param clientID String, the ID of the Client.
     * @param sidn String, SIDN that the SIDN will be changed to.
     * @throws SQLException Unable to retrieve data, loss of connection, or other errors.
     */
    private static void updateSIDN(String clientID, String sidn) throws SQLException{
        String updateStmt =
                "UPDATE CLIENT\n" +
                        "SET SIDN = '" + sidn + "'\n" +
                        "WHERE ID = '" + clientID + "';";
        try{
            DB.update(updateStmt);
        }catch(Exception e){
            System.out.print("Error occurred while UPDATE Operation: " + e);
            throw e;
        }
    }



    /*
     * ==================================================================================
     * DEMOGRAPHIC FUNCTIONS
     * ==================================================================================
     */

    static HashSet<String>demoFields = new HashSet<>(Arrays.asList(
            "CITY",
            "STATE",
            "ZIP",
            "RESIDENCY",
            "PRIMARYORSECONDARY60"
    ));

    /**
     * Insert a demographic into the DEMOGRAPHIC table of the database.
     * Inserts a demographic if the demographic associated with the clientID
     * does not already exist, otherwise the demographic with the associated
     * clientID is updated.
     * @param clientData Properties associated with the demographic.
     * @param clientID ID of the demographic's client.
     */
    public static void insertDemographic(HashMap<String, String> clientData, String clientID){
        // Grab demographic data for new or existing demographic in the demographic table.
        // Not guaranteed that each field is in clientData, so must instantiate variables.
        HashMap<String, String> demoFieldMap = new HashMap<>();
        for (String field: clientData.keySet()){
            if (demoFields.contains(field)){
                if (field.equals("PRIMARYORSECONDARY60")){
                    demoFieldMap.put("PRIMARYSECONDARY60PLUS", clientData.get(field));
                } else {
                    demoFieldMap.put(field, clientData.get(field));
                }
            }
        }
        try (ResultSet query = DB.executeQuery(String.format("SELECT * FROM DEMOGRAPHIC WHERE CLIENTID = '%1$s'" +
                        "AND TAXYEAR = '%2$s';",
                clientID,
                clientData.get("TAXYEAR")))) {
            // If the client already exists, update the necessary fields.
            if (query.next()) {
                // Reset pointer of the ResultSet (somewhat redundant since there should only be one or no elements
                // but a good habit nonetheless).
                query.beforeFirst();
            } else {
                StringBuilder insertStmt = new StringBuilder("INSERT INTO DEMOGRAPHIC (CLIENTID");
                StringBuilder intoStmt = new StringBuilder("VALUES ('" + clientID + "'");
                if (!demoFieldMap.isEmpty()) {
                    demoFieldMap.put("TAXYEAR", clientData.get("TAXYEAR"));
                    for (String field : demoFieldMap.keySet()) {
                        if (!demoFieldMap.get(field).equals("")) {
                            insertStmt.append(", ").append(field);
                            if (isNumeric(demoFieldMap.get(field))) {
                                intoStmt.append(", ").append(demoFieldMap.get(field));
                            } else {
                                intoStmt.append(", ").append("'").append(demoFieldMap.get(field)).append("'");
                            }
                        }
                    }
                    insertStmt.append(") \n");
                    intoStmt.append((");"));
                    try {
                        // Execute the SQL statement.
                        DB.update(insertStmt + intoStmt.toString());
                    } catch (Exception e) {
                        System.out.print("Error occurred while UPDATE Operation: " + e);
                        throw e;
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Unable to execute DEMOGRAPHIC query: " + e);
        }
    }


    /**
     * Update State of a DEMOGRAPHIC.
     * @param demographicID String, the ID of the DEMOGRAPHIC.
     * @param ps60p String, number representing sum of 60+ year olds between the primary
     *              and secondary filers.
     * @throws SQLException Unable to retrieve data, loss of connection, or other errors.
     */
    public static void updatePrimarySecondary60Plus(String demographicID, String ps60p) throws SQLException{
        String updateStmt =
                "UPDATE DEMOGRAPHIC\n" +
                        "SET PRIMARYSECONDARY60PLUS = '" + ps60p + "'\n" +
                        "WHERE CLIENTID = '" + demographicID + "';";
        try{
            DB.update(updateStmt);
        }catch(Exception e){
            System.out.print("Error occurred while UPDATE Operation: " + e);
            throw e;
        }
    }


    /*
     * ==================================================================================
     * QUESTION FUNCTIONS
     * ==================================================================================
     */

    static HashSet<String> questionFields = new HashSet<>(Arrays.asList(
            "CONSENTTODISCLOSETAXRETURN",
            "CONSENTTODISCLOSETAXPAYERD",
            "CONSENTTOUSETAXPAYERDATA",
            "CONSENTTODISCLOSETAXRETURN1",
            "CONSENTTODISCLOSETAXRETURN2",
            "CONSENTTODISCLOSETAXRETURN3",
            "CONSENTTODISCLOSETAXRETURN4",
            "QUESTIONS1",
            "QUESTIONS2",
            "QUESTIONS3",
            "QUESTIONS4",
            "QUESTIONS5",
            "QUESTIONS6",
            "QUESTIONS7",
            "QUESTIONS8",
            "QUESTIONS9",
            "QUESTIONA",
            "QUESTIONB",
            "QUESTIONC",
            "QUESTIOND",
            "QUESTIONE",
            "QUESTIONF",
            "QUESTIONG",
            "QUESTIONH",
            "QUESTIONI",
            "QUESTIONJ",
            "QUESTIONK",
            "PERSONS5ANDUNDER",
            "PERSONSAGE6TO18",
            "PERSONSAGE65PLUS"
            ));

    static String[] actualQuestions = new String[] {
            "1WOULDYOUSAYYOUCANCARRY",
            "2WOULDYOUSAYYOUCANREAD",
            "3DOYOUORANYMEMBEROFYOU",
            "4AREYOUORYOURSPOUSEAVE",
            "5YOURRACE",
            "6YOURSPOUSESRACE",
            "7YOURETHNICITY",
            "8YOURSPOUSESETHNICITY",
            "9WASTHETAXPAYERPHYSICALLY",
            "AAREYOUPLANNINGTOSAVEAN",
            "BIFYOUSETASIDEMONEYFROM",
            "CWHICHOFTHEFOLLOWINGBEST",
            "DINTHEPAST12MONTHSHAVE",
            "EINATYPICALMONTHWHICHO",
            "FSUPPOSETHATYOUHAVEANEM",
            "GBECAUSEOFMYMONEYSITUATI",
            "HIAMJUSTGETTINGBYFINANC",
            "IIAMCONCERNEDTHATTHEMON",
            "JIHAVEMONEYLEFTOVERATT",
            "KMYFINANCESCONTROLMYLIFE",
            "PERSONSONTAXRETURNAGE5AN",
            "PERSONSONTAXRETURNAGE618",
            "PERSONSONTAXRETURNAGE65"
    };


    private static String formatQuestions(String unformattedString){
        if (Character.isDigit(unformattedString.charAt(0))){
            return "QUESTIONS" + unformattedString.charAt(0);
        } else {
            return switch (unformattedString) {
                case "AAREYOUPLANNINGTOSAVEAN" -> "QUESTIONA";
                case "BIFYOUSETASIDEMONEYFROM" -> "QUESTIONB";
                case "CWHICHOFTHEFOLLOWINGBEST" -> "QUESTIONC";
                case "DINTHEPAST12MONTHSHAVE" -> "QUESTIOND";
                case "EINATYPICALMONTHWHICHO" -> "QUESTIONE";
                case "FSUPPOSETHATYOUHAVEANEM" -> "QUESTIONF";
                case "GBECAUSEOFMYMONEYSITUATI" -> "QUESTIONG";
                case "HIAMJUSTGETTINGBYFINANC" -> "QUESTIONH";
                case "IIAMCONCERNEDTHATTHEMON" -> "QUESTIONI";
                case "JIHAVEMONEYLEFTOVERATT" -> "QUESTIONJ";
                case "KMYFINANCESCONTROLMYLIFE" -> "QUESTIONK";
                case "PERSONSONTAXRETURNAGE5AN" -> "PERSONS5ANDUNDER";
                case "PERSONSONTAXRETURNAGE618" -> "PERSONSAGE6TO18";
                case "PERSONSONTAXRETURNAGE65" -> "PERSONSAGE65PLUS";
                default -> null;
            };
        }
    }

    public static void insertQuestion(HashMap<String, String> clientData, String clientID) throws Exception{
        //For each key in the field map
        //If the key matches one of the fields that we have instantiated, put it into our field map.
        //However, if the field is one of the poorly formatted questions, reformat the question name
        //to match the new name that we created ("7YOURETHNICITY" --> "QUESTIONS7") and insert the
        //value of the question into the database.
        //If the field is a consent to disclose tax return, since there are multiple of the same names,
        //need to assign it to the four different fields reserved for it.
        HashMap<String, String> questionFieldMap = new HashMap<>();
        for (String field: clientData.keySet()){
            if (questionFields.contains(field)){
                questionFieldMap.put(field, clientData.get(field));
            }
            //Finding exact match of String occurrence in an Array:
            //https://stackoverflow.com/questions/68115849/find-exact-match-from-array
            else if (Arrays.stream(actualQuestions)
                    .anyMatch(word -> Pattern
                            .compile("(?<![a-z-])" + Pattern.quote(word) + "(?![a-z-])",
                                     Pattern.CASE_INSENSITIVE)
                            .matcher(field)
                            .find())){
                questionFieldMap.put(formatQuestions(field), clientData.get(field).replace("'", "`"));
            } else if (field.contains("CONSENTTODISCLOSETAXRETURN")){
                if (questionFieldMap.get("CONSENTTODISCLOSETAXRETURN").equals("")){
                    questionFieldMap.put("CONSENTTODISCLOSETAXRETURN", clientData.get(field));
                }
                else if (questionFieldMap.get("CONSENTTODISCLOSETAXRETURN1").equals("")){
                    questionFieldMap.put("CONSENTTODISCLOSETAXRETURN1", clientData.get(field));
                }
                else if (questionFieldMap.get("CONSENTTODISCLOSETAXRETURN2").equals("")){
                    questionFieldMap.put("CONSENTTODISCLOSETAXRETURN2", clientData.get(field));
                }
                else if (questionFieldMap.get("CONSENTTODISCLOSETAXRETURN3").equals("")){
                    questionFieldMap.put("CONSENTTODISCLOSETAXRETURN3", clientData.get(field));
                }
                else {
                    questionFieldMap.put("CONSENTTODISCLOSETAXRETURN4", clientData.get(field));
                }
            }
        }
        try (ResultSet query = DB.executeQuery(String.format("SELECT * FROM QUESTION WHERE CLIENTID = '%1$s'" +
                        "AND TAXYEAR = '%2$s';",
                clientID,
                clientData.get("TAXYEAR")))) {
            // If the client already exists, update the necessary fields.
            if (query.next()) {
                // Reset pointer of the ResultSet (somewhat redundant since there should only be one or no elements
                // but a good habit nonetheless).
                query.beforeFirst();
            } else {
                StringBuilder insertStmt = new StringBuilder("INSERT INTO QUESTION (CLIENTID");
                StringBuilder intoStmt = new StringBuilder("VALUES ('" + clientID + "'");
                if (!questionFieldMap.isEmpty()) {
                    questionFieldMap.put("TAXYEAR", clientData.get("TAXYEAR"));
                    for (String field : questionFieldMap.keySet()) {
                        if (!questionFieldMap.get(field).equals("")) {
                            insertStmt.append(", ").append(field);
                            if (isNumeric(questionFieldMap.get(field))) {
                                intoStmt.append(", ").append(questionFieldMap.get(field));
                            } else {
                                intoStmt.append(", ").append("'").append(questionFieldMap.get(field)).append("'");
                            }
                        }
                    }
                    insertStmt.append(") \n");
                    intoStmt.append((");"));
                    System.out.println(insertStmt + intoStmt.toString());
                    try {
                        // Execute the SQL statement.
                        DB.update(insertStmt + intoStmt.toString());
                    } catch (Exception e) {
                        System.out.print("Error occurred while UPDATE Operation: " + e);
                        throw e;
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Unable to execute QUESTION query: " + e);
            throw e;
        }
    }


    /*
     * ==================================================================================
     * RETURN DATA FUNCTIONS
     * ==================================================================================
     */

    static HashSet<String> returnDataFields = new HashSet<>(Arrays.asList(
            "CREATEDDATETIME",
            "TAXYEAR",
            "FEDERAL",
            "EIC",
            "ACCEPTEDDATE",
            "RETURNTYPE",
            "FILINGSTATUS",
            "TOTALIRSEXEMPTIONS",
            "REFUND",
            "PAPERSTATE",
            "PAPERFEDERAL",
            "REQUESTINGDD",
            "AGI",
            "ADDCTC",
            "SAVINGSBONDS", // #SAVINGSBONDS
            "SAVINGBOND",
            "CHILDAXCREDIT",
            "EDUCATIONTAXCREDIT",
            "ELDERLYCREDIT",
            "TOTALRESPPYMENT",
            "TOTALADVPTCREPAYMENT",
            "AVERAGEADVPTCPAYMENT",
            "TOTALPTC",
            "BALANCEDUE",
            "ITIN",
            "EXEMPTION7",
            "FULLYEARCOVERAGE",
            "FORM8888",
            "SCHEDULEA",
            "SCHEDULEB",
            "SCHEDULEC",
            "SCHEDULECEZ",
            "SCHEDULED",
            "SCHEDULEE",
            "SCHEDULEF",
            "SCHEDULEH",
            "SCHEDULER",
            "SCHEDULESETP",
            "SCHEDULESESP",
            "AGENCYID",
            "STATEWITHOLDING",
            "STATETAXLIABILITY",
            "AAMOUNTTAXPAYERISPLANNINGTOSAVE"
    ));


    /**
     * Insert a return into the Return table of the database.
     * Inserts a return if the return associated with the clientID
     * does not already exist, otherwise the return with the associated
     * clientID is updated.
     * @param clientData Properties associated with the return.
     * @param clientID ID of the return's client.
     */
    public static void insertReturnData(HashMap<String, String> clientData, String clientID){
        HashMap<String, String> returnFieldMap = new HashMap<>();
        if(clientData.containsKey("FEDERAL") && !clientData.get("FEDERAL").equals("2")) {
            for (String field : clientData.keySet()) {
                if (returnDataFields.contains(field)) {
                    switch (field) {
                        case "PAPERFEDERAL" -> returnFieldMap.put("PAPERFED", clientData.get(field));
                        case "SAVINGSBONDS" -> returnFieldMap.put("POUNDSAVINGSBONDS", clientData.get(field));
                        case "SAVINGBOND" -> returnFieldMap.put("SAVINGSBONDS", clientData.get(field));
                        case "TOTALRESPPYMENT" -> returnFieldMap.put("TOTALRESPPAYMENT", clientData.get(field));
                        case "CREATEDDATETIME" -> returnFieldMap.put("CREATEDDATE", clientData.get(field));
                        default -> returnFieldMap.put(field, clientData.get(field));
                    }
                }
            }
            try (ResultSet query = DB.executeQuery(String.format("SELECT * FROM RETURNDATA WHERE CLIENTID = '%1$s'" +
                            "AND TAXYEAR = '%2$s' AND FEDERAL = '%3$s';",
                    clientID,
                    clientData.get("TAXYEAR"),
                    clientData.get("FEDERAL")))) {
                // If the client already exists, update the necessary fields.
                if (query.next()) {
                    // Reset pointer of the ResultSet (somewhat redundant since there should only be one or no elements
                    // but a good habit nonetheless).
                    query.beforeFirst();
                } else {
                    StringBuilder insertStmt = new StringBuilder("INSERT INTO RETURNDATA (CLIENTID");
                    StringBuilder intoStmt = new StringBuilder("VALUES ('" + clientID + "'");
                    if (!returnFieldMap.isEmpty()) {
                        for (String field : returnFieldMap.keySet()) {
                            if (!returnFieldMap.get(field).equals("")) {
                                insertStmt.append(", ").append(field);
                                if (isNumeric(returnFieldMap.get(field))) {
                                    intoStmt.append(", ").append(returnFieldMap.get(field));
                                } else {
                                    intoStmt.append(", ").append("'").append(returnFieldMap.get(field)).append("'");
                                }
                            }
                        }
                        insertStmt.append(") \n");
                        intoStmt.append((");"));
                        try {
                            // Execute the SQL statement.
                            DB.update(insertStmt + intoStmt.toString());
                        } catch (Exception e) {
                            System.out.print("Error occurred while UPDATE Operation: " + e);
                        }
                    }
                }
            } catch (Exception e) {
                System.out.println("Unable to execute RETURNDATA query: " + e);
            }
        }
    }


    /*
     * ==================================================================================
     * TAX YEAR FUNCTIONS
     * ==================================================================================
     */

    public static void insertTaxYear(HashMap<String, String> clientData){
        String taxYear = "";
        if (clientData.containsKey("TAXYEAR")){
            taxYear = clientData.get("TAXYEAR");
        }
        if (!taxYear.equals("")){
            try (ResultSet query = DB.executeQuery(String.format("SELECT * FROM TAXYEAR WHERE TAXYEAR = '%s';", taxYear))) {
                // If the client already exists, update the necessary fields.
                if (query.next()) {
                    // Reset pointer of the ResultSet (somewhat redundant since there should only be one or no elements
                    // but a good habit nonetheless).
                    query.beforeFirst();
                } else {
                    // Create an update SQL command to insert a new row into the Client table.
                    String sqlStmt = "INSERT INTO TAXYEAR (TAXYEAR)\n" +
                            "VALUES (" + taxYear + ");";
                    try {
                        // Execute the SQL statement.
                        DB.update(sqlStmt);
                    } catch (Exception e) {
                        System.out.print("Error occurred while UPDATE Operation: " + e);
                    }
                }
            } catch (Exception e) {
                System.out.println("Unable to insert Tax Year: " + e);
            }
        }
    }



    /*
    ==================================================================================
    SEARCH/GET FUNCTIONS
    ==================================================================================
     */

    /**
     * Translates a result set into an ObservableList of Data Objects
     * @param rs
     * @param demographic
     * @param returnData
     * @param client
     * @return
     * @throws SQLException
     */
    private static ObservableList<DataObject> getDataObjectList(ResultSet rs, boolean demographic, boolean returnData, boolean client, boolean question, boolean taxYear) throws SQLException{
        ObservableList<DataObject> dataObjectList = FXCollections.observableArrayList();
        ResultSetMetaData rsmd = rs.getMetaData();
        while(rs.next()){
            DataObject dataObject = new DataObject();
            if(client){
                dataObject.setSidn(rs.getString("SIDN"));
                dataObject.setL4SSN(rs.getString("L4SSN"));
                dataObject.setFirstName(rs.getString("FIRSTNAME"));
                dataObject.setLastName(rs.getString("LASTNAME"));
                dataObject.setDoB(rs.getString("DOB"));
                dataObject.setEfin(rs.getString("EFIN"));
            }
            if(demographic){
                dataObject.setTaxYear(rs.getInt("TAXYEAR"));
                dataObject.setCity(rs.getString("CITY"));
                dataObject.setState(rs.getString("STATE"));
                dataObject.setZip(rs.getString("ZIP"));
                dataObject.setPrimarySecondary60Plus(rs.getDouble("PRIMARYSECONDARY60PLUS"));
                dataObject.setResidency(rs.getString("RESIDENCY"));
            }
            if(returnData){
                dataObject.setTaxYear(rs.getInt("TAXYEAR"));
                dataObject.setFederal(rs.getBoolean("FEDERAL"));
                dataObject.setAcceptedDate(rs.getString("ACCEPTEDDATE"));
                dataObject.setReturnType(rs.getString("RETURNTYPE"));
                dataObject.setFilingStatus(rs.getString("FILINGSTATUS"));
                dataObject.setTotalIrsExemptions(rs.getDouble("TOTALIRSEXEMPTIONS"));
                dataObject.setRefund(rs.getDouble("REFUND"));
                dataObject.setPaperState(rs.getBoolean("PAPERSTATE"));
                dataObject.setPaperFed(rs.getBoolean("PAPERFED"));
                dataObject.setRequestingDd(rs.getBoolean("REQUESTINGDD"));
                dataObject.setAgi(rs.getDouble("AGI"));
                dataObject.setCreatedDate(rs.getString("CREATEDDATE"));
                dataObject.setAddctc(rs.getDouble("ADDCTC"));
                dataObject.setPoundSavingsBonds(rs.getString("POUNDSAVINGSBONDS"));
                dataObject.setSavingsBonds(rs.getString("SAVINGSBONDS"));
                dataObject.setEic(rs.getDouble("EIC"));
                dataObject.setChildTaxCredit(rs.getDouble("CHILDTAXCREDIT"));
                dataObject.setEducationTaxCredit(rs.getDouble("EDUCATIONTAXCREDIT"));
                dataObject.setElderlyCredit(rs.getDouble("ELDERLYCREDIT"));
                dataObject.setTotalRespPayment(rs.getDouble("TOTALRESPPAYMENT"));
                dataObject.setTotalAdvptcRepayment(rs.getDouble("TOTALADVPTCREPAYMENT"));
                dataObject.setAverageAdvptcPayment(rs.getDouble("AVERAGEADVPTCPAYMENT"));
                dataObject.setTotalPtc(rs.getDouble("TOTALPTC"));
                dataObject.setBalanceDue(rs.getDouble("BALANCEDUE"));
                dataObject.setItin(rs.getBoolean("ITIN"));
                dataObject.setExemption7(rs.getBoolean("EXEMPTION7"));
                dataObject.setFullYearCoverage(rs.getBoolean("FULLYEARCOVERAGE"));
                dataObject.setForm8888(rs.getBoolean("FORM8888"));
                dataObject.setScheduleA(rs.getBoolean("SCHEDULEA"));
                dataObject.setScheduleB(rs.getBoolean("SCHEDULEB"));
                dataObject.setScheduleC(rs.getBoolean("SCHEDULEC"));
                dataObject.setScheduleCEz(rs.getBoolean("SCHEDULECEZ"));
                dataObject.setScheduleD(rs.getBoolean("SCHEDULED"));
                dataObject.setScheduleE(rs.getBoolean("SCHEDULEE"));
                dataObject.setScheduleF(rs.getBoolean("SCHEDULEF"));
                dataObject.setScheduleH(rs.getBoolean("SCHEDULEH"));
                dataObject.setScheduleR(rs.getBoolean("SCHEDULER"));
                dataObject.setScheduleSetP(rs.getBoolean("SCHEDULESETP"));
                dataObject.setScheduleSesP(rs.getBoolean("SCHEDULESESP"));
                dataObject.setAgencyId(rs.getString("AGENCYID"));
                dataObject.setStateWithholding(rs.getDouble("STATEWITHHOLDING"));
                dataObject.setStateTaxLiability(rs.getDouble("STATETAXLIABILITY"));
                dataObject.setAAmountTaxpayerIsPlanningToSave(rs.getDouble("AAMOUNTTAXPAYERISPLANNINGTOSAVE"));
            }
            if(question){
                dataObject.setTaxYear(rs.getInt("TAXYEAR"));
                dataObject.setConsentToDiscloseTaxReturn(rs.getBoolean("CONSENTTODISCLOSETAXRETURN"));
                dataObject.setConsentToDiscloseTaxpayerD(rs.getBoolean("CONSENTTODISCLOSETAXPAYERD"));
                dataObject.setConsentToUseTaxpayerData(rs.getBoolean("CONSENTTOUSETAXPAYERDATA"));
                dataObject.setConsentToDiscloseTaxReturn1(rs.getBoolean("CONSENTTODISCLOSETAXRETURN1"));
                dataObject.setConsentToDiscloseTaxReturn2(rs.getBoolean("CONSENTTODISCLOSETAXRETURN2"));
                dataObject.setConsentToDiscloseTaxReturn3(rs.getBoolean("CONSENTTODISCLOSETAXRETURN3"));
                dataObject.setConsentToDiscloseTaxReturn4(rs.getBoolean("CONSENTTODISCLOSETAXRETURN4"));
                dataObject.setQuestions1(rs.getString("QUESTIONS1"));
                dataObject.setQuestions2(rs.getString("QUESTIONS2"));
                dataObject.setQuestions3(rs.getString("QUESTIONS3"));
                dataObject.setQuestions4(rs.getString("QUESTIONS4"));
                dataObject.setQuestions5(rs.getString("QUESTIONS5"));
                dataObject.setQuestions6(rs.getString("QUESTIONS6"));
                dataObject.setQuestions7(rs.getString("QUESTIONS7"));
                dataObject.setQuestions8(rs.getString("QUESTIONS8"));
                dataObject.setQuestions9(rs.getString("QUESTIONS9"));
                dataObject.setQuestionA(rs.getString("QUESTIONA"));
                dataObject.setQuestionB(rs.getString("QUESTIONB"));
                dataObject.setQuestionC(rs.getString("QUESTIONC"));
                dataObject.setQuestionD(rs.getString("QUESTIOND"));
                dataObject.setQuestionE(rs.getString("QUESTIONE"));
                dataObject.setQuestionF(rs.getString("QUESTIONF"));
                dataObject.setQuestionG(rs.getString("QUESTIONG"));
                dataObject.setQuestionH(rs.getString("QUESTIONH"));
                dataObject.setQuestionI(rs.getString("QUESTIONI"));
                dataObject.setQuestionJ(rs.getString("QUESTIONJ"));
                dataObject.setQuestionK(rs.getString("QUESTIONK"));
                dataObject.setPersons5AndUnder(rs.getDouble("PERSONS5ANDUNDER"));
                dataObject.setPersonsAge6To18(rs.getDouble("PERSONSAGE6TO18"));
                dataObject.setPersonsAge65Plus(rs.getDouble("PERSONSAGE65PLUS"));
            }
            if(taxYear){
                for(int i = 1; i <= rsmd.getColumnCount(); i++){
                    if(rsmd.getColumnLabel(i).equals("TAXYEAR") && rs.getInt(i) > 0){
                        dataObject.setTaxYear(rs.getInt(i));
                        break;
                    }
                }
            }

            dataObjectList.add(dataObject);
        }
        return dataObjectList;

    }


    /**
     * searches the database for data based on the given conditions
     * @param condition the condition for the SQL statement
     * @param included the included tables
     * @return the results of the search in the form of an ObservableList
     */
    public static ObservableList<DataObject> search(String condition, ArrayList<String>included) throws SQLException{
        ensureOrder(included);
        String selectStmt = "SELECT * FROM " + included.get(0) + " ";
        ArrayList<String>prevTabs = new ArrayList<>();
        for(int i = 1; i < included.size(); i++){
            selectStmt += "FULL JOIN " + included.get(i) + " ON ";
            if(included.get(i).equals("CLIENT")) {
                selectStmt += included.get(i - 1) + "." + "CLIENTID = CLIENT.ID ";
                for(String s : prevTabs){
                    selectStmt += " OR " + s + "." + "CLIENTID = CLIENT.ID ";
                }
            }else if(included.get(i).equals("TAXYEAR") && included.get(i - 1).equals("CLIENT")){
                selectStmt += included.get(i-2)+"."+"TAXYEAR = TAXYEAR.TAXYEAR ";
                for(String s : prevTabs){
                    selectStmt += " OR " + s +"."+"TAXYEAR = TAXYEAR.TAXYEAR ";
                }
            }else if(included.get(i).equals("TAXYEAR")){
                selectStmt += included.get(i-1)+"."+"TAXYEAR = TAXYEAR.TAXYEAR ";
                for(String s : prevTabs){
                    selectStmt += " OR " + s +"."+"TAXYEAR = TAXYEAR.TAXYEAR ";
                }
            }else{
                selectStmt += "(" + included.get(i - 1) + ".CLIENTID = " + included.get(i) + ".CLIENTID AND " + included.get(i - 1) + ".TAXYEAR = " + included.get(i) + ".TAXYEAR) ";
                for(String s : prevTabs) {
                    selectStmt += " OR (" + s + ".CLIENTID = " + included.get(i) + ".CLIENTID AND " + s + ".TAXYEAR = " + included.get(i) + ".TAXYEAR) ";
                }
                prevTabs.add(included.get(i-1));
            }
        }
        selectStmt += condition + ";";
        System.out.println(selectStmt);
        try{
            ResultSet rs = DB.executeQuery(selectStmt);
            Set<String> inc = new HashSet<>(included);
            ObservableList<DataObject> dataList = getDataObjectList(rs, inc.contains("DEMOGRAPHIC"), inc.contains("RETURNDATA"), inc.contains("CLIENT"), inc.contains("QUESTION"), inc.contains("TAXYEAR"));
            return dataList;
        }catch (SQLException e){
            System.out.println("SQL select operation has failed:" + e);
            throw e;
        }
    }

    /**
     * makes sure that the list of included tables are in the necessary order
     * @param included the list of included tables
     */
    private static void ensureOrder(ArrayList<String> included){
        for(int i = 0; i < included.size(); i++){
            if(included.get(i).equals("TAXYEAR") && i != included.size() - 1){
                included.set(i, included.get(included.size()-1));
                included.set(included.size()-1, "TAXYEAR");
            }else if(included.get(i).equals("CLIENT") && i != included.size()-2 && included.size() > 1){
                included.set(i, included.get(included.size()-2));
                included.set(included.size()-1, "CLIENT");
            }
        }
    }
}

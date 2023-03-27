package parsing;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.*;
import java.io.*;

public class FileParser{

    public List<String> columnNames;
    public Map<String, HashMap<String,String>> data;
    public List<String> fileLines;


    /**
     * Constructor for FileParser Class.
     * @param clientFile File, file that contains the data in CSV format.
     * @throws IOException Exception from wrong file format or some other input issue.
     */
    public FileParser(File clientFile) throws IOException{
        this.data = new HashMap<>();
        this.fileLines = Files.readAllLines(clientFile.toPath(), StandardCharsets.UTF_8);
        this.columnNames = getColumnNames();
        parseCSV();
    }

    /**
     * Capitalizes the first and last names for each client in the data.
     * @param line A row from the data that contains the information for a single client.
     */
    void capitalizeNames(List<String> line){
        String firstNameUpper = this.columnNames.contains("FIRSTNAME")
                ? line.get(getColumn("FIRSTNAME")).toUpperCase()
                : "";
        String lastNameUpper = line.get(getColumn("LASTNAME")).toUpperCase();
        if (!firstNameUpper.equals("")){
            line.set(getColumn("FIRSTNAME"), firstNameUpper);
        }
        line.set(getColumn("LASTNAME"), lastNameUpper);
    }

    /**
     * Creates a key for the client to be used as an ID in the database.
     * @param line A row from the csv file that contains the information for a single client.
     * @return String that is the ID for the client.
     */
    String createKey(List<String> line){
        int lastNameColumn = getColumn("LASTNAME");
        int ssColumn = this.columnNames.contains("L4SSN")
                ? getColumn("L4SSN")
                : getColumn("LAST4");
        return line.get(lastNameColumn).replaceAll(" ", "") + line.get(ssColumn);
    }

    /**
     * Gets index of column based on name of the header of the data.
     * @param columnName Name of the column.
     * @return The index associated with the column.
     */
    int getColumn(String columnName){
        return this.columnNames.indexOf(columnName);
    }

    /**
     * Gets all header names from the csv file.
     * @return List of names of headers.
     */
    List<String> getColumnNames(){
        List<String> columnNames = Arrays.asList(this.fileLines.get(0).split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)"));
        columnNames.replaceAll(String::trim);
        columnNames.replaceAll(s -> s.replaceAll("\\s+", ""));
        columnNames.replaceAll(s -> s.replaceAll("[^\\w\\s]", ""));
        columnNames.replaceAll(String::toUpperCase);
        return columnNames;
    }

    /**
     * Get the data associated with a client's ID.
     * @param client Client ID.
     * @return Hash Map containing different fields and values from the parser's data.
     */
    HashMap<String, String> getClient(String client){
        return data.get(client);
    }

    /**
     * Gets value of a specified property from a given client.
     * @param clientProperties Hash Map containing properties associated with a client.
     * @param property Name of the property.
     * @return The value of the property of a client.
     */
    String getClientProperty(HashMap<String, String> clientProperties, String property){
        return clientProperties.get(property);
    }


    /**
     * Parses a CSV file. Creates a Map containing an ID for a key for each user and a value which is a Hash Map
     * containing the csv headers as keys and values associated with the client for each value.
     * Result is put into data field.
     * @throws IOException, Calling File.readAllLines may not work if
     *                      file path is invalid.
     */
    void parseCSV() throws IOException{
        for (int line = 0; line < this.fileLines.size() - 1; line++) {
            if (line > 0){
                List<String> splitLine = removeCommas(this.fileLines.get(line));
                splitLine.replaceAll(String::trim);
                capitalizeNames(splitLine);
                if (this.columnNames.contains("DOB") || this.columnNames.contains("DATEOFBIRTH")) {
                    reformatDOB(splitLine, this.columnNames.contains("DOB")
                            ? getColumn("DOB")
                            : getColumn("DATEOFBIRTH"));
                }
                reformatSS(splitLine, this.columnNames.contains("L4SSN")
                           ? getColumn("L4SSN")
                           : getColumn("LAST4"));
                String clientKey = createKey(splitLine);
                this.data.put(clientKey, new HashMap<>());
                for (int column = 0; column < splitLine.size(); column++){
                    String columnName = this.columnNames.get(column);
                    this.data.get(clientKey).put(columnName, splitLine.get(column));
                }
            }
        }
    }

    /**
     * Reformat the date of birth in the data for each client to add extra zeroes.
     * @param line Line associated with client.
     * @param dobColumn Column that contains the date of birth of the client.
     */
     void reformatDOB(List<String> line, int dobColumn){
         if (!line.get(dobColumn).equals("")){
             String[] dob = line.get(dobColumn).split("/");
             for (int idx = 0; idx < dob.length - 1; idx++){
                 if (dob[idx].length() < 2){
                     dob[idx] = "0" + dob[idx];
                 }
             }
             line.set(dobColumn, String.join("/", dob));
         }
    }

    /**
     * Reformats the social security property of a client to get rid of x's or add zeroes if the last four digits of the
     * Social Security number is less than 1000.
     * @param line Line associated with client.
     * @param ssColumn Column that contains the last four digits of the clients Social Security number.
     */
    void reformatSS(List<String> line, int ssColumn){
        StringBuilder ss = new StringBuilder(line.get(ssColumn));
        if (ss.length() > 4){
            ss = new StringBuilder(removeXChars(ss.toString()));
        }else{
            while(ss.length() < 4){
                ss.insert(0, "0");
            }
        }
        line.set(ssColumn, ss.toString());
    }

    /**
     * Removes commas, unnecessary words, and other symbols that would interfere with data entry. Also used to clean
     * up data. Line argument is String due to how file is read and converted to String format.
     * @param line Line associated with client.
     * @return List of reformatted Strings.
     */
    List<String> removeCommas(String line){
        List<String> newLine = Arrays.asList(line.strip().split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)"));
        newLine.replaceAll(s -> s.replaceAll("[\",]", ""));
        for (int value = 0; value < newLine.size(); value ++){
            String lineValue = newLine.get(value);
            if (lineValue.contains("Sum")){
                newLine.set(value, lineValue.substring(6));
            }
            else if (lineValue.contains("$")){
                newLine.set(value, lineValue.substring(1, lineValue.length() - 4));
            }
        }
        return newLine;
    }

    /**
     * Remove x characters from Social Security number.
     * @param ss String containing last four digits of Social Security number.
     * @return Reformatted last four digits of Social Security number.
     */
    String removeXChars(String ss){return ss.substring(ss.length() - 4);}

}

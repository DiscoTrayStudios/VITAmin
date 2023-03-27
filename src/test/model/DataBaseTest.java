package model;

import SQLite.DB;
import org.junit.jupiter.api.Test;
import parsing.FileParser;

import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class DataBaseTest {
    File testFile = new File("src/test/testDataExamples/exampleData1.csv").getCanonicalFile();
    FileParser fileParser = new FileParser(testFile);
    Map<String, HashMap<String, String>> data = fileParser.data;
    DataBaseTest() throws IOException {
    }

    @Test
    void insertClient() {
        String clientID = "A1234";
        HashMap<String, String> clientProperties = data.get(clientID);
        DB.isTest = true;
        DataBase.insertClient(clientProperties, clientID);
        try (ResultSet query = DB.executeQuery(String.format("SELECT * FROM Client WHERE ID = '%s';", clientID))) {
            assertTrue(query.next());
            query.beforeFirst();
        }catch (Exception e){
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        DB.isTest = false;
    }
    @Test
    void insertDemographic(){
        String clientID = "A1234";
        HashMap<String, String> clientProperties = data.get(clientID);
        DB.isTest = true;
        DataBase.insertDemographic(clientProperties, clientID);
        try (ResultSet query = DB.executeQuery(String.format("SELECT * FROM Demographic WHERE Client_ID = '%s';", clientID))) {
            assertTrue(query.next());
            query.beforeFirst();
        }catch (Exception e){
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        DB.isTest = false;
    }

    @Test
    void insertReturnData(){
        String clientID = "A1234";
        HashMap<String, String> clientProperties = data.get(clientID);
        DB.isTest = true;
        DataBase.insertReturnData(clientProperties, clientID);
        try (ResultSet query = DB.executeQuery(String.format("SELECT * FROM ReturnData WHERE Client_ID = '%s';", clientID))) {
            assertTrue(query.next());
            query.beforeFirst();
        }catch (Exception e){
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        DB.isTest = false;
    }

    @Test
    void insertTaxYear(){
        String clientID = "A1234";
        HashMap<String, String> clientProperties = data.get(clientID);
        DB.isTest = true;
        DataBase.insertTaxYear(clientProperties);
        String year = clientProperties.get("CREATEDDATETIME").substring(0, 4);
        try (ResultSet query = DB.executeQuery(String.format("SELECT * FROM TaxYear WHERE TaxYear = %s;", year))) {
            assertTrue(query.next());
            query.beforeFirst();
        }catch (Exception e){
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        DB.isTest = false;
    }

    @Test
    void searchClients() {
    }

    @Test
    void searchDemographics() {
    }

    @Test
    void searchReturnData() {
    }

    @Test
    void searchDemographicsAndReturnData() {
    }

    @Test
    void searchDemographicsAndClients() {
    }

    @Test
    void searchReturnDataAndClients() {
    }

    @Test
    void searchDemographicsAndReturnDataAndClients() {
    }

    @Test
    void searchTaxYears() {
    }
}
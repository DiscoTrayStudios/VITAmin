package SQLite;

import javax.sql.rowset.*;
import java.sql.*;

/**
 * DB Class<br/>
 * <br/>
 * Class that represents the local database for the project.<br/>
 */
public class DB {

    private static Connection connection = null;
    public static boolean isTest = false;

    /**
     * Method for setting up the connection between the program and the database. <br/>
     * <br/>
     * Method will attempt to create a connection using the DriverManager's getConnection()
     * method.<br/>
     */
    public static void connect(){
        try {
            Class.forName("org.sqlite.JDBC");
            if (isTest){
                connection = DriverManager.getConnection("jdbc:sqlite:src/test/VITAminTest.db");
            }else{
                connection = DriverManager.getConnection("jdbc:sqlite:src/VITAmin.db");
            }
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        System.out.println("Opened database successfully");
    }

    public static void connectTest(){
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:src/test/VITAminTest.db");
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        System.out.println("Opened database successfully.");
    }

    /**
     * Method for closing the connection between the program and the database. <br/>
     * <br/>
     * Method checks if the connection is valid and not closed. If so, the close() method
     * is used to close the connection.
     */
    public static void disconnect(){
        try{
            if(connection != null && !connection.isClosed()){
                connection.close();
            }
        }catch(Exception e){
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
        }
        System.out.println("Closed database successfully.");
    }

    /**
     * Runs a query on the database with a given String.
     * @param query String containing the SQL query to send to the database.
     * @return ResultSet object, contains rows of data from the query that is
     * then cached into memory.<br/>
     */
    public static ResultSet executeQuery(String query){
        Statement stmt = null;
        ResultSet rs = null;

        CachedRowSet crs = null;


        try {
            connect();
            //c.setAutoCommit(false);
            System.out.println("Opened database successfully");

            stmt = connection.createStatement();
            System.out.println(query);
            rs = stmt.executeQuery(query);
            crs = RowSetProvider.newFactory().createCachedRowSet();
            crs.populate(rs);
            rs.close();
            stmt.close();
            disconnect();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        System.out.println("Operation done successfully");
        return crs;
    }

    public static void executeCreateQuery(String query){
        Statement stmt = null;

        try {
            connect();
            //c.setAutoCommit(false);
            System.out.println("Opened database successfully");

            stmt = connection.createStatement();
            System.out.println(query);
            stmt.execute(query);
            stmt.close();
            disconnect();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        System.out.println("Operation done successfully");
    }

    /**
     * Method for updating values in the database with a given SQL statement.
     * @param sqlStmt String, statement that is carried out to update the database.
     */
    public static void update(String sqlStmt){
        Statement stmt;
        try{
            connect();
            stmt = connection.createStatement();
            stmt.executeUpdate(sqlStmt);

            stmt.close();
            disconnect();
        }catch(Exception e){
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
    }

    public static boolean dbExists() throws SQLException{
        connect();
        DatabaseMetaData meta = connection.getMetaData();
        ResultSet resultSet = meta.getTables(null,null,null,new String[]{"Table"});
        disconnect();
        return resultSet.next();
    }

    public static void main(String args[]) throws SQLException {
        connect();
        System.out.println(dbExists());
    }
}
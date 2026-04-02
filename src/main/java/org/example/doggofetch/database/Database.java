package org.example.doggofetch.database;

import java.io.File;
import java.sql.*;
import java.sql.DriverManager;
import java.util.Scanner;

import static org.example.doggofetch.database.DBConst.*;

//import static org.example.doggofetch.database.Const.*;

// import db values

/**
 * Database Class
 * feb2026
 * updated javadoc 29march26
 * katkoe
 */

/**
 * Hania updated April 2
 *  - store the config database name in a class variable
 *  - create the new tables
 *  - create tables in safe order
 *  - stop checking hardcoded schema knagelmd
 */
public class Database {
    // singleton design pattern: connection for use in full app
    // step 1 - private static instance variable
    private static Database instance;  /// var only belongs to class not instances or objects
    private String dbName;
    private Connection connection;

    // step 2 - private constructor
    private Database(){

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Scanner file = new Scanner(new File("config.txt"));
            dbName = file.next();
            String DB_USER = file.next();
            String DB_PASS = file.next();
            file.close();
            connection = DriverManager
                    .getConnection("jdbc:mysql://localhost/" + dbName +"?serverTimezone=UTC", DB_USER,
                            DB_PASS);
            System.out.println("Created Connection");

            // Create parent tables first
            createTable(TABLE_USER, CREATE_TABLE_USER, connection);
            createTable(TABLE_SUPPLIER, CREATE_TABLE_SUPPLIER, connection);
            createTable(TABLE_CATEGORY, CREATE_TABLE_CATEGORY, connection);

            // Create dependent tables after parent tables exist
            createTable(TABLE_ADDRESS, CREATE_TABLE_ADDRESS, connection);
            createTable(TABLE_ORDER, CREATE_TABLE_ORDER, connection);
            createTable(TABLE_INVENTORY, CREATE_TABLE_INVENTORY, connection);
            createTable(TABLE_PRODUCT, CREATE_TABLE_PRODUCTS, connection);

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void createTable(String tableName, String tableQuery, Connection connection) throws SQLException {
        Statement createTable;
        DatabaseMetaData md = connection.getMetaData();
        //Look inside the database for a table with tableName
        ResultSet resultSet = md.getTables(dbName, null, tableName, null);
        if(resultSet.next()){
            System.out.println(tableName + " table already exists");
        }
        else {
            createTable = connection.createStatement();
            createTable.execute(tableQuery);
            System.out.println("The " + tableName + " table has been created");
        }
    }

    // step 3 - public static

    public Connection getConnection() {
        return connection;
    }

    public static Database getInstance(){
        if(instance == null){
            instance = new Database();
        }
        return instance;
    }


} // database
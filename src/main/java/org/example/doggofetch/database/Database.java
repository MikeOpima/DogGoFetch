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
public class Database {
    // singleton design pattern: connection for use in full app
    // step 1 - private static instance variable
    private static Database instance;  /// var only belongs to class not instances or objects
    private Connection connection;

    // step 2 - private constructor
    private Database(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Scanner file = new Scanner(new File("config.txt"));
            String DB_NAME = file.next();
            String DB_USER = file.next();
            String DB_PASS = file.next();
            file.close();
            connection = DriverManager
                    .getConnection("jdbc:mysql://localhost/" + DB_NAME +"?serverTimezone=UTC", DB_USER,
                            DB_PASS);
            System.out.println("Created Connection");

            createTable(TABLE_INVENTORY, CREATE_TABLE_INVENTORY, connection);
            createTable(TABLE_SUPPLIER, CREATE_TABLE_SUPPLIER, connection);
            createTable(TABLE_CATEGORY, CREATE_TABLE_CATEGORY, connection);
            createTable(TABLE_PRODUCT, CREATE_TABLE_PRODUCTS, connection);
            //createTable(TABLE_ORDER, CREATE_TABLE_ORDER, connection);



        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void createTable(String tableName, String tableQuery, Connection connection) throws SQLException {
        Statement createTable;
        DatabaseMetaData doggo = connection.getMetaData();
        //Look inside the database for a table with tableName
        ResultSet resultSet = doggo.getTables("doggo", null, tableName, null);
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
package org.example.doggofetch.database;

import java.sql.*;

import static org.example.doggofetch.database.Const.*;

// import db values
//import static org.example.doggofetch.database.Const.*;

public class Database {
    // singleton design pattern: connection for use in full app
    // step 1 - private static instance variable
    private static Database instance;  /// var only belongs to class not instances or objects
    private Connection connection;
    // step 2 - private constructor
    private Database(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager
                    .getConnection("jdbc:mysql//localhost/" + DB_NAME+"?serverTimezone=UTC",
                            DB_USER,
                            DB_PASS);
            System.out.println("Created Connection");
            createTable(DBConst.TABLE_PRODUCT, DBConst.CREATE_TABLE_PRODUCTS,connection);
            createTable(DBConst.TABLE_INVENTORY, DBConst.CREATE_TABLE_INVENTORY,connection);
            createTable(DBConst.TABLE_ORDER, DBConst.CREATE_TABLE_ORDER,connection);
            createTable(DBConst.TABLE_SUPPLIER, DBConst.CREATE_TABLE_SUPPLIER,connection);

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    // Method to create table
    public void createTable(String tableName, String create_table, Connection connection) throws SQLException {
        Statement createTable;
        DatabaseMetaData metaData = connection.getMetaData();
        ResultSet resultSet = metaData.getTables("mopimajava", null, tableName, null);
        if (resultSet.next()) {
            System.out.println(tableName + " already exists");
        }else {
            createTable = connection.createStatement();
            createTable.execute(create_table);
            System.out.println("Table " + tableName + " has been created");
            //insert default records
        }
    }

    // Runs to create table query ( use this one if you have IF NOT EXISTS and not do not require initial data)
    public void createTable(String tableQuery, Connection connection) throws SQLException {
        connection.createStatement().execute(tableQuery);
    }

    // step 3 - public static
    public static Database getInstance(){
        if(instance == null){
            instance = new Database();
        }
        return instance;
    }


}

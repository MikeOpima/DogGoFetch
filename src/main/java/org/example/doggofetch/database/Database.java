package org.example.doggofetch.database;

import java.io.File;
import java.sql.*;
import java.sql.DriverManager;
import java.util.Scanner;

import static org.example.doggofetch.database.Const.*;

// import db values

/** Database Class
 *  katkoe
 *  march 2026
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

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    // step 3 - public static
    public static Database getInstance(){
        if(instance == null){
            instance = new Database();
        }
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }

} // database

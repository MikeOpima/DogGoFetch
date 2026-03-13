package org.example.doggofetch.database;

import java.sql.Connection;
import java.sql.DriverManager;

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
//            connection = DriverManager
//                    .getConnection("jdbc:mysql//localhost/" + DB_NAME+"?serverTimezone=UTC",
//                            DB_USER,
//                            DB_PASS);
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


}

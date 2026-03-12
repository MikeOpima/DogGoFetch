package org.example.doggofetch.database;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


public class Const {
    public static ArrayList<String> dbArray = new ArrayList<>();
    public String  DB_NAME;
    public String  DB_USER;
    public String  DB_PASS;

    public Const(String DB_NAME) {


        File file = new File("../../../config.txt");

        try {
            if (file.isFile()) {
                System.out.println("file found");
                Scanner in = new Scanner(file);
                System.out.println("write to file");

                if(dbArray.getFirst() == null){
                    System.out.println("array value is null");
                }

                while (in.hasNext()) {
                    dbArray.add(String.valueOf(in.next()));
                }



            } else {
                System.out.println("no file found");
            }



        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } // end try / catch

    }



//    public static String setDbName() {
//        DB_NAME = dbArray.getFirst();
//        return DB_NAME;
//    }
//
//    public static String setDbUser() {
//        DB_USER = dbArray.get(1);
//        return DB_USER;
//    }
//
//    public static String getDbName(){
//        return DB_NAME;
//    }
//    public static String getDbUser(){
//        return DB_USER;
//    }
//    public static String getDbPass(){
//        return DB_PASS;
//    }

} // end Const class



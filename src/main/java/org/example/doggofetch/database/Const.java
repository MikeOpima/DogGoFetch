package org.example.doggofetch.database;

import org.w3c.dom.ls.LSOutput;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Const {
    private static String dbName;
    private static String dbUser;
    private static String dbPass;

    public void Const() {
        File file = new File("config.txt");

        try {
            if (file.isFile()) {
                System.out.println("file found");
                Scanner in = new Scanner(file);
                while (in.hasNext()) {
                    dbName = in.next();
                    dbUser = in.next();
                    dbPass = in.next();
                    System.out.println(dbName + " " + dbUser + "connection vars");
                }

            } else {
                System.out.println("no file found");
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    public static final String DB_NAME = dbName;
    public static final String DB_USER = dbUser;
    public static final String DB_PASS = dbPass;

}


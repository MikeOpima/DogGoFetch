package org.example.doggofetch;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.example.doggofetch.database.Database;
import org.example.doggofetch.tabs.*;
import org.example.doggofetch.tabs.product.AddProductTab;
import org.example.doggofetch.tabs.product.RemoveProductTab;

import java.io.*;
import java.util.ArrayList;
import java.io.IOException;

import static org.example.doggofetch.UserCheck.userLoggedIn;

/**
 * HelloApplication
 * checks for config settings - displays landing page
 * Kat Koeller
 * Feb 2026
 **/

public class HelloApplication extends Application {

    @Override
    public void start(Stage stage) throws IOException {

        BorderPane root = new BorderPane();

        BorderPane configCheck = new BorderPane();
        VBox instructionsVb = new VBox();
        Text instructions = new Text("Missing Config Doc \n \n");
        Text dbName = new Text("Enter in NAME: ");
        TextField dbNameTf = new TextField();
        Text dbUser = new Text("Enter in USER: ");
        TextField dbUserTf = new TextField();
        Text dbPass = new Text("Enter in PASS: ");
        PasswordField dbPassTf = new PasswordField();
        Button test = new Button(" test connection ");
        Button connect = new Button(" connect ");
        instructionsVb.getChildren().addAll(
                instructions, dbName, dbNameTf, dbUser, dbUserTf,
                dbPass, dbPassTf, test, connect);

        configCheck.setCenter(instructionsVb);
        // end configCheck pane form
        
        ///  add in db config.txt check with scene switches //
        ArrayList<String> dbArray = new ArrayList<String>();
        File dbConfig = new File("config.txt");

        // check for config file
        try {
            if (!dbConfig.isFile()) {
                // if no config --- configCheck pane

                root.setCenter(configCheck);


                // on test
                test.setOnMouseClicked( e->{
                    try{
                        // add to array
                        dbArray.add(dbNameTf.getText() + "\n" +
                                dbUserTf.getText() + "\n" +
                                dbPassTf.getText() + "\n");

                        BufferedWriter out = new BufferedWriter(new FileWriter("config.txt"));
                        out.close();

                        System.out.println("Wrote to File");

                        Text testMessage = new Text("Connection Created");
                        root.setBottom(testMessage);

                    }catch (Exception ex){
                        ex.printStackTrace();
                        Text testMessage = new Text("Connection Error try again");
                        root.setBottom(testMessage);
                    }

                    try {
                        PrintWriter out = new PrintWriter( new BufferedWriter
                                (new FileWriter("config.txt", true)));

                        for(String str : dbArray) {
                            out.write(str + "\n");
                        }

                        out.close();

                        Database db = Database.getInstance();

                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }

                }); /// end test action

                // create connection
                connect.setOnMouseClicked( e->{
                    try{
                        // add to array
                        dbArray.add(dbNameTf.getText() + "\n" +
                                dbUserTf.getText() + "\n" +
                                dbPassTf.getText() + "\n");

                        BufferedWriter out = new BufferedWriter(new FileWriter("config.txt"));
                        out.close();

                        System.out.println("Created Connection");
                        Text testMessage = new Text("Connection Created");
                        root.setBottom(testMessage);

                    }catch (Exception ex){
                        ex.printStackTrace();
                        Text testMessage = new Text("Connection Error try again");
                        root.setBottom(testMessage);
                    }

                    try {
                        PrintWriter out = new PrintWriter( new BufferedWriter
                                (new FileWriter("config.txt", true)));

                        for(String str : dbArray) {
                            out.write(str + "\n");
                        }

                        out.close();

                        // clear the form
                        dbNameTf.clear();
                        dbUserTf.clear();
                        dbPassTf.clear();

                        Database db = Database.getInstance();

                        ConfigAddSampleData.getInstance();



                    } catch (Exception ex) {
                        ex.printStackTrace();
                        System.out.println("db connection error");
                    }
//                    root.setCenter(IndexPane.getInstance());

                }); /// end connect action


            } else {

                root.setCenter(IndexPane.getInstance());
                // user login check
//            if(!userLoggedIn) {
//                System.out.println("display login panel");
//                root.setCenter(UserCheck.getInstance());
//            }else {
//                System.out.println("display index panel");
//                root.setCenter(IndexPane.getInstance());
//                }


            }
        } catch (Exception e) {
            e.printStackTrace();
        }



        Scene scene = new Scene(root, 800, 600);
        scene.getStylesheets().add(String.valueOf(this.getClass().getResource("css/main.css")));
        stage.setScene(scene);
        stage.setTitle("Dog Go Fetch");
        stage.show();

    }// end main
} // end hello app
package org.example.doggofetch;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.example.doggofetch.database.Database;

import java.io.*;
import java.util.ArrayList;
import java.io.IOException;

/** Hello Application
 *  katkoe
 *  march 2026
 */

public class HelloApplication extends Application {
    /**
     * start main
     * @param stage
     * @throws IOException
     */
    @Override
    public void start(Stage stage) throws IOException {
        BorderPane root = new BorderPane();
        ///  add in db config.txt check with scene switches //
        ArrayList<String> dbArray = new ArrayList<String>();

        File dbConfig = new File("config.txt");

        // check for config file
        try {
            if (!dbConfig.isFile()) {

                // if no config --- configCheck pane
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

                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }

                }); /// end connect action


            } else {
                // if file exists show app

                // menu bar
                MenuBar mainMenuBar = new MenuBar();
                // menu items inventory, search, user/login, cart
                Menu login = new Menu("Log-in");
                Menu inventory = new Menu("Inventory");
                Menu search = new Menu("Input by SKU");
                Menu cart = new Menu("View Cart");
                Menu orders = new Menu("View Orders");
                Menu signout = new Menu("Sign Out");
                login.getItems().add(signout);

                // add items
                mainMenuBar.getMenus().addAll(login, inventory, search, cart, orders);
                signout.setOnAction( e-> {
                    System.exit(0);
                });

                // create tab pane
                TabPane pane = new TabPane();

                // create tabs
                AddItemTab addItemTab = new AddItemTab();
                RemoveItemTab removeItemTab = new RemoveItemTab();
                CartTab statsTab = new CartTab();
                pane.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);

                // add tabs to pane
                pane.getTabs().addAll(addItemTab, removeItemTab, statsTab);
                root.setTop(mainMenuBar);
                root.setCenter(pane);
                System.out.println("config file exist");
                Database.getInstance();

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        Scene scene = new Scene(root, 800, 600);
        stage.setScene(scene);
        stage.setTitle("Dog Go Fetch");
        stage.show();

    }// end main
} // end hello app





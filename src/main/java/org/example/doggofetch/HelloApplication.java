package org.example.doggofetch;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.awt.print.PrinterIOException;
import java.io.File;
import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        BorderPane root = new BorderPane();
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
        // menuBar.getMenu().add(file);
        mainMenuBar.getMenus().addAll(login, inventory, search, cart,
        orders);
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

        BorderPane configCheck = new BorderPane();

        VBox instructionsVb = new VBox();
        Text instructions = new Text("Missing Config Doc \n \n");
        Text dbName = new Text("Enter in NAME: ");
        TextField dbNameTf = new TextField();
        Text dbUser = new Text("Enter in USER: ");
        TextField dbUserTf = new TextField();
        Text dbPass = new Text("Enter in PASS: ");
        PasswordField dbPassPf = new PasswordField();
        Button test = new Button(" test connection ");
        Button submit = new Button(" connect ");


        instructionsVb.getChildren().addAll(
                instructions, dbName, dbNameTf, dbUser, dbUserTf, dbPass, dbPassPf, test, submit);

        configCheck.setCenter(instructionsVb);

        ///  add in db config.txt check with scene switches //

        File dbConfig = new File("config.txt");
        try {
            if (dbConfig.isFile()) {
                // add tabs to pane
                pane.getTabs().addAll(addItemTab, removeItemTab, statsTab);
                root.setTop(mainMenuBar);
                root.setCenter(pane);
            } else {
                root.setCenter(configCheck);

            }

            // set global variables from config.txt

        } catch (Exception e) {
            e.printStackTrace();
        }






        Scene scene = new Scene(root, 600, 240);
        stage.setScene(scene);
        stage.setTitle("Dog Go Fetch");
        stage.show();
    }
}

package org.example.doggofetch;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.example.doggofetch.database.Database;
import org.example.doggofetch.pojo.Category;
import org.example.doggofetch.tables.CategoryTable;
import org.example.doggofetch.tables.ProductTable;
import org.example.doggofetch.tables.SupplierTable;
import org.example.doggofetch.tabs.product.AddProductTab;
import org.example.doggofetch.tabs.CartTab;
import org.example.doggofetch.tabs.product.RemoveProductTab;

import java.io.*;
import java.util.ArrayList;


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
        ArrayList<String> dbArray = new ArrayList<String>();

        BorderPane indexPane = new BorderPane();
        // menu bar
        MenuBar mainMenuBar = new MenuBar();
        mainMenuBar.getStyleClass().add("mainMenuBar");
        // menu items inventory, search, user/login, cart
        Menu login = new Menu("Log-in");
        Menu inventory = new Menu("Inventory");
        Menu search = new Menu("Input by SKU");
        Menu cart = new Menu("View Cart");
        Menu orders = new Menu("View Orders");
        Menu signout = new Menu("Sign Out");
        login.getItems().add(signout);

        // menuBar.getMenu().add(file);
        mainMenuBar.getMenus().addAll(inventory, search, cart,
                orders,login);
        signout.setOnAction( e-> {
            System.exit(0);
        });


        // add header items
        Text title = new Text("Dog.Go Fetch");
        title.getStyleClass().add("title");

        ImageView logo = new ImageView(new Image(getClass().getResourceAsStream("images/doggofetch_logo.png")));
        logo.setFitHeight(108);
        logo.setFitWidth(108);

        // header Content
        BorderPane headerContent = new BorderPane();
        headerContent.getStyleClass().add("headerContent");
        headerContent.setCenter(title);
        headerContent.setLeft(logo);
        headerContent.setBottom(mainMenuBar);


        ///  add in db config.txt check with scene switches //
        File dbConfig = new File("config.txt");

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


                // on connect
                connect.setOnMouseClicked( e->{
                    try{

                        ConfigCheckPane configSQL = ConfigCheckPane.getInstance();

                        // create tab pane
                        TabPane itemTabPane = new TabPane();
                        itemTabPane.getStyleClass().add("itemTabPane");

                        // create tabs
                        AddProductTab addItemTab = new AddProductTab();
                        RemoveProductTab removeItemTab = new RemoveProductTab();
                        CartTab statsTab = new CartTab();

                        itemTabPane.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);

                        // end header with tabs

                        // add tabs to pane
                        itemTabPane.getTabs().addAll(addItemTab, removeItemTab, statsTab);
                        indexPane.setTop(headerContent);
                        indexPane.setCenter(itemTabPane);

                        root.setCenter(indexPane);

                    } catch (Exception ex) {
                        ex.printStackTrace();
                        System.out.println("db connection error");
                    }


                }); /// end connect action

            } else {
                // create tab pane
                TabPane itemTabPane = new TabPane();
                itemTabPane.getStyleClass().add("itemTabPane");

                // create tabs
                AddProductTab addItemTab = new AddProductTab();
                RemoveProductTab removeItemTab = new RemoveProductTab();
                CartTab statsTab = new CartTab();

                itemTabPane.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);

                // end header with tabs


                // add tabs to pane
                itemTabPane.getTabs().addAll(addItemTab, removeItemTab, statsTab);
                indexPane.setTop(headerContent);
                indexPane.setCenter(itemTabPane);

                root.setCenter(indexPane);

            }

            // set global variables from config.txt

        } catch (Exception e) {
            e.printStackTrace();
        }

        Scene scene = new Scene(root, 800, 600);
        scene.getStylesheets().add(String.valueOf(this.getClass().getResource("css/main.css")));
        stage.setScene(scene);
        stage.setTitle("Dog Go Fetch");
        stage.show();
    }
}
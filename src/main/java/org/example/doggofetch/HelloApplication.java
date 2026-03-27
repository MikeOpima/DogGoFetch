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
import org.example.doggofetch.tabs.AddItemTab;
import org.example.doggofetch.tabs.CartTab;
import org.example.doggofetch.tabs.RemoveItemTab;

import java.io.File;
import java.io.IOException;


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

        // add items
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

        // create tab pane
        TabPane itemTabPane = new TabPane();
        itemTabPane.getStyleClass().add("itemTabPane");

        // create tabs
        AddItemTab addItemTab = new AddItemTab();
        RemoveItemTab removeItemTab = new RemoveItemTab();
        CartTab statsTab = new CartTab();

        itemTabPane.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);

        BorderPane configCheck = new BorderPane();

        VBox instructionsVb = new VBox();
        Text instructions = new Text("Missing Config Doc \n \n");
        Text dbName = new Text("Enter in DB_NAME: ");
        TextField dbNameTf = new TextField();
        Text dbUser = new Text("Enter in USER NAME: ");
        TextField dbUserTf = new TextField();
        Text dbPass = new Text("Enter in PASSWORD: ");
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
                itemTabPane.getTabs().addAll(addItemTab, removeItemTab, statsTab);
                root.setTop(headerContent);
                root.setCenter(itemTabPane);
            } else {
                root.setCenter(configCheck);

            }

            // set global variables from config.txt

        } catch (Exception e) {
            e.printStackTrace();
        }






        Scene scene = new Scene(root, 800, 600);
        stage.setScene(scene);
        stage.setTitle("Dog Go Fetch");
        stage.show();
    }
}
package org.example.doggofetch;

import javafx.scene.layout.BorderPane;

public class IndexPane extends BorderPane {
    private static IndexPane instance;

    public IndexPane(){

        // if file exists show app
        BorderPane indexPane = new BorderPane();

//        // menu bar
//        MenuBar mainMenuBar = new MenuBar();
//        mainMenuBar.getStyleClass().add("mainMenuBar");
//
//        // menu items inventory, search, user/login, cart
//        Menu login = new Menu("Log-in");
//        Menu inventory = new Menu("Inventory");
//        Menu search = new Menu("Input by SKU");
//        Menu cart = new Menu("View Cart");
//        Menu orders = new Menu("View Orders");
//        Menu signout = new Menu("Sign Out");
//        login.getItems().add(signout);
//
//        // menuBar.getMenu().add(file);
//        mainMenuBar.getMenus().addAll(inventory, search, cart,
//                orders,login);
//        signout.setOnAction( e-> {
//            System.exit(0);
//        });
//
//        // add header items
//        Text title = new Text("Dog.Go Fetch");
//        title.getStyleClass().add("title");
//
//        ImageView logo = new ImageView(new Image(getClass().getResourceAsStream("../../../images/doggofetch_logo.png")));
//        logo.setFitHeight(108);
//        logo.setFitWidth(108);
//
//        // header Content
//        BorderPane headerContent = new BorderPane();
//        headerContent.getStyleClass().add("headerContent");
//        headerContent.setCenter(title);
//        headerContent.setLeft(logo);
//        headerContent.setBottom(mainMenuBar);
//
//        // create tab pane
//        TabPane itemTabPane = new TabPane();
//        itemTabPane.getStyleClass().add("itemTabPane");
//
//        // create tabs
//        AddProductTab addItemTab = new AddProductTab();
//        RemoveProductTab removeItemTab = new RemoveProductTab();
//        CartTab statsTab = new CartTab();
//
//        itemTabPane.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);
//
//        // end header with tabs
//
//        // add tabs to pane
//        itemTabPane.getTabs().addAll(addItemTab, removeItemTab, statsTab);
//        this.setTop(headerContent);
//        this.setCenter(itemTabPane);

    }

    public static IndexPane getInstance(){
        if(instance == null){
            instance = new IndexPane();
        }
        return instance;
    }

}



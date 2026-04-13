package org.example.doggofetch;

import com.mysql.cj.x.protobuf.MysqlxCrud;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TabPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import org.example.doggofetch.pojo.Product;
import org.example.doggofetch.tabs.CartTab;
import org.example.doggofetch.tabs.product.AddProductTab;
import org.example.doggofetch.tabs.product.RemoveProductTab;
import org.example.doggofetch.tabs.product.UpdateProductTab;

import java.util.ArrayList;

public class IndexPane extends BorderPane {
    private static IndexPane instance;

    public IndexPane(){

        // if file exists show app
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

        // create tab pane
        TabPane productTabPane = new TabPane();
        productTabPane.getStyleClass().add("itemTabPane");

        productTabPane.getTabs().addAll(AddProductTab.getInstance(), RemoveProductTab.getInstance());
        productTabPane.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);

        // end header with tabs

        // add tabs to pane
        this.setTop(headerContent);
        this.setCenter(productTabPane);

    }

    public static IndexPane getInstance(){
        if(instance == null){
            instance = new IndexPane();
        }
        return instance;
    }

}



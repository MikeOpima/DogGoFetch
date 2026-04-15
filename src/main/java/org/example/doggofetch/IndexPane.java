package org.example.doggofetch;

import com.mysql.cj.x.protobuf.MysqlxCrud;
import javafx.animation.Animation;
import javafx.animation.FadeTransition;
import javafx.animation.ParallelTransition;
import javafx.animation.SequentialTransition;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TabPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.util.Duration;
import org.example.doggofetch.pojo.Product;
import org.example.doggofetch.pojo.Supplier;
import org.example.doggofetch.tabs.CartTab;
import org.example.doggofetch.tabs.product.*;
import org.example.doggofetch.tabs.supplier.RemoveSupplierTab;
import org.example.doggofetch.tabs.supplier.SupplierTab;
import org.example.doggofetch.tabs.user.AddUserTab;
import org.example.doggofetch.tabs.user.RemoveUserTab;
<<<<<<< HEAD
import org.example.doggofetch.tabs.user.UpdateUserTab;
//import org.example.doggofetch.tabs.user.UpdateUserTab;
//
import javax.security.auth.Refreshable;
=======

>>>>>>> dev
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
        Menu spacer = new Menu("    ");
        Menu login = new Menu("Log-in");
        Menu products = new Menu("Products");
        Menu suppliers = new Menu("Suppliers");
        Menu users = new Menu("Users");
        // Menu search = new Menu("Input by SKU");
        // Menu cart = new Menu("View Cart");
        // Menu orders = new Menu("View Orders");
        Menu signout = new Menu("Sign Out");
        Menu addProductTab = new Menu("Add Product Tab");
        login.getItems().add(signout);

        // menuBar.getMenu().add(file);
        mainMenuBar.getMenus().addAll(spacer, products, suppliers, users, login);
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
        TabPane userTabPane = new TabPane();
        userTabPane.getStyleClass().add("itemTabPane");
        userTabPane.getTabs().addAll(AddUserTab.getInstance(), RemoveUserTab.getInstance(),UpdateUserTab.getInstance());
        userTabPane.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);

        TabPane productTabPane = new TabPane();
        productTabPane.getStyleClass().add("itemTabPane");
<<<<<<< HEAD
        productTabPane.getTabs().addAll(AddProductTab.getInstance(), RemoveProductTab.getInstance(),UpdateProductTab.getInstance(), ProductStatsTab.getInstance());
=======
        productTabPane.getTabs().addAll(AddProductTab.getInstance(), RemoveProductTab.getInstance());
>>>>>>> dev
        productTabPane.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);

        TabPane supplierTabPane = new TabPane();
        supplierTabPane.getStyleClass().add("itemTabPane");
        supplierTabPane.getTabs().addAll(RemoveSupplierTab.getInstance());
        supplierTabPane.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);

        // end header with tabs

        // add tabs to pane
        this.setTop(headerContent);
        this.setCenter(productTabPane);


        products.setOnAction( e-> {
           IndexPane.getInstance().setCenter(productTabPane);
        // @TODO Refresh / TabLoad
        });

        suppliers.setOnAction( e-> {

        });


        FadeTransition titleFade = new FadeTransition(Duration.seconds(3), title);
        titleFade.setFromValue(0);
        titleFade.setToValue(1);
        titleFade.setCycleCount(1);

        FadeTransition logoFade = new FadeTransition(Duration.seconds(3.5), logo);
        logoFade.setFromValue(0);
        logoFade.setToValue(1);
        logoFade.setCycleCount(1);

        ParallelTransition fadeIn = new ParallelTransition(titleFade, logoFade);
        fadeIn.setCycleCount(1);
        fadeIn.play();
    }

    public static IndexPane getInstance(){
        if(instance == null){
            instance = new IndexPane();
        }
        return instance;
    }
}



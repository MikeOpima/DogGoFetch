package org.example.doggofetch.tabs.product;

import javafx.scene.Node;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;

public class ProductsPane extends Tab {
    private static ProductsPane instance;

    public ProductsPane(){
        TabPane productTabPane = new TabPane();
        productTabPane.getStyleClass().add("itemTabPane");
        productTabPane.getTabs().addAll(AddProductTab.getInstance(), RemoveProductTab.getInstance(), UpdateProductTab.getInstance());
        productTabPane.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);
    }

    public static ProductsPane getInstance(){
        if(instance == null){
            instance = new ProductsPane();
        }
        return instance;
    }




}

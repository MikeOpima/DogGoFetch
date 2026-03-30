package org.example.doggofetch.tabs;

import javafx.scene.control.Tab;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import org.example.doggofetch.tables.InventoryTable;

/**
 * AddProductTab
 * katkoe 29mar26
 * add in products tab feature
 */
public class AddProductTab extends Tab {
    public AddProductTab(){
        this.setText("Add Item");

        Text welcome = new Text("Welcome to add items");

        GridPane root = new GridPane();
        root.setHgap(10);
        root.setVgap(10);
        InventoryTable inventoryTable = new InventoryTable();



    } // end con


} // end addItemTab class

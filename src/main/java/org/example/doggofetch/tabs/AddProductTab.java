package org.example.doggofetch.tabs;

import javafx.collections.FXCollections;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Tab;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import org.example.doggofetch.pojo.Category;
import org.example.doggofetch.tables.CategoryTable;
import org.example.doggofetch.tables.InventoryTable;
import org.example.doggofetch.tables.ProductTable;
import org.example.doggofetch.tables.SupplierTable;

/**
 * AddProductTab
 * @author katkoe
 * @date 29mar26
 * add in products tab feature
 * @version 1.0
 */
public class AddProductTab extends Tab {
    public AddProductTab(){
        this.setText("Add Item");

        Text welcome = new Text("Welcome to add items");

        GridPane root = new GridPane();
        root.setHgap(10);
        root.setVgap(10);

        //get table instances
        CategoryTable categoryTable = CategoryTable.getInstance();
        ProductTable productTable = ProductTable.getInstance();
        SupplierTable supplierTable = SupplierTable.getInstance();

        Text category = new Text("Category");
        ComboBox<Category> comboName = new ComboBox<>();
       // comboName.setItems(FXCollections.observableList(categoryTable.getAllCategory()));
      //  comboName.getSelectionModel().select(0);










    } // end con


} // end addItemTab class

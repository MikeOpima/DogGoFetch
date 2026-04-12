package org.example.doggofetch.tabs.product;

import javafx.collections.FXCollections;
import javafx.scene.control.*;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import org.example.doggofetch.pojo.Category;
import org.example.doggofetch.pojo.Product;
import org.example.doggofetch.pojo.Supplier;
import org.example.doggofetch.tables.CategoryTable;
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
    private static AddProductTab instance;

    public AddProductTab(){
        this.setText("Add Product");

        Text welcome = new Text("Welcome to add items");
        Text confirmMessage = new Text("Product Added Successfully");

        GridPane root = new GridPane();
        root.setHgap(10);
        root.setVgap(10);

        //get table instances
        ProductTable productTable = new ProductTable();
        CategoryTable categoryTable = CategoryTable.getInstance();
        SupplierTable supplierTable = SupplierTable.getInstance();

        // product name
        Text name = new Text("Name: ");
        TextField tfName = new TextField();
        root.add(name,0,0);
        root.add(tfName,1,0);

        // product sku
        Text sku = new Text("SKU: ");
        TextField tfSku = new TextField();
        root.add(sku,0,1);
        root.add(tfSku,1,1);

        // product Qty
        Text qty = new Text("Quantity: ");
        TextField tfQty = new TextField();
        root.add(qty,0,2);
        root.add(tfQty,1,2);

        // product location
        Text location = new Text("Location: ");
        TextField tfLocation = new TextField();
        root.add(location,0,3);
        root.add(tfLocation,1,3);

        Text category = new Text("Category");
        ComboBox<Category> comboCategory = new ComboBox<>();
        comboCategory.setItems(FXCollections.observableList(categoryTable.getAllCategory()));
        comboCategory.getSelectionModel().select(0);
        root.add(category, 0,4);
        root.add(comboCategory, 1, 4);

        Text supplier = new Text("Supplier");
        ComboBox<Supplier> comboSupplier = new ComboBox<>();
        comboSupplier.setItems(FXCollections.observableList(supplierTable.getAllSuppliers()));
        comboSupplier.getSelectionModel().select(0);
        root.add(supplier, 0,5);
        root.add(comboSupplier, 1, 5);

        Button submitButton = new Button(" Add New Product ");
        int id = 0;
        submitButton.setOnAction( e->{
            try {
                Product product = new Product(
                        id, // null value needs to pass to add in entry
                        tfName.getText(),
                        Integer.parseInt(tfSku.getText()),
                        Integer.parseInt(tfQty.getText()),
                        tfLocation.getText(),
                        comboCategory.getSelectionModel().getSelectedItem().getId(),
                        comboSupplier.getSelectionModel().getSelectedItem().getId()
                );
                productTable.createProduct(product);

                // add confirmation pane

                tfName.clear();
                tfSku.clear();
                tfQty.clear();
                tfLocation.clear();


                root.add(confirmMessage, 1, 7);

                ProductStatsTab.getInstance().generateChart();
            } catch(Exception ex){
                ex.printStackTrace();
            }
        });

        root.add(submitButton, 1, 6);

        this.setContent(root);

    } // end AddProductTab f    orm

    public static AddProductTab getInstance(){
        if(instance == null){
            instance = new AddProductTab();
        }
        return instance;
    } // end create instance call


} // end addItemTab class

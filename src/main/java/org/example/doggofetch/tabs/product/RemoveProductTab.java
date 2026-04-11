package org.example.doggofetch.tabs.product;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.PieChart;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import org.example.doggofetch.pojo.DisplayProduct;
import org.example.doggofetch.pojo.Product;
import org.example.doggofetch.tables.ProductTable;
import org.example.doggofetch.tables.SupplierTable;

import java.util.ArrayList;


public class RemoveProductTab extends Tab {

    private static RemoveProductTab instance;

    public TableView tableView;

    public RemoveProductTab(){
        this.setText("Remove Product");

        GridPane gridPane = new GridPane();
        gridPane.setHgap(10);
        gridPane.setVgap(10);

        //get item istances
        ProductTable productTable = new ProductTable();
        SupplierTable supplierTable = SupplierTable.getInstance();

        Text productId = new Text("Product ID: ");
        TextField productIdField = new TextField();
        productIdField.setPromptText("Product ID");
        gridPane.add(productId,0,0);
        gridPane.add(productIdField,1,0);

        Text productName = new Text("Product Name: ");
        TextField productNameField = new TextField();
        productNameField.setPromptText("Product Name");
        gridPane.add(productName,0,1);
        gridPane.add(productNameField,1,1);

        Text supplierName = new Text("Supplier Name: ");
        TextField supplierNameField = new TextField();
        supplierNameField.setPromptText("Supplier Name");
        gridPane.add(supplierName,0,2);
        gridPane.add(supplierNameField,1,2);

        Text quantity = new Text("Quantity: ");
        TextField quantityField = new TextField();
        productNameField.setPromptText("Quantity");
        gridPane.add(quantity,0,3);
        gridPane.add(quantityField,1,3);

        Button removeButton = new Button("Remove Product");
        removeButton.setOnAction(e -> {
//            Product product = new Product();
//            productNameField.getText();
//            supplierNameField.getText();
//            Integer.parseInt(quantityField.getText());
//
//            productTable.deleteProduct(product.getId());
//            RemoveProductTab.getInstance().refreshTable();
        });
        gridPane.add(removeButton,1,4);

        this.setContent(gridPane);

    }



    public void refreshTable(){
        ProductTable product = ProductTable.getInstance();
        tableView.getItems().clear();
        tableView.getItems().addAll(product.getAllProducts());
    }
    public static RemoveProductTab getInstance(){
        if(instance == null){
            instance = new RemoveProductTab();
        }
        return instance;
    }
}
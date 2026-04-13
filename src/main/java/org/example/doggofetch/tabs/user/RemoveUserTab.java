
/**
 * RemoveUserTab
 * @author hania
 * @date 13apr26
 * remove in user tab feature
 * @version 1.0
 */

package org.example.doggofetch.tabs.user;

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
import org.example.doggofetch.tables.UserTable;

import java.util.ArrayList;


public class RemoveUserTab extends Tab {

    private static RemoveUserTab instance;

    public TableView tableView;

    public RemoveUserTab(){
        this.setText("Remove User");

        GridPane gridPane = new GridPane();
        gridPane.setHgap(10);
        gridPane.setVgap(10);

        //get item istances
        UserTable userTable = new UserTable();


        Text dbUser = new Text("Enter in USER: ");
        TextField dbUserTf = new TextField();
        dbUserTf.setPromptText("User Name");
        gridPane.add(dbUser,0,0);
        gridPane.add(dbUserTf,1,0);

//        Text productName = new Text("Product Name: ");
//        TextField productNameField = new TextField();
//        productNameField.setPromptText("Product Name");
//        gridPane.add(productName,0,1);
//        gridPane.add(productNameField,1,1);
//
//        Text supplierName = new Text("Supplier Name: ");
//        TextField supplierNameField = new TextField();
//        supplierNameField.setPromptText("Supplier Name");
//        gridPane.add(supplierName,0,2);
//        gridPane.add(supplierNameField,1,2);
//
//        Text quantity = new Text("Quantity: ");
//        TextField quantityField = new TextField();
//        productNameField.setPromptText("Quantity");
//        gridPane.add(quantity,0,3);
//        gridPane.add(quantityField,1,3);

        Button removeButton = new Button("Remove User");
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
        UserTable user = UserTable.getInstance();
        tableView.getItems().clear();
        tableView.getItems().addAll(user.getAllUsers());
    }
    public static RemoveUserTab getInstance(){
        if(instance == null){
            instance = new RemoveUserTab();
        }
        return instance;
    }
}
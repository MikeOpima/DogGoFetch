package org.example.doggofetch.tabs.supplier;

import javafx.collections.FXCollections;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import org.example.doggofetch.pojo.Supplier;
import org.example.doggofetch.tables.ProductTable;
import org.example.doggofetch.tables.SupplierTable;
import org.example.doggofetch.tabs.product.RemoveProductTab;

public class RemoveSupplierTab extends Tab {

    private static RemoveSupplierTab instance;

    public TableView tableView;

    public RemoveSupplierTab(){
        this.setText("Remove Supplier");

        GridPane gridPane = new GridPane();
        gridPane.setHgap(10);
        gridPane.setVgap(10);

        //get item instances
        SupplierTable supplierTable = SupplierTable.getInstance();


        Text supplierId = new Text("Supplier ID: ");
        TextField supplierNameField = new TextField();
        supplierNameField.setPromptText("Supplier ID");
        gridPane.add(supplierId,0,0);
        gridPane.add(supplierNameField,1,0);

        Text supplierName = new Text("Supplier Name: ");
        ComboBox<Supplier> comboSupplier = new ComboBox<>();
        comboSupplier.setItems(FXCollections.observableList(supplierTable.getAllSuppliers()));
        comboSupplier.getSelectionModel().select(0);
        gridPane.add(supplierName,0 ,1);
        gridPane.add(comboSupplier, 1, 1);

        Button removeButton = new Button("Remove Supplier");
        removeButton.setOnAction(e -> {
            Supplier supplier = new Supplier();
            supplierNameField.getText();
            supplierNameField.getText();
            Integer.parseInt(supplierNameField.getText());

            supplierTable.deleteSupplier(supplier.getId());
            RemoveProductTab.getInstance().refreshTable();
        });
        gridPane.add(removeButton,1,4);

        this.setContent(gridPane);

    }

    public void refreshTable(){
        ProductTable product = ProductTable.getInstance();
        tableView.getItems().clear();
        tableView.getItems().addAll(product.getAllProducts());
    }
    public static RemoveSupplierTab getInstance(){
        if(instance == null){
            instance = new RemoveSupplierTab();
        }
        return instance;
    }

}

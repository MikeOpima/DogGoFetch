package org.example.doggofetch.tabs;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import org.example.doggofetch.pojo.DisplayProduct;
import org.example.doggofetch.pojo.Product;
import org.example.doggofetch.tables.ProductTable;

import static org.example.doggofetch.database.DBConst.*;
import static org.example.doggofetch.database.DBConst.PRODUCT_COLUMN_CATEGORY;

public class RemoveProductTab extends Tab {
    private static RemoveProductTab instance;

    public TableView tableView;

    public RemoveProductTab(){
        this.setText("Remove Product");
        ProductTable product = ProductTable.getInstance();
        BorderPane root = new BorderPane();
        tableView = new TableView();
//            Text welcome = new Text("Remove Items");
//      Product Name
        TableColumn<DisplayProduct, String> column1 = new TableColumn<>("Product Name");

        column1.setCellValueFactory(
                e-> new SimpleStringProperty(e.getValue().getName()));

        TableColumn<DisplayProduct, String> column2  = new TableColumn<>("Product Supplier");

        column2.setCellValueFactory(
                e-> new SimpleStringProperty(e.getValue().getSupplier()));

        TableColumn<DisplayProduct, String> column3  = new TableColumn<>("Product Quantity");

        column3.setCellValueFactory(
                e->new SimpleStringProperty(String.valueOf(e.getValue().getQuantity())));

        tableView.getColumns().addAll(column1, column2, column3);
        tableView.getItems().addAll(product.getAllProducts()); //select * from displayable table
        root.setCenter(tableView);
        Button removeProduct = new Button("Remove Product");
        removeProduct.setOnAction(e -> {
            DisplayProduct remove = (DisplayProduct) tableView.getSelectionModel().getSelectedItem();
            product.deleteProduct(remove.getId());
            refreshTable();
            tableView.getItems().clear();
            tableView.getItems().addAll(product.getAllProducts());  /// getAllProoducts is supposed to be the table the user views like PrettyItems
            ProductStatsTab.getInstance().generateChart();

        });

        tableView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observableValue, Object oldValue, Object newValue) {
                System.out.println("Changed");
                if (newValue != null) {
                    Product selectedProduct = product.getProduct(((DisplayProduct) newValue).getId());
                    //Product object version of DisplayItem (Selected in table)
                    UpdateItemPane pane = new UpdateItemPane(selectedProduct);  /// TO-FIXX
                    root.getRight(pane);
                }
            }
        });
        root.setBottom(removeProduct);
        this.setContent(root);

    }// end con
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
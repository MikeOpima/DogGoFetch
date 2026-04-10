package org.example.doggofetch.tabs;

import javafx.beans.property.SimpleStringProperty;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;
import org.example.doggofetch.pojo.Supplier;
import org.example.doggofetch.tables.SupplierTable;

public class SupplierTab extends Tab {
    private static  SupplierTab instance;

    public TableView tableView;

    private SupplierTab() {
        this.setText("Supplier Tab");
        SupplierTable supplier = SupplierTable.getInstance();
        BorderPane root = new BorderPane();
        tableView = new TableView();

        TableColumn<Supplier, String> getSupplierStringTableColumn;

        TableColumn<Supplier, String> column1 = new TableColumn<>("Supplier Name");
            column1.setCellValueFactory(
                    e -> new SimpleStringProperty(e.getValue().getName()));
        TableColumn<Supplier, String> column2 = new TableColumn<>("Supplier Address");
            column2.setCellValueFactory(
                    e -> new SimpleStringProperty(e.getValue().getAddress()));

        TableColumn<Supplier, String> column3 = new TableColumn<>("Supplier Province");
            column3.setCellValueFactory(
                    e -> new SimpleStringProperty(e.getValue().getProvince()));

        TableColumn<Supplier, String> column4 = new TableColumn<>("Supplier City");
            column4.setCellValueFactory(
                    e -> new SimpleStringProperty(e.getValue().getCity()));

        TableColumn<Supplier, String> column5 = new TableColumn<>("Supplier Postal Code");
            column5.setCellValueFactory(
                    e -> new SimpleStringProperty(e.getValue().getPostalcode()));

        TableColumn<Supplier, String> column6 = new TableColumn<>("Supplier Contact");
            column6.setCellValueFactory(
                    e -> new SimpleStringProperty(e.getValue().getPhone()));

        TableColumn<Supplier, String> column7 = new TableColumn<>("Supplier Email");
            column7.setCellValueFactory(
                    e -> new SimpleStringProperty(e.getValue().getEmail()));

        tableView.getColumns().addAll(column1, column2, column3, column4, column5, column6);
        tableView.getItems().addAll(supplier.getSuppliers()); // select * from suppliers

        root.setCenter(tableView);

        }


    }

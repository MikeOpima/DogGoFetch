package org.example.doggofetch.tabs.product;

import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import org.example.doggofetch.pojo.*;
import org.example.doggofetch.tables.CategoryTable;
import org.example.doggofetch.tables.ProductTable;
import org.example.doggofetch.tables.SupplierTable;

import java.util.ArrayList;


/**
 * UpdateProductPane Class
 * @author katkoe
 * 5apr26
 */

public class UpdateProductTab extends Tab {

    private static UpdateProductTab instance;

    public int find(ArrayList<?> arrayList, int id){
        ArrayList<DatabaseItem> searchList = (ArrayList<DatabaseItem>)
                ((ArrayList<?>) arrayList);
        for(int i = 0; i < searchList.size(); i++){
            if(searchList.get(i).getId() == id){
                return i;
            }
        }
        return 0;
    }

    public static UpdateProductTab getInstance(){
        if(instance == null){
            instance = new UpdateProductTab();
        }
        return instance;
    } // end create instance call

    public UpdateProductTab() {
        this.setText("Update Product");

        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(10, 10, 10, 10));
        gridPane.setVgap(10);
        gridPane.setHgap(10);

        ProductTable productTable = ProductTable.getInstance();
        SupplierTable supplierTable = SupplierTable.getInstance();
        CategoryTable categoryTable = CategoryTable.getInstance();

        // id comboBox
        GridPane selectProductPane = new GridPane();
        Text productIdLabel = new Text("Select A Product: ");
        ComboBox<Product> comboProduct = new ComboBox<>();
        ArrayList<Product> allProducts= productTable.getAllProducts();
        comboProduct.setItems(FXCollections.observableArrayList(productTable.getAllProducts()));

        comboProduct.getSelectionModel().select(0);
        selectProductPane.add(productIdLabel, 0, 0);
        selectProductPane.add(comboProduct, 1, 0);
        Button selectButton = new Button(" Update Product ");
        selectButton.setOnAction((e -> {
            productSelectedId = comboProduct.getSelectionModel().getSelectedItem().getId();
        }));
        selectProductPane.add(selectButton, 1, 1);
        // end id combo box selector

        if(productSelectedId <= 0){
            GridPane updateGridPane = new GridPane();
            // product name
            Text name = new Text("Name: ");
            TextField tfName = new TextField();
            tfName.setText(String.valueOf(productTable.getProduct(productSelectedId).getName()));
            updateGridPane.add(name, 0, 0);
            updateGridPane.add(tfName, 1, 0);

            // product sku
            Text sku = new Text("SKU: ");
            TextField tfSku = new TextField();
            tfSku.setText(String.valueOf(productTable.getProduct(productSelectedId).getSku()));
            updateGridPane.add(sku, 0, 1);
            updateGridPane.add(tfSku, 1, 1);

            // product Qty
            Text qty = new Text("Quantity: ");
            TextField tfQty = new TextField();
            tfQty.setText(String.valueOf(productTable.getProduct(productSelectedId).getQuantity()));
            updateGridPane.add(qty, 0, 2);
            updateGridPane.add(tfQty, 1, 2);

            // product location
            Text location = new Text("Location: ");
            TextField tfLocation = new TextField();
            tfLocation.setText(String.valueOf(productTable.getProduct(productSelectedId).getLocation()));
            updateGridPane.add(location, 0, 3);
            updateGridPane.add(tfLocation, 1, 3);

            // category id comboBox
            Text category = new Text("Category: ");
            ComboBox<Category> comboCategory = new ComboBox<>();
            ArrayList<Category> allCategories = categoryTable.getAllCategory();
            comboCategory.setItems(FXCollections.observableArrayList(allCategories));
            comboCategory.getSelectionModel().select(find(allCategories, productTable.getProduct(productSelectedId).getCategory()));
            updateGridPane.add(category, 0, 4);
            updateGridPane.add(comboCategory, 1, 4);

            // supplier id comboBox
            Text supplier = new Text("Supplier: ");
            ComboBox<Supplier> comboSupplier = new ComboBox<>();
            ArrayList<Supplier> allSuppliers = supplierTable.getAllSuppliers();
            comboSupplier.setItems(FXCollections.observableArrayList(allSuppliers));
            comboSupplier.getSelectionModel().select(find(allCategories, productTable.getProduct(productSelectedId).getSupplier()));
            updateGridPane.add(name, 0, 5);
            updateGridPane.add(comboSupplier, 1, 5);

            Button updateButton = new Button(" Update Product ");
            updateButton.setOnAction((e -> {

                System.out.println("update action complete");
//                product.setId(productSelectedId);
//                product.setCategory(comboCategory.getSelectionModel().getSelectedItem().getId());
//                product.setSupplier(comboSupplier.getSelectionModel().getSelectedItem().getId());
//                product.setName(tfName.getText());
//                product.setSku(Integer.parseInt(tfSku.getText()));
//                product.setQuantity(Integer.parseInt(tfQty.getText()));
//                product.setLocation(tfLocation.getText());

            }));
            updateGridPane.add(updateButton, 1, 6);

        }

    } // end UpdateProductPane

} // end updateProductTab class

package org.example.doggofetch.tabs.product;

import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import org.example.doggofetch.pojo.Category;
import org.example.doggofetch.pojo.DatabaseItem;
import org.example.doggofetch.pojo.Product;
import org.example.doggofetch.pojo.Supplier;
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

    /**
     * Search Feature to Update Product
     *
     * @param arraylist
     * @param id
     * @return
     */
    public int find(ArrayList<?> arraylist, int id) {
        ArrayList<DatabaseItem> searchList = (ArrayList<DatabaseItem>)
                ((ArrayList<?>) arraylist);
        for (int i = 0; i < searchList.size(); i++) {
            if (searchList.get(i).getId() == id) {
                return i;
            }
        }
        return 0;
    }

    public UpdateProductTab(Product selectedProduct) {
        this.setText("Update Product");

        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(10, 10, 10, 10));
        gridPane.setVgap(10);
        gridPane.setHgap(10);

        Product product = selectedProduct;
        ProductTable productTable = ProductTable.getInstance();
        SupplierTable supplierTable = SupplierTable.getInstance();
        CategoryTable categoryTable = CategoryTable.getInstance();

        // product name
        Text name = new Text("Name: ");
        TextField tfName = new TextField();
        tfName.setText(String.valueOf(product.getName()));
        gridPane.add(name, 0, 0);
        gridPane.add(tfName, 1, 0);

        // product sku
        Text sku = new Text("SKU: ");
        TextField tfSku = new TextField();
        tfSku.setText(String.valueOf(product.getSku()));
        gridPane.add(sku, 0, 1);
        gridPane.add(tfSku, 1, 1);

        // product Qty
        Text qty = new Text("Quantity: ");
        TextField tfQty = new TextField();
        tfQty.setText(String.valueOf(product.getSku()));
        gridPane.add(qty, 0, 2);
        gridPane.add(tfQty, 1, 2);

        // product location
        Text location = new Text("Location: ");
        TextField tfLocation = new TextField();
        tfLocation.setText(String.valueOf(product.getName()));
        gridPane.add(location, 0, 3);
        gridPane.add(tfLocation, 1, 3);

        // category id comboBox
        Text category = new Text("Category: ");
        ComboBox<Category> comboCategory = new ComboBox<>();
        ArrayList<Category> allCategories = categoryTable.getAllCategory();
        comboCategory.setItems(FXCollections.observableArrayList(allCategories));
        comboCategory.getSelectionModel().select(find(allCategories, product.getId()));
        gridPane.add(category, 0, 4);
        gridPane.add(comboCategory, 1, 4);

        // supplier id comboBox
        Text supplier = new Text("Supplier: ");
        ComboBox<Supplier> comboSupplier = new ComboBox<>();
        ArrayList<Supplier> allSuppliers = supplierTable.getAllSuppliers();
        comboSupplier.setItems(FXCollections.observableArrayList(allSuppliers));
        comboSupplier.getSelectionModel().select(find(allSuppliers, product.getId()));
        gridPane.add(name, 0, 5);
        gridPane.add(comboSupplier, 1, 5);

        Button updateButton = new Button(" Update Product ");
        updateButton.setOnAction((e -> {
            product.setCategory(comboCategory.getSelectionModel().getSelectedItem().getId());
            product.setSupplier(comboSupplier.getSelectionModel().getSelectedItem().getId());
            product.setName(tfName.getText());
            product.setSku(Integer.parseInt(tfSku.getText()));
            product.setQuantity(Integer.parseInt(tfQty.getText()));
            product.setLocation(tfLocation.getText());

            productTable.updateProduct(product);

        }));
        gridPane.add(updateButton, 1, 6);
    } // end UpdateProductPane


    public UpdateProductTab() {
    }

    public static UpdateProductTab getInstance(){
        if(instance == null){
            instance = new UpdateProductTab();
        }
        return instance;
    } // end create instance call

    public void refreshTable(){
        System.out.println("Test refresh");
//        ItemTable table = ItemTable.getInstance();
//        tableView.getItems().clear();
//        tableView.getItems().addAll(table.getPrettyItems());
    }


} // end updateProductTab class

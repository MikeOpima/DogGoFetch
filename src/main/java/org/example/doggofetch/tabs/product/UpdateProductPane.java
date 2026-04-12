package org.example.doggofetch.tabs.product;

import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
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

public class UpdateProductPane extends GridPane {

    /**
     * Search Feature to Update Product
     * @param arraylist
     * @param id
     * @return
     */
    public int find(ArrayList<?> arraylist, int id){
        ArrayList<DatabaseItem> searchList = (ArrayList<DatabaseItem>)
                ((ArrayList<?>) arraylist);
        for(int i = 0 ; i < searchList.size(); i++){
            if(searchList.get(i).getId() == id){
                return i;
            }
        }
        return 0;
    }

    public UpdateProductPane(Product selectedProduct) {
        this.setPadding(new Insets(10,10,10,10));
        this.setVgap(10);
        this.setHgap(10);

        Product product = selectedProduct;
        ProductTable productTable = ProductTable.getInstance();
        SupplierTable supplierTable = SupplierTable.getInstance();
        CategoryTable categoryTable = CategoryTable.getInstance();

        // product name
        Text name = new Text("Name: ");
        TextField tfName = new TextField();
        tfName.setText(String.valueOf(product.getName()));
        this.add(name,0,0);
        this.add(tfName,1,0);

        // product sku
        Text sku = new Text("SKU: ");
        TextField tfSku = new TextField();
        tfSku.setText(String.valueOf(product.getSku()));
        this.add(sku,0,1);
        this.add(tfSku,1,1);

        // product Qty
        Text qty = new Text("Quantity: ");
        TextField tfQty = new TextField();
        tfQty.setText(String.valueOf(product.getSku()));
        this.add(qty,0,2);
        this.add(tfQty,1,2);

        // product location
        Text location = new Text("Location: ");
        TextField tfLocation = new TextField();
        tfLocation.setText(String.valueOf(product.getName()));
        this.add(location,0,3);
        this.add(tfLocation,1,3);

        // category id comboBox
        Text category = new Text("Category: ");
        ComboBox<Category> comboCategory = new ComboBox<>();
        ArrayList<Category> allCategories = categoryTable.getAllCategory();
        comboCategory.setItems(FXCollections.observableArrayList(allCategories));
        comboCategory.getSelectionModel().select(find(allCategories, product.getId()));
        this.add(category, 0,4);
        this.add(comboCategory,1,4);

        // supplier id comboBox
        Text supplier = new Text("Supplier: ");
        ComboBox<Supplier> comboSupplier = new ComboBox<>();
        ArrayList<Supplier> allSuppliers = supplierTable.getAllSuppliers();
        comboSupplier.setItems(FXCollections.observableArrayList(allSuppliers));
        comboSupplier.getSelectionModel().select(find(allSuppliers, product.getId()));
        this.add(name, 0,5);
        this.add(comboSupplier,1,5);

        Button updateButton = new Button(" Update Product ");
        updateButton.setOnAction(( e->{
            product.setCategory(comboCategory.getSelectionModel().getSelectedItem().getId());
            product.setSupplier(comboSupplier.getSelectionModel().getSelectedItem().getId());
            product.setName(tfName.getText());
            product.setSku(Integer.parseInt(tfSku.getText()));
            product.setQuantity(Integer.parseInt(tfQty.getText()));
            product.setLocation(tfLocation.getText());

        }));
        this.add(updateButton, 1, 6);
    } // end UpdateProductPane
} // end class

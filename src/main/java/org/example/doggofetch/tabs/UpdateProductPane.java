package org.example.doggofetch.tabs;

import javafx.collections.FXCollections;
import javafx.geometry.Insets;
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

        Product product1 = selectedProduct;
        ProductTable productTable = ProductTable.getInstance();
        SupplierTable supplierTable = SupplierTable.getInstance();
        CategoryTable categoryTable = CategoryTable.getInstance();

        // product
        Text name = new Text("Year");
        TextField tfName = new TextField();
        tfName.setText(String.valueOf(product1.getName()));
        this.add(name,0,1);
        this.add(tfName,1,1);

        // and category name
        Text category = new Text("Category: ");
        ComboBox<Category> comboCategory = new ComboBox<>();
        ArrayList<Category> allCategories = categoryTable.getAllCategory();
        comboCategory.setItems(FXCollections.observableArrayList(allCategories));
        comboCategory.getSelectionModel().select(find(allCategories, product1.getId()));
        this.add(category, 0,1);
        this.add(comboCategory,1,1);

        // supplier combo box select option
        Text supplier = new Text("Supplier: ");
        ComboBox<Supplier> comboSupplier = new ComboBox<>();
        ArrayList<Supplier> allSuppliers = supplierTable.getAllSuppliers();
        comboSupplier.setItems(FXCollections.observableArrayList(allSuppliers));
        comboSupplier.getSelectionModel().select(find(allSuppliers, product1.getId()));
        this.add(name, 0,2);
        this.add(comboSupplier,1,2);






    }



}

package org.example.doggofetch;

import org.example.doggofetch.pojo.Category;
import org.example.doggofetch.pojo.Product;
import org.example.doggofetch.pojo.Supplier;
import org.example.doggofetch.tables.CategoryTable;
import org.example.doggofetch.tables.ProductTable;
import org.example.doggofetch.tables.SupplierTable;

import java.util.ArrayList;
import java.util.Collections;

public class ConfigAddSampleData {
    private static ConfigAddSampleData instance;
    // loop to prepopulate sql tables

    /**
     * ConfigAddSampleData Class
     * Load Sample Data at Config.txt file creation only
     * @author katkoe
     * 8apr26
     **/
    public ConfigAddSampleData() {
        //get table instances // set up sample data loads

        CategoryTable categoryTable = CategoryTable.getInstance();
        ArrayList<String> categoryLoad = new ArrayList<String>();

        categoryLoad.add("Tools");
        categoryLoad.add("Fasteners - Hardware");
        categoryLoad.add("Equipment - Heavy");
        categoryLoad.add("Equipment - Light");
        categoryLoad.add("Electronics");
        categoryLoad.add("Electronics - Fragile");
        categoryLoad.add("Packaging Materials");
        categoryLoad.add("Structure Metal");

        for (String category : categoryLoad) {
            categoryTable.createCategory(new Category(category));
        }

        SupplierTable supplierTable = SupplierTable.getInstance();
        ArrayList<String> supplierLoad = new ArrayList<String>();
        supplierTable.createSupplier(new Supplier(0, "Global Something", "123 main", "Windsor", "ON", "465468685", "65465465", "slkd@lskdjls.com"));


        ProductTable productTable = ProductTable.getInstance();
        productTable.createProduct(new Product(0,"Hammer",1001, 50, "Aisle 1 - Shelf A", 1 , 1));
        }

    public static ConfigAddSampleData getInstance(){
        if(instance == null){
            instance = new ConfigAddSampleData();
        }
        return instance;
    }



}

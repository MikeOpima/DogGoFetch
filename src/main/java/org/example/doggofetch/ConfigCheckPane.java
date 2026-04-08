package org.example.doggofetch;

import org.example.doggofetch.database.Database;
import org.example.doggofetch.pojo.Category;
import org.example.doggofetch.tables.CategoryTable;
import org.example.doggofetch.tables.ProductTable;
import org.example.doggofetch.tables.SupplierTable;

import java.util.ArrayList;

public class ConfigCheckPane {
    private static ConfigCheckPane instance;
    // loop to prepopulate sql tables

    public ConfigCheckPane() {
        //get table instances
        ProductTable productTable = new ProductTable();
        CategoryTable categoryTable = CategoryTable.getInstance();
        SupplierTable supplierTable = SupplierTable.getInstance();

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

    }

    public static ConfigCheckPane getInstance(){
        if(instance == null){
            instance = new ConfigCheckPane();
        }
        return instance;
    }



}

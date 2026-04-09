package org.example.doggofetch;

import org.example.doggofetch.pojo.Category;
import org.example.doggofetch.tables.CategoryTable;
import org.example.doggofetch.tables.ProductTable;
import org.example.doggofetch.tables.SupplierTable;

import java.util.ArrayList;

public class ConfigAddSampleData {
    private static ConfigAddSampleData instance;
    // loop to prepopulate sql tables

    /**
     * ConfigCheckPane Class
     * Load Sample Data at Config.txt file creation
     * @author katkoe
     * 8apr26
     * v1.0
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

        ProductTable productTable = new ProductTable();

    }

    public static ConfigAddSampleData getInstance(){
        if(instance == null){
            instance = new ConfigAddSampleData();
        }
        return instance;
    }



}

package org.example.doggofetch;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.text.Text;
import org.example.doggofetch.pojo.Category;
import org.example.doggofetch.pojo.Product;
import org.example.doggofetch.pojo.Supplier;
import org.example.doggofetch.pojo.User;
import org.example.doggofetch.tables.CategoryTable;
import org.example.doggofetch.tables.ProductTable;
import org.example.doggofetch.tables.SupplierTable;
import org.example.doggofetch.tables.UserTable;

import java.util.ArrayList;

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

        // preload categories
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

        // preload suppliers
        SupplierTable supplierTable = SupplierTable.getInstance();
        ArrayList<String> supplierLoad = new ArrayList<String>();
        supplierTable.createSupplier(new Supplier(0, "Global Something", "123 main", "Windsor", "ON", "465468685", "65465465", "slkd@lskdjls.com"));

        supplierTable.createSupplier(new Supplier(0, "Global Tools Inc.", "123 Industrial Way", "Detroit", "MI", "465468685", "+1-313-555-1001", "contact@globaltools.com"));
        supplierTable.createSupplier(new Supplier(0, "Fasteners Co.", "456 Bolt Ave", "Cleveland", "OH", "465468685", "+1-216-555-1002", "sales@fastenersco.com"));
        supplierTable.createSupplier(new Supplier(0, "Industrial Supply Ltd.", "789 Factory Rd", "Chicago", "IL", "465468685", "+1-312-555-1003", "info@industrialsupply.com"));
        supplierTable.createSupplier(new Supplier(0, "Warehouse Goods Inc.", "321 Distribution St", "Toledo", "OH", "465468685", "+1-419-555-1004", "support@warehousegoods.com"));
        supplierTable.createSupplier(new Supplier(0, "TechSource Ltd.", "654 Silicon Blvd", "San Jose", "CA", "465468685", "+1-408-555-1005", "help@techsource.com"));
        supplierTable.createSupplier(new Supplier(0, "Packaging Experts", "987 Box Lane", "Indianapolis", "IN", "465468685", "+1-317-555-1006", "orders@packagingexperts.com"));
        supplierTable.createSupplier(new Supplier(0, "Logistics Supply Co.", "147 Transport Dr", "Columbus", "OH", "465468685", "+1-614-555-1007", "logistics@suppliesco.com"));
        supplierTable.createSupplier(new Supplier(0, "Bulk Materials Inc.", "258 Steel Yard", "Pittsburgh", "PA", "465468685", "+1-412-555-1008", "bulk@materialsinc.com"));
        supplierTable.createSupplier(new Supplier(0, "Hardware Hub", "369 Tool St", "Grand Rapids", "MI", "465468685", "+1-616-555-1009", "sales@hardwarehub.com"));
        supplierTable.createSupplier(new Supplier(0, "Precision Parts Ltd.", "159 Measure Ave", "Dayton", "OH", "465468685", "+1-937-555-1010", "info@precisionparts.com"));

        // preload products
        ProductTable productTable = ProductTable.getInstance();
        productTable.createProduct(new Product(0,"Hammer",1001, 50, "Aisle 1 - Shelf A", 1 , 1));
        productTable.createProduct(new Product(0,"Screwdriver Set", 1002, 5, "Aisle 2 - Shelf A", 1 ,3));
        productTable.createProduct(new Product(0,"Nails (Box)", 1003, 120, "Aisle 1 - Shelf B", 1 ,2));
        productTable.createProduct(new Product(0,"Drill Machine", 1004, 20, "Aisle 2 - Shelf C", 1 ,3));
        productTable.createProduct(new Product(0,"Laptop", 1005, 15, "Aisle 3 - Shelf B", 1 ,3));
        productTable.createProduct(new Product(0,"Cardboard Boxes", 1006, 90, "Aisle 4 - Shelf A", 1 ,1));
        productTable.createProduct(new Product(0,"Forklift Battery", 1007, 10, "Aisle 4 - Shelf D", 1 ,1));
        productTable.createProduct(new Product(0,"Steel Beams", 1008, 300, "Aisle 5 - Shelf A", 1 ,1));
        productTable.createProduct(new Product(0,"Wrench Set", 1009,45, "Aisle 5 - Shelf C", 1 ,2));
        productTable.createProduct(new Product(0,"Measuring Tape", 1010,25, "Aisle 6 - Shelf B",1 , 2));

        // preload users
        UserTable userTable = UserTable.getInstance();
        userTable.createUser(new User(0, "admin1", "User1","User1LastName","can123","Admin"));


    } // end Preload - ConfigAddSampleData

    public static ConfigAddSampleData getInstance(){
        if(instance == null){
            instance = new ConfigAddSampleData();
        }
        return instance;
    }



}

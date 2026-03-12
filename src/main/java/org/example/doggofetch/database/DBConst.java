package org.example.doggofetch.database;

public class DBConst {

    //Product table
    public static final String TABLE_PRODUCT = "Product";
    public static final String PRODUCT_COLUMN_ID = "Id";
    public static final String PRODUCT_COLUMN_NAME = "Name";
    public static final String PRODUCT_COLUMN_QUANTITY = "Quantity";
    public static final String PRODUCT_COLUMN_LOCATION = "Location";
    public static final String PRODUCT_COLUMN_SUPPLIER = "Supplier";

    //INVENTORY TABLE
    public static final String TABLE_INVENTORY = "Inventory";
    public static final String INVENTORY_COLUMN_ID = "Id";
    public static final String INVENTORY_COLUMN_QUANTITY = "Quantity";
    public static final String INVENTORY_COLUMN_NAME = "Name";
    public static final String INVENTORY_COLUMN_DESCRIPTION = "DESCRIPTION";
    public static final String INVENTORY_COLUMN_LOCATION = "Location";

    //ORDER TABLE
    public static final String TABLE_ORDER = "Order";
    public static final String ORDER_COLUMN_ID = "Id";
    public static final String ORDER_COLUMN_DATE = "Date";
    public static final String ORDER_COLUMN_QUANTITY = "Quantity";
    public static final String ORDER_COLUMN_STATUS = "Status";

    //SUPPLIER TABLE
    public static final String TABLE_SUPPLIER = "Supplier";
    public static final String SUPPLIER_COLUMN_ID = "Id";
    public static final String SUPPLIER_COLUMN_NAME = "Name";
    public static final String SUPPLIER_COLUMN_ADDRESS = "Address";
    public static final String SUPPLIER_COLUMN_PHONE = "Phone";
    public static final String SUPPLIER_COLUMN_EMAIL = "Email";

    public static final String CREATE_TABLE_INVENTORY =
            "CREATE TABLE IF NOT EXISTS "+ TABLE_INVENTORY +"(" +
                    INVENTORY_COLUMN_ID + " INT NOT NULL AUTO_INCREMENT, " +
                    INVENTORY_COLUMN_QUANTITY + " INT NOT NULL), " +
                    INVENTORY_COLUMN_NAME + " VARCHAR(200) NOT NULL), " +
                    INVENTORY_COLUMN_DESCRIPTION + " VARCHAR(200) NOT NULL), " +
                    INVENTORY_COLUMN_LOCATION + " VARCHAR(200) NOT NULL), " +
                    "PRIMARY KEY(" + INVENTORY_COLUMN_ID + "))";

    public static final String CREATE_TABLE_ORDER =
            "CREATE TABLE IF NOT EXISTS "+ TABLE_ORDER +"(" +
                    ORDER_COLUMN_ID + " INT NOT NULL AUTO_INCREMENT, " +
                    ORDER_COLUMN_DATE + " VARCHAR(12) NOT NULL), " +
                    ORDER_COLUMN_QUANTITY + " INT NOT NULL), " +
                    ORDER_COLUMN_STATUS + " VARCHAR(100) NOT NULL)" +
                    "PRIMARY KEY(" + INVENTORY_COLUMN_ID + "))";

    public static final String CREATE_TABLE_SUPPLIER =
            "CREATE TABLE IF NOT EXISTS "+ TABLE_SUPPLIER +"(" +
                    SUPPLIER_COLUMN_ID + " INT NOT NULL AUTO_INCREMENT, " +
                    SUPPLIER_COLUMN_NAME + " VARCHAR(200) NOT NULL), " +
                    SUPPLIER_COLUMN_ADDRESS + " VARCHAR(200) NOT NULL), " +
                    SUPPLIER_COLUMN_PHONE + " VARCHAR(200) NOT NULL)" +
                    SUPPLIER_COLUMN_EMAIL + " VARCHAR(200) NOT NULL)" +
                    "PRIMARY KEY(" + SUPPLIER_COLUMN_ID + "))";

    public static final String CREATE_TABLE_PRODUCTS =
            "CREATE TABLE IF NOT EXISTS " + TABLE_PRODUCT + " (" +
                    PRODUCT_COLUMN_ID + " INT NOT NULL AUTO_INCREMENT, " +
                    PRODUCT_COLUMN_NAME + " INT, " +
                    PRODUCT_COLUMN_QUANTITY + " INT, " +
                    PRODUCT_COLUMN_LOCATION + " VARCHAR(200) NOT NULL)" +
                    PRODUCT_COLUMN_SUPPLIER + " VARCHAR(200) NOT NULL)" +
                    "FOREIGN KEY(" +PRODUCT_COLUMN_SUPPLIER +")" +
                        "REFERENCES " + TABLE_SUPPLIER + "(" + SUPPLIER_COLUMN_ID +")," +
                    "FOREIGN KEY(" +PRODUCT_COLUMN_LOCATION +")" +
                        "REFERENCES " + TABLE_INVENTORY + "(" + INVENTORY_COLUMN_ID +")," +
                    "FOREIGN KEY(" +PRODUCT_COLUMN_QUANTITY +")" +
                        "REFERENCES " + TABLE_ORDER + "(" + ORDER_COLUMN_ID +")," +
                    "PRIMARY KEY(" + PRODUCT_COLUMN_ID + "))";
}

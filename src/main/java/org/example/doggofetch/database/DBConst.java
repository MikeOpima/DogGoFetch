package org.example.doggofetch.database;

import org.example.doggofetch.pojo.Category;

public class DBConst {

    //Product table
    public static final String TABLE_PRODUCT = "Product";
    public static final String PRODUCT_COLUMN_ID = "Id";
    public static final String PRODUCT_COLUMN_NAME = "Name";
    public static final String PRODUCT_COLUMN_SKU= "Sku";
    public static final String PRODUCT_COLUMN_QUANTITY = "Quantity";
    public static final String PRODUCT_COLUMN_LOCATION = "Location";
    public static final String PRODUCT_COLUMN_SUPPLIER = "Supplier";
    public static final String PRODUCT_COLUMN_CATEGORY = "Category";

    //INVENTORY TABLE
    public static final String TABLE_INVENTORY = "Inventory";
    public static final String INVENTORY_COLUMN_ID = "Id";
    public static final String INVENTORY_COLUMN_QUANTITY = "Quantity";
    public static final String INVENTORY_COLUMN_NAME = "Name";
    public static final String INVENTORY_COLUMN_DESCRIPTION = "Description";
    public static final String INVENTORY_COLUMN_LOCATION = "Location";

    //ORDER TABLE
    public static final String TABLE_ORDER = "Orders";
    public static final String ORDER_COLUMN_ID = "Id";
    public static final String ORDER_COLUMN_DATE = "Date";
    public static final String ORDER_COLUMN_QUANTITY = "Quantity";
    public static final String ORDER_COLUMN_STATUS = "Status";
    public static final String ORDER_COLUMN_USER_ID = "UserId";

    //SUPPLIER TABLE
    public static final String TABLE_SUPPLIER = "Supplier";
    public static final String SUPPLIER_COLUMN_ID = "Id";
    public static final String SUPPLIER_COLUMN_NAME = "Name";
    public static final String SUPPLIER_COLUMN_ADDRESS = "Address";
    public static final String SUPPLIER_COLUMN_CITY = "City";
    public static final String SUPPLIER_COLUMN_PROVINCE = "Province";
    public static final String SUPPLIER_COLUMN_POSTALCODE = "PostalCode";
    public static final String SUPPLIER_COLUMN_PHONE = "Phone";
    public static final String SUPPLIER_COLUMN_EMAIL = "Email";

    //CATEGORY TABLE
    public static final String TABLE_CATEGORY = "Category";
    public static final String CATEGORY_COLUMN_ID = "id";
    public static final String CATEGORY_COLUMN_NAME = "name";

    // USER TABLE
    public static final String TABLE_USER = "User";
    public static final String USER_COLUMN_ID = "Id";
    public static final String USER_COLUMN_FIRST_NAME = "FirstName";
    public static final String USER_COLUMN_LAST_NAME = "LastName";
    public static final String USER_COLUMN_PASSWORD = "Password";
    public static final String USER_COLUMN_ROLE = "UserRole";

    public static final String CREATE_TABLE_SUPPLIER =
            "CREATE TABLE IF NOT EXISTS "+ TABLE_SUPPLIER +"(" +
                    SUPPLIER_COLUMN_ID + " INT NOT NULL AUTO_INCREMENT, " +
                    SUPPLIER_COLUMN_NAME + " VARCHAR(200) NOT NULL, " +
                    SUPPLIER_COLUMN_ADDRESS + " VARCHAR(200) NOT NULL, " +
                    SUPPLIER_COLUMN_CITY + " VARCHAR(200) NOT NULL, " +
                    SUPPLIER_COLUMN_PROVINCE + " VARCHAR(4) NOT NULL, " +
                    SUPPLIER_COLUMN_POSTALCODE + " VARCHAR(200) NOT NULL, " +
                    SUPPLIER_COLUMN_PHONE + " VARCHAR(200) NOT NULL, " +
                    SUPPLIER_COLUMN_EMAIL + " VARCHAR(200) NOT NULL," +
                    "PRIMARY KEY(" + SUPPLIER_COLUMN_ID + "));";

    public static final String CREATE_TABLE_CATEGORY =
            "CREATE TABLE IF NOT EXISTS "+ TABLE_CATEGORY +"(" +
                    CATEGORY_COLUMN_ID + " INT NOT NULL AUTO_INCREMENT, " +
                    CATEGORY_COLUMN_NAME + " VARCHAR(50) NOT NULL, " +
                    "PRIMARY KEY(" + CATEGORY_COLUMN_ID + "));";

    public static final String CREATE_TABLE_INVENTORY =
            "CREATE TABLE IF NOT EXISTS "+ TABLE_INVENTORY +"(" +
                    INVENTORY_COLUMN_ID + " INT NOT NULL AUTO_INCREMENT, " +
                    INVENTORY_COLUMN_QUANTITY + " INT NOT NULL, " +
                    INVENTORY_COLUMN_NAME + " VARCHAR(200) NOT NULL, " +
                    INVENTORY_COLUMN_DESCRIPTION + " VARCHAR(200) NOT NULL, " +
                    INVENTORY_COLUMN_LOCATION + " VARCHAR(200) NOT NULL, " +
                    "PRIMARY KEY(" + INVENTORY_COLUMN_ID + "));";

    public static final String CREATE_TABLE_USER =
            "CREATE TABLE IF NOT EXISTS " + TABLE_USER + "(" +
                    USER_COLUMN_ID + " INT NOT NULL AUTO_INCREMENT, " +
                    USER_COLUMN_FIRST_NAME + " VARCHAR(100) NOT NULL, " +
                    USER_COLUMN_LAST_NAME + " VARCHAR(100) NOT NULL, " +
                    USER_COLUMN_PASSWORD + " VARCHAR(255) NOT NULL, " +
                    USER_COLUMN_ROLE + " VARCHAR(20) NOT NULL, " +
                    "PRIMARY KEY(" + USER_COLUMN_ID + "));";

    public static final String CREATE_TABLE_ORDER =
            "CREATE TABLE IF NOT EXISTS " + TABLE_ORDER + "(" +
                    ORDER_COLUMN_ID + " INT NOT NULL AUTO_INCREMENT, " +
                    ORDER_COLUMN_DATE + " VARCHAR(12) NOT NULL, " +
                    ORDER_COLUMN_QUANTITY + " INT NOT NULL, " +
                    ORDER_COLUMN_STATUS + " VARCHAR(100) NOT NULL, " +
                    ORDER_COLUMN_USER_ID + " INT, " +
                    "PRIMARY KEY(" + ORDER_COLUMN_ID + ")," +
                    "FOREIGN KEY(" + ORDER_COLUMN_USER_ID + ") REFERENCES " +
                    TABLE_USER + "(" + USER_COLUMN_ID + "));";

    public static final String CREATE_TABLE_PRODUCTS =
            "CREATE TABLE IF NOT EXISTS " + TABLE_PRODUCT + " (" +
                    PRODUCT_COLUMN_ID + " INT NOT NULL AUTO_INCREMENT, " +
                    PRODUCT_COLUMN_NAME + " VARCHAR(200) NOT NULL, " +
                    PRODUCT_COLUMN_SKU + " INT, " +
                    PRODUCT_COLUMN_QUANTITY + " INT, " +
                    PRODUCT_COLUMN_LOCATION + " VARCHAR(200) NOT NULL," +
                    PRODUCT_COLUMN_SUPPLIER + " INT," +
                    PRODUCT_COLUMN_CATEGORY + " INT," +
                    "FOREIGN KEY(" + PRODUCT_COLUMN_SUPPLIER +")" +
                    "REFERENCES " + TABLE_SUPPLIER + "(" + SUPPLIER_COLUMN_ID +")," +
                    "FOREIGN KEY(" + PRODUCT_COLUMN_CATEGORY +")" +
                    "REFERENCES " + TABLE_CATEGORY + "(" + CATEGORY_COLUMN_ID +")," +
                    "PRIMARY KEY(" + PRODUCT_COLUMN_ID + "));";



}
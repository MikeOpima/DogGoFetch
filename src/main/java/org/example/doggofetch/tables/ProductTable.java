package org.example.doggofetch.tables;

import org.example.doggofetch.database.Database;
import org.example.doggofetch.dao.ProductDAO;
import org.example.doggofetch.pojo.DisplayProduct;
import org.example.doggofetch.pojo.Product;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import static org.example.doggofetch.database.DBConst.*;

/**
 * Product Table pojo Class
 * katkoe 29mar26
 * CRUD and display Product methods
 */
public class ProductTable implements ProductDAO {
    private static ProductTable instance;
    Database db =  Database.getInstance();
    ArrayList<Product> products = new ArrayList<>();

    public static ProductTable getInstance(){
        if(instance == null){
            instance = new ProductTable();
        }
        return instance;
    }

    @Override
    public ArrayList<Product> getAllProducts() {
        String query = "SELECT * FROM " + TABLE_PRODUCT;
        try{
            ResultSet data = db.getConnection()
                    .createStatement().executeQuery(query);
            while(data.next()){
                products.add(new Product(
                        data.getInt(PRODUCT_COLUMN_ID),
                        data.getString(PRODUCT_COLUMN_NAME),
                        data.getInt(PRODUCT_COLUMN_QUANTITY),
                        data.getString(PRODUCT_COLUMN_LOCATION),
                        data.getInt(PRODUCT_COLUMN_SUPPLIER),
                        data.getInt(PRODUCT_COLUMN_CATEGORY)
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return products;
    } // end getAllProducts

    /**
     * getProduct
     * return single product record on id match
     * @param id
     * @return
     */
    @Override
    public Product getProduct(int id) {
        Product product = new Product();
        String query = "SELECT * FROM " + TABLE_PRODUCT +
                " WHERE " + PRODUCT_COLUMN_ID + " = " + id;
        try{
            ResultSet data = db.getConnection().createStatement().executeQuery(query);
            if(data.next()){
                product = new Product(
                        data.getInt(PRODUCT_COLUMN_ID),
                        data.getString(PRODUCT_COLUMN_NAME),
                        data.getInt(PRODUCT_COLUMN_QUANTITY),
                        data.getString(PRODUCT_COLUMN_LOCATION),
                        data.getInt(PRODUCT_COLUMN_SUPPLIER),
                        data.getInt(PRODUCT_COLUMN_CATEGORY)
                );
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return product;

    } // end getProduct

    public void updateProduct(Product product) {
        String query = "UPDATE " + TABLE_PRODUCT + " SET " +
                PRODUCT_COLUMN_NAME + "= " + product.getName() + ", " +
                PRODUCT_COLUMN_QUANTITY + "= " + product.getQuantity() + ", " +
                PRODUCT_COLUMN_LOCATION + "= " + product.getLocation() + ", " +
                PRODUCT_COLUMN_SUPPLIER + "= " + product.getSupplier() +
                PRODUCT_COLUMN_CATEGORY + "= " + product.getCategory() +
                "WHERE " + PRODUCT_COLUMN_ID + " = " + product.getId();
        try {
            Statement updateProduct = db.getConnection().createStatement();
            System.out.println("Product" + product.getName() + "Updated");
            updateProduct.executeUpdate(query);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }  // end updateProduct

    @Override
    public void deleteProduct(int id) {
        String query  = "DELETE FROM " + TABLE_PRODUCT + " WHERE " +
                PRODUCT_COLUMN_ID + " = " + id;
        try {
            db.getConnection().createStatement().execute(query);
            System.out.println("Deleted Product");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    } // end deleteProduct

    @Override
    public void createProduct(Product product) {
        String query = "INSERT INTO " + TABLE_PRODUCT +
                "(" + PRODUCT_COLUMN_NAME + ", " +
                PRODUCT_COLUMN_QUANTITY + ", " +
                PRODUCT_COLUMN_LOCATION + ", " +
                PRODUCT_COLUMN_SUPPLIER + ", " +
                PRODUCT_COLUMN_CATEGORY + ") VALUES ('" +
                product.getName() + "', " +
                product.getQuantity() + ", '" +
                product.getLocation() + "', " +
                product.getSupplier() + ", " +
                product.getCategory() + ")";
        try {
            db.getConnection().createStatement().execute(query);
            System.out.println("Add New Product: " + product.getName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    } // end createProduct

    public int getProductCount(int product) {
        int count = -1;
        try {
            PreparedStatement getCount = db.getConnection()
                    .prepareStatement("SELECT COUNT(*) as count FROM " + TABLE_PRODUCT + " WHERE "
                            + PRODUCT_COLUMN_CATEGORY + " = '" + product + "'");
            ResultSet data = getCount.executeQuery();
            data.next();
            return data.getInt("count");
        }
        catch(SQLException e) {
            e.printStackTrace();
        }
        return count;
    } // end get ProductCount  --- count qty of product type added

}

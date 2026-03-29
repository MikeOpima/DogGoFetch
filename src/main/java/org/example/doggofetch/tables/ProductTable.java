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
                        data.getString(PRODUCT_COLUMN_SUPPLIER)
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return products;
    }

    @Override
    public Product getProduct(int id) {
        Product product = new Product();
        String query = "SELECT * FROM " + TABLE_PRODUCT +
                " WHERE " + PRODUCT_COLUMN_ID + " = " + id;
        try{
            ResultSet data = db.getConnection().createStatement().executeQuery(query);
            if(data.next()){
                return new Product(
                        data.getInt(PRODUCT_COLUMN_ID),
                        data.getString(PRODUCT_COLUMN_NAME),
                        data.getInt(PRODUCT_COLUMN_QUANTITY),
                        data.getString(PRODUCT_COLUMN_LOCATION),
                        data.getString(PRODUCT_COLUMN_SUPPLIER)
                );
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    } // getProduct

    public void updateProduct(Product product) {

    }

    @Override
    public void deleteProduct(int id) {
        //String query = "DELETE FROM " + TABLE_PRODUCT
    }

    @Override
    public void createProduct(Product product) {

    }

}

package org.example.doggofetch.tables;

import org.example.doggofetch.dao.ProductDAO;
import org.example.doggofetch.database.DBConst;
import org.example.doggofetch.database.Database;
import org.example.doggofetch.pojo.Product;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class ProductTable implements ProductDAO {
    Database db =  Database.getInstance();
    ArrayList<Product> products;

    @Override
    public ArrayList<Product> getAllProducts() {
        String query = "SELECT * FROM " + DBConst.TABLE_PRODUCT;
        products = new ArrayList<>();
        try{
            Statement getAllProducts = db.getConnection().createStatement();
            ResultSet data = getAllProducts.executeQuery(query);
            while(data.next()){
                products.add(new Product(
                        data.getInt(DBConst.PRODUCT_COLUMN_ID),
                        data.getString(DBConst.PRODUCT_COLUMN_NAME),
                        data.getInt(DBConst.PRODUCT_COLUMN_QUANTITY),
                        data.getString(DBConst.PRODUCT_COLUMN_LOCATION),
                        data.getString(DBConst.PRODUCT_COLUMN_SUPPLIER)
                ));
            }
            return products;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Product getProduct(int id) {
        String query = "SELECT * FROM " + DBConst.TABLE_PRODUCT +
                " WHERE " + DBConst.PRODUCT_COLUMN_ID + " = " + id;
        try{
            Statement getAllProducts = db.getConnection().createStatement();
            ResultSet data = getAllProducts.executeQuery(query);
            if(data.next()){
                return new Product(
                        data.getInt(DBConst.PRODUCT_COLUMN_ID),
                        data.getString(DBConst.PRODUCT_COLUMN_NAME),
                        data.getInt(DBConst.PRODUCT_COLUMN_QUANTITY),
                        data.getString(DBConst.PRODUCT_COLUMN_LOCATION),
                        data.getString(DBConst.PRODUCT_COLUMN_SUPPLIER)
                );
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
}

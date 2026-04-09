package org.example.doggofetch.dao;

import org.example.doggofetch.pojo.Product;

import java.util.ArrayList;

/**
 * ProductDAO
 * FEB2026
 */
public interface ProductDAO {
    public ArrayList<Product> getAllProducts();
    public Product getProduct(int id);
    public void updateProduct(Product product);
    public void deleteProduct(int id);
    public void createProduct(Product product);
}



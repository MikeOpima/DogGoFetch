package org.example.doggofetch.dao;

import org.example.doggofetch.pojo.Product;

import java.util.ArrayList;

public interface ProductDAO {
    public ArrayList<Product> getAllProducts();
    public Product getProduct(int id);
}

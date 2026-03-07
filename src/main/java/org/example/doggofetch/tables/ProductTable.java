package org.example.doggofetch.tables;

import org.example.doggofetch.dao.ProductDAO;
import org.example.doggofetch.pojo.Product;

import java.util.ArrayList;

public class ProductTable implements ProductDAO {
    @Override
    public ArrayList<Product> getAllProducts() {
        return null;
    }

    @Override
    public Product getProduct(int id) {
        return null;
    }
}

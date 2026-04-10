package org.example.doggofetch.dao;

import org.example.doggofetch.pojo.Product;
import org.example.doggofetch.pojo.Supplier;

import java.util.ArrayList;

public interface SupplierDAO {
    public ArrayList<Supplier> getAllSuppliers();
    public Supplier getSupplier(int id);
    public void createSupplier(Supplier supplier);
    public void updateSupplier(Supplier supplier);
    public void deleteSupplier(int id);
}

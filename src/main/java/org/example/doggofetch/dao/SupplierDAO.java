package org.example.doggofetch.dao;

import org.example.doggofetch.pojo.Supplier;

import java.util.ArrayList;

public interface SupplierDAO {
    public ArrayList<Supplier> getAllSuppliers();
    public Supplier getSupplier(int id);
}

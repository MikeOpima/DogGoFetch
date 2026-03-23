package org.example.doggofetch.dao;

import org.example.doggofetch.pojo.Inventory;

import java.util.ArrayList;

public interface InventoryDAO {
    public ArrayList<Inventory> getAllInventory();
    public Inventory getInventory(int id);
}

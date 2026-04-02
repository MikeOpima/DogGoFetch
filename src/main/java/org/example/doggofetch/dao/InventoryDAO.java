package org.example.doggofetch.dao;

import org.example.doggofetch.pojo.Inventory;

import java.util.ArrayList;

/**
 * InventoryDAO
 * March 2026
 * Hania
 * Hania updated - April 2 CRUD methods added
 */

public interface InventoryDAO {
    public ArrayList<Inventory> getAllInventory();
    public Inventory getInventory(int id);
    public void createInventory(Inventory inventory);
    public void updateInventory(Inventory inventory);
    public void deleteInventory(int id);
}

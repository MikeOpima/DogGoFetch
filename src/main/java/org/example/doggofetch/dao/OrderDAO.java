package org.example.doggofetch.dao;

import org.example.doggofetch.pojo.Inventory;

import java.util.ArrayList;

public interface OrderDAO {

    public ArrayList<Inventory> getAllOrders();
    public Inventory getOrder(int id);
}

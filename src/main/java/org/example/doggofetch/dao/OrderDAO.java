package org.example.doggofetch.dao;

import org.example.doggofetch.pojo.Order;

import java.util.ArrayList;

public interface OrderDAO {

    public ArrayList<Order> getAllOrders();
    public Order getOrder(int id);
}

package org.example.doggofetch.dao;

import org.example.doggofetch.pojo.Order;

import java.util.ArrayList;

/**
 * OrderDAO
 * March 2026
 * Hania
 * Hania updated - April 2 CRUD methods added
 */

public interface OrderDAO {

    public ArrayList<Order> getAllOrders();
    public Order getOrder(int id);
    public void createOrder(Order order);
    public void updateOrder(Order order);
    public void deleteOrder(int id);
}

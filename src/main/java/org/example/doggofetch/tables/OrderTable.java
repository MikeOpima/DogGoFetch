package org.example.doggofetch.tables;

import org.example.doggofetch.dao.OrderDAO;
import org.example.doggofetch.database.DBConst;
import org.example.doggofetch.database.Database;
import org.example.doggofetch.pojo.Order;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class OrderTable implements OrderDAO {
    Database db = Database.getInstance();
    ArrayList<Order> order;
    @Override
    public ArrayList<Order> getAllOrders() {
        String query = "SELECT * FROM " + DBConst.TABLE_ORDER;
        order = new ArrayList<>();
        try{
            Statement getOrder = db.getConnection().createStatement();
            ResultSet data = getOrder.executeQuery(query);
            while(data.next()){
                order.add(new Order(
                        data.getInt(DBConst.ORDER_COLUMN_ID),
                        data.getString(DBConst.ORDER_COLUMN_DATE),
                        data.getInt(DBConst.ORDER_COLUMN_QUANTITY),
                        data.getString(DBConst.ORDER_COLUMN_STATUS),
                        (Integer) data.getObject(DBConst.ORDER_COLUMN_USER_ID)
                ));
            }
            return order;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Order getOrder(int id) {
        String query = "SELECT * FROM "+DBConst.TABLE_ORDER +""+
                " WHERE " + DBConst.ORDER_COLUMN_ID +" = " +id;
        try{
            Statement getOrder= db.getConnection().createStatement();
            ResultSet data = getOrder.executeQuery(query);
            if(data.next()){
                return new Order(
                        data.getInt(DBConst.ORDER_COLUMN_ID),
                        data.getString(DBConst.ORDER_COLUMN_DATE),
                        data.getInt(DBConst.ORDER_COLUMN_QUANTITY),
                        data.getString(DBConst.ORDER_COLUMN_STATUS),
                        (Integer) data.getObject(DBConst.ORDER_COLUMN_USER_ID)
                );
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void createOrder(Order orderObj) {
        String query = "INSERT INTO " + DBConst.TABLE_ORDER +
                "(" + DBConst.ORDER_COLUMN_DATE + ", " +
                DBConst.ORDER_COLUMN_QUANTITY + ", " +
                DBConst.ORDER_COLUMN_STATUS + ", " +
                DBConst.ORDER_COLUMN_USER_ID + ") VALUES ('" +
                orderObj.getOrderDate() + "', " +
                orderObj.getOrderQuantity() + ", '" +
                orderObj.getOrderStatus() + "', " +
                (orderObj.getUserId() == null ? "NULL" : orderObj.getUserId()) + ")";

        try {
            db.getConnection().createStatement().execute(query);
            System.out.println("Created Order");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateOrder(Order orderObj) {
        String query = "UPDATE " + DBConst.TABLE_ORDER + " SET " +
                DBConst.ORDER_COLUMN_DATE + " = '" + orderObj.getOrderDate() + "', " +
                DBConst.ORDER_COLUMN_QUANTITY + " = " + orderObj.getOrderQuantity() + ", " +
                DBConst.ORDER_COLUMN_STATUS + " = '" + orderObj.getOrderStatus() + "', " +
                DBConst.ORDER_COLUMN_USER_ID + " = " +
                (orderObj.getUserId() == null ? "NULL" : orderObj.getUserId()) + " " +
                "WHERE " + DBConst.ORDER_COLUMN_ID + " = " + orderObj.getOrderId();

        try {
            db.getConnection().createStatement().executeUpdate(query);
            System.out.println("Updated Order");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteOrder(int id) {
        String query = "DELETE FROM " + DBConst.TABLE_ORDER +
                " WHERE " + DBConst.ORDER_COLUMN_ID + " = " + id;

        try {
            db.getConnection().createStatement().execute(query);
            System.out.println("Deleted Order");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

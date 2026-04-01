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
        String query = "SELECT * FROM " + DBConst.CREATE_TABLE_ORDER;
        order = new ArrayList<>();
        try{
            Statement getOrder = db.getConnection().createStatement();
            ResultSet data = getOrder.executeQuery(query);
            while(data.next()){
                order.add(new Order(
                        data.getInt(DBConst.ORDER_COLUMN_ID),
                        data.getString(DBConst.ORDER_COLUMN_DATE),
                        data.getInt(DBConst.ORDER_COLUMN_QUANTITY),
                        data.getString(DBConst.ORDER_COLUMN_STATUS)
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
                        data.getString(DBConst.ORDER_COLUMN_STATUS)
                );
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }


}

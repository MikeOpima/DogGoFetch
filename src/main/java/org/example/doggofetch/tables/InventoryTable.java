package org.example.doggofetch.tables;

import org.example.doggofetch.dao.InventoryDAO;
import org.example.doggofetch.database.DBConst;
import org.example.doggofetch.database.Database;
import org.example.doggofetch.pojo.Inventory;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import static org.example.doggofetch.database.DBConst.*;

public class InventoryTable implements InventoryDAO {
    Database db = Database.getInstance();
    ArrayList<Inventory> inventory;
    @Override
    public ArrayList<Inventory> getAllInventory() {
        String query = "SELECT * FROM " + DBConst.CREATE_TABLE_INVENTORY;
        inventory = new ArrayList<>();
        try{
            Statement getInventory = db.getConnection().createStatement();
            ResultSet data = getInventory.executeQuery(query);
            while(data.next()){
                inventory.add(new Inventory(
                        data.getInt(DBConst.INVENTORY_COLUMN_ID),
                        data.getInt(DBConst.INVENTORY_COLUMN_QUANTITY),
                        data.getString(DBConst.INVENTORY_COLUMN_NAME),
                        data.getString(DBConst.INVENTORY_COLUMN_DESCRIPTION),
                        data.getString(DBConst.INVENTORY_COLUMN_LOCATION)
                ));
            }
            return inventory;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Inventory getInventory(int id) {
        String query = "SELECT * FROM "+ TABLE_INVENTORY +""+
        " WHERE " + DBConst.INVENTORY_COLUMN_ID +" = " +id;
        try{
            Statement getInventory= db.getConnection().createStatement();
            ResultSet data = getInventory.executeQuery(query);
            if(data.next()){
                return new Inventory(
                        data.getInt(DBConst.INVENTORY_COLUMN_ID),
                        data.getInt(DBConst.INVENTORY_COLUMN_QUANTITY),
                        data.getString(DBConst.INVENTORY_COLUMN_NAME),
                        data.getString(DBConst.INVENTORY_COLUMN_DESCRIPTION),
                        data.getString(DBConst.INVENTORY_COLUMN_LOCATION)
                );
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void createInventory(Inventory inventory) {
        String query = "INSERT INTO " + TABLE_INVENTORY +
                "(" +
                INVENTORY_COLUMN_QUANTITY + ", " +
                INVENTORY_COLUMN_NAME + ", " +
                INVENTORY_COLUMN_DESCRIPTION + ", " +
                INVENTORY_COLUMN_LOCATION + ") VALUES ('" +
                inventory.getInventoryQuantity() + ", '" +
                inventory.getInventoryName() + "', " +
                inventory.getInventoryLocation() + "', " +
                inventory.getInventoryDescription() + ")";
        try {
            db.getConnection().createStatement().execute(query);
            System.out.println("Add New Inventory: " + inventory.getInventoryName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    public void updateInventory(Inventory inventory) {
        String query = "UPDATE " + TABLE_INVENTORY + " SET " +
                INVENTORY_COLUMN_QUANTITY + "= " + inventory.getInventoryQuantity() + ", " +
                INVENTORY_COLUMN_NAME + "= " + inventory.getInventoryName() + ", " +
                INVENTORY_COLUMN_DESCRIPTION + "= " + inventory.getInventoryDescription() + ", " +
                INVENTORY_COLUMN_LOCATION + "= " + inventory.getInventoryLocation() + ", " +
                "WHERE " + PRODUCT_COLUMN_ID + " = " + inventory.getInventoryId();
        try {
            Statement updateProduct = db.getConnection().createStatement();
            System.out.println("Inventory" + inventory.getInventoryName() + "Updated");
            updateProduct.executeUpdate(query);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteInventory(int id) {
        String query  = "DELETE FROM " + TABLE_INVENTORY + " WHERE " +
                INVENTORY_COLUMN_ID + " = " + id;
        try {
            db.getConnection().createStatement().execute(query);
            System.out.println("Deleted Inventory");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}

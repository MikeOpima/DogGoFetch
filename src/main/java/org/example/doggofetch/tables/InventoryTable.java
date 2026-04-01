package org.example.doggofetch.tables;

import org.example.doggofetch.dao.InventoryDAO;
import org.example.doggofetch.database.DBConst;
import org.example.doggofetch.database.Database;
import org.example.doggofetch.pojo.Inventory;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

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
        String query = "SELECT * FROM "+DBConst.TABLE_INVENTORY +""+
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

}

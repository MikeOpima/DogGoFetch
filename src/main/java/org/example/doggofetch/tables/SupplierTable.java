package org.example.doggofetch.tables;

import org.example.doggofetch.dao.SupplierDAO;
import org.example.doggofetch.database.DBConst;
import org.example.doggofetch.database.Database;
import org.example.doggofetch.pojo.Supplier;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class SupplierTable implements SupplierDAO {
    private  static SupplierTable instance;
    Database db =Database.getInstance();
    ArrayList<Supplier> suppliers = new ArrayList<>();

    public static SupplierTable getInstance(){
        if(instance == null){
            instance = new SupplierTable();
        }
        return instance;
    }

    @Override
    public ArrayList<Supplier> getAllSuppliers() {
        String query = "SELECT * FROM " + DBConst.TABLE_SUPPLIER;
        suppliers = new ArrayList<>();
        try{
            Statement getSuppliers = db.getConnection().createStatement();
            ResultSet data = getSuppliers.executeQuery(query);
            while(data.next()){
                suppliers.add(new Supplier(
                        data.getInt(DBConst.SUPPLIER_COLUMN_ID),
                        data.getString(DBConst.SUPPLIER_COLUMN_NAME),
                        data.getString(DBConst.SUPPLIER_COLUMN_ADDRESS),
                        data.getString(DBConst.SUPPLIER_COLUMN_PHONE),
                        data.getString(DBConst.SUPPLIER_COLUMN_EMAIL)
                ));
            }
            return  suppliers;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Supplier getSupplier(int id) {
        String query = "SELECT * FROM " + DBConst.TABLE_SUPPLIER +"" +
                " WHERE " + DBConst.SUPPLIER_COLUMN_ID + " = " + id;
        try {
            Statement getSuppliers = db.getConnection().createStatement();
            ResultSet data = getSuppliers.executeQuery(query);
            if(data.next()){
                return new Supplier(
                        data.getInt(DBConst.SUPPLIER_COLUMN_ID),
                        data.getString(DBConst.SUPPLIER_COLUMN_NAME),
                        data.getString(DBConst.SUPPLIER_COLUMN_ADDRESS),
                        data.getString(DBConst.SUPPLIER_COLUMN_PHONE),
                        data.getString(DBConst.SUPPLIER_COLUMN_EMAIL)
                );
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}

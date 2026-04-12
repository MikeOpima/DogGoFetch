package org.example.doggofetch.tables;

import org.example.doggofetch.dao.SupplierDAO;
import org.example.doggofetch.database.Database;
import org.example.doggofetch.pojo.Supplier;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import static org.example.doggofetch.database.DBConst.*;

/**
 * Supplier Table CRUD
 */
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
        String query = "SELECT * FROM " + TABLE_SUPPLIER;
        suppliers = new ArrayList<>();
        try{
            Statement getSuppliers = db.getConnection().createStatement();
            ResultSet data = getSuppliers.executeQuery(query);
            while(data.next()){
                suppliers.add(new Supplier(
                        data.getInt(SUPPLIER_COLUMN_ID),
                        data.getString(SUPPLIER_COLUMN_NAME),
                        data.getString(SUPPLIER_COLUMN_ADDRESS),
                        data.getString(SUPPLIER_COLUMN_CITY),
                        data.getString(SUPPLIER_COLUMN_PROVINCE),
                        data.getString(SUPPLIER_COLUMN_POSTALCODE),
                        data.getString(SUPPLIER_COLUMN_PHONE),
                        data.getString(SUPPLIER_COLUMN_EMAIL)
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
        String query = "SELECT * FROM " + TABLE_SUPPLIER +"" +
                " WHERE " + SUPPLIER_COLUMN_ID + " = " + id;
        try {
            Statement getSuppliers = db.getConnection().createStatement();
            ResultSet data = getSuppliers.executeQuery(query);
            if(data.next()){
                return new Supplier(
                        data.getInt(SUPPLIER_COLUMN_ID),
                        data.getString(SUPPLIER_COLUMN_NAME),
                        data.getString(SUPPLIER_COLUMN_ADDRESS),
                        data.getString(SUPPLIER_COLUMN_CITY),
                        data.getString(SUPPLIER_COLUMN_PROVINCE),
                        data.getString(SUPPLIER_COLUMN_POSTALCODE),
                        data.getString(SUPPLIER_COLUMN_PHONE),
                        data.getString(SUPPLIER_COLUMN_EMAIL)
                );
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    /**
     * update by kat 9april26
     * @param supplier
     */
    public void createSupplier(Supplier supplier) {
        String query = "INSERT INTO " + TABLE_SUPPLIER +
                "(" + SUPPLIER_COLUMN_NAME + ", " +
                SUPPLIER_COLUMN_ADDRESS + ", " +
                SUPPLIER_COLUMN_CITY + ", " +
                SUPPLIER_COLUMN_PROVINCE + ", " +
                SUPPLIER_COLUMN_POSTALCODE + ", " +
                SUPPLIER_COLUMN_PHONE + ", " +
                SUPPLIER_COLUMN_EMAIL + ") VALUES ('" +
                supplier.getName() + "', " +
                supplier.getAddress() + "', " +
                supplier.getCity() + ", " +
                supplier.getProvince() + "', " +
                supplier.getPostalcode() + ", " +
                supplier.getPhone() + ", " +
                supplier.getEmail() + ")";
        try{
            db.getConnection().createStatement().execute(query);
            System.out.println("Add New Supplier: " + supplier.getName());
        }catch (Exception e){
            e.printStackTrace();
        }
    } // end createSupplier

    public void updateSupplier(Supplier supplier) {
        String query = "UPDATE " + TABLE_SUPPLIER + " SET " +
                SUPPLIER_COLUMN_NAME + "= " + supplier.getName() + ", " +
                SUPPLIER_COLUMN_ADDRESS + "= " + supplier.getAddress() + ", " +
                SUPPLIER_COLUMN_CITY + "= " + supplier.getCity() + ", " +
                SUPPLIER_COLUMN_PROVINCE + "= " + supplier.getProvince() + ", " +
                SUPPLIER_COLUMN_POSTALCODE + "= " + supplier.getPostalcode() +
                SUPPLIER_COLUMN_PHONE + "= " + supplier.getPhone() +
                SUPPLIER_COLUMN_EMAIL + "= " + supplier.getEmail() +
                "WHERE " + SUPPLIER_COLUMN_ID + " = " + supplier.getId();
        try {
            Statement updateSupplier= db.getConnection().createStatement();
            System.out.println("Supplier" + supplier.getName() + "Updated");
            updateSupplier.executeUpdate(query);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }  // end updateSupplier

    /**
     * update by kat 9april26
     * @param id
     */
    public void deleteSupplier(int id) {
        String query  = "DELETE FROM " + TABLE_SUPPLIER + " WHERE " +
                SUPPLIER_COLUMN_ID + " = " + id;
        try {
            db.getConnection().createStatement().execute(query);
            System.out.println("Deleted Supplier");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    } // end deleteSupplier

    public int getSupplierCount(int supplier) {
        int count = -1;
        try {
            PreparedStatement getCount = db.getConnection()
                    .prepareStatement("SELECT COUNT(*) as count FROM " + TABLE_SUPPLIER + " WHERE "
                            + SUPPLIER_COLUMN_NAME + " = '" + supplier + "'");
            ResultSet data = getCount.executeQuery();
            data.next();
            return data.getInt("count");
        }
        catch(SQLException e) {
            e.printStackTrace();
        }
        return count;
    } // end get SupplierCount  --- count qty of Supplier type added

    public ArrayList<Supplier> getSuppliers() {
        ArrayList<Supplier> suppliers = new ArrayList<>();
        String query = "SELECT * FROM " + TABLE_SUPPLIER;
        try {
            Statement getSuppliers = db.getConnection().createStatement();
            ResultSet data = getSuppliers.executeQuery(query);
            while (data.next()) {
                suppliers.add(new Supplier(data.getInt(SUPPLIER_COLUMN_ID),
                        data.getString("name"),
                        data.getString("address"),
                        data.getString("province"),
                        data.getString("city"),
                        data.getString("postalcode"),
                        data.getString("contact"),
                        data.getString("email")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return suppliers;
    }
}

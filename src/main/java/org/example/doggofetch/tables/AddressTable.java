package org.example.doggofetch.tables;

import org.example.doggofetch.dao.AddressDAO;
import org.example.doggofetch.database.DBConst;
import org.example.doggofetch.database.Database;
import org.example.doggofetch.pojo.Address;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * AddressTable
 * April 2, 2026
 * Hania
 */

public class AddressTable implements AddressDAO {

    private static AddressTable instance;
    Database db = Database.getInstance();
    ArrayList<Address> addresses = new ArrayList<>();

    public static AddressTable getInstance(){
        if(instance == null){
            instance = new AddressTable();
        }
        return instance;
    }

    @Override
    public ArrayList<Address> getAllAddresses() {
        String query = "SELECT * FROM " + DBConst.TABLE_ADDRESS;
        addresses = new ArrayList<>();
        try {
            Statement getAddresses = db.getConnection().createStatement();
            ResultSet data = getAddresses.executeQuery(query);
            while (data.next()) {
                addresses.add(new Address(
                        data.getInt(DBConst.ADDRESS_COLUMN_ID),
                        data.getString(DBConst.ADDRESS_COLUMN_STREET),
                        data.getString(DBConst.ADDRESS_COLUMN_CITY),
                        data.getString(DBConst.ADDRESS_COLUMN_PROVINCE),
                        data.getString(DBConst.ADDRESS_COLUMN_POSTAL_CODE),
                        data.getString(DBConst.ADDRESS_COLUMN_COUNTRY),
                        (Integer) data.getObject(DBConst.ADDRESS_COLUMN_USER_ID),
                        (Integer) data.getObject(DBConst.ADDRESS_COLUMN_SUPPLIER_ID)
                ));
            }
            return addresses;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Address getAddress(int id) {
        String query = "SELECT * FROM " + DBConst.TABLE_ADDRESS +
                " WHERE " + DBConst.ADDRESS_COLUMN_ID + " = " + id;
        try {
            Statement getAddress = db.getConnection().createStatement();
            ResultSet data = getAddress.executeQuery(query);
            if (data.next()) {
                return new Address(
                        data.getInt(DBConst.ADDRESS_COLUMN_ID),
                        data.getString(DBConst.ADDRESS_COLUMN_STREET),
                        data.getString(DBConst.ADDRESS_COLUMN_CITY),
                        data.getString(DBConst.ADDRESS_COLUMN_PROVINCE),
                        data.getString(DBConst.ADDRESS_COLUMN_POSTAL_CODE),
                        data.getString(DBConst.ADDRESS_COLUMN_COUNTRY),
                        (Integer) data.getObject(DBConst.ADDRESS_COLUMN_USER_ID),
                        (Integer) data.getObject(DBConst.ADDRESS_COLUMN_SUPPLIER_ID)
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void createAddress(Address address) {
        String query = "INSERT INTO " + DBConst.TABLE_ADDRESS +
                "(" + DBConst.ADDRESS_COLUMN_STREET + ", " +
                DBConst.ADDRESS_COLUMN_CITY + ", " +
                DBConst.ADDRESS_COLUMN_PROVINCE + ", " +
                DBConst.ADDRESS_COLUMN_POSTAL_CODE + ", " +
                DBConst.ADDRESS_COLUMN_COUNTRY + ", " +
                DBConst.ADDRESS_COLUMN_USER_ID + ", " +
                DBConst.ADDRESS_COLUMN_SUPPLIER_ID + ") VALUES ('" +
                address.getStreet() + "', '" +
                address.getCity() + "', '" +
                address.getProvince() + "', '" +
                address.getPostalCode() + "', '" +
                address.getCountry() + "', " +
                (address.getUserId() == null ? "NULL" : address.getUserId()) + ", " +
                (address.getSupplierId() == null ? "NULL" : address.getSupplierId()) + ")";

        try {
            db.getConnection().createStatement().execute(query);
            System.out.println("Created Address");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateAddress(Address address) {
        String query = "INSERT INTO " + DBConst.TABLE_ADDRESS +
                "(" + DBConst.ADDRESS_COLUMN_STREET + ", " +
                DBConst.ADDRESS_COLUMN_CITY + ", " +
                DBConst.ADDRESS_COLUMN_PROVINCE + ", " +
                DBConst.ADDRESS_COLUMN_POSTAL_CODE + ", " +
                DBConst.ADDRESS_COLUMN_COUNTRY + ", " +
                DBConst.ADDRESS_COLUMN_USER_ID + ", " +
                DBConst.ADDRESS_COLUMN_SUPPLIER_ID + ") VALUES ('" +
                address.getStreet() + "', '" +
                address.getCity() + "', '" +
                address.getProvince() + "', '" +
                address.getPostalCode() + "', '" +
                address.getCountry() + "', " +
                (address.getUserId() == null ? "NULL" : address.getUserId()) + ", " +
                (address.getSupplierId() == null ? "NULL" : address.getSupplierId()) + ")";

        try {
            db.getConnection().createStatement().execute(query);
            System.out.println("Created Address");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteAddress(int id) {
        String query = "DELETE FROM " + DBConst.TABLE_ADDRESS +
                " WHERE " + DBConst.ADDRESS_COLUMN_ID + " = " + id;

        try {
            db.getConnection().createStatement().execute(query);
            System.out.println("Deleted Address");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

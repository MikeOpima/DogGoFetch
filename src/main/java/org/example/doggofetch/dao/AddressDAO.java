package org.example.doggofetch.dao;

import org.example.doggofetch.pojo.Address;

import java.util.ArrayList;

/**
 * AddressDAO
 * April 2, 2026
 * Hania
 */

public interface AddressDAO {
    public ArrayList<Address> getAllAddresses();
    public Address getAddress(int id);
    public void createAddress(Address address);
    public void updateAddress(Address address);
    public void deleteAddress(int id);
}

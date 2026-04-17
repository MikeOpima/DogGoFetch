
/**
 * Supplier POJO
 * Mike - April 2 update v.1.1
 * Constructors are not assigning category
 */
package org.example.doggofetch.pojo;

public class Supplier extends DatabaseItem {
    private int id;
    private String name;
    private String address;
    private String city;
    private String province;
    private String postalcode;
    private String phone;
    private String email;

    public Supplier(int id, String name, String address, String city, String province, String postalcode, String phone, String email) {
        super (id);
        this.id = id;
        this.name = name;
        this.address = address;
        this.city = city;
        this.province = province;
        this.postalcode = postalcode;
        this.phone = phone;
        this.email = email;
    }

//    public Supplier(){
//
//    }
//
//    public Supplier(String supplier) {
//    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCity() { return city; }

    public void setCity(String city) {  this.city = city; }

    public String getProvince() { return province;  }

    public void setProvince(String province) {  this.province = province;  }

    public String getPostalcode() { return postalcode;  }

    public void setPostalcode(String postalcode) {  this.postalcode = postalcode;  }

    @Override
    public String toString() {return name;}
}

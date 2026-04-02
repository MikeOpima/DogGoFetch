package org.example.doggofetch.pojo;

/**
 * Address pojo
 * April 2, 2026
 * Hania
 */

public class Address {
    private int id;
    private String street;
    private String city;
    private String province;
    private String postalCode;
    private String country;
    private Integer userId;
    private Integer supplierId;

    public Address(int id, String street, String city, String province, String postalCode, String country, Integer userId, Integer supplierId) {
        this.id = id;
        this.street = street;
        this.city = city;
        this.province = province;
        this.postalCode = postalCode;
        this.country = country;
        this.userId = userId;
        this.supplierId = supplierId;
    }

    public Address(String street, String city, String province, String postalCode, String country, Integer userId, Integer supplierId) {
        this.street = street;
        this.city = city;
        this.province = province;
        this.postalCode = postalCode;
        this.country = country;
        this.userId = userId;
        this.supplierId = supplierId;
    }

    public int getId() {return id;}

    public void setId(int id) {this.id = id;}

    public String getStreet() {return street;}

    public void setStreet(String street) {this.street = street;}

    public String getCity() {return city;}

    public void setCity(String city) {this.city = city;}

    public String getProvince() {return province;}

    public void setProvince(String province) {this.province = province;}

    public String getPostalCode() {return postalCode;}

    public void setPostalCode(String postalCode) {this.postalCode = postalCode;}

    public String getCountry() {return country;}

    public void setCountry(String country) {this.country = country;}

    public Integer getUserId() {return userId;}

    public void setUserId(Integer userId) {this.userId = userId;}

    public Integer getSupplierId() {return supplierId;}

    public void setSupplierId(Integer supplierId) {this.supplierId = supplierId;}


}

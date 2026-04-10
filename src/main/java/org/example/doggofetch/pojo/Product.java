package org.example.doggofetch.pojo;

public class Product {
    private int id;
    private String name;
    private int sku;
    private int quantity;
    private String location;
    private int supplier;
    private int category;


    /**
     * Product POJO
     * Hania - April 2 update v.1.1
     * Constructors are not assigning category
     * Getter for category has typo
     */

    public Product(int id, String name, int sku, int quantity, String location,
                   int supplier, int category) {
        this.id = id;
        this.name = name;
        this.sku = sku;
        this.quantity = quantity;
        this.location = location;
        this.supplier = supplier;
        this.category = category;
    }

    public Product(String name, int sku, int quantity, String location, int supplier, int category) {
        this.name = name;
        this.sku = sku;
        this.quantity = quantity;
        this.location = location;
        this.supplier = supplier;
        this.category = category;
    }

    public Product() {

    }

    public Product(String product) {
    }

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

    public int getSku() {
        return sku;
    }

    public void setSku(int sku) {
        this.sku = sku;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getSupplier() {
        return supplier;
    }

    public void setSupplier(int supplier) {
        this.supplier = supplier;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }
//
//    @Override
//    public String toString() {return name;}
}

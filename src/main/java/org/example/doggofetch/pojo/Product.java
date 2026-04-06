package org.example.doggofetch.pojo;

/**
 * Product POJO
 * march2026
 * katkoe
 */
public class Product {
    private int id;
    private String name;
    private int sku;
    private int quantity;
    private String location;
    private int supplier;
    private int category;

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

    public int getSCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }
//
//    @Override
//    public String toString() {return name;}
}

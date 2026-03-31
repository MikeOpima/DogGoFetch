package org.example.doggofetch.pojo;

public class DisplayProduct {
    private int id;
    private String name;
    private int quantity;
    private String location;
    private String supplier;

    public DisplayProduct(int id, String name,  int quantity, String location, String supplier) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.location = location;
        this.supplier = supplier;
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

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

}

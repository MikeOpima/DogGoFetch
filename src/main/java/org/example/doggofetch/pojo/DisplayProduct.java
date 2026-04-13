package org.example.doggofetch.pojo;

public class DisplayProduct {
    private int id;
    private String name;
    private int sku;
    private int quantity;
    private String supplier;
    private String category;
    private String orderStatus;

    public DisplayProduct(int id, String name, int sku,  int quantity,
                          String supplier, String category, String orderStatus) {
        this.id = id;
        this.name = name;
        this.sku = sku;
        this.quantity = quantity;
        this.supplier = supplier;
        this.category = category;
        this.orderStatus = orderStatus;
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

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) { this.category = category; }

    public String getOrderStatus() { return orderStatus; }

    public void setOrderStatus(String orderStatus) { this.orderStatus = orderStatus;}
}

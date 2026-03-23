package org.example.doggofetch.pojo;

public class Order {

    private int orderId;
    private String orderDate;
    private int orderQuantity;
    private String orderStatus;

    public Order(int id, String date, int quantity, String status) {
        this.orderId = id;
        this.orderDate = date;
        this.orderQuantity = quantity;
        this.orderStatus = status;
    }

    public int getId() {return orderId;}

    public void setId(int id) {this.orderId = id;}

    public String getDate() {return orderDate;}

    public void setDate(String date) {this.orderDate = date;}

    public int getQuantity() {return orderQuantity;}

    public void setQuantity(int quantity) {this.orderQuantity = quantity;}

    public String getStatus() {return orderStatus;}

    public void setStatus(String status) {this.orderStatus = status;}

    @Override
    public String toString() {
        String orderStringId = Integer.toString(orderId);
        return "Order #"+ orderStringId;}

}

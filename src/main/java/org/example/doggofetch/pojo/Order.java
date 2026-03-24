package org.example.doggofetch.pojo;

public class Order {

    private int orderId;
    private String orderDate;
    private int orderQuantity;
    private String orderStatus;

    public Order(int orderId, String orderDate, int orderQuantity, String orderStatus) {
        this.orderId = orderId;
        this.orderDate = orderDate;
        this.orderQuantity = orderQuantity;
        this.orderStatus = orderStatus;
    }

    public int getId() {return orderId;}

    public void setId(int orderId) {this.orderId = orderId;}

    public String getDate() {return orderDate;}

    public void setDate(String orderDate) {this.orderDate = orderDate;}

    public int getQuantity() {return orderQuantity;}

    public void setQuantity(int orderQuantity) {this.orderQuantity = orderQuantity;}

    public String getStatus() {return orderStatus;}

    public void setStatus(String orderStatus) {this.orderStatus = orderStatus;}

    @Override
    public String toString() {
        String orderStringId = Integer.toString(orderId);
        return "Order #"+ orderStringId;}

}

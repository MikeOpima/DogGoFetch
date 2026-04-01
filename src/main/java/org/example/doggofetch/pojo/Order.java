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

    public int getOrderId() {return orderId;}

    public void setOrderId(int orderId) {this.orderId = orderId;}

    public String getOrderDate() {return orderDate;}

    public void setOrderDate(String orderDate) {this.orderDate = orderDate;}

    public int getOrderQuantity() {return orderQuantity;}

    public void setOrderQuantity(int orderQuantity) {this.orderQuantity = orderQuantity;}

    public String getOrderStatus() {return orderStatus;}

    public void setOrderStatus(String orderStatus) {this.orderStatus = orderStatus;}

    @Override
    public String toString() {
        String orderStringId = Integer.toString(orderId);
        return "Order #"+ orderStringId;}


}

package org.example.doggofetch.pojo;

/**
 * Order POJO
 * Hania
 */

public class Order {

    private int orderId;
    private String orderDate;
    private int orderQuantity;
    private String orderStatus;
    private Integer userId;

    public Order(int orderId, String orderDate, int orderQuantity, String orderStatus, Integer userId) {
        this.orderId = orderId;
        this.orderDate = orderDate;
        this.orderQuantity = orderQuantity;
        this.orderStatus = orderStatus;
        this.userId = userId;
    }

    public Order(String orderDate, int orderQuantity, String orderStatus, Integer userId) {
        this.orderDate = orderDate;
        this.orderQuantity = orderQuantity;
        this.orderStatus = orderStatus;
        this.userId = userId;
    }

    public int getOrderId() {return orderId;}

    public void setOrderId(int orderId) {this.orderId = orderId;}

    public String getOrderDate() {return orderDate;}

    public void setOrderDate(String orderDate) {this.orderDate = orderDate;}

    public int getOrderQuantity() {return orderQuantity;}

    public void setOrderQuantity(int orderQuantity) {this.orderQuantity = orderQuantity;}

    public String getOrderStatus() {return orderStatus;}

    public void setOrderStatus(String orderStatus) {this.orderStatus = orderStatus;}

    public Integer getUserId() {return userId;}

    public void setUserId(Integer userId) {this.userId = userId;}

    @Override
    public String toString() {
        String orderStringId = Integer.toString(orderId);
        return "Order #"+ orderStringId;}


}

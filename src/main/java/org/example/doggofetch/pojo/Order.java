package org.example.doggofetch.pojo;

public class Order {

    private int id;
    private String date;
    private int quantity;
    private String status;

    public Order(int id, String date, int quantity, String status) {
        this.id = id;
        this.date = date;
        this.quantity = quantity;
        this.status = status;
    }

    public int getId() {return id;}

    public void setId(int id) {this.id = id;}

    public String getDate() {return date;}

    public void setDate(String date) {this.date = date;}

    public int getQuantity() {return quantity;}

    public void setQuantity(int quantity) {this.quantity = quantity;}

    public String getStatus() {return status;}

    public void setStatus(String status) {this.status = status;}

    //TODO toString?
//    @Override
//    public String toString() {return id;}

}

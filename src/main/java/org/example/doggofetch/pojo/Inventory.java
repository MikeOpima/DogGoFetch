package org.example.doggofetch.pojo;

public class Inventory {
    private int id;
    private int quantity;
    private String name;
    private String description;
    private String location;

    public Inventory(int id, int quantity, String name, String description, String location) {
        this.id = id;
        this.quantity = quantity;
        this.name = name;
        this.description = description;
        this.location = location;
    }

    public int getId() {return id;}

    public void setId(int id) {this.id = id;}

    public int getQuantity() {return quantity;}

    public void setQuantity(int quantity) {this.quantity = quantity;}

    public String getName() {return name;}

    public void setName(String name) {this.name = name;}

    public String getDescription() {return description;}

    public void setDescription(String description) {this.description = description;}

    public String getLocation() {return location;}

    public void setLocation(String location) {this.location = location;}

    @Override
    public String toString() {return name;}
}

package org.example.doggofetch.pojo;

public class Inventory {
    private int inventoryId;
    private int inventoryQuantity;
    private String inventoryName;
    private String inventoryDescription;
    private String inventoryLocation;

    public Inventory(int inventoryId, int inventoryQuantity, String inventoryName, String inventoryDescription, String inventoryLocation) {
        this.inventoryId = inventoryId;
        this.inventoryQuantity = inventoryQuantity;
        this.inventoryName = inventoryName;
        this.inventoryDescription = inventoryDescription;
        this.inventoryLocation = inventoryLocation;
    }

    public int getId() {return inventoryId;}

    public void setId(int inventoryId) {this.inventoryId = inventoryId;}

    public int getQuantity() {return inventoryQuantity;}

    public void setQuantity(int inventoryQuantity) {this.inventoryQuantity = inventoryQuantity;}

    public String getName() {return inventoryName;}

    public void setName(String inventoryName) {this.inventoryName = inventoryName;}

    public String getDescription() {return inventoryDescription;}

    public void setDescription(String inventoryDescription) {this.inventoryDescription = inventoryDescription;}

    public String getLocation() {return inventoryLocation;}

    public void setLocation(String inventoryLocation) {this.inventoryLocation = inventoryLocation;}

    @Override
    public String toString() {return inventoryName;}
}

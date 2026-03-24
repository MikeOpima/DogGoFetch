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

    public int getInventoryId() {return inventoryId;}

    public void setInventoryId(int inventoryId) {this.inventoryId = inventoryId;}

    public int getInventoryQuantity() {return inventoryQuantity;}

    public void setInventoryQuantity(int inventoryQuantity) {this.inventoryQuantity = inventoryQuantity;}

    public String getInventoryName() {return inventoryName;}

    public void setInventoryName(String inventoryName) {this.inventoryName = inventoryName;}

    public String getInventoryDescription() {return inventoryDescription;}

    public void setInventoryDescription(String inventoryDescription) {this.inventoryDescription = inventoryDescription;}

    public String getInventoryLocation() {return inventoryLocation;}

    public void setInventoryLocation(String inventoryLocation) {this.inventoryLocation = inventoryLocation;}

    @Override
    public String toString() {return inventoryName;}
}

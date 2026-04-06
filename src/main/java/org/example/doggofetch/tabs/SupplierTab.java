package org.example.doggofetch.tabs;

import javafx.scene.control.Tab;
import javafx.scene.layout.GridPane;

public class SupplierTab extends Tab {
    private static  SupplierTab instance;

    private SupplierTab() {
        this.setText("Supplier Tab");
        GridPane root = new GridPane();
        root.setHgap(10);
        root.setVgap(10);
    }


}

package org.example.doggofetch;

import javafx.scene.control.Tab;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;

public class CartTab extends Tab {
    public CartTab(){
    this.setText("View Cart");
    BorderPane root = new BorderPane();
    Text welcome = new Text("Remove Items");
    } // con
}

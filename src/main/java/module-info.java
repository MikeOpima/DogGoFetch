module org.example.doggofetch {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires javafx.graphics;
    requires java.desktop;
    requires javafx.base;
    requires mysql.connector.j;


    opens org.example.doggofetch to javafx.fxml;
    exports org.example.doggofetch;
    exports org.example.doggofetch.tabs;
    opens org.example.doggofetch.tabs to javafx.fxml;
    exports org.example.doggofetch.tabs.product;
    opens org.example.doggofetch.tabs.product to javafx.fxml;
    exports org.example.doggofetch.tabs.supplier;
    opens org.example.doggofetch.tabs.supplier to javafx.fxml;
}
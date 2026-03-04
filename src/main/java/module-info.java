module org.example.doggofetch {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires javafx.graphics;
    requires java.desktop;


    opens org.example.doggofetch to javafx.fxml;
    exports org.example.doggofetch;
}
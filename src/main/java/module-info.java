module org.example.doggofetch {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires javafx.graphics;
    requires java.desktop;
    requires org.example.doggofetch;
//    requires org.example.doggofetch;


    opens org.example.doggofetch to javafx.fxml;
    exports org.example.doggofetch;
    exports org.example.doggofetch.tabs;
    opens org.example.doggofetch.tabs to javafx.fxml;
}
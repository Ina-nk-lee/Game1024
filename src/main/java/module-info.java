module com.example.demo {
    requires javafx.controls;
    requires javafx.fxml;
            
                            
    opens com.example.demo.ui to javafx.fxml;
    exports com.example.demo.ui;
    exports com.example.demo.ui.tools;
    opens com.example.demo.ui.tools to javafx.fxml;
    exports com.example.demo.model;
    opens com.example.demo.model to javafx.fxml;
}
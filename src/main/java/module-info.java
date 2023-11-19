module com.example.demo {
    requires javafx.controls;
    requires javafx.fxml;
    requires junit;
    requires org.junit.jupiter.api;


    opens com.example.demo to javafx.fxml;
    exports com.example.demo;
    exports com.example.demo.controllers;
    opens com.example.demo.controllers to javafx.fxml;
    opens com.example.demo.TestCases to junit;
}
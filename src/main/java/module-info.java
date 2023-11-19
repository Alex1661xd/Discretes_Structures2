module com.example.demo {
    requires javafx.controls;
    requires javafx.fxml;
    requires junit;
    requires org.junit.jupiter.api;

    opens com.example.demo to javafx.fxml;
    opens com.example.demo.controllers to javafx.fxml;
    opens com.example.demo.TestCases to junit; // Corrige el paquete de JUnit

    exports com.example.demo;
    exports com.example.demo.controllers;
}

module com.example.atm {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.atm to javafx.fxml;
    exports com.example.atm;
    exports com.example.atm.Controllers;
    opens com.example.atm.Controllers to javafx.fxml;
}
package com.example.atm.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.util.Objects;

public class adminLoginController {
    @FXML
    private AnchorPane adminLoginAnchorPane;
    @FXML
    private PasswordField adminPIN;
    @FXML
    private Button Continue;

    @FXML
    private void Error()
    {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error!");
        alert.setContentText("This is an Incorrect Password for Admin. Try Again!");
        alert.setHeaderText("Incorrect Password!");
        alert.showAndWait();
    }

    @FXML
    public void onContinueClick(ActionEvent event) throws IOException {
        String pin = adminPIN.getText();
        if(Objects.equals(pin, "admin"))
        {
            new SceneSwitch(adminLoginAnchorPane,"admin.fxml");
        }
        else
        {
            Error();
            adminPIN.setText("");
        }
    }
}

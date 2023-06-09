package com.example.atm.Controllers;

import com.example.atm.model.Datasource;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class changePinController {
    @FXML
    private AnchorPane changePinAnchor;
    @FXML
    private PasswordField pin;
    @FXML
    private Button change;
    @FXML
    private Label cancelLabel;

    private void Success()
    {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Success");
        alert.setContentText("PIN has been Changed Successfully!");
        alert.setHeaderText("PIN Changed.");
        alert.show();
    }
    private void Error()
    {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setContentText("PIN must be 4 numeric digits. Try Again!");
        alert.setHeaderText("Invalid PIN");
        alert.show();
    }
    @FXML
    void onChangeClick(ActionEvent event) throws IOException {
        String pinIn = pin.getText();
        char[] pinTest = pinIn.toCharArray();
        if(pinIn.length() != 4)
        {
            Error();
            return;
        }
        for(char c : pinTest)
        {
            if(!Character.isDigit(c))
            {
                Error();
                return;
            }
        }
        Datasource.getInstance().updatePIN(pinIn);
        Success();
        new SceneSwitch(changePinAnchor,"accountant.fxml");
    }
    @FXML
    void onCancelClick(MouseEvent event) throws IOException
    {
        new SceneSwitch(changePinAnchor,"accountant.fxml");
    }
}

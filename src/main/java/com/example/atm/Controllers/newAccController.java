package com.example.atm.Controllers;

import com.example.atm.model.Accountant;
import com.example.atm.model.Datasource;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.time.LocalDate;

public class newAccController {
    @FXML
    private AnchorPane newAccAnchorPane;
    @FXML
    private TextField name;
    @FXML
    private DatePicker date;
    @FXML
    private TextField postalCode;
    @FXML
    private Button DoneButton;
    @FXML
    private TextField balanceField;
    private void Error()
    {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error!");
        alert.setContentText("Illegal Balance Input");
        alert.setHeaderText("Incorrect Balance");
        alert.showAndWait();
    }
    @FXML
    void onCreateCardClick(ActionEvent event) throws IOException {
        String fullName = name.getText();
        LocalDate dateIn = date.getValue();
        String postalIn = postalCode.getText();
        double balance;
        try {
            balance = Double.parseDouble(balanceField.getText());
        }catch (NumberFormatException e)
        {
            Error();
            return;
        }
        Accountant acc = new Accountant(fullName,dateIn,postalIn);
        acc.getCreditCard().setBalance(balance);
        Datasource.getInstance().addAcc(acc.getId(),fullName,dateIn,postalIn,acc.getCreditCard().getCreditNumber(),acc.getCreditCard().getPin(),balance);
        new SceneSwitch(newAccAnchorPane,"creditCard.fxml");
    }
}

package com.example.atm.Controllers;

import com.example.atm.model.Datasource;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class specificDepositController {
    @FXML
    private AnchorPane specificDepositAnchor;
    @FXML
    private TextField amount;
    @FXML
    private Button DepositBtn;

    private void Error()
    {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error!");
        alert.setContentText("Illegal Amount Input");
        alert.setHeaderText("Incorrect Amount");
        alert.showAndWait();
    }
    private void Success()
    {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Success");
        alert.setContentText("Money has been deposited successfully.");
        alert.setHeaderText("TRANSACTION SUCCESS!");
        alert.show();
    }
    @FXML
    void onDepositClick(ActionEvent event) throws IOException
    {
        double amountIn;
        try {
            amountIn = Double.parseDouble(amount.getText());
        }catch (NumberFormatException e)
        {
            Error();
            return;
        }
        Datasource.getInstance().deposit(amountIn);
        Success();
        new SceneSwitch(specificDepositAnchor,"accountant.fxml");
    }
    @FXML
    void onCancelClick(MouseEvent event) throws IOException
    {
        new SceneSwitch(specificDepositAnchor,"accountant.fxml");
    }
}

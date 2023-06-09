package com.example.atm.Controllers;

import com.example.atm.model.Datasource;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class specificWithdrawController {
    @FXML
    private AnchorPane specificWithdrawAnchor;
    @FXML
    private TextField amount;
    @FXML
    private Button withdrawBtn;
    @FXML
    private Label cancelLabel;

    private void Error()
    {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error!");
        alert.setContentText("Illegal Amount Input");
        alert.setHeaderText("Incorrect Amount");
        alert.showAndWait();
    }
    private void Error2()
    {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Invalid Operation");
        alert.setContentText("Not Enough Balance!");
        alert.setHeaderText("Invalid Operation!");
        alert.show();
    }
    private void Success()
    {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Success");
        alert.setContentText("Money has been withdrawn successfully.");
        alert.setHeaderText("TRANSACTION SUCCESS!");
        alert.show();
    }
    @FXML
    void onWithdrawClick(ActionEvent event) throws IOException
    {
        double amountIn;
        try {
            amountIn = Double.parseDouble(amount.getText());
        }catch (NumberFormatException e)
        {
            Error();
            return;
        }
        if(!Datasource.getInstance().withdraw(amountIn))
        {
            Error();
            return;
        }
        Success();
        new SceneSwitch(specificWithdrawAnchor,"accountant.fxml");
    }
    @FXML
    void onCancelClick(MouseEvent event) throws IOException
    {
        new SceneSwitch(specificWithdrawAnchor,"accountant.fxml");
    }
}

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

public class mainController {
    private static String cardLoginNum;
    @FXML
    public Label adminLoginLabel;
    @FXML
    private AnchorPane mainAnchorPane;
    @FXML
    private Button continueProcess;
    @FXML
    private TextField cardNumberIn;

    @FXML
    void onAdminLoginClick(MouseEvent event) throws IOException {
        new SceneSwitch(mainAnchorPane,"adminLogin.fxml");
    }
    private void Error()
    {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error!");
        alert.setContentText("The Accountant not found at System.");
        alert.setHeaderText("Not Found!");
        alert.showAndWait();
    }

    @FXML
    void onContinueClick(ActionEvent event) throws IOException {
            cardLoginNum = Datasource.getInstance().returnCardNum(cardNumberIn.getText());
            if(cardLoginNum == null) {
                Error();
                return;
            }
            new SceneSwitch(mainAnchorPane,"cardPin.fxml");
    }
    public static String getCardLoginNum() {
        return cardLoginNum;
    }

    public static void setCardLoginNum(String cardLoginNum) {
        cardLoginNum = cardLoginNum;
    }
}

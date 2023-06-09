package com.example.atm.Controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class accountantController {
    @FXML
    private AnchorPane accountantAnchor;
    @FXML
    private Label deposit, withdraw, balanceEnq, pinChange, cancel;

    @FXML
    void onDepositClick(MouseEvent event) throws IOException {
        new SceneSwitch(accountantAnchor,"deposit.fxml");
    }
    @FXML
    void onWithdrawClick(MouseEvent event) throws IOException {
        new SceneSwitch(accountantAnchor,"withdraw.fxml");
    }
    @FXML
    void onBalanceClick(MouseEvent event) throws IOException {
        new SceneSwitch(accountantAnchor,"balanceEnq.fxml");
    }
    @FXML
    void onPinChangeClick(MouseEvent event) throws IOException {
        new SceneSwitch(accountantAnchor,"changePin.fxml");
    }
    @FXML
    void onCancelClick(MouseEvent event) throws IOException {
        new SceneSwitch(accountantAnchor,"main.fxml");
    }
}

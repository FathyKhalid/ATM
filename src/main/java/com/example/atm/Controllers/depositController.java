package com.example.atm.Controllers;

import com.example.atm.model.Datasource;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class depositController {
    @FXML
    private AnchorPane depositAnchor;
    @FXML
    private Label d200, d500, d1000, d2000, d5000, dOther;

    private void Success()
    {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Success");
        alert.setContentText("Money has been deposited successfully.");
        alert.setHeaderText("TRANSACTION SUCCESS!");
        alert.show();
    }

    @FXML
    void onD200Click(MouseEvent event) throws IOException {
        Datasource.getInstance().deposit(200);
        Success();
        new SceneSwitch(depositAnchor,"accountant.fxml");
    }
    @FXML
    void onD500Click(MouseEvent event) throws IOException {
        Datasource.getInstance().deposit(500);
        Success();
        new SceneSwitch(depositAnchor,"accountant.fxml");
    }
    @FXML
    void onD1000Click(MouseEvent event) throws IOException {
        Datasource.getInstance().deposit(1000);
        Success();
        new SceneSwitch(depositAnchor,"accountant.fxml");
    }
    @FXML
    void onD2000Click(MouseEvent event) throws IOException {
        Datasource.getInstance().deposit(2000);
        Success();
        new SceneSwitch(depositAnchor,"accountant.fxml");
    }
    @FXML
    void onD5000Click(MouseEvent event) throws IOException {
        Datasource.getInstance().deposit(5000);
        Success();
        new SceneSwitch(depositAnchor,"accountant.fxml");
    }
    @FXML
    void onOtherClick(MouseEvent event) throws IOException {
        new SceneSwitch(depositAnchor,"specificDeposit.fxml");
    }
}

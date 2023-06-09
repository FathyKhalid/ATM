package com.example.atm.Controllers;

import com.example.atm.model.Datasource;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class withdrawController {
    @FXML
    private AnchorPane withdrawAnchor;
    @FXML
    private Label w200, w500, w1000, w2000, w5000, wOther;

    private void Success()
    {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Success");
        alert.setContentText("Money has been withdrawn successfully.");
        alert.setHeaderText("TRANSACTION SUCCESS!");
        alert.show();
    }
    private void Error()
    {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Invalid Operation");
        alert.setContentText("Not Enough Balance!");
        alert.setHeaderText("Invalid Operation!");
        alert.show();
    }

    @FXML
    void onW200Click(MouseEvent event) throws IOException {
        if(!Datasource.getInstance().withdraw(200))
        {
            Error();
            return;
        }
        Success();
        new SceneSwitch(withdrawAnchor,"accountant.fxml");
    }
    @FXML
    void onW500Click(MouseEvent event) throws IOException {
        if(!Datasource.getInstance().withdraw(500))
        {
            Error();
            return;
        }
        Success();
        new SceneSwitch(withdrawAnchor,"accountant.fxml");
    }
    @FXML
    void onW1000Click(MouseEvent event) throws IOException {
        if(!Datasource.getInstance().withdraw(1000))
        {
            Error();
            return;
        }
        Success();
        new SceneSwitch(withdrawAnchor,"accountant.fxml");
    }
    @FXML
    void onW2000Click(MouseEvent event) throws IOException {
        if(!Datasource.getInstance().withdraw(2000))
        {
            Error();
            return;
        }
        Success();
        new SceneSwitch(withdrawAnchor,"accountant.fxml");
    }
    @FXML
    void onW5000Click(MouseEvent event) throws IOException {
        if(!Datasource.getInstance().withdraw(5000))
        {
            Error();
            return;
        }
        Success();
        new SceneSwitch(withdrawAnchor,"accountant.fxml");
    }
    @FXML
    void onOtherClick(MouseEvent event) throws IOException {
        new SceneSwitch(withdrawAnchor,"specificWithdraw.fxml");
    }
}

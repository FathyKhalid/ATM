package com.example.atm.Controllers;

import com.example.atm.model.Datasource;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.util.Objects;

public class CardPinController {
    @FXML
    private AnchorPane cardPnAnchorPane;
    @FXML
    private TextField pin;
    @FXML
    private Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btnOk, btnCancel;
    @FXML
    void onBtn0Click(ActionEvent event)
    {pin.appendText("0");}
    @FXML
    void onBtn1Click(ActionEvent event)
    {pin.appendText("1");}
    @FXML
    void onBtn2Click(ActionEvent event)
    {pin.appendText("2");}
    @FXML
    void onBtn3Click(ActionEvent event)
    {pin.appendText("3");}
    @FXML
    void onBtn4Click(ActionEvent event)
    {pin.appendText("4");}
    @FXML
    void onBtn5Click(ActionEvent event)
    {pin.appendText("5");}
    @FXML
    void onBtn6Click(ActionEvent event)
    {pin.appendText("6");}
    @FXML
    void onBtn7Click(ActionEvent event)
    {pin.appendText("7");}
    @FXML
    void onBtn8Click(ActionEvent event)
    {pin.appendText("8");}
    @FXML
    void onBtn9Click(ActionEvent event)
    {pin.appendText("9");}

    private void Error()
    {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error!");
        alert.setContentText("You Entered a wrong PIN. Try Again!");
        alert.setHeaderText("Wrong PIN!");
        alert.showAndWait();
    }
    @FXML
    void onBtnOkClick(ActionEvent event) throws IOException
    {
        if(!Objects.equals(Datasource.getInstance().getPIN(), pin.getText()))
        {
            Error();
            pin.setText("");
            return;
        }
        new SceneSwitch(cardPnAnchorPane,"accountant.fxml");
    }
    @FXML
    void onBtnCancelClick(ActionEvent event) throws IOException
    {
        new SceneSwitch(cardPnAnchorPane,"main.fxml");
    }
}

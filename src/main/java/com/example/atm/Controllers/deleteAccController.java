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

public class deleteAccController {
    @FXML
    private AnchorPane deleteAccAnchorPane;
    @FXML
    private TextField number;
    @FXML
    private TextField pin;
    @FXML
    private Button deleteButton;

    private void Confirmation()
    {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation!");
        alert.setContentText("Are You Sure you want delete Accountant?");
        alert.setHeaderText("Confirm?");
        alert.showAndWait();
    }
    private void Error()
    {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error!");
        alert.setContentText("The Accountant you want to delete is not Found!");
        alert.setHeaderText("Not Found!");
        alert.showAndWait();
    }
    private void Success()
    {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Success");
        alert.setContentText("");
        alert.setHeaderText("The Accountant has been deleted Successfully!");
        alert.showAndWait();
    }

    @FXML
    void onDeleteClick(ActionEvent event) throws IOException {
        Confirmation();
            if(Objects.equals(Datasource.getInstance().find(number.getText(),pin.getText()), "")) {
                Error();
                return;
            }
            Datasource.getInstance().deleteAcc(number.getText(),pin.getText());
            Success();
        new SceneSwitch(deleteAccAnchorPane,"admin.fxml");
    }

}

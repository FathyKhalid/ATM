package com.example.atm.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class adminController {

    @FXML
    private AnchorPane adminAnchorPane;
    @FXML
    private Button add;
    @FXML
    private Button delete;
    @FXML
    private Button logOut;

    @FXML
    void onAddClick(ActionEvent event) throws IOException {
        new SceneSwitch(adminAnchorPane,"newAcc.fxml");
    }
    @FXML
    void onDeleteClick(ActionEvent event) throws IOException {
        new SceneSwitch(adminAnchorPane,"deleteAcc.fxml");
    }
    @FXML
    void onLogOutClick(ActionEvent event) throws IOException {
        new SceneSwitch(adminAnchorPane,"main.fxml");
    }

}

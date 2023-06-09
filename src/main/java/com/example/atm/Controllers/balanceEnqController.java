package com.example.atm.Controllers;

import com.example.atm.model.Datasource;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

import java.io.IOException;

public class balanceEnqController {
    public Text balanceView;
    @FXML
    private AnchorPane balanceAnchor;
    @FXML
    private Rectangle rect;
    @FXML
    private Button viewBtn, closeBtn;

    @FXML
    void onViewClick(ActionEvent event)
    {
        balanceView.setText("Your Balance: "+ Datasource.getInstance().getBalance() +" E£");
        rect.setVisible(false);
    }
    @FXML
    void onCloseClick(ActionEvent event) throws IOException {
        new SceneSwitch(balanceAnchor,"accountant.fxml");
    }
}

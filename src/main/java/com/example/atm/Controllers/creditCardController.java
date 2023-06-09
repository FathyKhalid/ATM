package com.example.atm.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.sql.*;

public class creditCardController {
    @FXML
    private AnchorPane creditCardAnchorPane;
    @FXML
    private Label number;
    @FXML
    private Label pin;
    @FXML
    private Button Close;
    @FXML
    private Button view;

    @FXML
    void onCloseClick(ActionEvent event) throws IOException {
        new SceneSwitch(creditCardAnchorPane,"admin.fxml");
    }
    @FXML
    void onViewClick(ActionEvent event) throws IOException {
        try (Connection con = DriverManager.getConnection("jdbc:sqlite:F:\\Java\\ATM\\DataBase\\Accountant.db");) {
            Statement statement = con.createStatement();
            statement.execute("SELECT * FROM accountants ORDER BY 1 DESC LIMIT 1");
            ResultSet resultSet = statement.getResultSet();
            number.setText("Card Number: "+resultSet.getString("card_number"));
            pin.setText("PIN Code: "+resultSet.getString("pin"));
        }catch (SQLException e)
        {
            System.out.println("Something Went Wrong "+e.getMessage());
        }
    }

}

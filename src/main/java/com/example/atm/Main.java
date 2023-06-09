package com.example.atm;

import com.example.atm.model.Accountant;
import com.example.atm.model.Datasource;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void init() throws Exception {
        super.init();
        Datasource.getInstance().open();
        Datasource.getInstance().createTable();
        Accountant.id = Datasource.getInstance().returnIdLast();
    }
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("main.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 600);
        stage.setTitle("ATM Management System");
        stage.setScene(scene);
        Image icon = new Image("F:\\Java\\ATM\\Icons\\Icon.png");
        stage.getIcons().add(icon);
        stage.setResizable(false);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
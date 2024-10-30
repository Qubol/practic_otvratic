package com.example.kursach_beta;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class Zal {

    @FXML
    private TextField idRabZal;

    @FXML
    private TextField idZala;

    @FXML
    private Button zalBackButton;

    @FXML
    private Button zalButtonZapis;

    @FXML
    private TextField zalName;

    @FXML
    void initialize(){
        DatabaseHandler dbHandler = new DatabaseHandler();

        zalButtonZapis.setOnAction(event -> {
            dbHandler.zapisZal(idZala.getText(), zalName.getText(), idRabZal.getText());
        });
        zalBackButton.setOnAction(event -> {
            zalBackButton.getScene().getWindow().hide();

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("choose-table.fxml"));

            try {
                loader.load();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        });
    }
}

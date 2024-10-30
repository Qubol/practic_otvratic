package com.example.kursach_beta;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class Seans {

    @FXML
    private TextField idSeansUsluga;

    @FXML
    private Button seansBackButton;

    @FXML
    private Button seansButtonZapis;

    @FXML
    private TextField seansID;

    @FXML
    private TextField seansIDClient;

    @FXML
    private TextField seansIDPC;

    @FXML
    private TextField seansIDRab;

    @FXML
    private TextField seansTime;

    @FXML
    private TextField seansData;

    @FXML
    void initialize(){
        DatabaseHandler dbHandler = new DatabaseHandler();

        seansButtonZapis.setOnAction(event -> {
            dbHandler.zapisSeans(seansID.getText(), seansData.getText(), seansTime.getText(),
                    idSeansUsluga.getText(), seansIDClient.getText(), seansIDRab.getText(), seansIDPC.getText());
        });

        seansBackButton.setOnAction(event -> {
            seansBackButton.getScene().getWindow().hide();

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

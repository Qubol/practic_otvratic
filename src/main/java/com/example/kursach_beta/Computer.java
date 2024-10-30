package com.example.kursach_beta;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class Computer {

    @FXML
    private Button compBackButton;

    @FXML
    private Button compButtonZapis;

    @FXML
    private TextField idCharactComp;

    @FXML
    private TextField idCompComp;

    @FXML
    private TextField idZalaComp;

    @FXML
    void initialize(){
        DatabaseHandler dbHandler = new DatabaseHandler();

        compButtonZapis.setOnAction(event ->{
            dbHandler.zapisComp(idCompComp.getText(), idCharactComp.getText(), idZalaComp.getText());
        });

        compBackButton.setOnAction(event ->{
            compBackButton.getScene().getWindow().hide();

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

package com.example.kursach_beta;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class Uslugi {

    @FXML
    private TextField costUslugi;

    @FXML
    private TextField idUsluga;

    @FXML
    private TextField uslugaName;

    @FXML
    private Button uslugiBackButton;

    @FXML
    private Button uslugiButtonZapis;

    @FXML
    void initialize(){
        DatabaseHandler dbHandler = new DatabaseHandler();

        uslugiButtonZapis.setOnAction(event ->{
            dbHandler.zapisUslug(idUsluga.getText(), uslugaName.getAccessibleText(), costUslugi.getText());
        });
        uslugiBackButton.setOnAction(event -> {
            uslugiBackButton.getScene().getWindow().hide();

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

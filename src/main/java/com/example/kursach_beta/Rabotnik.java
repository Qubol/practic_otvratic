package com.example.kursach_beta;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class Rabotnik {

    @FXML
    private TextField rabAddress;

    @FXML
    private Button rabButtonZapis;

    @FXML
    private TextField rabID;

    @FXML
    private TextField rabName;

    @FXML
    private TextField rabSurname;

    @FXML
    private TextField rabPhone;

    @FXML
    private Button rabBackButton;

    @FXML
    void initialize(){
        DatabaseHandler dbHandler = new DatabaseHandler();

        rabButtonZapis.setOnAction(event ->{
            dbHandler.zapisRab(rabID.getText(), rabSurname.getText(),
                    rabName.getText(), rabAddress.getText(), rabPhone.getText());
        });

        rabBackButton.setOnAction(event ->{
            rabBackButton.getScene().getWindow().hide();

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
            stage.showAndWait();
        });
    }

}

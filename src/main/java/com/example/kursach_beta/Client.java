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

public class Client {

    @FXML
    private TextField clientAddress;

    @FXML
    private Button clientButtonZapis;

    @FXML
    private TextField clientID;

    @FXML
    private TextField clientName;

    @FXML
    private TextField clientSurname;

    @FXML
    private Button clientBackButton;

    @FXML
    void initialize(){
        DatabaseHandler dbHandler = new DatabaseHandler();

        clientButtonZapis.setOnAction(event ->{
            dbHandler.zapisClient(clientID.getText(), clientSurname.getText(), clientName.getText(),
                    clientAddress.getText());
        });

        clientBackButton.setOnAction(event ->{
            clientBackButton.getScene().getWindow().hide();

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

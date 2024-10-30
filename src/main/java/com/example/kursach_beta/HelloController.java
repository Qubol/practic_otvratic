package com.example.kursach_beta;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloController {

    @FXML
    private Button buttonVoity1;

    @FXML
    private TextField login1;

    @FXML
    private PasswordField password1;

    @FXML
    private Button regis1;

    @FXML
    void initialize(){

        buttonVoity1.setOnAction(event -> {
            String loginText = login1.getText().trim();
            String loginPassword = password1.getText().trim();

            if(!loginText.equals("") && !loginPassword.equals(""))
                loginUser(loginText, loginPassword);
                else
                    System.out.println("Данные не заполнены!");
        });

        buttonVoity1.setOnAction(event -> {
            buttonVoity1.getScene().getWindow().hide();

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

    private void loginUser(String loginText, String loginPassword) {

    }

}
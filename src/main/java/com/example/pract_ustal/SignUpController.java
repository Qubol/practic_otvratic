package com.example.pract_ustal;


import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class SignUpController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField login_field;

    @FXML
    private PasswordField password_field;

    @FXML
    private Button signUpButton;

    @FXML
    private PasswordField signUpLastName;

    @FXML
    private TextField signUpName;

    @FXML
    void initialize() {


        signUpButton.setOnAction(event -> {

            signUpNewUser();
            

        });
    }

    private void signUpNewUser() {
        DatabaseHandler dbHandler = new DatabaseHandler();

        String firstName = signUpName.getText();
        String lastName = signUpLastName.getText();
        String userName = login_field.getText();
        String password = password_field.getText();

        User user = new User(firstName, lastName, userName, password);

        dbHandler.signUpUser(user);
    }

}


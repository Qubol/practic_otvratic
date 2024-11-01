package com.example.pract_ustal;


import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.text.Text;

public class HomeController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Text textHello;

    @FXML
    void initialize() {
        assert textHello != null : "fx:id=\"textHello\" was not injected: check your FXML file 'app.fxml'.";

    }

}

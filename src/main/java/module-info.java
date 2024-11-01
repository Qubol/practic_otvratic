module com.example.pract_ustal {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.pract_ustal to javafx.fxml;
    exports com.example.pract_ustal;
}
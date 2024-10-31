module com.example.pract_zv {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.pract_zv to javafx.fxml;
    exports com.example.pract_zv;
}
module com.example.kursach_beta {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.kursach_beta to javafx.fxml;
    exports com.example.kursach_beta;
}
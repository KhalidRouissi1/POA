module com.example.tp3fx {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.tp3fx to javafx.fxml;
    exports com.example.tp3fx;
}
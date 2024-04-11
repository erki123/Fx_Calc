module com.example.fx_calc {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.fx_calc to javafx.fxml;
    exports com.example.fx_calc;
}
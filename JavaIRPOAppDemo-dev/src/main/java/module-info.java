module sample.irpoappdemo {
    requires javafx.controls;
    requires javafx.fxml;


    opens sample.irpoappdemo to javafx.fxml;
    exports sample.irpoappdemo;
}
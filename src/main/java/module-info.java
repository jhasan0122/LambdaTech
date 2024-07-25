module com.example.lambdatech {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;

    opens com.example.lambdatech to javafx.fxml;
    exports com.example.lambdatech;
}
module com.example.lambdatech {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;
    requires java.sql;

    opens com.example.lambdatech to javafx.fxml;
    exports com.example.lambdatech;
    exports com.example.lambdatech.Controller;
    opens com.example.lambdatech.Controller to javafx.fxml;
}
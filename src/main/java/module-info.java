module com.example.lambdatech {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;
    requires java.sql;
    requires java.desktop;

    opens com.example.lambdatech to javafx.fxml;
    exports com.example.lambdatech;
}
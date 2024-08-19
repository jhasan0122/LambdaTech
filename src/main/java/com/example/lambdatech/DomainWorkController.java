package com.example.lambdatech;



import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.text.Text;

public class DomainWorkController {

    @FXML
    private Text write_here;

    @FXML
    void findText(ActionEvent event) {
        System.out.println(DashboardController.searchQuery);
    }

}

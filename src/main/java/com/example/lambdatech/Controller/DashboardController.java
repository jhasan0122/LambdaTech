package com.example.lambdatech.Controller;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

public class DashboardController {

    // Board
    @FXML
    private ImageView back_pic;

    @FXML
    void android_dev(ActionEvent event) {
        System.out.println("Android");
    }

    @FXML
    void dbms_dev(ActionEvent event) {
        System.out.println("DBMS");
    }

    @FXML
    void deep_dev(ActionEvent event) {
        System.out.println("Deep");
    }

    @FXML
    void html_dev(ActionEvent event) {
        System.out.println("HTML");
    }

    @FXML
    void js_dev(ActionEvent event) {
        System.out.println("JS");
    }

    @FXML
    void ml_dev(ActionEvent event) {
        System.out.println("ML");
    }

    @FXML
    void python_dev(ActionEvent event) {
        System.out.println("Python");
    }

    @FXML
    void web_dev(ActionEvent event) {
        System.out.println("Web");
    }

    @FXML
    void ios_dev(ActionEvent event) {
        System.out.println("IOS");
    }
    @FXML
    void ai_dev(ActionEvent event) {
        System.out.println("AI");
    }

    //search

    @FXML
    private TextField searchBar;

    @FXML
    void search(ActionEvent event) {
        String searchValue = searchBar.getText();
        System.out.println(searchValue + "Searching...");
    }

    //Sidebar

    @FXML
    void contact_manager_page_change(ActionEvent event) {
        System.out.println("contact with manager");
    }

    @FXML
    void review_page_change(ActionEvent event) {
        System.out.println("Review page pending....");
    }




}

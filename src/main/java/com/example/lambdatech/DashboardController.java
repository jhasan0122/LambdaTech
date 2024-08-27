package com.example.lambdatech;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;

public class DashboardController {

    public static String searchQuery ="";

    // Board
    @FXML
    private ImageView back_pic;

    @FXML
    void android_dev(ActionEvent event) {
        try{

            searchQuery = "apps";

            Parent parent = FXMLLoader.load(getClass().getResource("domain_work.fxml"));

            Scene scene2 = new Scene(parent);

            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            window.setTitle("Dashboard");

            window.setScene(scene2);
            window.show();
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }

    @FXML
    void dbms_dev(ActionEvent event) {
        try{

            searchQuery = "dbms";

            Parent parent = FXMLLoader.load(getClass().getResource("domain_work.fxml"));

            Scene scene2 = new Scene(parent);

            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            window.setTitle("Dashboard");

            window.setScene(scene2);
            window.show();
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }

    @FXML
    void deep_dev(ActionEvent event) {
        try{

            searchQuery = "deep";

            Parent parent = FXMLLoader.load(getClass().getResource("domain_work.fxml"));

            Scene scene2 = new Scene(parent);

            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            window.setTitle("Dashboard");

            window.setScene(scene2);
            window.show();
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }

    @FXML
    void html_dev(ActionEvent event) {
        try{

            searchQuery = "html";

            Parent parent = FXMLLoader.load(getClass().getResource("domain_work.fxml"));

            Scene scene2 = new Scene(parent);

            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            window.setTitle("Dashboard");

            window.setScene(scene2);
            window.show();
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }

    @FXML
    void js_dev(ActionEvent event) {
        try{

            searchQuery = "js";

            Parent parent = FXMLLoader.load(getClass().getResource("domain_work.fxml"));

            Scene scene2 = new Scene(parent);

            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            window.setTitle("Dashboard");

            window.setScene(scene2);
            window.show();
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }

    @FXML
    void ml_dev(ActionEvent event) {
        try{

            searchQuery = "ml";

            Parent parent = FXMLLoader.load(getClass().getResource("domain_work.fxml"));

            Scene scene2 = new Scene(parent);

            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            window.setTitle("Dashboard");

            window.setScene(scene2);
            window.show();
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }

    @FXML
    void python_dev(ActionEvent event) {
        try{

            searchQuery = "python";

            Parent parent = FXMLLoader.load(getClass().getResource("domain_work.fxml"));

            Scene scene2 = new Scene(parent);

            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            window.setTitle("Dashboard");

            window.setScene(scene2);
            window.show();
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }

    @FXML
    void web_dev(ActionEvent event) {
        try{

            searchQuery = "web";

            Parent parent = FXMLLoader.load(getClass().getResource("domain_work.fxml"));

            Scene scene2 = new Scene(parent);

            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            window.setTitle("Dashboard");

            window.setScene(scene2);
            window.show();
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }

    @FXML
    void ios_dev(ActionEvent event) {
        try{

            searchQuery = "ios";

            Parent parent = FXMLLoader.load(getClass().getResource("domain_work.fxml"));

            Scene scene2 = new Scene(parent);

            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            window.setTitle("Dashboard");

            window.setScene(scene2);
            window.show();
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
    @FXML
    void ai_dev(ActionEvent event) {
        try{

            searchQuery = "ai";

            Parent parent = FXMLLoader.load(getClass().getResource("domain_work.fxml"));

            Scene scene2 = new Scene(parent);

            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            window.setTitle("Dashboard");

            window.setScene(scene2);
            window.show();
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }

    //search

    @FXML
    private TextField searchBar;

    @FXML
    void search(ActionEvent event) {   //in
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

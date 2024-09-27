package com.example.lambdatech;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.time.format.DateTimeFormatter;

public class ContractWorkController {
    @FXML
    private TextArea description;

    @FXML
    public static ComboBox<String> managerList = new ComboBox<>();

    @FXML
    private TextField title;

    @FXML
    void submitWork(ActionEvent event) {
        String desc = description.getText();
        String titl = title.getText();

        if(!MainController.user.isEmpty()) {

            String sql = "INSERT INTO system(manager_name,client_name, system_title,system_details, domain, language) VALUES (?, ?, ?, ?,?,?)";
            final String URL = "jdbc:mysql://localhost:3306/lambdatech";
            final String USER = "root";
            final String PASSWORD = "";

            try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
                 PreparedStatement pst = con.prepareStatement(sql)) {

                // Set parameters
                pst.setString(1, "manager1");
                pst.setString(2, MainController.user);
                pst.setString(3, titl);
                pst.setString(4, desc);
                pst.setString(5, "apps");
                pst.setString(6, "flutter");

                // Execute the SQL INSERT statement
                int row = pst.executeUpdate();

                if (row > 0) {
                    Parent parent = FXMLLoader.load(getClass().getResource("/com/example/lambdatech/dashboard.fxml"));

                    Scene scene2 = new Scene(parent);

                    Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    window.setTitle("Dashboard");

                    window.setScene(scene2);
                    window.show();
                }

            } catch (Exception e) {
                System.out.println(e.getMessage());
                ;
            }
        }
    }
}



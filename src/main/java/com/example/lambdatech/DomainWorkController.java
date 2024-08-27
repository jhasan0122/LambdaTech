package com.example.lambdatech;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;


import javax.swing.*;



import javafx.geometry.Insets;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.AnchorPane;

import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;


public class DomainWorkController extends JFrame {

    @FXML
    private GridPane gridList;


    @FXML
    public void initialize() {
        // This code will run when the FXML file is loaded
        System.out.println("Page has been initialized!");
        System.out.println(DashboardController.searchQuery);

        String sql = "SELECT system_title,system_details,domain,language  FROM system where domain=?";
        final String URL = "jdbc:mysql://localhost:3306/lambdatech";
        final String USER = "root";
        final String PASSWORD = "";

        try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pst = con.prepareStatement(sql)) {

            // Set parameters
            pst.setString(1, DashboardController.searchQuery);

            ResultSet resultSet = pst.executeQuery();

            int i=0,j=0;
            while (resultSet.next()){
                if(j>=4){
                    i++;
                    j=0;
                    if(i>=3){
                        break;
                    }
                }
                String heading = resultSet.getString("system_title");
                String about = resultSet.getString("domain") +" - " +resultSet.getString("language");
                String context = resultSet.getString("system_details");

                Pane div = createPane(heading,about,context);
                gridList.add(div,j,i);
                j++;
            }

        }catch (SQLException  e){
            System.out.println(e.getMessage());
        }


    }

    @FXML
    void dashboard_go(ActionEvent event) throws IOException{
        Parent parent = FXMLLoader.load(getClass().getResource("dashboard.fxml"));

        Scene scene2 = new Scene(parent);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setTitle("Sign Up");

        window.setScene(scene2);
        window.show();
    }



    public static Pane createPane(String heading,String about,String content) {
    // Create the main Pane
    Pane item = new Pane();
    item.setPrefSize(200, 200);
    item.setStyle("-fx-background-color: #2196F3; -fx-border-radius: 10px;");

    // Set padding and margin
    item.setPadding(new Insets(5, 5, 5, 5));
    GridPane.setMargin(item, new Insets(10, 10, 10, 10));

    // Create the SplitPane
    SplitPane splitPane = new SplitPane();
    splitPane.setDividerPositions(0.5);
    splitPane.setLayoutX(20);
    splitPane.setOrientation(javafx.geometry.Orientation.VERTICAL);
    splitPane.setPrefSize(189, 64);

    // Create the first AnchorPane (for heading)
    AnchorPane anchorPane1 = new AnchorPane();
    anchorPane1.setPrefSize(160, 100);

    Text item_head = new Text(heading);
    item_head.setFont(Font.font("System Bold", 24));
    item_head.setLayoutX(14);
    item_head.setLayoutY(23);

    anchorPane1.getChildren().add(item_head);

    // Create the second AnchorPane (for about)
    AnchorPane anchorPane2 = new AnchorPane();
    anchorPane2.setPrefSize(160, 100);

    Text item_about = new Text(about);
    item_about.setFont(Font.font(18));
    item_about.setLayoutX(14);
    item_about.setLayoutY(21);

    anchorPane2.getChildren().add(item_about);

    // Add the AnchorPanes to the SplitPane
    splitPane.getItems().addAll(anchorPane1, anchorPane2);

    // Create the Text element (for description)
    Text item_des = new Text(content);
    item_des.setFont(Font.font(18));
    item_des.setFill(javafx.scene.paint.Color.WHITE);
    item_des.setLayoutX(21);
    item_des.setLayoutY(87);
    item_des.setWrappingWidth(187);

    // Add children to the Pane
    item.getChildren().addAll(splitPane, item_des);

    return item;
}

}

package com.example.lambdatech;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

public class DeveloperSignupController {

    @FXML
    private TextArea about;

    @FXML
    private TextField designation;

    @FXML
    private TextField email;

    @FXML
    private PasswordField password_hide;

    @FXML
    private TextField password_show;

    @FXML
    private TextField phone;

    @FXML
    private CheckBox showCheck;

    @FXML
    private TextField username;


    @FXML
    private TextField d1;

    @FXML
    private TextField d2;

    @FXML
    private TextField d3;

    @FXML
    private TextField d4;

    @FXML
    private TextField d5;

    @FXML
    private TextField l1;

    @FXML
    private TextField l2;

    @FXML
    private TextField l3;

    @FXML
    private TextField l4;

    @FXML
    private TextField l5;

    @FXML
    private Text about_black;

    @FXML
    private Text des_black;

    @FXML
    private Text email_black;

    @FXML
    private Text password_black;

    @FXML
    private Text phone_black;

    @FXML
    private Text username_black;


    @FXML
    void changeVisibility(MouseEvent event) {
        if(showCheck.isSelected()){
            password_show.setText(password_hide.getText());
            password_hide.setVisible(false);
            password_show.setVisible(true);
            return;
        }
        password_hide.setText(password_show.getText());
        password_show.setVisible(false);
        password_hide.setVisible(true);
    }

    @FXML
    void dev_loign_page(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("developer_login.fxml"));

        Scene scene2 = new Scene(parent);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setTitle("Dashboard");

        window.setScene(scene2);
        window.show();
    }

    @FXML
    void signup_admin(ActionEvent event) {
        String usernameS = username.getText();
        String passwordS = password_hide.getText();
        String passwordShowS = password_show.getText();
        String emailS = email.getText();
        String phoneS = phone.getText();
        String desS = designation.getText();
        String aboutS = about.getText();

        ArrayList<String> domains = new ArrayList<String>();
        ArrayList<String> Languages = new ArrayList<String>();

        if (!passwordShowS.isEmpty()) {
            passwordS = passwordShowS;
        }

        boolean flag = true,done=false;
        if (usernameS.isEmpty()) {
            username_black.setText("Username is blank");
            flag = false;
        } else {


            String sql = "SELECT sys FROM developer WHERE dev_name = '"+usernameS+"'";
            final String URL = "jdbc:mysql://localhost:3306/lambdatech";
            final String USER = "root";
            final String PASSWORD = "";



            try{
                Connection con = DriverManager.getConnection(URL,USER,PASSWORD);
                Statement st = con.createStatement();
                ResultSet rs= st.executeQuery(sql);
                rs.next();

                String userCount =  rs.getString(1);

                if(Integer.parseInt(userCount) >= 1){
                    flag=false;
                    username_black.setText("Username has taken");
                }
                else {
                    username_black.setText("");
                }

            }catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (passwordS.isEmpty()) {
            password_black.setText("Password is blank");
            flag = false;
        } else {
            password_black.setText("");
        }

        if (emailS.isEmpty()) {
            email_black.setText("Email is blank");
            flag = false;
        } else {

            String sql = "SELECT COUNT(*) FROM developer WHERE email = '"+emailS+"'";
            final String URL = "jdbc:mysql://localhost:3306/lambdatech";
            final String USER = "root";
            final String PASSWORD = "";



            try{
                Connection con = DriverManager.getConnection(URL,USER,PASSWORD);
                Statement st = con.createStatement();
                ResultSet rs= st.executeQuery(sql);
                rs.next();

                String userCount =  rs.getString(1);

                if(Integer.parseInt(userCount) >= 1){
                    flag=false;
                    email_black.setText("Email has taken");
                }
                else {
                    email_black.setText("");
                }

            }catch (SQLException e) {
                e.printStackTrace();
            }


        }

        if (phoneS.isEmpty()) {
            phone_black.setText("Phone is blank");
            flag = false;
        } else {
            phone_black.setText("");
        }

        if (phoneS.isEmpty()) {
            phone_black.setText("Phone is blank");
            flag = false;
        } else {
            phone_black.setText("");
        }

        if (desS.isEmpty()) {
            des_black.setText("Designation is blank");
            flag = false;
        } else {
            des_black.setText("");
        }

        if (aboutS.isEmpty()) {
            about_black.setText("About is blank");
            flag = false;
        } else {
            about_black.setText("");
        }

        if (flag) {
            String sql = "INSERT INTO developer(dev_name, password, email, phone, about,designation) VALUES (?, ?, ?, ?, ?,?)";
            final String URL = "jdbc:mysql://localhost:3306/lambdatech";
            final String USER = "root";
            final String PASSWORD = "";

            try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
                 PreparedStatement pst = con.prepareStatement(sql)) {

                // Set parameters
                pst.setString(1, usernameS);
                pst.setString(2, passwordS);
                pst.setString(3, emailS);
                pst.setString(4, phoneS);
                pst.setString(5, aboutS);
                pst.setString(6, desS);


                // Execute the SQL INSERT statement
                int row = pst.executeUpdate();

                if(row > 0){


                    if(!(d1.getText()).isEmpty()){
                        domains.add(d1.getText());
                    }
                    if(!(d2.getText()).isEmpty()){
                        domains.add(d2.getText());
                    }
                    if(!(d3.getText()).isEmpty()){
                        domains.add(d3.getText());
                    }
                    if(!(d4.getText()).isEmpty()){
                        domains.add(d4.getText());
                    }
                    if(!(d5.getText()).isEmpty()){
                        domains.add(d5.getText());
                    }


                    if(!(l1.getText()).isEmpty()){
                        Languages.add(l1.getText());
                    }
                    if(!(l2.getText()).isEmpty()){
                        Languages.add(l2.getText());
                    }
                    if(!(l3.getText()).isEmpty()){
                        Languages.add(l3.getText());
                    }
                    if(!(l4.getText()).isEmpty()){
                        Languages.add(l4.getText());
                    }
                    if(!(l5.getText()).isEmpty()){
                        Languages.add(l5.getText());
                    }



                  
                    Parent parent = FXMLLoader.load(getClass().getResource("dashboard.fxml"));

                    Scene scene2 = new Scene(parent);

                    Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
                    window.setTitle("Dashboard");

                    window.setScene(scene2);
                    window.show();
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());;
            }

            for (String dom:domains){
                String sql2 = "INSERT INTO dev_domain(dev_name, domain) VALUES (?, ?)";

                try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
                     PreparedStatement pst2 = con.prepareStatement(sql2)) {

                    pst2.setString(1, usernameS);
                    pst2.setString(2, dom);

                    pst2.executeUpdate();

                }catch (Exception e){
                    System.out.println(e.getMessage());
                }
            }
            for (String lan:Languages){
                String sql23 = "INSERT INTO dev_lang(dev_name, language) VALUES (?, ?)";

                try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
                     PreparedStatement pst3 = con.prepareStatement(sql23)) {

                    pst3.setString(1, usernameS);
                    pst3.setString(2, lan);

                    pst3.executeUpdate();

                }catch (Exception e){
                    System.out.println(e.getMessage());
                }
            }

        }

    }

}

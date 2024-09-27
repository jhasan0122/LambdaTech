package com.example.lambdatech;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.Node;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.PasswordField;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;

public class MainController {

    static String user="";

    @FXML
    private ImageView back_ss;


    @FXML
    private PasswordField passwordField;

    @FXML
    private TextField password_show;

    @FXML
    private CheckBox showCheck;

    @FXML
    private TextField username_login;

    @FXML
    private Text username_black;

    @FXML
    private Text password_black;

    @FXML
    void changeVisibility(MouseEvent event) {
        if(showCheck.isSelected()){
            password_show.setText(passwordField.getText());
            passwordField.setVisible(false);
            password_show.setVisible(true);
            return;
        }
        passwordField.setText(password_show.getText());
        password_show.setVisible(false);
        passwordField.setVisible(true);
    }

    @FXML
    void delete_it(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("dashboard.fxml"));

        Scene scene2 = new Scene(parent);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setTitle("Dashboard");

        window.setScene(scene2);
        window.show();
    }

    @FXML
    void login_click(MouseEvent event) {
        String username = username_login.getText();
        String password = passwordField.getText();
        String pass2 = password_show.getText();
        boolean flag = true;
        if(username.isEmpty()){
            username_black.setText("Enter user name");
            flag = false;
        }
        else{
            username_black.setText("");
        }

        if (password.isEmpty() && pass2.isEmpty()) {
            password_black.setText("Enter password");
            flag = false;
        }
        else{
            password_black.setText("");
        }

        if(flag){
            String sql = "select password from client where client_name = '" + username + "'";
             final String URL = "jdbc:mysql://localhost:3306/lambdatech";
             final String USER = "root";
             final String PASSWORD = "";




            try {
                Connection con = DriverManager.getConnection(URL,USER,PASSWORD);
                Statement st = con.createStatement();
                ResultSet rs= st.executeQuery(sql);
                rs.next();

                String pass =  rs.getString(1);



                if(pass ==null || pass.isEmpty()){
                    username_black.setText("Username or password is not valid");
                    password_black.setText("Username or password is not valid");
                    return;
                }

                if(pass.equals(password) || pass.equals(pass2)){

                    user = username;

                    Parent parent = FXMLLoader.load(getClass().getResource("dashboard.fxml"));

                    Scene scene2 = new Scene(parent);

                    Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
                    window.setTitle("Dashboard");

                    window.setScene(scene2);
                    window.show();
                }
                else{
                    username_black.setText("Username or password is not valid");
                    password_black.setText("Username or password is not valid");
                    System.out.println("Login Error");
                }
                con.close();
            } catch (SQLException | IOException e) {
                username_black.setText("Username is not valid or");
                password_black.setText("Password is not valid");
                e.printStackTrace();
            }

        }
    }

    @FXML
    void signup_page_change(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("signup.fxml"));

        Scene scene2 = new Scene(parent);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setTitle("Sign Up");

        window.setScene(scene2);
        window.show();
    }

    @FXML
    void developer_mode(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("developer_login.fxml"));

        Scene scene3 = new Scene(parent);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setTitle("developer");

        window.setScene(scene3);
        window.show();
    }

}
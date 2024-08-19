package com.example.lambdatech;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.io.IOException;

public class SignupController {

    @FXML
    private ImageView back_btn;

    @FXML
    private TextField email;

    @FXML
    private DatePicker dob;

    @FXML
    private PasswordField password;

    @FXML
    private TextField password_show;

    @FXML
    private TextField phone;

    @FXML
    private ImageView signup_ss;

    @FXML
    private TextField username;

    @FXML
    private Text dob_black;

    @FXML
    private Text email_black;

    @FXML
    private Text password_black;

    @FXML
    private Text phone_black;

    @FXML
    private Text username_black;

    @FXML
    private CheckBox checkShow;

    @FXML
    void back_to_signup(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("login.fxml"));
        Scene scene1 = new Scene(parent);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(scene1);
        window.show();
    }

    @FXML
    void changeVisibility(ActionEvent event) {
        if (checkShow.isSelected()) {
            password_show.setText(password.getText());
            password.setVisible(false);
            password_show.setVisible(true);
        } else {
            password.setText(password_show.getText());
            password_show.setVisible(false);
            password.setVisible(true);
        }
    }

    @FXML
    void signup_it(ActionEvent event) {
        String usernameS = username.getText();
        String passwordS = password.getText();
        String passwordShowS = password_show.getText();
        String emailS = email.getText();
        String phoneS = phone.getText();
        LocalDate dobS = dob.getValue();

        if (!passwordShowS.isEmpty()) {
            passwordS = passwordShowS;
        }

        boolean flag = true;
        if (usernameS.isEmpty()) {
            username_black.setText("Username is blank");
            flag = false;
        } else {


            String sql = "SELECT COUNT(*) FROM client WHERE client_name = '"+usernameS+"'";
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

            String sql = "SELECT COUNT(*) FROM client WHERE email = '"+emailS+"'";
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

        if (dobS == null) {
            dob_black.setText("Date of Birth is blank");
            flag = false;
        } else {
            dob_black.setText("");
        }

        if (flag) {
            String sql = "INSERT INTO client(client_name, password, email, phone, dob) VALUES (?, ?, ?, ?, ?)";
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
                pst.setString(5, dobS.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));

                // Execute the SQL INSERT statement
                int row = pst.executeUpdate();

                if(row > 0){
                    Parent parent = FXMLLoader.load(getClass().getResource("/com/example/lambdatech/dashboard.fxml"));

                    Scene scene2 = new Scene(parent);

                    Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
                    window.setTitle("Dashboard");

                    window.setScene(scene2);
                    window.show();
                }

            } catch (Exception e) {
                System.out.println(e.getMessage());;
            }
        }
    }
}

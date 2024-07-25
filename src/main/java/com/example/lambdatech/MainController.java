package com.example.lambdatech;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.PasswordField;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

public class MainController {

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
    void login_click(MouseEvent event) {
        String username = username_login.getText();
        String password = passwordField.getText();
        String pass2 = password_show.getText();
        if(username.isEmpty()){
            username_black.setText("Enter user name");
        }
        else{
            username_black.setText("");
        }

        if (password.isEmpty() && pass2.isEmpty()) {
            password_black.setText("Enter password");
        }
        else{
            password_black.setText("");
        }

    }



}
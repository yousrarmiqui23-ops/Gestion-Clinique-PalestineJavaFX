package com.clinique.controller;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

public class loginController {
    @FXML
    private TextField email;       // lié à fx:id="email"
    @FXML
    private PasswordField password; // lié à fx:id="password"
    @FXML
    private Button loginButton;

    @FXML
    private void handleLogin() throws Exception {
        String userEmail = email.getText();
        String userPassword = password.getText();
        if (userEmail.equals("palestine@clinique.com") && userPassword.equals("gethealed2026")) {
            // Charger la page home.fxml
            Parent root = FXMLLoader.load(getClass().getResource("/vue/home.fxml"));
            Stage stage = (Stage) loginButton.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } else {
            System.out.println("Email ou mot de passe incorrect !");
        }

    }
}

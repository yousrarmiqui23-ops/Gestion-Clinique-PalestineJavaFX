package com.clinique;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Objects;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Charger la page de login
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/vue/login.fxml")));
        primaryStage.setTitle("clinique_palestine");
        primaryStage.setScene(new Scene(root, 600,  435));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

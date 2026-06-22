package com.clinique.controller;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
// la classe :
public class homeController {
    @FXML private Button medecin ;
    @FXML private Button rendezVous;
    @FXML private Button Tbord;
    @FXML private Button ppatient;


    @FXML
    private void ouvrirTbord(){
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/vue/dashboard.fxml"));
            Stage stage = (Stage) Tbord.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @FXML
    private void ouvrirPagePatient(){
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/vue/patients.fxml"));
            Stage stage = (Stage) ppatient.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @FXML
    private void ouvrirPageMedecin() {

        try {
            Parent root = FXMLLoader.load(getClass().getResource("/vue/medecin.fxml"));
            Stage stage = (Stage) medecin.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void ouvrirPageRendezvous(){
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/vue/rendezVous.fxml"));
            Stage stage = (Stage) rendezVous.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



}

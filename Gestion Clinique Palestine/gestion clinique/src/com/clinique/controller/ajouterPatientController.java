package com.clinique.controller;
import com.clinique.DAO.PatientDAO;
import  com.clinique.modele.Patient;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ajouterPatientController {

    @FXML
    private Button ajouter;
    @FXML
    private TextField txtNom;
    @FXML
    private TextField txtPrenom;
    @FXML
    private TextField txtCin;
    @FXML
    private TextField txtTlphn;
    @FXML
    private TextField txtGS;
    @FXML
    private TextField txtAdresse;


    @FXML
    private void AjouterPatient() {
        Patient p = new Patient(0,
                txtNom.getText(),
                txtPrenom.getText(),
                txtCin.getText(),
                txtTlphn.getText(),
                txtGS.getText(),
                txtAdresse.getText());

        PatientDAO dao = new PatientDAO();
        dao.ajouterPatient(p);

        System.out.println("Patient ajouté avec succès !");
        // Retour à la vue patients
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/vue/patients.fxml"));
            Stage stage = (Stage) ajouter.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

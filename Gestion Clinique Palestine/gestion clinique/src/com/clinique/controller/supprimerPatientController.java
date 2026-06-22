package com.clinique.controller;
import com.clinique.modele.Patient;
import com.clinique.DAO.PatientDAO;
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

public class supprimerPatientController {

    @FXML private Button supprimer;
    @FXML private TextField txtId;

    @FXML
    private void SupprimerPatient() {
        int id = Integer.parseInt(txtId.getText());
        PatientDAO dao = new PatientDAO();
        dao.supprimerPatient(id);

        System.out.println("Patient supprimé avec succès !");
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/vue/patients.fxml"));
            Stage stage = (Stage) supprimer.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

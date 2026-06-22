package com.clinique.controller;
import com.clinique.DAO.MedecinDAO;
import com.clinique.modele.Medecin;
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

public class supprimerMedecinController {

    @FXML private Button supprimer;
    @FXML private TextField txtCin;

    @FXML
    private void SupprimerMedecin() {
        String cin = txtCin.getText();
        MedecinDAO dao = new MedecinDAO();
        dao.supprimerMedecin(cin);

        System.out.println("Médecin supprimé avec succès !");
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/vue/medecin.fxml"));
            Stage stage = (Stage) supprimer.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

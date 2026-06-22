package com.clinique.controller;
import com.clinique.DAO.RendezVousDAO;
import com.clinique.modele.RendezVous;
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

public class supprimerRVController {

    @FXML private TextField txtId;
    @FXML private Button supprimer;

    @FXML
    private void SupprimerRV() {
        try {
            int id = Integer.parseInt(txtId.getText());
            RendezVousDAO dao = new RendezVousDAO();
            dao.supprimerRendezVous(id);

            System.out.println("Rendez-vous supprimé avec succès !");
            Parent root = FXMLLoader.load(getClass().getResource("/vue/rendezVous.fxml"));
            Stage stage = (Stage) supprimer.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (NumberFormatException e) {
            System.out.println("Veuillez entrer un ID valide (nombre).");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}


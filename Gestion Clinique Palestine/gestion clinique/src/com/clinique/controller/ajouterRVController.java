package com.clinique.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import com.clinique.DAO.RendezVousDAO;
import com.clinique.modele.RendezVous;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ajouterRVController {

    @FXML
    private ComboBox<String> motif;
    @FXML
    private TextField txtNom;
    @FXML
    private TextField txtCin;
    @FXML
    private TextField txtMedecin;
    @FXML
    private TextField txtDate;
    @FXML
    private TextField txtHeure;
    @FXML
    private TextField txtTarif;
    @FXML
    private TextField txtTelephone;
    @FXML
    private TextField txtPaye;   // maintenant un TextField
    @FXML
    public Button ajouter;

    @FXML
    public void initialize() {
        motif.getItems().addAll(
                "Consultation générale",
                "Urgence",
                "Suivi de traitement",
                "Examens complémentaires",
                "Vaccination"
        );
    }

    @FXML
    private void ajouterRV() {
        RendezVous rv = new RendezVous(
                0,
                txtNom.getText(),
                txtCin.getText(),
                txtMedecin.getText(),
                txtDate.getText(),
                txtHeure.getText(),
                motif.getValue(),
                Double.parseDouble(txtTarif.getText()),
                Double.parseDouble(txtPaye.getText()),
                txtTelephone.getText()
        );

        RendezVousDAO dao = new RendezVousDAO();
        dao.ajouterRendezVous(rv);

        System.out.println("Rendez-vous ajouté avec succès !");
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/vue/rendezVous.fxml"));
            Stage stage = (Stage) ajouter.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

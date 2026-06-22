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

public class ajouterMedecinController {

    @FXML private TextField txtNom;
    @FXML private TextField txtPrenom;
    @FXML private TextField txtCin;
    @FXML private TextField txtSpecialite;
    @FXML private TextField txtDateEmbauche;
    @FXML private TextField txtTelephone;
    @FXML private TextField txtEmail;
    @FXML private Button Ajouter;

    @FXML
    private void AjouterMedeecin() {
        Medecin m = new Medecin(
                txtNom.getText(),
                txtPrenom.getText(),
                txtCin.getText(),
                txtSpecialite.getText(),
                txtDateEmbauche.getText(),
                txtTelephone.getText(),
                txtEmail.getText()
        );

        MedecinDAO dao = new MedecinDAO();
        dao.ajouterMedecin(m);

        System.out.println("Médecin ajouté avec succès !");
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/vue/medecin.fxml"));
            Stage stage = (Stage) Ajouter.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

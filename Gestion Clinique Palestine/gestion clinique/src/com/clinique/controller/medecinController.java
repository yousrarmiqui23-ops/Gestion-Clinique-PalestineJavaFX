package com.clinique.controller;
import com.clinique.DAO.MedecinDAO;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;


import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

import com.clinique.modele.Medecin;
import javafx.stage.Stage;

public class medecinController implements Initializable {

    @FXML private TableView<Medecin> tableMedecin;
    @FXML private TableColumn<Medecin, String> colNom;
    @FXML private TableColumn<Medecin, String> colPrenom;
    @FXML private TableColumn<Medecin, String> colCin;
    @FXML private TableColumn<Medecin, String> colSpecialite;
    @FXML private TableColumn<Medecin, String> colDateEmbauche;
    @FXML private TableColumn<Medecin, String> colTelephone;
    @FXML private TableColumn<Medecin, String> colEmail;
    @FXML private Button home;
    @FXML private Button ajouter;
    @FXML private Button supprimer;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Lier les colonnes aux attributs de la classe Medecin
        colNom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        colPrenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        colCin.setCellValueFactory(new PropertyValueFactory<>("cin"));
        colSpecialite.setCellValueFactory(new PropertyValueFactory<>("specialite"));
        colDateEmbauche.setCellValueFactory(new PropertyValueFactory<>("dateEmbauche"));
        colTelephone.setCellValueFactory(new PropertyValueFactory<>("telephone"));
        colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));

        // Charger les données depuis la base
        tableMedecin.setItems(getMedecinsFromDB());
    }

    private ObservableList<Medecin> getMedecinsFromDB() {
        MedecinDAO dao = new MedecinDAO();
        return FXCollections.observableArrayList(dao.getAllMedecins());
    }

    @FXML
    private void bouttonHome() {

        try {
            Parent root = FXMLLoader.load(getClass().getResource("/vue/home.fxml"));
            Stage stage = (Stage) home.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @FXML
    private void bouttonAjouter(){
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/vue/ajouterMedecin.fxml"));
            Stage stage = (Stage) ajouter.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @FXML
    private void BouttonSupprimer(){
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/vue/supprimerMedecin.fxml"));
            Stage stage = (Stage) supprimer.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}

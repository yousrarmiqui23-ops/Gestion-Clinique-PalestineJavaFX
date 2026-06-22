package com.clinique.controller;
import com.clinique.DAO.RendezVousDAO;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

import com.clinique.modele.RendezVous;

public class rendezVousController implements Initializable {

    @FXML private Button home;
    @FXML private Button ajouter;
    @FXML private Button supprimer;

    @FXML private TableView<RendezVous> tableRV;
    @FXML private TableColumn<RendezVous, Integer> txtId;
    @FXML private TableColumn<RendezVous, String> txtNom;
    @FXML private TableColumn<RendezVous, String> txtCin;
    @FXML private TableColumn<RendezVous, String> txtMedecin;
    @FXML private TableColumn<RendezVous, String> txtDate;
    @FXML private TableColumn<RendezVous, String> txtHeure;
    @FXML private TableColumn<RendezVous, String> txtMotif;
    @FXML private TableColumn<RendezVous, Double> txtTarif;
    @FXML private TableColumn<RendezVous, Double> txtPaye;
    @FXML private TableColumn<RendezVous, String> txtTlphn;

    private ObservableList<RendezVous> data = FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Lier les colonnes aux getters du modèle RendezVous
        txtId.setCellValueFactory(cell -> new javafx.beans.property.SimpleIntegerProperty(cell.getValue().getId()).asObject());
        txtNom.setCellValueFactory(cell -> new javafx.beans.property.SimpleStringProperty(cell.getValue().getNomComplet()));
        txtCin.setCellValueFactory(cell -> new javafx.beans.property.SimpleStringProperty(cell.getValue().getCin()));
        txtMedecin.setCellValueFactory(cell -> new javafx.beans.property.SimpleStringProperty(cell.getValue().getMedecin()));
        txtDate.setCellValueFactory(cell -> new javafx.beans.property.SimpleStringProperty(cell.getValue().getDateRv()));
        txtHeure.setCellValueFactory(cell -> new javafx.beans.property.SimpleStringProperty(cell.getValue().getHeure()));
        txtMotif.setCellValueFactory(cell -> new javafx.beans.property.SimpleStringProperty(cell.getValue().getMotif()));
        txtTarif.setCellValueFactory(cell -> new javafx.beans.property.SimpleDoubleProperty(cell.getValue().getTarif()).asObject());
        txtPaye.setCellValueFactory(cell -> new javafx.beans.property.SimpleDoubleProperty(cell.getValue().getPaye()).asObject());
        txtTlphn.setCellValueFactory(cell -> new javafx.beans.property.SimpleStringProperty(cell.getValue().getTelephone()));

        loadData();
    }

    private void loadData() {
        RendezVousDAO dao = new RendezVousDAO();
        data.setAll(dao.getAllRendezVous());
        tableRV.setItems(data);
    }


    @FXML
    private void bouttonAcceuil(){
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
            Parent root = FXMLLoader.load(getClass().getResource("/vue/ajouterRV.fxml"));
            Stage stage = (Stage) ajouter.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @FXML
    private void bouttonSupprimer(){
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/vue/supprimerRV.fxml"));
            Stage stage = (Stage) ajouter.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

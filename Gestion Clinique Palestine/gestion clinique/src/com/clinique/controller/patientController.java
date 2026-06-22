package com.clinique.controller;
import com.clinique.DAO.PatientDAO;
import com.clinique.modele.Medecin;
import com.clinique.modele.RendezVous;
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

import com.clinique.modele.Patient;
import javafx.stage.Stage;

public class patientController implements Initializable{

    @FXML private Button home;
    @FXML private Button ajouter;
    @FXML private Button supprimer;
    @FXML private TableView<Patient> tablePatient;
    @FXML private TableColumn<Patient, Integer> colId;
    @FXML private TableColumn<Patient, String> colNom;
    @FXML private TableColumn<Patient, String> colPrenom;
    @FXML private TableColumn<Patient, String> colCin;
    @FXML private TableColumn<Patient, String> colTlphn;
    @FXML private TableColumn<Patient, String> colGS;
    @FXML private TableColumn<Patient, String> colAdresse;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        colId.setCellValueFactory(new PropertyValueFactory<>("Id"));
        colNom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        colPrenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        colCin.setCellValueFactory(new PropertyValueFactory<>("cin"));
        colTlphn.setCellValueFactory(new PropertyValueFactory<>("telephone"));
        colGS.setCellValueFactory(new PropertyValueFactory<>("groupeSanguin"));
        colAdresse.setCellValueFactory(new PropertyValueFactory<>("adresse"));

        // Charger les données depuis la base
        tablePatient.setItems(getPatientsFromDB());
    }
    private ObservableList<Patient> getPatientsFromDB() {
        PatientDAO dao = new PatientDAO();
        return FXCollections.observableArrayList(dao.getAllPatients());
    }

    @FXML
    private void home(){
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
    private void ajouter(){
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/vue/ajouterPatient.fxml"));
            Stage stage = (Stage) ajouter.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @FXML
    private void supprimer() {
    try{
            Parent root = FXMLLoader.load(getClass().getResource("/vue/supprimerPatient.fxml"));
            Stage stage = (Stage) supprimer.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch(
        Exception e)

        {
            e.printStackTrace();
        }
    }
}

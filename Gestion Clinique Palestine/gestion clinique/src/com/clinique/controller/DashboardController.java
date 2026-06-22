package com.clinique.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;

import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

import com.clinique.modele.RendezVous;
import javafx.stage.Stage;

public class DashboardController implements Initializable {

    @FXML private TableView<RendezVous> tableRV;
    @FXML private TableColumn<RendezVous, String> txtHeure;
    @FXML private TableColumn<RendezVous, String> txtNom;
    @FXML private TableColumn<RendezVous, String> txtMedecin;
    @FXML private TableColumn<RendezVous, String> txtMotif;
    @FXML private TableColumn<RendezVous, String> txtPaye;

    @FXML private TextField txtCin;
    @FXML private Button chercher;
    @FXML private Button home;

    private ObservableList<RendezVous> data = FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Lier les colonnes aux getters de RendezVous
        txtHeure.setCellValueFactory(cell -> new javafx.beans.property.SimpleStringProperty(cell.getValue().getHeure()));
        txtNom.setCellValueFactory(cell -> new javafx.beans.property.SimpleStringProperty(cell.getValue().getNomComplet()));
        txtMedecin.setCellValueFactory(cell -> new javafx.beans.property.SimpleStringProperty(cell.getValue().getMedecin()));
        txtMotif.setCellValueFactory(cell -> new javafx.beans.property.SimpleStringProperty(cell.getValue().getMotif()));

        // Status calculé à partir du montant payé et du tarif
        txtPaye.setCellValueFactory(cell -> {
            double tarif = cell.getValue().getTarif();
            double paye = cell.getValue().getPaye(); // maintenant c’est un double
            String status;
            if (paye == 0) {
                status = "Non payé";
            } else if (paye == tarif) {
                status = "Payé";
            } else if (paye < tarif) {
                status = "Incomplet";
            } else {
                status = "Erreur";
            }
            return new javafx.beans.property.SimpleStringProperty(status);
        });

        loadData(); // charger tous les rendez-vous au démarrage
    }

    private void loadData() {
        data.clear();
        String url = "jdbc:mysql://localhost:3306/clinique";
        String user = "root";
        String password = "";

        String sql = "SELECT * FROM rendezvous";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                data.add(new RendezVous(
                        rs.getInt("id"),
                        rs.getString("nom_complet"),
                        rs.getString("cin"),
                        rs.getString("medecin"),
                        rs.getString("date_rv"),
                        rs.getString("heure"),
                        rs.getString("motif"),
                        rs.getDouble("tarif"),
                        rs.getDouble("paye"), // récupère le montant payé
                        rs.getString("telephone")
                ));
            }
            tableRV.setItems(data);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void chercherParCin() {
        data.clear();
        String url = "jdbc:mysql://localhost:3306/clinique";
        String user = "root";
        String password = "";

        String sql = "SELECT * FROM rendezvous WHERE cin = ?";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement pst = conn.prepareStatement(sql)) {

            pst.setString(1, txtCin.getText());
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                data.add(new RendezVous(
                        rs.getInt("id"),
                        rs.getString("nom_complet"),
                        rs.getString("cin"),
                        rs.getString("medecin"),
                        rs.getString("date_rv"),
                        rs.getString("heure"),
                        rs.getString("motif"),
                        rs.getDouble("tarif"),
                        rs.getDouble("paye"), // récupère le montant payé
                        rs.getString("telephone")
                ));
                tableRV.setItems(data);
            } else {
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Recherche");
                alert.setHeaderText(null);
                alert.setContentText("Personne introuvable !");
                alert.showAndWait();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
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
}

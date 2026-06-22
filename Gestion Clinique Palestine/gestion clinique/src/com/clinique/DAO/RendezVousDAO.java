package com.clinique.DAO;

import com.clinique.modele.RendezVous;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RendezVousDAO {
    private final String url = "jdbc:mysql://localhost:3306/clinique";
    private final String user = "root";
    private final String password = "";

    // Récupérer tous les rendez-vous
    public List<RendezVous> getAllRendezVous() {
        List<RendezVous> list = new ArrayList<>();
        String sql = "SELECT * FROM rendezvous";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                list.add(new RendezVous(
                        rs.getInt("id"),
                        rs.getString("nom_complet"),
                        rs.getString("cin"),
                        rs.getString("medecin"),
                        rs.getString("date_rv"),
                        rs.getString("heure"),
                        rs.getString("motif"),
                        rs.getDouble("tarif"),
                        rs.getDouble("paye"),
                        rs.getString("telephone")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    // Ajouter un rendez-vous
    public void ajouterRendezVous(RendezVous rv) {
        String sql = "INSERT INTO rendezvous (nom_complet, cin, medecin, date_rv, heure, motif, tarif, paye, telephone) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement pst = conn.prepareStatement(sql)) {

            pst.setString(1, rv.getNomComplet());
            pst.setString(2, rv.getCin());
            pst.setString(3, rv.getMedecin());
            pst.setString(4, rv.getDateRv());
            pst.setString(5, rv.getHeure());
            pst.setString(6, rv.getMotif());
            pst.setDouble(7, rv.getTarif());
            pst.setDouble(8, rv.getPaye());
            pst.setString(9, rv.getTelephone());
            pst.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Supprimer un rendez-vous par ID
    public void supprimerRendezVous(int id) {
        String sql = "DELETE FROM rendezvous WHERE id = ?";
        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement pst = conn.prepareStatement(sql)) {

            pst.setInt(1, id);
            pst.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

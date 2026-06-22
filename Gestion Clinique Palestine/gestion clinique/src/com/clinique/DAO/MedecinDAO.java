package com.clinique.DAO;

import com.clinique.modele.Medecin;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MedecinDAO {
    private final String url = "jdbc:mysql://localhost:3306/clinique";
    private final String user = "root";
    private final String password = "";

    // Récupérer tous les médecins
    public List<Medecin> getAllMedecins() {
        List<Medecin> list = new ArrayList<>();
        String sql = "SELECT * FROM medecin";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                list.add(new Medecin(
                        rs.getString("nom"),
                        rs.getString("prenom"),
                        rs.getString("cin"),
                        rs.getString("specialite"),
                        rs.getString("date_embauche"),
                        rs.getString("telephone"),
                        rs.getString("email")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    // Ajouter un médecin
    public void ajouterMedecin(Medecin m) {
        String sql = "INSERT INTO medecin (nom, prenom, cin, specialite, date_embauche, telephone, email) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement pst = conn.prepareStatement(sql)) {

            pst.setString(1, m.getNom());
            pst.setString(2, m.getPrenom());
            pst.setString(3, m.getCin());
            pst.setString(4, m.getSpecialite());
            pst.setString(5, m.getDateEmbauche());
            pst.setString(6, m.getTelephone());
            pst.setString(7, m.getEmail());
            pst.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Supprimer un médecin par CIN
    public void supprimerMedecin(String cin) {
        String sql = "DELETE FROM medecin WHERE cin = ?";
        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement pst = conn.prepareStatement(sql)) {

            pst.setString(1, cin);
            pst.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

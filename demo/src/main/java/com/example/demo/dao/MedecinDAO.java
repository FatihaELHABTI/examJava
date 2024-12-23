package com.example.demo.dao;

import com.example.demo.config.SingletonConnexionDB;
import com.example.demo.models.Medecin;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MedecinDAO {

    private Connection connection;

    public MedecinDAO() {
        connection = SingletonConnexionDB.getConnexion();
    }

    // Ajouter un médecin
    public void ajouterMedecin(Medecin medecin) throws SQLException {
        String sql = "INSERT INTO medecins (nom, prenom, email, tel) VALUES (?, ?, ?, ?)";
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setString(1, medecin.getNom());
        stmt.setString(2, medecin.getPrenom());
        stmt.setString(3, medecin.getEmail());
        stmt.setString(4, medecin.getTel());
        stmt.executeUpdate();
    }

    // Supprimer un médecin
    public void supprimerMedecin(int idMedecin) throws SQLException {
        String sql = "DELETE FROM medecins WHERE id_medecin = ?";
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setInt(1, idMedecin);
        stmt.executeUpdate();
    }

    // Lister tous les médecins
    public List<Medecin> listerMedecins() throws SQLException {
        List<Medecin> medecins = new ArrayList<>();
        String sql = "SELECT * FROM medecins";
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery(sql);

        while (rs.next()) {
            Medecin medecin = new Medecin(
                    rs.getInt("id_medecin"),
                    rs.getString("nom"),
                    rs.getString("prenom"),
                    rs.getString("email"),
                    rs.getString("tel")
            );
            medecins.add(medecin);
        }
        return medecins;
    }
}


package com.example.demo.dao;

import com.example.demo.config.SingletonConnexionDB;
import com.example.demo.models.Patient;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PatientDAO {

    private Connection connection;

    public PatientDAO() {
        connection = SingletonConnexionDB.getConnexion();
    }

    // Ajouter un patient
    public void ajouterPatient(Patient patient) throws SQLException {
        String sql = "INSERT INTO patients (nom, prenom, cin, telephone, email, date_naissance) VALUES (?, ?, ?, ?, ?, ?)";
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setString(1, patient.getNom());
        stmt.setString(2, patient.getPrenom());
        stmt.setString(3, patient.getCin());
        stmt.setString(4, patient.getTelephone());
        stmt.setString(5, patient.getEmail());
        stmt.setDate(6, java.sql.Date.valueOf(patient.getDateNaissance()));
        stmt.executeUpdate();
    }

    // Supprimer un patient
    public void supprimerPatient(int idPatient) throws SQLException {
        String sql = "DELETE FROM patients WHERE id_patient = ?";
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setInt(1, idPatient);
        stmt.executeUpdate();
    }

    // Lister tous les patients
    public List<Patient> listerPatients() throws SQLException {
        List<Patient> patients = new ArrayList<>();
        String sql = "SELECT * FROM patients";
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery(sql);

        while (rs.next()) {
            Patient patient = new Patient(
                    rs.getInt("id_patient"),
                    rs.getString("nom"),
                    rs.getString("prenom"),
                    rs.getString("cin"),
                    rs.getString("telephone"),
                    rs.getString("email"),
                    rs.getDate("date_naissance").toLocalDate()
            );
            patients.add(patient);
        }
        return patients;
    }

    // Rechercher un patient par mot clé
    public List<Patient> rechercherPatients(String motCle) throws SQLException {
        List<Patient> patients = new ArrayList<>();
        String sql = "SELECT * FROM patients WHERE nom LIKE ? OR prenom LIKE ? OR cin LIKE ?";
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setString(1, "%" + motCle + "%");
        stmt.setString(2, "%" + motCle + "%");
        stmt.setString(3, "%" + motCle + "%");
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            Patient patient = new Patient(
                    rs.getInt("id_patient"),
                    rs.getString("nom"),
                    rs.getString("prenom"),
                    rs.getString("cin"),
                    rs.getString("telephone"),
                    rs.getString("email"),
                    rs.getDate("date_naissance").toLocalDate()
            );
            patients.add(patient);
        }
        return patients;
    }
}


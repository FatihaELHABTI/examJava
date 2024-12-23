package com.example.demo.dao;

import com.example.demo.config.SingletonConnexionDB;
import com.example.demo.models.Consultation;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ConsultationDAO {

    private Connection connection;

    public ConsultationDAO() {
        connection = SingletonConnexionDB.getConnexion();
    }

    // Ajouter une consultation
    public void ajouterConsultation(Consultation consultation) throws SQLException {
        String sql = "INSERT INTO consultations (id_patient, id_medecin, date_consultation) VALUES (?, ?, ?)";
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setInt(1, consultation.getIdPatient());
        stmt.setInt(2, consultation.getIdMedecin());
        stmt.setDate(3, java.sql.Date.valueOf(consultation.getDateConsultation()));
        stmt.executeUpdate();
    }

    // Supprimer une consultation
    public void supprimerConsultation(int idConsultation) throws SQLException {
        String sql = "DELETE FROM consultations WHERE id_consultation = ?";
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setInt(1, idConsultation);
        stmt.executeUpdate();
    }

    // Lister les consultations
    public List<Consultation> listerConsultations() throws SQLException {
        List<Consultation> consultations = new ArrayList<>();
        String sql = "SELECT * FROM consultations";
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery(sql);

        while (rs.next()) {
            Consultation consultation = new Consultation(
                    rs.getInt("id_consultation"),
                    rs.getInt("id_patient"),
                    rs.getInt("id_medecin"),
                    rs.getDate("date_consultation").toLocalDate()
            );
            consultations.add(consultation);
        }
        return consultations;
    }
    // Obtenir les consultations par ID Patient
    public List<Consultation> getConsultationsByPatientId(int idPatient) throws SQLException {
        List<Consultation> consultations = new ArrayList<>();
        String sql = "SELECT * FROM consultations WHERE id_patient = ?";

        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setInt(1, idPatient);

        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            Consultation consultation = new Consultation(
                    rs.getInt("id_consultation"),
                    rs.getInt("id_patient"),
                    rs.getInt("id_medecin"),
                    rs.getDate("date_consultation").toLocalDate()
            );
            consultations.add(consultation);
        }

        return consultations;
    }
    // Obtenir les consultations par ID Médecin
    public List<Consultation> getConsultationsByMedecinId(int idMedecin) throws SQLException {
        List<Consultation> consultations = new ArrayList<>();
        String sql = "SELECT * FROM consultations WHERE id_medecin = ?";

        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setInt(1, idMedecin);

        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            Consultation consultation = new Consultation(
                    rs.getInt("id_consultation"),
                    rs.getInt("id_patient"),
                    rs.getInt("id_medecin"),
                    rs.getDate("date_consultation").toLocalDate()
            );
            consultations.add(consultation);
        }

        return consultations;
    }
}

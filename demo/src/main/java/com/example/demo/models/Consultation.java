package com.example.demo.models;

import java.time.LocalDate;
import java.time.LocalTime;

public class Consultation {
    private int idConsultation;
    private int idPatient;
    private int idMedecin;
    private LocalDate dateConsultation;
    

    // Constructeur complet
    public Consultation(int idConsultation, int idPatient, int idMedecin, 
                        LocalDate dateConsultation) {
        this.idConsultation = idConsultation;
        this.idPatient = idPatient;
        this.idMedecin = idMedecin;
        this.dateConsultation = dateConsultation;
        
    }

    // Constructeur sans idConsultation (pour création automatique)
    public Consultation(LocalDate dateConsultation, 
                        int idPatient, int idMedecin) {
        this.dateConsultation = dateConsultation;
        this.idPatient = idPatient;
        this.idMedecin = idMedecin;
    }

    // Constructeur minimal avec seulement les IDs du patient et du médecin
    public Consultation(int idPatient, int idMedecin) {
        this.idPatient = idPatient;
        this.idMedecin = idMedecin;
        this.dateConsultation = LocalDate.now(); // Date par défaut
    }

    // Getters et Setters
    public int getIdConsultation() {
        return idConsultation;
    }

    public void setIdConsultation(int idConsultation) {
        this.idConsultation = idConsultation;
    }

    public int getIdPatient() {
        return idPatient;
    }

    public void setIdPatient(int idPatient) {
        this.idPatient = idPatient;
    }

    public int getIdMedecin() {
        return idMedecin;
    }

    public void setIdMedecin(int idMedecin) {
        this.idMedecin = idMedecin;
    }

    public LocalDate getDateConsultation() {
        return dateConsultation;
    }

    public void setDateConsultation(LocalDate dateConsultation) {
        this.dateConsultation = dateConsultation;
    }

        // Méthode toString mise à jour
    @Override
    public String toString() {
        return "Consultation{" +
                "idConsultation=" + idConsultation +
                ", idPatient=" + idPatient +
                ", idMedecin=" + idMedecin +
                '}';
    }
}

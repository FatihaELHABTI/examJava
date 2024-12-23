package com.example.demo.models;

import java.time.LocalDate;
import java.time.LocalTime;

public class Consultation {
    private int idConsultation;
    private int idPatient;
    private int idMedecin;
    private LocalDate dateConsultation;
    private LocalTime heureConsultation;
    private String motifConsultation;
    private String observations;

    // Constructeur complet
    public Consultation(int idConsultation, int idPatient, int idMedecin, 
                        LocalDate dateConsultation, LocalTime heureConsultation, 
                        String motifConsultation, String observations) {
        this.idConsultation = idConsultation;
        this.idPatient = idPatient;
        this.idMedecin = idMedecin;
        this.dateConsultation = dateConsultation;
        this.heureConsultation = heureConsultation;
        this.motifConsultation = motifConsultation;
        this.observations = observations;
    }

    // Constructeur sans idConsultation
    public Consultation(LocalDate dateConsultation, LocalTime heureConsultation, 
                        String motifConsultation, String observations, 
                        int idPatient, int idMedecin) {
        this.dateConsultation = dateConsultation;
        this.heureConsultation = heureConsultation;
        this.motifConsultation = motifConsultation;
        this.observations = observations;
        this.idPatient = idPatient;
        this.idMedecin = idMedecin;
    }

    public Consultation(int idPatient, int idMedecin) {
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

    public LocalTime getHeureConsultation() {
        return heureConsultation;
    }

    public void setHeureConsultation(LocalTime heureConsultation) {
        this.heureConsultation = heureConsultation;
    }

    public String getMotifConsultation() {
        return motifConsultation;
    }

    public void setMotifConsultation(String motifConsultation) {
        this.motifConsultation = motifConsultation;
    }

    public String getObservations() {
        return observations;
    }

    public void setObservations(String observations) {
        this.observations = observations;
    }

    // Méthode toString mise à jour
    @Override
    public String toString() {
        return "Consultation{" +
                "idConsultation=" + idConsultation +
                ", idPatient=" + idPatient +
                ", idMedecin=" + idMedecin +
                ", dateConsultation=" + dateConsultation +
                ", heureConsultation=" + heureConsultation +
                ", motifConsultation='" + motifConsultation + '\'' +
                ", observations='" + observations + '\'' +
                '}';
    }
}

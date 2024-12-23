package com.example.demo.dao;

import com.example.demo.models.Consultation;
import com.example.demo.models.Medecin;
import com.example.demo.models.Patient;

import java.util.List;

public interface ICabinetMetier {

    // Gestion des patients
    void ajouterPatient(Patient patient);
    void supprimerPatient(int idPatient);
    List<Patient> listerPatients();
    List<Patient> rechercherPatients(String motCle);
    List<Consultation> afficherConsultationsPatient(int idPatient);

    // Gestion des médecins
    void ajouterMedecin(Medecin medecin);
    void supprimerMedecin(int idMedecin);
    List<Medecin> listerMedecins();
    List<Consultation> afficherConsultationsMedecin(int idMedecin);

    // Gestion des consultations
    void ajouterConsultation(Consultation consultation);
    void supprimerConsultation(int idConsultation);
    List<Consultation> listerConsultations();
}

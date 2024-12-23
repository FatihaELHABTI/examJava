package com.example.demo.application;

import com.example.demo.dao.CabinetMetierImpl;
import com.example.demo.models.Consultation;
import com.example.demo.models.Medecin;
import com.example.demo.models.Patient;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // Créer une instance de CabinetMetierImpl
        CabinetMetierImpl cabinetMetier = new CabinetMetierImpl();

        // Tester l'ajout de patients
        System.out.println("--- Test : Ajout de Patients ---");
        Patient patient1 = new Patient("Dupont", "Jean", "AB12345", "0612345678", "jean.dupont@email.com", LocalDate.of(1980, 5, 15));
        Patient patient2 = new Patient("Martin", "Sophie", "CD67890", "0687654321", "sophie.martin@email.com", LocalDate.of(1990, 8, 20));
        
        cabinetMetier.ajouterPatient(patient1);
        cabinetMetier.ajouterPatient(patient2);

        // Tester la liste des patients
        System.out.println("\n--- Test : Liste des Patients ---");
        List<Patient> patients = cabinetMetier.listerPatients();
        patients.forEach(patient -> System.out.println(patient.getNom() + " " + patient.getPrenom()));

        // Tester la recherche de patients
        System.out.println("\n--- Test : Recherche de Patients ---");
        List<Patient> recherchePatients = cabinetMetier.rechercherPatients("Dupont");
        recherchePatients.forEach(patient -> System.out.println(patient.getNom() + " " + patient.getPrenom()));

        // Tester l'ajout de médecins
        System.out.println("\n--- Test : Ajout de Médecins ---");
        Medecin medecin1 = new Medecin("Dr. Leroy", "Pierre", "pierre.leroy@cabinet.com", "0123456789");
        Medecin medecin2 = new Medecin("Dr. Dubois", "Marie", "marie.dubois@cabinet.com", "0987654321");
        
        cabinetMetier.ajouterMedecin(medecin1);
        cabinetMetier.ajouterMedecin(medecin2);

        // Tester la liste des médecins
        System.out.println("\n--- Test : Liste des Médecins ---");
        List<Medecin> medecins = cabinetMetier.listerMedecins();
        medecins.forEach(medecin -> System.out.println(medecin.getNom() + " " + medecin.getPrenom()));

        // Tester l'ajout de consultations
        System.out.println("\n--- Test : Ajout de Consultations ---");
        // Supposons que les patients et médecins ont été ajoutés avec des ID auto-générés
        Consultation consultation1 = new Consultation(1, 1, LocalDate.now(), LocalTime.now(), "Consultation de routine", "RAS");
        Consultation consultation2 = new Consultation(2, 2, LocalDate.now(), LocalTime.now(), "Suivi médical", "Prescription de tests");
        
        cabinetMetier.ajouterConsultation(consultation1);
        cabinetMetier.ajouterConsultation(consultation2);

        // Tester la liste des consultations
        System.out.println("\n--- Test : Liste des Consultations ---");
        List<Consultation> consultations = cabinetMetier.listerConsultations();
        consultations.forEach(consultation -> System.out.println("Consultation pour patient ID: " + consultation.getIdPatient() 
                + ", Médecin ID: " + consultation.getIdMedecin()));

        // Tester l'affichage des consultations d'un patient
        System.out.println("\n--- Test : Consultations d'un Patient ---");
        List<Consultation> consultationsPatient = cabinetMetier.afficherConsultationsPatient(1);
        consultationsPatient.forEach(consultation -> System.out.println("Date: " + consultation.getDateConsultation() 
                + ", Observations: " + consultation.getObservations()));

        // Tester l'affichage des consultations d'un médecin
        System.out.println("\n--- Test : Consultations d'un Médecin ---");
        List<Consultation> consultationsMedecin = cabinetMetier.afficherConsultationsMedecin(1);
        consultationsMedecin.forEach(consultation -> System.out.println("Date: " + consultation.getDateConsultation() 
                + ", Observations: " + consultation.getObservations()));

        // Test de suppression (optionnel)
        System.out.println("\n--- Test : Suppression ---");
        cabinetMetier.supprimerConsultation(1);
        cabinetMetier.supprimerPatient(2);
        cabinetMetier.supprimerMedecin(2);
    }
}

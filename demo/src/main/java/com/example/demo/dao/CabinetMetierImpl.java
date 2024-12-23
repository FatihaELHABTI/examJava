package com.example.demo.dao;

import com.example.demo.models.Consultation;
import com.example.demo.models.Medecin;
import com.example.demo.models.Patient;

import java.util.List;

// Implémentation de l'interface ICabinetMetier
public class CabinetMetierImpl implements ICabinetMetier {

    private PatientDAO patientDAO;
    private MedecinDAO medecinDAO;
    private ConsultationDAO consultationDAO;

    // Constructeur
    public CabinetMetierImpl() {
        patientDAO = new PatientDAO();
        medecinDAO = new MedecinDAO();
        consultationDAO = new ConsultationDAO();
    }

    @Override
    public void ajouterPatient(Patient patient) {
        try {
            patientDAO.ajouterPatient(patient);
            System.out.println("Patient ajouté avec succès !");
        } catch (Exception e) {
            System.err.println("Erreur lors de l'ajout du patient : " + e.getMessage());
        }
    }

    @Override
    public void supprimerPatient(int idPatient) {
        try {
            patientDAO.supprimerPatient(idPatient);
            System.out.println("Patient supprimé avec succès !");
        } catch (Exception e) {
            System.err.println("Erreur lors de la suppression du patient : " + e.getMessage());
        }
    }

    @Override
    public List<Patient> listerPatients() {
        try {
            return patientDAO.listerPatients();
        } catch (Exception e) {
            System.err.println("Erreur lors du listage des patients : " + e.getMessage());
            return null;
        }
    }

    @Override
    public List<Patient> rechercherPatients(String motCle) {
        try {
            return patientDAO.rechercherPatients(motCle);
        } catch (Exception e) {
            System.err.println("Erreur lors de la recherche de patients : " + e.getMessage());
            return null;
        }
    }

    @Override
    public List<Consultation> afficherConsultationsPatient(int idPatient) {
        try {
            return consultationDAO.getConsultationsByPatientId(idPatient);
        } catch (Exception e) {
            System.err.println("Erreur lors de l'affichage des consultations du patient : " + e.getMessage());
            return null;
        }
    }

    @Override
    public void ajouterMedecin(Medecin medecin) {
        try {
            medecinDAO.ajouterMedecin(medecin);
            System.out.println("Médecin ajouté avec succès !");
        } catch (Exception e) {
            System.err.println("Erreur lors de l'ajout du médecin : " + e.getMessage());
        }
    }

    @Override
    public void supprimerMedecin(int idMedecin) {
        try {
            medecinDAO.supprimerMedecin(idMedecin);
            System.out.println("Médecin supprimé avec succès !");
        } catch (Exception e) {
            System.err.println("Erreur lors de la suppression du médecin : " + e.getMessage());
        }
    }

    @Override
    public List<Medecin> listerMedecins() {
        try {
            return medecinDAO.listerMedecins();
        } catch (Exception e) {
            System.err.println("Erreur lors du listage des médecins : " + e.getMessage());
            return null;
        }
    }

    @Override
    public List<Consultation> afficherConsultationsMedecin(int idMedecin) {
        try {
            return consultationDAO.getConsultationsByMedecinId(idMedecin);
        } catch (Exception e) {
            System.err.println("Erreur lors de l'affichage des consultations du médecin : " + e.getMessage());
            return null;
        }
    }


    @Override
    public void ajouterConsultation(Consultation consultation) {
        try {
            consultationDAO.ajouterConsultation(consultation);
            System.out.println("Consultation ajoutée avec succès !");
        } catch (Exception e) {
            System.err.println("Erreur lors de l'ajout de la consultation : " + e.getMessage());
        }
    }

    @Override
    public void supprimerConsultation(int idConsultation) {
        try {
            consultationDAO.supprimerConsultation(idConsultation);
            System.out.println("Consultation supprimée avec succès !");
        } catch (Exception e) {
            System.err.println("Erreur lors de la suppression de la consultation : " + e.getMessage());
        }
    }

    @Override
    public List<Consultation> listerConsultations() {
        try {
            return consultationDAO.listerConsultations();
        } catch (Exception e) {
            System.err.println("Erreur lors du listage des consultations : " + e.getMessage());
            return null;
        }
    }
}

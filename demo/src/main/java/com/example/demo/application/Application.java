package com.example.demo.application;

import com.example.demo.models.Consultation;
import com.example.demo.models.Medecin;
import com.example.demo.models.Patient;
import com.example.demo.dao.CabinetMetierImpl;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CabinetMetierImpl cabinetMetier = new CabinetMetierImpl();

        while (true) {
            System.out.println("===== MENU =====");
            System.out.println("1. Ajouter un patient");
            System.out.println("2. Lister les patients");
            System.out.println("3. Rechercher un patient");
            System.out.println("4. Ajouter un médecin");
            System.out.println("5. Lister les médecins");
            System.out.println("6. Ajouter une consultation");
            System.out.println("7. Lister les consultations");
            System.out.println("8. Quitter");
            System.out.print("Choisissez une option : ");

            int choix = scanner.nextInt();
            scanner.nextLine();  // Pour capturer le '\n' après le nombre

            switch (choix) {
                case 1:
                    // Ajouter un patient
                    System.out.print("Nom du patient : ");
                    String nomPatient = scanner.nextLine();
                    System.out.print("Prénom du patient : ");
                    String prenomPatient = scanner.nextLine();
                    System.out.print("CIN du patient : ");
                    String cinPatient = scanner.nextLine();
                    System.out.print("Téléphone du patient : ");
                    String telPatient = scanner.nextLine();
                    System.out.print("Email du patient : ");
                    String emailPatient = scanner.nextLine();
                    System.out.print("Date de naissance du patient (YYYY-MM-DD) : ");
                    String dateNaissanceStr = scanner.nextLine();

                    // Convertir la chaîne en LocalDate
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                    LocalDate dateNaissance = LocalDate.parse(dateNaissanceStr, formatter);


                    Patient patient = new Patient(nomPatient, prenomPatient, cinPatient, telPatient, emailPatient, dateNaissance);
                    cabinetMetier.ajouterPatient(patient);
                    break;

                case 2:
                    // Lister les patients
                    List<Patient> patients = cabinetMetier.listerPatients();
                    if (patients != null && !patients.isEmpty()) {
                        patients.forEach(p -> System.out.println(p.getNom() + " " + p.getPrenom()));
                    } else {
                        System.out.println("Aucun patient trouvé.");
                    }
                    break;

                case 3:
                    // Rechercher un patient
                    System.out.print("Entrez un mot-clé pour rechercher un patient : ");
                    String motCle = scanner.nextLine();
                    List<Patient> patientsTrouves = cabinetMetier.rechercherPatients(motCle);
                    if (patientsTrouves != null && !patientsTrouves.isEmpty()) {
                        patientsTrouves.forEach(p -> System.out.println(p.getNom() + " " + p.getPrenom()));
                    } else {
                        System.out.println("Aucun patient trouvé pour le mot-clé : " + motCle);
                    }
                    break;

                case 4:
                    // Ajouter un médecin
                    System.out.print("Nom du médecin : ");
                    String nomMedecin = scanner.nextLine();
                    System.out.print("Prénom du médecin : ");
                    String prenomMedecin = scanner.nextLine();
                    System.out.print("Email du médecin : ");
                    String emailMedecin = scanner.nextLine();
                    System.out.print("Téléphone du médecin : ");
                    String telMedecin = scanner.nextLine();

                    Medecin medecin = new Medecin(nomMedecin, prenomMedecin, emailMedecin, telMedecin);
                    cabinetMetier.ajouterMedecin(medecin);
                    break;

                case 5:
                    // Lister les médecins
                    List<Medecin> medecins = cabinetMetier.listerMedecins();
                    if (medecins != null && !medecins.isEmpty()) {
                        medecins.forEach(m -> System.out.println(m.getNom() + " " + m.getPrenom()));
                    } else {
                        System.out.println("Aucun médecin trouvé.");
                    }
                    break;

                case 6:
                    // Ajouter une consultation
                    System.out.print("ID du patient pour la consultation : ");
                    int idPatient = scanner.nextInt();
                    System.out.print("ID du médecin pour la consultation : ");
                    int idMedecin = scanner.nextInt();
                    scanner.nextLine(); // Pour capturer le '\n' après les nombres

                    Consultation consultation = new Consultation(idPatient, idMedecin);
                    cabinetMetier.ajouterConsultation(consultation);
                    break;

                case 7:
                    // Lister les consultations
                    List<Consultation> consultations = cabinetMetier.listerConsultations();
                    if (consultations != null && !consultations.isEmpty()) {
                        consultations.forEach(c -> System.out.println("Consultation ID : " + c.getIdConsultation()));
                    } else {
                        System.out.println("Aucune consultation trouvée.");
                    }
                    break;

                case 8:
                    // Quitter
                    System.out.println("Au revoir !");
                    return;

                default:
                    System.out.println("Option invalide. Veuillez réessayer.");
            }
        }
    }
}

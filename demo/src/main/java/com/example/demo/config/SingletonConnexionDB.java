package com.example.demo.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SingletonConnexionDB {

    // Instance unique de la connexion
    private static Connection connection;

    // Paramètres de connexion
    private static final String URL = "jdbc:mysql://localhost:3306/medical_cabinet_db";
    private static final String USER = "root";
    private static final String PASSWORD = "7OCTober2023*";

    // Constructeur privé pour empêcher l'instanciation externe
    private SingletonConnexionDB() {
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Connexion à la base de données établie avec succès !");
        } catch (SQLException e) {
            System.err.println("Erreur lors de la connexion à la base de données : " + e.getMessage());
        }
    }

    // Méthode publique pour obtenir l'instance unique de la connexion
    public static Connection getConnexion() {
        if (connection == null) {
            synchronized (SingletonConnexionDB.class) { // Synchronisation pour les accès concurrents
                if (connection == null) { // Double vérification pour éviter des connexions multiples
                    new SingletonConnexionDB();
                }
            }
        }
        return connection;
    }
}

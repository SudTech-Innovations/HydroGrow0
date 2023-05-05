package com.vinckier.hydrogrow_v2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseManager {
    private static Connection conn = null;

    public static Connection getConnection() {
        // Vérifier si une connexion existe déjà
        if (conn != null) {
            return conn;
        }

        // Connexion à la base de données
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hydrobase", "hydrouser", "hydropwd");
            System.out.println("Connexion réussie !");
        } catch (SQLException e) {
            System.err.println("Erreur lors de la connexion à la base de données : " + e.getMessage());
        }

        return conn;
    }
}

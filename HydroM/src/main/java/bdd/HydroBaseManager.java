package bdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class HydroBaseManager {

    private Connection connection;
    private Statement statement;
    private String databaseName = "HydroBase";
    private String username = "root";
    private String password = "";
    private String url = "jdbc:mysql://localhost/" + databaseName;

    public HydroBaseManager() {
        try {
            // Charger le pilote JDBC
            Class.forName("com.mysql.jdbc.Driver");

            // Créer une connexion JDBC à la base de données
            connection = DriverManager.getConnection(url, username, password);

            // Créer une instance de Statement
            statement = connection.createStatement();

            // Vérifier si la base de données existe déjà
            ResultSet resultSet = statement.executeQuery("SHOW DATABASES LIKE '" + databaseName + "'");
            boolean databaseExists = resultSet.next();

            if (databaseExists) {
                // Se connecter à la base de données existante
                System.out.println("La base de données existe déjà. Connexion en cours...");
                connection = DriverManager.getConnection(url, username, password);
                System.out.println("Connexion à la base de données réussie.");
            } else {
                // Créer une nouvelle base de données
                statement.executeUpdate("CREATE DATABASE " + databaseName);
                System.out.println("La base de données a été créée avec succès.");

                // Se connecter à la nouvelle base de données
                connection = DriverManager.getConnection(url, username, password);
                System.out.println("Connexion à la base de données réussie.");
            }

        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Erreur lors de la connexion à la base de données : " + e.getMessage());
            e.printStackTrace();
        }
    }
}

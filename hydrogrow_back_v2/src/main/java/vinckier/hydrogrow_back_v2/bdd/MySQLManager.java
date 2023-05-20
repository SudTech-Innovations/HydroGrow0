package vinckier.hydrogrow_back_v2.bdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Cette classe est une classe utilitaire pour gérer la connexion à une base de
 * données MySQL.
 */
public class MySQLManager {

    /**
     * L'instance de connexion à la base de données MySQL.
     */
    public static Connection connection;

    /**
     * L'instance de statement pour exécuter des requêtes SQL.
     */
    public Statement statement;

    /**
     * Le nom de la base de données MySQL.
     */
    public String databaseName = "hydrobase";

    /**
     * Le nom d'utilisateur MySQL.
     */
    public String username = "hydrouser";

    /**
     * Le mot de passe MySQL.
     */
    public String password = "hydropwd";

    /**
     * L'URL de connexion à la base de données MySQL.
     */
    public String url = "jdbc:mysql://localhost/" + databaseName;

    /**
     * Le constructeur MySQLManager crée une connexion à la base de données MySQL.
     *
     * @throws SQLException si une erreur survient lors de la tentative de
     *                      connexion.
     */
    public MySQLManager() throws SQLException {
        connection = DriverManager.getConnection(url, username, password);
        System.out.println("Connexion à la base de données réussie.");
    }

    /**
     * Ferme la connexion à la base de données MySQL.
     *
     * @throws SQLException si une erreur survient lors de la tentative de
     *                      fermeture.
     */
    public void close() throws SQLException {
        connection.close();
        System.out.println("Connexion à la base de données fermée.");
    }

    /**
     * Obtient l'instance de connexion à la base de données MySQL.
     *
     * @return l'instance de connexion à la base de données MySQL.
     */
    public static Connection getConnection() {
        return connection;
    }

}
package bdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Si la création de la base de donnée ne marche pas
 * allez dans votre phpmyadmin - SQL
 * Executé la commande suivante :
 * CREATE DATABASE hydrobase;
 */
public class HydroBaseManager {

    public Connection connection;
    public Statement statement;
    public String databaseName = "hydrobase";
    public String username = "root";
    public String password = "";
    public String url = "jdbc:mysql://localhost/" + databaseName;

    public HydroBaseManager() throws SQLException {
        connection = DriverManager.getConnection(url, username, password);
        System.out.println("Connexion à la base de données réussie.");
        // ------------------------------------------------------------- //

        HydroTablePlante HydroTable = new HydroTablePlante(connection);
        System.out.println(HydroTable);
    }

    public void close() throws SQLException {
        connection.close();
        System.out.println("Connexion à la base de données fermée.");
    }

}

package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnexionMySQL {

    private static Connection connection;

    public static Connection getConnection() throws SQLException {
        if (connection == null) {
            String url = "jdbc:mysql://localhost:3306/nom_de_votre_base_de_donnees";
            String user = "votre_utilisateur";
            String password = "votre_mot_de_passe";
            connection = DriverManager.getConnection(url, user, password);
        }
        return connection;
    }
}

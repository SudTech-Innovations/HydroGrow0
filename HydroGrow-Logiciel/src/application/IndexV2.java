package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import dao.PlanteDAOImpl;

public class IndexV2 {
    public static void main(String[] args) throws SQLException {
        // Connexion à la base de données
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/plantes?serverTimezone=UTC",
                "root", "");

        // Création d'un objet PlanteDAOImpl pour accéder à la base de données
        PlanteDAOImpl planteDAO = new PlanteDAOImpl(connection);

        // Affichage de toutes les plantes dans la console
        List<Plante> plantes = planteDAO.getAllPlantes();
        for (Plante plante : plantes) {
            System.out.println(plante.getNom() + ", " + plante.getHumiditeRecommandee() + ", "
                    + plante.getTemperatureRecommandee());
        }

        // Fermeture de la connexion à la base de données
        connection.close();
    }
}

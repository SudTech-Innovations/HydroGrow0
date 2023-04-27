package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import application.*;

public class PlanteDAOImpl implements PlanteDAO {

    private Connection connection;

    public PlanteDAOImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Plante getPlanteById(int id) throws SQLException {
        String query = "SELECT * FROM plantes WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    String nom = resultSet.getString("nom");
                    double humidite = resultSet.getDouble("humidite");
                    double temperature = resultSet.getDouble("temperature");
                    return new Plante(nom, humidite, temperature);
                } else {
                    return null;
                }
            }
        }
    }

    @Override
    public List<Plante> getAllPlantes() throws SQLException {
        String query = "SELECT * FROM plantes";
        try (PreparedStatement statement = connection.prepareStatement(query);
                ResultSet resultSet = statement.executeQuery()) {
            List<Plante> plantes = new ArrayList<>();
            while (resultSet.next()) {
                String nom = resultSet.getString("nom");
                double humidite = resultSet.getDouble("humidite");
                double temperature = resultSet.getDouble("temperature");
                plantes.add(new Plante(nom, humidite, temperature));
            }
            return plantes;
        }
    }

    @Override
    public void addPlante(Plante plante) throws SQLException {
        String query = "INSERT INTO plantes (nom, humidite, temperature) VALUES (?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, plante.getNom());
            statement.setDouble(2, plante.getHumiditeRecommandee());
            statement.setDouble(3, plante.getTemperatureRecommandee());
            statement.executeUpdate();
        }
    }

    @Override
    public void updatePlante(Plante plante) throws SQLException {
        throw new UnsupportedOperationException("Unimplemented method 'updatePlante'");
    }

    @Override
    public void deletePlante(Plante plante) throws SQLException {
        throw new UnsupportedOperationException("Unimplemented method 'deletePlante'");
    }
}
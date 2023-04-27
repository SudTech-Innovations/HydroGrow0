package dao;

import java.sql.SQLException;
import java.util.List;

import application.Plante;

public interface PlanteDAO {

    Plante getPlanteById(int id) throws SQLException;

    List<Plante> getAllPlantes() throws SQLException;

    void addPlante(Plante plante) throws SQLException;

    void updatePlante(Plante plante) throws SQLException;

    void deletePlante(Plante plante) throws SQLException;
}

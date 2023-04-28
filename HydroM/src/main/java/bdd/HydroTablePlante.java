package bdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class HydroTablePlante {

    public Connection connection;
    public Statement statement;
    public String databaseName = "hydrobase";
    public String username = "root";
    public String password = "";
    public String url = "jdbc:mysql://localhost/" + databaseName;

    public HydroTablePlante() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String sql = "CREATE TABLE IF NOT EXISTS plante (nom VARCHAR(255), temperature VARCHAR(255), humidite VARCHAR(255))";
            Connection connexionBase = DriverManager.getConnection(url, username, password);
            Statement stmt = connexionBase.createStatement();
            stmt.execute(sql);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

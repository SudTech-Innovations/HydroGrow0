package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnexionMySQL {

    private static Connection connection;

    public static Connection getConnection() throws SQLException {
        if (connection == null) {
            String url = "jdbc:mysql://localhost:3306/plantes";
            String user = "root";
            String password = "";
            connection = DriverManager.getConnection(url, user, password);
        }
        return connection;
    }
}

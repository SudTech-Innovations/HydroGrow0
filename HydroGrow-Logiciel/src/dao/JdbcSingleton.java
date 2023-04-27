package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcSingleton {
    private final static String URL = "jdbc:mysql://localhost/plantes";
    private final static String DRIVER = "com.mysql.cj.jdbc.Driver";
    private final static String USER = "root";
    private final static String PWD = "";

    public Connection connection = null;

    private final static JdbcSingleton INSTANCE = new JdbcSingleton();

    private JdbcSingleton() {

    }

    public static JdbcSingleton getInstance() {
        return INSTANCE;
    }

    public Connection getConnection() {
        if (connection == null) {
            try {
                Class.forName(DRIVER);
                // connection = DriverManager.getConnection(URL, USER, PWD);

                connection = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/plantes?serverTimezone=UTC",
                        "root", "");
                System.out.println("Connexion ouverte.");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }

    public void close() {
        if (connection != null) {
            try {
                connection.close();
                System.out.println("Connexion close.");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}

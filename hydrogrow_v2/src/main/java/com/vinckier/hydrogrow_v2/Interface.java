package com.vinckier.hydrogrow_v2;

import java.awt.BorderLayout;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Interface extends JFrame {

    private JPanel contentPane;
    private JComboBox<String> plantesComboBox;

    public Interface() {
        super("HydroGrow Interface");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 400);

        init();
        setVisible(true);
    }

    private void init() {
        contentPane = new JPanel();
        getContentPane().add(contentPane, BorderLayout.CENTER);

        plantesComboBox = new JComboBox<String>();
        contentPane.add(plantesComboBox);

        try (Connection conn = DatabaseManager.getConnection()) {
            String query = "SELECT nom FROM plante";
            PreparedStatement statement = conn.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                plantesComboBox.addItem(resultSet.getString("nom"));
            }
        } catch (SQLException e) {
            System.err.println("Erreur lors de la récupération des plantes : " + e.getMessage());
        }
    }
}
package com.vinckier.hydrogrow_v2;

import java.awt.BorderLayout;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;

public class Interface extends JFrame {

    public JPanel contentPane;
    public JComboBox<String> plantesComboBox;

    public Interface() {
        super("HydroGrow Interface");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 400);

        init();
        setVisible(true);
    }

    // private void init() {
    // contentPane = new JPanel(new BorderLayout());
    // getContentPane().add(contentPane, BorderLayout.CENTER);

    // try (Connection conn = DatabaseManager.getConnection()) {
    // String query = "SELECT nom FROM plante";
    // PreparedStatement statement = conn.prepareStatement(query);
    // ResultSet resultSet = statement.executeQuery();
    // while (resultSet.next()) {
    // JCheckBox planteCheckBox = new JCheckBox(resultSet.getString("nom"));
    // contentPane.add(planteCheckBox);
    // }
    // } catch (SQLException e) {
    // System.err.println("Erreur lors de la récupération des plantes : " +
    // e.getMessage());
    // }
    // }

    private void init() {
        contentPane = new JPanel(new BorderLayout());
        getContentPane().add(contentPane, BorderLayout.CENTER);

        try (Connection conn = DatabaseManager.getConnection()) {
            String query = "SELECT nom FROM plante";
            PreparedStatement statement = conn.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            DefaultListModel<String> listePlantes = new DefaultListModel<String>();
            while (resultSet.next()) {
                listePlantes.addElement(resultSet.getString("nom"));
            }
            JList<String> liste = new JList<String>(listePlantes);
            contentPane.add(liste);
        } catch (SQLException e) {
            System.err.println("Erreur lors de la récupération des plantes : " + e.getMessage());
        }
    }
}
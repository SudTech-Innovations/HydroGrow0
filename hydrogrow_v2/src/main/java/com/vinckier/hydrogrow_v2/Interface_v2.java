package com.vinckier.hydrogrow_v2;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.*;

public class Interface_v2 extends JFrame {

    public Interface_v2() {
        super("HydroGrow Interface");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);

        init();
        setVisible(true);
    }

    private void init() {
        JTabbedPane onglets = new JTabbedPane();

        // Premier onglet pour un message de bienvenue
        JPanel ongletBienvenue = new JPanel(new BorderLayout());
        JLabel labelBienvenue = new JLabel("Bienvenue sur HydroGrow!");
        ongletBienvenue.add(labelBienvenue, BorderLayout.CENTER);

        // Deuxième onglet pour une analyse de données
        JPanel ongletAnalyse = new JPanel(new BorderLayout());
        JLabel labelAnalyse = new JLabel("Analyse de données");
        ongletAnalyse.add(labelAnalyse, BorderLayout.CENTER);

        // Troisième onglet pour la planification
        JPanel ongletPlanification = new JPanel(new BorderLayout());
        JLabel labelPlanification = new JLabel("Planification");
        ongletPlanification.add(labelPlanification, BorderLayout.CENTER);

        onglets.addTab("Bienvenue", ongletBienvenue);
        onglets.addTab("Analyse de données", ongletAnalyse);
        onglets.addTab("Planification", ongletPlanification);

        getContentPane().add(onglets, BorderLayout.CENTER);
    }
}
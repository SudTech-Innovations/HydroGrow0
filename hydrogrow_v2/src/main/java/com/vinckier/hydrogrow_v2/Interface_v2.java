package com.vinckier.hydrogrow_v2;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import com.vinckier.hydrogrow_v2.onglets.Analyse;
import com.vinckier.hydrogrow_v2.onglets.Planification;

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

        // Deuxième onglet pour l'analyse de données
        Analyse ongletAnalyse = new Analyse();

        // Troisième onglet pour la planification
        Planification ongletPlanification = new Planification();

        onglets.addTab("Bienvenue", ongletBienvenue);
        onglets.addTab("Analyse de données", ongletAnalyse);
        onglets.addTab("Planification", ongletPlanification);

        getContentPane().add(onglets, BorderLayout.CENTER);
    }
}
package com.vinckier.hydrogrow_v2;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * La classe Interface représente l'interface graphique de l'application
 * HydroGrow.
 * Elle permet à l'utilisateur de se connecter à la base de données et
 * d'afficher un message de bienvenue.
 * Elle étend la classe JFrame pour créer une fenêtre.
 */
public class Interface extends JFrame {

    private JPanel buttonPanel;
    private JButton btnConnexion;

    /**
     * Constructeur de la classe Interface.
     * Initialise la fenêtre avec un titre et une taille prédéfinie, puis appelle la
     * méthode init pour initialiser les composants.
     */
    public Interface() {
        // Titre de la fenêtre
        super("HydroGrow Interface");

        // Taille de la fenêtre
        setSize(400, 400);

        // Action lors de la fermeture de la fenêtre
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Initialisation des composants
        init();

        // Affichage de la fenêtre
        setVisible(true);
    }

    /**
     * Initialise les composants de l'interface graphique, tels que le bouton de
     * connexion.
     * Ajoute également des gestionnaires d'événements pour détecter les clics sur
     * le bouton.
     */
    private void init() {
        // Panneau pour le bouton de connexion
        buttonPanel = new JPanel();
        getContentPane().add(buttonPanel, BorderLayout.NORTH);

        // Bouton de connexion
        btnConnexion = new JButton("Se connecter à la base de données");
        btnConnexion.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Connexion à la base de données
                Connection conn = DatabaseManager.getConnection();
                if (conn == null) {
                    JOptionPane.showMessageDialog(Interface.this, "La connexion à la base de données a échoué.",
                            "Erreur", JOptionPane.ERROR_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(Interface.this, "La connexion à la base de données est établie.",
                            "Succès", JOptionPane.INFORMATION_MESSAGE);

                    // Supprimer le bouton de connexion
                    buttonPanel.remove(btnConnexion);

                    // Ajouter un label pour afficher "Hello World"
                    JLabel helloLabel = new JLabel("Hello World !");
                    getContentPane().add(helloLabel, BorderLayout.CENTER);

                    // Mettre à jour l'affichage de la fenêtre
                    revalidate();
                    repaint();
                }
            }
        });
        buttonPanel.add(btnConnexion);

        // Affichage de la fenêtre
        setVisible(true);
    }
}

package com.vinckier.hydrogrow_v2.onglets;

import javax.swing.*;
import java.awt.*;

public class Analyse extends JPanel {

    public Analyse() {
        this.setLayout(new BorderLayout());

        // Ajouter un titre à l'onglet
        JLabel titreOnglet = new JLabel("Analyse de données");
        this.add(titreOnglet, BorderLayout.NORTH);
    }
}
package com.vinckier.hydrogrow_v2.onglets;

import javax.swing.*;
import java.awt.*;

public class Planification extends JPanel {
    public Planification() {
        this.setLayout(new BorderLayout());
        JLabel titreOnglet = new JLabel("Planification");
        this.add(titreOnglet, BorderLayout.NORTH);
    }
}
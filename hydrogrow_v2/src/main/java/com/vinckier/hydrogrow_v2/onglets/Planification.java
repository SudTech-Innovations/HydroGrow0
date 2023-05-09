package com.vinckier.hydrogrow_v2.onglets;

import java.awt.BorderLayout;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.toedter.calendar.JDateChooser;
import com.vinckier.hydrogrow_v2.models.Plante;

public class Planification extends JPanel {

    private JComboBox<Plante> plantesComboBox;
    private JDateChooser dateChooser;

    public Planification(EntityManagerFactory entityManagerFactory) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        TypedQuery<Plante> query = entityManager.createQuery("FROM Plante", Plante.class);
        List<Plante> plantes = query.getResultList();

        plantesComboBox = new JComboBox<Plante>();
        for (Plante plante : plantes) {
            plantesComboBox.addItem(plante);
        }

        dateChooser = new JDateChooser();
        dateChooser.setDateFormatString("yyyy-MM-dd");

        JPanel comboPanel = new JPanel();
        comboPanel.add(new JLabel("Plante: "));
        comboPanel.add(plantesComboBox);
        comboPanel.add(new JLabel("Date de début: "));
        comboPanel.add(dateChooser);

        setLayout(new BorderLayout());
        add(comboPanel, BorderLayout.CENTER);
    }

    public void savePlanification() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("HydroGrowDB");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        Planification planification = new Planification();
        planification.setPlante((Plante) plantesComboBox.getSelectedItem());
        planification.setDateDebut(dateChooser.getDate());

        entityManager.persist(planification);
        entityManager.getTransaction().commit();
        entityManager.close();

        JOptionPane.showMessageDialog(this, "Planification enregistrée !");
    }
}
// package com.vinckier.hydrogrow_v2.onglets;

// import java.awt.event.ActionEvent;
// import java.awt.event.ActionListener;
// import java.text.ParseException;
// import java.text.SimpleDateFormat;
// import java.util.List;

// import javax.persistence.EntityManager;
// import javax.persistence.EntityManagerFactory;
// import javax.persistence.TypedQuery;
// import javax.swing.JButton;
// import javax.swing.JComboBox;
// import javax.swing.JComponent;
// import javax.swing.JPanel;
// import javax.swing.JTextField;

// import com.vinckier.hydrogrow_v2.models.Plante;

// public class Planification extends JPanel {
//     private JComboBox<Plante> plantesComboBox;
//     private JTextField dateField;

//     public Planification(EntityManagerFactory entityManagerFactory) {
//         final EntityManagerFactory emf = entityManagerFactory;
//         EntityManager entityManager;
//         if (getTopLevelAncestor() != null) {
//             EntityManagerFactory em = (EntityManagerFactory) ((JComponent) getTopLevelAncestor())
//                     .getClientProperty("entityManagerFactory");
//             entityManager = em.createEntityManager();
//         } else {
//             entityManager = entityManagerFactory.createEntityManager();
//         }

//         // On récupère toutes les plantes depuis la base de données
//         TypedQuery<Plante> query = entityManager.createQuery("SELECT p FROM Plante p", Plante.class);
//         List<Plante> plantes = query.getResultList();
//         entityManager.close();

//         // On créé la combobox à partir de la liste de plantes
//         plantesComboBox = new JComboBox<>(plantes.toArray(new Plante[0]));
//         add(plantesComboBox);

//         // On crée un champ pour saisir la date
//         dateField = new JTextField(10);
//         add(dateField);

//         // On créé le bouton "Enregistrer"
//         JButton enregistrerButton = new JButton("Enregistrer");
//         enregistrerButton.addActionListener(new ActionListener() {
//             @Override
//             public void actionPerformed(ActionEvent e) {
//                 savePlanification(emf);
//                 plantesComboBox.setSelectedIndex(0);
//                 dateField.setText("");
//             }
//         });
//         add(enregistrerButton);
//     }

//     private void savePlanification(EntityManagerFactory entityManagerFactory) {
//         // On récupère la plante sélectionnée et la date saisie
//         Plante plante = (Plante) plantesComboBox.getSelectedItem();
//         String dateDebutString = dateField.getText();

//         // On convertit la chaîne de date en java.util.Date
//         SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//         java.util.Date dateDebut = null;
//         try {
//             dateDebut = sdf.parse(dateDebutString);
//         } catch (ParseException e) {
//             e.printStackTrace();
//             return;
//         }

//         // On crée une nouvelle instance de Planification avec ces données
//         com.vinckier.hydrogrow_v2.models.Planification planification = new com.vinckier.hydrogrow_v2.models.Planification();
//         planification.setPlante(plante);
//         planification.setDateDebut(dateDebut);

//         // On enregistre la planification en base de données
//         EntityManager entityManager = entityManagerFactory.createEntityManager();
//         entityManager.getTransaction().begin();
//         entityManager.persist(planification);
//         entityManager.getTransaction().commit();
//         entityManager.close();
//     }
// }
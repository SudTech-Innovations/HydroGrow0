// package com.vinckier.hydrogrow_v2;

// import javax.persistence.EntityManager;
// import javax.persistence.EntityManagerFactory;
// import javax.persistence.EntityTransaction;
// import javax.persistence.Persistence;

// import com.vinckier.hydrogrow_v2.models.Environnement;
// import com.vinckier.hydrogrow_v2.models.Plante;

// public class DatabaseInitializer {
//     public static void init() {
//         EntityManagerFactory emf = Persistence.createEntityManagerFactory("hydrobase_v2");
//         EntityManager em = emf.createEntityManager();
//         EntityTransaction tx = em.getTransaction();

//         try {
//             tx.begin();

//             Environnement env = new Environnement();
//             env.setNom("Serre");

//             Plante plante = new Plante();
//             plante.setNom("Tomate");
//             plante.setEnvironnement(env);

//             em.persist(env);
//             em.persist(plante);

//             tx.commit();
//         } catch (Exception e) {
//             tx.rollback();
//             e.printStackTrace();
//         } finally {
//             em.close();
//             emf.close();
//         }
//     }
// }

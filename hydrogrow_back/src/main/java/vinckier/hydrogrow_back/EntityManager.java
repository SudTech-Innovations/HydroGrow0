package vinckier.hydrogrow_v2;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class EntityManager {
    public static void init() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hydrogrow_back");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            // Début de la transaction
            tx.begin();

            // Validation de la transaction
            tx.commit();
        } catch (Exception e) {
            // Annulation de la transaction en cas d'erreur
            tx.rollback();
            e.printStackTrace();
        } finally {
            // Fermeture de l'EntityManager
            em.close();

            // Fermeture de l'EntityManagerFactory
            emf.close();
        }
    }
}
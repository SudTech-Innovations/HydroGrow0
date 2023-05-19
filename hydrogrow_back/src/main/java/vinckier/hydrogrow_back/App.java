package vinckier.hydrogrow_back;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import vinckier.hydrogrow_back.models.User;

public class App {
    public static void main(String[] args) throws Exception {
        // Initialisation de l'entity manager factory
        JPAUtils.initEntityManagerFactory();

        // Initialisation de la base de données
        HydroManager.init();

        // TODO: Ajoutez le code de votre application backend ici
        EntityManager entityManager = (EntityManager) JPAUtils.getEntityManager();

        // Création d'un nouvel utilisateur
        User user = new User();
        user.setNom("Alice");
        user.setMdp("Dupont");
        user.setIdUser("alice.dupont");
        user.setEmail("alice.dupont@example.com");

        // Début de la transaction
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(user);
        transaction.commit();

        // Fermeture de l'entity manager
        entityManager.close();

        // Fermeture de l'entity manager factory
        JPAUtils.destroyEntityManagerFactory();
    }
}
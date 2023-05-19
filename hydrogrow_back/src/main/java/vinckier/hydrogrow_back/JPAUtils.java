package vinckier.hydrogrow_back;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtils {
    private static final String PERSISTENCE_UNIT_NAME = "hydrogrow_back";

    private static EntityManagerFactory entityManagerFactory;

    // Méthode permettant d'initialiser l'entity manager factory et de créer les
    // tables
    public static void initEntityManagerFactory() throws Exception {
        try {
            entityManagerFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
            // Création des tables
            entityManagerFactory.createEntityManager().close();
        } catch (Exception e) {
            throw new Exception("Erreur lors de l'initialisation de l'entity manager factory", e);
        }
    }

    // Méthode permettant de fermer l'entity manager factory
    public static void destroyEntityManagerFactory() {
        if (entityManagerFactory != null && entityManagerFactory.isOpen()) {
            entityManagerFactory.close();
        }
    }

    // Méthode permettant d'obtenir un entity manager pour interagir avec la base de
    // données
    public static EntityManager getEntityManager() {
        return entityManagerFactory.createEntityManager();
    }
}
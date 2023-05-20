package vinckier.hydrogrow_back_v2.bdd;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

/**
 * Cette classe est une classe utilitaire pour gérer l'accès à l'EntityManager
 * pour la persistance en JPA.
 */
public class JPAUtils {

    /**
     * L'instance unique de cette classe.
     */
    private static JPAUtils INSTANCE = new JPAUtils();

    /**
     * Constructeur privé pour empêcher la création d'autres instances de cette
     * classe.
     */
    private JPAUtils() {

    }

    /**
     * Obtient l'instance unique de cette classe.
     *
     * @return l'instance unique de cette classe.
     */
    public static JPAUtils getInstance() {
        return INSTANCE;
    }

    /**
     * L'EntityManagerFactory utilisée pour créer l'EntityManager.
     */
    public final static EntityManagerFactory EMF = Persistence.createEntityManagerFactory("hydrogrow_back_v2");

    /**
     * L'EntityManager créée à partir de l'EntityManagerFactory.
     */
    private final static EntityManager EM = EMF.createEntityManager();

    /**
     * Renvoie l'instance de l'EntityManager pour cette application.
     *
     * @return l'instance de l'EntityManager pour cette application.
     */
    public EntityManager getEntityManager() {
        return EM;
    }

}
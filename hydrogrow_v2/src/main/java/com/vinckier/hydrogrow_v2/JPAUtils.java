package com.vinckier.hydrogrow_v2;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;

public class JPAUtils {
    private static JPAUtils INSTANCE = new JPAUtils();

    private JPAUtils() {

    }

    public static JPAUtils getInstance() {
        return INSTANCE;
    }

    // JPA
    private final static EntityManagerFactory EMF = Persistence.createEntityManagerFactory("hydrobase_v2");
    private final static EntityManager EM = EMF.createEntityManager();

    public EntityManager getEntityManager() {
        return EM;
    }
}

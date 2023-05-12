package com.vinckier.hydrogrow_v3;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtils {
    private static EntityManagerFactory EMF = Persistence.createEntityManagerFactory("hydrobase_v2");

    private JPAUtils() {
    }

    public static JPAUtils getInstance() {
        return new JPAUtils();
    }

    public EntityManager getEntityManager() {
        return EMF.createEntityManager();
    }
}

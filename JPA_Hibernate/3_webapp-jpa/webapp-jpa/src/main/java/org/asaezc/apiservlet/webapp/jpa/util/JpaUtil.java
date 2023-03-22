package org.asaezc.apiservlet.webapp.jpa.util;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JpaUtil {
//sigleton una instancia para toda la app
    private static final EntityManagerFactory entityManagerFactory = buildEntityManagerFactory();

    private static EntityManagerFactory buildEntityManagerFactory() {
        return Persistence.createEntityManagerFactory("ejemploJpa");
    }
    //inst para cada req
    public static EntityManager getEntityManager() {
        return entityManagerFactory.createEntityManager();
    }
}

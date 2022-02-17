package org.andr7st.hibernate.app.utilities;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JpaUtil {

    private static final EntityManagerFactory entityManagerFactory= buildEntiotyManagerFactory();

    /**
    * persistenceUnitName debe ser el mismo nombre proporcionado en la configuracion de la persistencia:
    * META-INF/persistence.xml => <persistence-unit name="ejemploJPA" transaction-type="RESOURCE_LOCAL">
    */
    private static EntityManagerFactory buildEntiotyManagerFactory() {
        return Persistence.createEntityManagerFactory("ejemploJPA");
    }

    public static EntityManager getEntityManager() {
        return entityManagerFactory.createEntityManager();
    }
}

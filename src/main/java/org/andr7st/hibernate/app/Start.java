package org.andr7st.hibernate.app;

import jakarta.persistence.EntityManager;
import org.andr7st.hibernate.app.entity.Cliente;
import org.andr7st.hibernate.app.utilities.JpaUtil;

import java.util.List;

public class Start { // HibernateList
    public static void main(String[] args) {

        EntityManager em = JpaUtil.getEntityManager();
        List<Cliente> clientes = em.createQuery("select c from Cliente c", Cliente.class).getResultList();

        System.out.print("\u001B[35m \n");
        clientes.forEach(System.out::println);
        System.out.print("\u001B[0m");


        em.close();
    }
}

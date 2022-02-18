package org.andr7st.hibernate.app;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.andr7st.hibernate.app.entity.Cliente;
import org.andr7st.hibernate.app.utilities.JpaUtil;

import java.util.List;

public class Start { // HibernateList
    public static void main(String[] args) {
      //  Start.HibernateListarWhere("paypal");

        Start.HibernatePorIdFormaB(2L);
    }

    public static void HibernateListar() {

        EntityManager em = JpaUtil.getEntityManager();
        List<Cliente> clientes = em.createQuery("select c from Cliente c", Cliente.class).getResultList();
        System.out.print(ForeColor);
        clientes.forEach(System.out::println);
        System.out.print(ClearColor);
        em.close();

    }

    public static void HibernateListarWhere(String formaPago) {

        EntityManager em = JpaUtil.getEntityManager();
        Query query = em.createQuery("select c from Cliente c where c.formaPago=?1", Cliente.class);
        query.setParameter(1, formaPago);
        query.setMaxResults(1);
        Cliente c = (Cliente) query.getSingleResult();
        System.out.print(ForeColor);
        System.out.println(c);
        System.out.print(ClearColor);
        em.close();

    }

    public static void HibernatePorId(Long porId) {
        EntityManager em = JpaUtil.getEntityManager();
        Query query = em.createQuery("select c from Cliente c where c.id=?1", Cliente.class);
        query.setParameter(1, porId);
        query.setMaxResults(1);
        Cliente c = (Cliente) query.getSingleResult();
        System.out.print(ForeColor);
        System.out.println(c);
        System.out.print(ClearColor);
        em.close();
    }

    public static void HibernatePorIdFormaB(Long porId) {

        EntityManager em = JpaUtil.getEntityManager();
        Cliente cliente = em.find(Cliente.class, porId);

        System.out.print(ForeColor);
        System.out.println(cliente);
        System.out.print(ClearColor);

        em.close();
    }

    public static final String ForeColor = "\u001B[35m \n";
    public static final String ClearColor = "\u001B[0m";
}

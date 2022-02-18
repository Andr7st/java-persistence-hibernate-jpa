package org.andr7st.hibernate.app;

import jakarta.persistence.EntityManager;
import org.andr7st.hibernate.app.entity.Cliente;
import org.andr7st.hibernate.app.utilities.JpaUtil;

import java.util.Scanner;

public class HibernateEliminar {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingresa id del cliente a eliminar: ");
        Long id = scanner.nextLong();

        EntityManager em = JpaUtil.getEntityManager();

        try{

            Cliente cliente = em.find(Cliente.class, id);

            em.getTransaction().begin();
            em.remove(cliente); // Eliminar de la database.table
            em.getTransaction().commit();

        }catch (Exception e){
            em.getTransaction().rollback();
            e.printStackTrace();
        }finally{
            em.close();
        }
    }
}

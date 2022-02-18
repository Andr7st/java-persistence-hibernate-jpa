package org.andr7st.hibernate.app;

import jakarta.persistence.EntityManager;
import org.andr7st.hibernate.app.entity.Cliente;
import org.andr7st.hibernate.app.utilities.JpaUtil;

import javax.swing.*;

public class HibernateCrear {

    public static void main(String[] args) {

        EntityManager em = JpaUtil.getEntityManager();
        try{
            String nombre = JOptionPane.showInputDialog("Ingrese el nombre:");
            String apellido = JOptionPane.showInputDialog("Ingrese el apellido:");
            String formaPago = JOptionPane.showInputDialog("Ingrese la forma de pago:");

            em.getTransaction().begin();

            Cliente cliente = new Cliente();
            cliente.setNombre(nombre);
            cliente.setApellido(apellido);
            cliente.setFormaPago(formaPago);

            // guardar / persittir datos
            em.persist(cliente);

            System.out.printf("El id del cliente registrado es %d \n", cliente.getId());
            em.getTransaction().commit(); // for send transaction

            // esta consulta hibernate la saca de la caché, no la busca fisicamente en la base de datos porque ya la tiene.
            cliente  = em.find(Cliente.class, cliente.getId());

            System.out.println(cliente);
        }catch (Exception e){
            em.getTransaction().rollback();
            e.printStackTrace();
        }
        finally{
            em.close();
        }
    }
}

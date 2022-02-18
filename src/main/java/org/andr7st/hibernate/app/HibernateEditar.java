package org.andr7st.hibernate.app;

import jakarta.persistence.EntityManager;
import org.andr7st.hibernate.app.entity.Cliente;
import org.andr7st.hibernate.app.utilities.JpaUtil;

import javax.swing.*;

/**
 * Modificar un registro existente en la base de datos
 * */
public class HibernateEditar {
    public static void main(String[] args) {

        EntityManager em = JpaUtil.getEntityManager();

        try{

            Long id = Long.valueOf(JOptionPane.showInputDialog("ingrese el ide del cliente a modificar:"));
            Cliente cliente = em.find(Cliente.class, id);

            String nombre = JOptionPane.showInputDialog("Modificar el nombre ?:", cliente.getNombre());
            String apellido = JOptionPane.showInputDialog("Modificar el apellido ?:", cliente.getApellido());
            String formaPago = JOptionPane.showInputDialog("Modificar la forma de pago ?:", cliente.getFormaPago());

            em.getTransaction().begin();

            cliente.setNombre(nombre);
            cliente.setApellido(apellido);
            cliente.setFormaPago(formaPago);

            em.merge(cliente);

            em.getTransaction().commit();

            System.out.println("Modificado: " + cliente);

        }catch (Exception e){
            em.getTransaction().rollback();
        }finally {
            em.close();
        }
    }
}

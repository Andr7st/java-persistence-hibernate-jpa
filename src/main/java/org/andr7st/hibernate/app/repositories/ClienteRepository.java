package org.andr7st.hibernate.app.repositories;

import jakarta.persistence.EntityManager;
import org.andr7st.hibernate.app.entity.Cliente;

import java.util.List;

public class ClienteRepository implements CrudRepository<Cliente> {


    private EntityManager em;

    public ClienteRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<Cliente> Listar() {
        return em.createQuery("select c from Cliente c", Cliente.class).getResultList();
    }

    @Override
    public Cliente porId(Long id) {
        return em.find(Cliente.class, id);
    }

    @Override
    public void guadar(Cliente cliente) {

        if (cliente.getId() != null && cliente.getId() > 0) {
            em.merge(cliente);
        }else {
            em.persist(cliente);
        }
    }

    @Override
    public void eliminar(Long id) {
        Cliente cliente = this.porId(id);
        em.remove(cliente);
    }
}

package org.andr7st.hibernate.app.services;

import jakarta.persistence.EntityManager;
import org.andr7st.hibernate.app.entity.Cliente;
import org.andr7st.hibernate.app.repositories.ClienteRepository;
import org.andr7st.hibernate.app.repositories.CrudRepository;

import java.util.List;
import java.util.Optional;

public class ClienteServiceImpl implements ClienteServiceInterface {

    private EntityManager em;

    private CrudRepository<Cliente> repository;

    public ClienteServiceImpl(EntityManager em) {
        this.em = em;
        this.repository = new ClienteRepository(em);
    }

    @Override
    public List<Cliente> listar() {
        return repository.Listar();
    }

    @Override
    public Optional<Cliente> porId(Long id) {
        return Optional.ofNullable(repository.porId(id));
    }

    @Override
    public void guardar(Cliente cliente) {

        try {
            em.getTransaction().begin();
            repository.guadar(cliente);
            em.getTransaction().commit();
        }catch (Exception e) {
            em.getTransaction().getRollbackOnly();
        }
    }

    @Override
    public void eliminar(Long id) {
        try {
            em.getTransaction().begin();
            repository.eliminar(id);
            em.getTransaction().commit();
        }catch (Exception e) {
            em.getTransaction().getRollbackOnly();
        }

    }
}

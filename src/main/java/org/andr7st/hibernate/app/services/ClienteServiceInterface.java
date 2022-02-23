package org.andr7st.hibernate.app.services;

import org.andr7st.hibernate.app.entity.Cliente;

import java.util.List;
import java.util.Optional;

public interface ClienteServiceInterface {
    List<Cliente> listar();
    Optional<Cliente> porId(Long id);
    void guardar(Cliente cliente);
    void eliminar(Long id);
}

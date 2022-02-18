package org.andr7st.hibernate.app.repositories;

import java.util.List;

public interface CrudRepository<T> {

    List<T> Listar();
    T porId(Long id);
    void guadar(T t);
    void eliminar(Long id);
}

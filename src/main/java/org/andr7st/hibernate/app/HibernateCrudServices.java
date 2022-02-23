package org.andr7st.hibernate.app;

import jakarta.persistence.EntityManager;
// import org.andr7st.hibernate.app.entity.Cliente;
import org.andr7st.hibernate.app.entity.Cliente;
import org.andr7st.hibernate.app.services.ClienteServiceImpl;
import org.andr7st.hibernate.app.services.ClienteServiceInterface;
import org.andr7st.hibernate.app.utilities.JpaUtil;

import java.util.List;
import java.util.Optional;

public class HibernateCrudServices {
    public static void main(String[] args) {

        System.out.print("\u001B[35m");

        EntityManager em = JpaUtil.getEntityManager();

        ClienteServiceInterface service = new ClienteServiceImpl(em);

        System.out.println("============== listar ==============");
        List<Cliente> clientes = service.listar();
        clientes.forEach(c -> System.out.println(c));

        System.out.println("============== obtener por id ==============");
        Optional<Cliente> optionalCliente = service.porId(1L);
        optionalCliente.ifPresent(System.out::println);

        {}
        System.out.println("============== insertar nuevo cliente ==============");
        Cliente cliente = new Cliente();
        cliente.setNombre("Luci");
        cliente.setApellido("Mena");
        cliente.setFormaPago("paypal");

        service.guardar(cliente);
        System.out.println("Cliente guardado");
        service.listar().forEach(System.out::println);

        System.out.println("============== editar cliente pot id ==============");
        Long id = cliente.getId(); //el ultimo guardado
        optionalCliente = service.porId(id);
        optionalCliente.ifPresent(c -> {
            c.setFormaPago( "mercado pago" );
            service.guardar(c);
            System.out.println("Cliente editado con exito!");
            service.listar().forEach(System.out::println);
        });

        System.out.println("============== eliminar cliente ==============");
        id = cliente.getId(); //el ultimo guardado
        optionalCliente = service.porId(id);
        optionalCliente.ifPresent(c -> {
            service.eliminar(c.getId());
            System.out.println("cliente eliminado copn exito");
            service.listar().forEach(System.out::println);
        });

        /* Alternativa:
        if (optionalCliente.isPresent()) {
            service.eliminar(id);
        }*/

        System.out.println("============== === ==============");
        em.close();

        System.out.print("\u001B[0m");
    }
}

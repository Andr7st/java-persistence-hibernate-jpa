# java - JPA Persistence - API

### Stack

![icon](readme-resources/stack/java.png?raw=true )
![icon](readme-resources/stack/spring.png?raw=true )
![icon](readme-resources/stack/database.png?raw=true )
![icon](readme-resources/stack/mysql.png?raw=true )

[**wikibooks.org**](https://en.wikibooks.org/wiki/Java_Persistence/What_is_JPA%3F): The Java Persistence API (JPA) is a Java specification for accessing, persisting, and managing data between Java objects / classes and a relational database. JPA was defined as part of the EJB 3.0 specification as a replacement for the EJB 2 CMP Entity Beans specification...


### Database

Using MySQL Community Edition.

#### credentials:
 * url: `localhost:3306/java_curso`
 * username: `root`
 * password: `password123`

#### Graphic representation:

```mermaid
  graph TD;
      database.java_curso-->table.clientes;
      table.clientes-->column.id;
      table.clientes-->column.nombre;
      table.clientes-->column.apellido;
      table.clientes-->column.forma_pago;

```



---

[**Andr7st**](https://github.com/Andr7st/)

[//]: # (This repo belongs to a greater project: Andrés Segura's)

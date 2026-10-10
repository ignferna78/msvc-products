package org.springcloud.microservicio.product.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Representa un producto almacenado en la base de datos.
 * <p>
 * Mapea la tabla {@code products} y contiene la información del producto,
 * incluyendo su identificador, nombre, precio y fecha de creación.
 * El puerto de la instancia del microservicio se utiliza como dato
 * transitorio y no se almacena en la base de datos.
 */
@Entity
@Table(name = "products")
@Data
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Double price;

    @Column(name = "create_at")
    private LocalDateTime createAt;

    @Transient
    private int port;
}

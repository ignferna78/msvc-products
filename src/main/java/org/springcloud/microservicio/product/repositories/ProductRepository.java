package org.springcloud.microservicio.product.repositories;

import org.springcloud.microservicio.product.entities.Product;
import org.springframework.data.repository.CrudRepository;

/**
 * Repositorio para el acceso y la gestión de las entidades {@link Product}.
 * <p>
 * Proporciona operaciones CRUD para los productos mediante
 * {@link org.springframework.data.repository.CrudRepository}.
 */
public interface ProductRepository extends CrudRepository<Product, Long> {
}

package org.springcloud.microservicio.product.repositories;

import org.springcloud.microservicio.product.entities.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long> {
}

package org.springcloud.microservicio.product.services;

import org.springcloud.microservicio.product.entities.Product;

import java.util.List;
import java.util.Optional;

/**
 * Define las operaciones disponibles para la gestión de productos.
 */
public interface ProductService {

    /**
     * Obtiene la lista de todos los productos disponibles.
     *
     * @return una lista de productos
     */
    List<Product> findAll();


    /**
     * Busca un producto por su identificador.
     *
     * @param id identificador del producto que se desea buscar
     * @return un {@code Optional} que contiene el producto si existe,
     *         o vacío si no se encuentra
     */
    Optional<Product> findById(Long id);
}
 
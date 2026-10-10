package org.springcloud.microservicio.product.services.impl;

import org.springcloud.microservicio.product.entities.Product;
import org.springcloud.microservicio.product.repositories.ProductRepository;
import org.springcloud.microservicio.product.services.ProductService;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Implementación del servicio de gestión de productos.
 * <p>
 * Proporciona operaciones para consultar productos y añadir a cada uno
 * el puerto del servidor en el que se está ejecutando la aplicación.
 */
@Service
public class ProductServiceImpl implements ProductService {

    final private ProductRepository repository;

    final private Environment enviroment;

    public ProductServiceImpl(ProductRepository repository, Environment enviroment) {
        this.repository = repository;
        this.enviroment = enviroment;
    }

    /** {@inheritDoc} */
    @Override
    @Transactional(readOnly = true)
    public List<Product> findAll() {
        return ((List<Product>) repository.findAll()).stream().map(product -> {
            product.setPort(Integer.parseInt(enviroment.getProperty("local.server.port")));
            return product;
        }).collect(Collectors.toList());
    }

    /** {@inheritDoc} */
    @Override
    @Transactional(readOnly = true)
    public Optional<Product> findById(Long id) {

        return repository.findById(id).map(product -> {
            product.setPort(Integer.parseInt(enviroment.getProperty("local.server.port")));
            return product;
        });
    }

}

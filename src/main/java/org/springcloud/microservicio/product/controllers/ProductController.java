package org.springcloud.microservicio.product.controllers;

import org.springcloud.microservicio.product.entities.Product;
import org.springcloud.microservicio.product.services.ProductService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class ProductController {

    final private ProductService service;

    @Value("${app.instance}")
    private String instance;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @GetMapping("/index")
    public String index() {
        return "Hola a todos";
    }


    @GetMapping
    public ResponseEntity<?> list() {
        System.out.println("Atendiendo petición desde: " + instance);
        return ResponseEntity.ok(this.service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> details(@PathVariable Long id) {
        Optional<Product> productOptional = service.findById(id);
        System.out.println("Atendiendo petición desde: " + instance);
        if (productOptional.isPresent()) {
            return ResponseEntity.ok(productOptional.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }
}

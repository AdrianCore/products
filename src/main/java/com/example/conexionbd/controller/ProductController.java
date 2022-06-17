package com.example.conexionbd.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.conexionbd.model.Producto;
import com.example.conexionbd.service.ProductoService;

@RestController
@RequestMapping("/productos")
public class ProductController {

    @Autowired
    private final ProductoService productoService;

    public ProductController(ProductoService productoService) {
        this.productoService = productoService;
    }

    @GetMapping
    public List<Producto> getProductos() {
        return productoService.getAllProducts();
    }

    @PostMapping
    public Producto guardarProducto(@RequestBody Producto product) {
        return productoService.saveProduct(product);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Producto> findProductById(@PathVariable Long id) {
        return productoService.getProductById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Producto> updateProduct(@PathVariable Long id, @RequestBody Producto productDetails) {
        return productoService.updateProduct(id, productDetails);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String,Boolean >> deleteProduct(@PathVariable Long id) {
        return productoService.deleteProduct(id);
    }
}

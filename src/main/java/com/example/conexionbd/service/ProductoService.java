package com.example.conexionbd.service;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.conexionbd.exceptions.ResourceNotFoundException;
import com.example.conexionbd.model.Producto;
import com.example.conexionbd.repository.ProductRepository;

@Service
public class ProductoService {

    @Autowired
    private final ProductRepository productRepository;

    public ProductoService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public  List<Producto> getAllProducts(){
        return productRepository.findAll();
    }

    public Producto saveProduct(Producto producto) {
        return productRepository.save(producto);
    }

    public ResponseEntity<Producto> getProductById(Long id) {
        Producto producto = productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No se encontró el elemento"));
        return ResponseEntity.ok(producto);
    }

    public Producto guardarProducto(Producto product) {
        return productRepository.save(product);
    }

    public ResponseEntity<Producto> updateProduct(Long id, Producto productDetails) {
        Producto producto = productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No se encontró el elemento"));
        producto.setNombre(productDetails.getNombre());
        producto.setDescripcion(productDetails.getDescripcion());
        producto.setPrecio(productDetails.getPrecio());
        producto.setCantidad(productDetails.getCantidad());
        producto.setIdCategoria(productDetails.getIdCategoria());

        Producto updatedProducto = productRepository.save(producto);

        return ResponseEntity.ok(updatedProducto);
    }

    public ResponseEntity<Map<String,Boolean >> deleteProduct(Long id) {
        Producto producto = productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No se encontró el elemento"));

        productRepository.delete(producto);
        Map<String,Boolean> response = new HashMap<>();
        response.put("Eliminar", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
    
}

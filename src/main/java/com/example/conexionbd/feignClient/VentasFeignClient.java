package com.example.conexionbd.feignClient;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.conexionbd.model.Producto;

@FeignClient(name = "product-service", url = "http://localhost:8080/productos")
public interface VentasFeignClient {

    @GetMapping()
    List<Producto> getProductos();
    
    
}

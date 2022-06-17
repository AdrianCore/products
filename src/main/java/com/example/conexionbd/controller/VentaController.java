package com.example.conexionbd.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.conexionbd.feignClient.VentasFeignClient;
import com.example.conexionbd.model.Producto;

@RestController
@RequestMapping("/ventas")
public class VentaController {

    @Autowired
    private VentasFeignClient ventasFeignClient;

    @GetMapping("/productos")
    public List<Producto> getProductos() {
        return ventasFeignClient.getProductos();
    }
    
}

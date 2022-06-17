package com.example.conexionbd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.conexionbd.model.Producto;

@Repository
public interface ProductRepository extends JpaRepository<Producto, Long> {
    
}

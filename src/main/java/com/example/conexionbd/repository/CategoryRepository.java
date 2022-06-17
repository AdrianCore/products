package com.example.conexionbd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.conexionbd.model.Categoria;

@Repository
public interface CategoryRepository extends JpaRepository<Categoria, Long> {
    
}

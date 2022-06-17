package com.example.conexionbd.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.conexionbd.exceptions.ResourceNotFoundException;
import com.example.conexionbd.model.Categoria;
import com.example.conexionbd.repository.CategoryRepository;

@Service
public class CategoriaService {

    @Autowired
    private final CategoryRepository categoryRepository;

    private CategoriaService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public  List<Categoria> getAllCategories(){
        return categoryRepository.findAll();
    }

    public ResponseEntity<Categoria> getCategoryById(Long id) {
        Categoria categoria = categoryRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No se encontró el elemento"));
        return ResponseEntity.ok(categoria);
    }

    public Categoria saveCategory(Categoria categoria) {
        return categoryRepository.save(categoria);
    }

    public ResponseEntity<Categoria> updateCategoria(Long id, Categoria categiryDetails) {
        Categoria categoria = categoryRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No se encontró el elemento"));
        categoria.setNombre(categiryDetails.getNombre());
        categoria.setDescripcion(categiryDetails.getDescripcion());

        Categoria updatedCategoria = categoryRepository.save(categoria);

        return ResponseEntity.ok(updatedCategoria);
    }

    public ResponseEntity<Map<String,Boolean >> deleteCategoria(Long id) {
        Categoria categoria = categoryRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No se encontró el elemento"));

        categoryRepository.delete(categoria);
        Map<String,Boolean> response = new HashMap<>();
        response.put("Eliminar", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
    
}

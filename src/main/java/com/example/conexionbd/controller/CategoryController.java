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

import com.example.conexionbd.model.Categoria;
import com.example.conexionbd.service.CategoriaService;

@RestController
@RequestMapping("/categorias")
public class CategoryController {

    @Autowired
    private final CategoriaService categoriaService;

    public CategoryController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    @GetMapping
    public List<Categoria> getCategorias() {
        return categoriaService.getAllCategories();
    }

    @PostMapping
    public Categoria guardarCategoria(@RequestBody Categoria categoria) {
        return categoriaService.saveCategory(categoria);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Categoria> findCategoryById(@PathVariable Long id) {
        return categoriaService.getCategoryById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Categoria> updateCategory(@PathVariable Long id, @RequestBody Categoria categoriaDetails) {
        return categoriaService.updateCategoria(id, categoriaDetails);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String,Boolean >> deleteCategory(@PathVariable Long id) {
        return categoriaService.deleteCategoria(id);
    }
    
}

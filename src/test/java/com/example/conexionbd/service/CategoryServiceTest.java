package com.example.conexionbd.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.example.conexionbd.model.Categoria;
import com.example.conexionbd.repository.CategoryRepository;

public class CategoryServiceTest {
    
    @Mock
    private CategoryRepository categoryRepository;

    @InjectMocks
    private CategoriaService categoriaService;

    private Categoria categoria;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        categoria = new Categoria();
        categoria.setId((long)6);
        categoria.setNombre("Bebés");
        categoria.setDescripcion("Artículos para el cuidado de los más pequeños del hogar");

    }

    @Test
    void listaCategorias() {
        when(categoryRepository.findAll()).thenReturn(Arrays.asList(categoria));
        assertNotNull(categoriaService.getAllCategories());
    }

    @Test
    void guardarCategoria() {
        when(categoryRepository.save(any(Categoria.class))).thenReturn(categoria);
         assertNotNull(categoriaService.saveCategory(new Categoria()));
    }

    @Test
    void encontrarCategoria() {
        assertNotNull(categoriaService.getCategoryById((long) 5));
    }

    @Test
    void modificarCategoria() {
        assertNotNull(categoriaService.updateCategoria((long) 2, categoria));
    }

    @Test
    void borrarCategoria() {
        assertNotNull(categoriaService.deleteCategoria((long) 5));
    }
    
    
}

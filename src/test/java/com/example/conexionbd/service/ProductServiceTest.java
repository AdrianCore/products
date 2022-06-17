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

import com.example.conexionbd.model.Producto;
import com.example.conexionbd.repository.ProductRepository;

public class ProductServiceTest {

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductoService productoService;

    private Producto producto;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        producto = new Producto();
        producto.setId((long)6);
        producto.setNombre("Pantalla Samsung LED 65 pulgadas");
        producto.setDescripcion("Ve tus programas favoritos y tus series a 120 cuadros por segundo");
        producto.setPrecio((long)13000);
        producto.setCantidad((long) 40);
        producto.setIdCategoria((long)5);
    }

    @Test
    void listaProductos() {
        when(productRepository.findAll()).thenReturn(Arrays.asList(producto));
        assertNotNull(productoService.getAllProducts());
    }

    @Test
    void guardarProducto() {
        when(productRepository.save(any(Producto.class))).thenReturn(producto);
         assertNotNull(productoService.saveProduct(new Producto()));
    }

    @Test
    void encontrarProducto() {
        assertNotNull(productoService.getProductById((long) 3));
    }

    @Test
    void modificarProducto() {
        assertNotNull(productoService.updateProduct((long) 2, producto));
    }

    @Test
    void borrarProducto() {
        assertNotNull(productoService.deleteProduct((long) 5));
    }
    
}

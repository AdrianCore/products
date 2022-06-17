package com.example.conexionbd.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_producto_generator")
    @SequenceGenerator(name = "id_producto_generator", sequenceName = "producto_id_seq", allocationSize = 1)

    @Column(name = "id_producto", length = 25)
    private Long id;

    @Column(name = "nombre", length = 25)
    private String nombre;

    @Column(name = "descripcion", length = 80)
    private String descripcion;

    @Column(name = "precio", length = 25)
    private Long precio;

    @Column(name = "cantidad", length = 25)
    private Long cantidad;

    @Column(name = "id_categoria", length = 25)
    private Long id_categoria;

    public Producto() {
        
    }

    public Producto(Long id, String nombre, String descripcion, Long precio, Long cantidad, Long id_categoria) {
        this.id = id;
        this.nombre= nombre;
        this.descripcion = descripcion;
        this.cantidad = cantidad;
        this.id_categoria = id_categoria;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Long getPrecio() {
        return precio;
    }

    public void setPrecio(Long precio) {
        this.precio = precio;
    }

    public Long getCantidad() {
        return cantidad;
    }

    public void setCantidad(Long cantidad) {
        this.cantidad = cantidad;
    }

    public Long getIdCategoria() {
        return id_categoria;
    }

    public void setIdCategoria(Long id_categoria) {
        this.id_categoria = id_categoria;
    }
    
}

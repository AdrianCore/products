package com.example.conexionbd.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "categoria_id_generator")
    @SequenceGenerator(name = "categoria_id_generator", sequenceName = "categoria_id_seq", allocationSize = 1)

    @Column(name = "id_categoria", length = 25)
    private Long id;

    @Column(name = "nombre", length = 25)
    private String nombre;

    @Column(name = "descripcion", length = 80)
    private String descripcion;

    public Categoria() {

    }

    public Categoria(Long id, String nombre, String descripcion) {
        this.id = id;
        this.nombre= nombre;
        this.descripcion = descripcion;
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
    
}

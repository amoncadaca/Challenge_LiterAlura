package com.alura.literalura.literalura.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import org.springframework.data.annotation.Id;

@Entity
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private Integer anioNacimiento;
    private Integer anioFallecimiento;

    public Autor(Long id, String nombre, Integer anioNacimiento, Integer anioFallecimiento) {
        this.id = id;
        this.nombre = nombre;
        this.anioNacimiento = anioNacimiento;
        this.anioFallecimiento = anioFallecimiento;
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

    public Integer getAnioNacimiento() {
        return anioNacimiento;
    }

    public void setAnioNacimiento(Integer anioNacimiento) {
        this.anioNacimiento = anioNacimiento;
    }

    public Integer getAnioFallecimiento() {
        return anioFallecimiento;
    }

    public void setAnioFallecimiento(Integer anioFallecimiento) {
        this.anioFallecimiento = anioFallecimiento;
    }
}


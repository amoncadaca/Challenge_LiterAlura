package com.alura.literalura.literalura.model;

import jakarta.persistence.*;
import org.springframework.data.annotation.Id;

@Entity
public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;

    @Enumerated(EnumType.STRING)
    private Language idioma;

    private int descargas;

    @ManyToOne(cascade = CascadeType.ALL)
    private Autor autor;

    public Libro(Long id, String titulo, Language idioma, int descargas, Autor autor) {
        this.id = id;
        this.titulo = titulo;
        this.idioma = idioma;
        this.descargas = descargas;
        this.autor = autor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Language getIdioma() {
        return idioma;
    }

    public void setIdioma(Language idioma) {
        this.idioma = idioma;
    }

    public int getDescargas() {
        return descargas;
    }

    public void setDescargas(int descargas) {
        this.descargas = descargas;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }
}

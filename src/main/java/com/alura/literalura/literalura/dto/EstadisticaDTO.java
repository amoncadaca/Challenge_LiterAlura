package com.alura.literalura.literalura.dto;

public class EstadisticaDTO {
    private String idioma;
    private Long cantidadLibros;

    public EstadisticaDTO(String idioma, Long cantidadLibros) {
        this.idioma = idioma;
        this.cantidadLibros = cantidadLibros;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public Long getCantidadLibros() {
        return cantidadLibros;
    }

    public void setCantidadLibros(Long cantidadLibros) {
        this.cantidadLibros = cantidadLibros;
    }

    @Override
    public String toString() {
        return "EstadisticaDTO{" +
                "idioma='" + idioma + '\'' +
                ", cantidadLibros=" + cantidadLibros +
                '}';
    }
}


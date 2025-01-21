package com.alura.literalura.literalura.repository;

import com.alura.literalura.literalura.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AutorRepository extends JpaRepository<Autor, Long> {
    List<Autor> findByAnioNacimientoBeforeAndAnioFallecimientoAfter(int year, int year2);
}


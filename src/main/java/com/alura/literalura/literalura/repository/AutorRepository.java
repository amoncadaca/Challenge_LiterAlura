package com.alura.literalura.literalura.repository;

import com.alura.literalura.literalura.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AutorRepository extends JpaRepository<Autor, Long> {
    @Query("SELECT a FROM Autor a WHERE a.anioNacimiento <= :year AND (a.anioFallecimiento IS NULL OR a.anioFallecimiento > :year)")
    List<Autor> findAutoresVivosEnAno(@Param("year") int year);
}



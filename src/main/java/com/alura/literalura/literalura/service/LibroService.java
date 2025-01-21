package com.alura.literalura.literalura.service;

import com.alura.literalura.literalura.model.Libro;
import com.alura.literalura.literalura.repository.AutorRepository;
import com.alura.literalura.literalura.repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LibroService {

    @Autowired
    private LibroRepository libroRepository;

    @Autowired
    private AutorRepository autorRepository;

    private final RestTemplate restTemplate = new RestTemplate();
    private final String API_URL = "https://gutendex.com/books";

    public LibroService(LibroRepository libroRepository) {
        this.libroRepository = libroRepository;
    }

    public Libro buscarLibroPorTitulo(String titulo) {
        String url = API_URL + "?search=" + titulo;
        ResponseEntity<Map> response = restTemplate.getForEntity(url, Map.class);
        List<Map<String, Object>> resultados = (List<Map<String, Object>>) response.getBody().get("results");

        if (resultados.isEmpty()) {
            throw new RuntimeException("No se encontró ningún libro con el título: " + titulo);
        }

        Map<String, Object> libroJson = resultados.get(0);

        // Procesar datos del libro
        String tituloLibro = (String) libroJson.get("title");
        List<Map<String, Object>> autoresJson = (List<Map<String, Object>>) libroJson.get("authors");
        List<String> idiomas = (List<String>) libroJson.get("languages");
        int descargas = (int) libroJson.get("download_count");

        // Crear Autor
        Map<String, Object> primerAutor = autoresJson.get(0);
        Autor autor = new Autor();
        autor.setNombre((String) primerAutor.get("name"));
        autor.setAnioNacimiento((Integer) primerAutor.get("birth_year"));
        autor.setAnioFallecimiento((Integer) primerAutor.get("death_year"));

        // Crear Libro
        Libro libro = new Libro();
        libro.setTitulo(tituloLibro);
        libro.setIdioma(idiomas.get(0));
        libro.setDescargas(descargas);
        libro.setAutor(autor);

        // Guardar en la base de datos
        autorRepository.save(autor);
        return libroRepository.save(libro);
    }

    public Iterable<Libro> listarTodos() {
        return libroRepository.findAll();
    }

    public Map<String, Long> obtenerEstadisticasPorIdioma() {
        return libroRepository.findAll().stream()
                .collect(Collectors.groupingBy(Libro::getIdioma, Collectors.counting()));
    }

}


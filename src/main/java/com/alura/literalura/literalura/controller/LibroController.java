package com.alura.literalura.literalura.controller;

@RestController
@RequestMapping("/libros")
public class LibroController {

    @Autowired
    private LibroRepository libroRepository;

    @GetMapping
    public List<Libro> listarLibros() {
        return libroRepository.findAll();
    }

    @GetMapping("/estadisticas/idiomas")
    public Map<String, Long> contarLibrosPorIdioma() {
        List<Libro> libros = libroRepository.findAll();
        return libros.stream()
                .collect(Collectors.groupingBy(Libro::getIdioma, Collectors.counting()));
    }


}


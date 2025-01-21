package com.alura.literalura.literalura.controller;

@RestController
@RequestMapping("/autores")
public class AutorController {

    @Autowired
    private AutorRepository autorRepository;

    @GetMapping
    public List<Autor> listarAutores() {
        return autorRepository.findAll();
    }

    @GetMapping("/vivos/{year}")
    public List<Autor> listarAutoresVivosEnAno(@PathVariable int year) {
        return autorRepository.findAutoresVivosEnAno(year);
    }

}

package com.alura.literalura.literalura.Principal;

import com.alura.literalura.literalura.model.Libro;
import com.alura.literalura.literalura.repository.AutorRepository;
import com.alura.literalura.literalura.repository.LibroRepository;
import com.alura.literalura.literalura.service.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class Main {

    @Autowired
    private LibroService libroService;

    @Autowired
    private LibroRepository libroRepository;

    @Autowired
    private AutorRepository autorRepository;

    public void mostrarMenu() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nSeleccione una opción:");
            System.out.println("1. Buscar un libro por título");
            System.out.println("2. Listar todos los libros");
            System.out.println("3. Listar todos los autores");
            System.out.println("4. Listar autores vivos en un año específico");
            System.out.println("5. Mostrar estadísticas (cantidad de libros por idioma)");
            System.out.println("6. Salir");

            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir la línea

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el título del libro: ");
                    String titulo = scanner.nextLine();
                    try {
                        Libro libro = libroService.buscarLibroPorTitulo(titulo);
                        System.out.println("Libro encontrado y guardado: " + libro.getTitulo());
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 2:
                    libroRepository.findAll().forEach(System.out::println);
                    break;
                case 3:
                    autorRepository.findAll().forEach(System.out::println);
                    break;
                case 4:
                    System.out.print("Ingrese el año: ");
                    int year = scanner.nextInt();
                    autorRepository.findAutoresVivosEnAno(year).forEach(System.out::println);
                    break;
                case 5:
                    contarLibrosPorIdioma().forEach((idioma, cantidad) ->
                            System.out.println("Idioma: " + idioma + ", Cantidad: " + cantidad));
                    break;
                case 6:
                    System.out.println("¡Hasta luego!");
                    return;
                default:
                    System.out.println("Opción inválida.");
            }
        }
        scanner.close();
    }

    private void listarTodosLosLibros() {
        System.out.println("Listando todos los libros almacenados:");
        var libros = libroService.listarTodos();
        if (!libros.isEmpty()) {
            libros.forEach(libro -> {
                System.out.println("Título: " + libro.getTitulo());
                System.out.println("Autor: " + libro.getAutor().getNombre());
                System.out.println("Idioma: " + libro.getIdioma());
                System.out.println("Descargas: " + libro.getDescargas());
                System.out.println("----------");
            });
        } else {
            System.out.println("No hay libros almacenados.");
        }
    }

    private void listarTodosLosAutores() {
        System.out.println("Listando todos los autores registrados:");
        var autores = autorService.listarTodos();
        if (!autores.isEmpty()) {
            autores.forEach(autor -> {
                System.out.println("Nombre: " + autor.getNombre());
                System.out.println("Año de nacimiento: " + autor.getAnioNacimiento());
                System.out.println("Año de fallecimiento: " + (autor.getAnioFallecimiento() != null ? autor.getAnioFallecimiento() : "Vivo"));
                System.out.println("----------");
            });
        } else {
            System.out.println("No hay autores registrados.");
        }
    }

    private void listarAutoresVivosPorAnio() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el año para buscar autores vivos: ");
        int anio = scanner.nextInt();

        var autores = autorService.listarAutoresVivosEnAnio(anio);
        if (!autores.isEmpty()) {
            System.out.println("Autores vivos en el año " + anio + ":");
            autores.forEach(autor -> {
                System.out.println("Nombre: " + autor.getNombre());
                System.out.println("Año de nacimiento: " + autor.getAnioNacimiento());
                System.out.println("----------");
            });
        } else {
            System.out.println("No se encontraron autores vivos en ese año.");
        }
    }

    private void mostrarEstadisticas() {
        System.out.println("Mostrando estadísticas de libros por idioma:");
        var estadisticas = libroService.obtenerEstadisticasPorIdioma();
        estadisticas.forEach((idioma, cantidad) -> {
            System.out.println("Idioma: " + idioma + " | Cantidad de libros: " + cantidad);
        });
    }

}


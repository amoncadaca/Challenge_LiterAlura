# Literalura

Este proyecto, **Literalura**, es una aplicación basada en Java con Spring Boot para gestionar un catálogo de libros. La aplicación permite buscar libros mediante una API externa, almacenarlos en una base de datos PostgreSQL y realizar consultas interactivas desde la consola.

## Tecnologías utilizadas

- **Java 17** o superior
- **Spring Boot 3.2.3**
  - Spring Data JPA
  - PostgreSQL Driver
- **Maven 4**
- **PostgreSQL 16**
- **Jackson** para la deserialización de JSON

---

## Funcionalidades

### 1. Búsqueda de libro por título
Conecta con la API externa [Gutendex](https://gutendex.com/books/) para buscar libros por su título y guardar los resultados en la base de datos. Solo se almacena el primer autor y el primer idioma del libro.

### 2. Listar todos los libros
Recupera y muestra todos los libros almacenados en la base de datos.

### 3. Listar todos los autores
Devuelve una lista de todos los autores registrados en la base de datos.

### 4. Listar autores vivos en un año específico
Utiliza consultas derivadas en JPA para encontrar autores que estaban vivos en un año determinado.

### 5. Estadísticas
Calcula y muestra la cantidad de libros disponibles en la base de datos por idioma utilizando Streams de Java.

---

## Configuración del proyecto

### Base de datos

1. Crea una base de datos en PostgreSQL:
   ```sql
   CREATE DATABASE literaluradb;
   ```
2. Configura las credenciales en el archivo `application.properties`:

   ```properties
   spring.datasource.url=jdbc:postgresql://localhost:5432/literaluradb
   spring.datasource.username=postgres
   spring.datasource.password=Admin
   spring.jpa.hibernate.ddl-auto=update
   spring.jpa.show-sql=true
   ```

### Dependencias
Asegúrate de incluir las siguientes dependencias en tu archivo `pom.xml`:

```xml
<dependencies>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-data-jpa</artifactId>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>
    <dependency>
        <groupId>org.postgresql</groupId>
        <artifactId>postgresql</artifactId>
    </dependency>
    <dependency>
        <groupId>com.fasterxml.jackson.core</groupId>
        <artifactId>jackson-databind</artifactId>
    </dependency>
</dependencies>
```

---

## Estructura del proyecto

```plaintext
src/main/java/com/alura/literalura
├── dto
│   ├── AutorDTO.java
│   ├── LibroDTO.java
│   └── EstadisticaDTO.java
├── entity
│   ├── Autor.java
│   └── Libro.java
├── repository
│   ├── AutorRepository.java
│   └── LibroRepository.java
├── service
│   ├── AutorService.java
│   └── LibroService.java
├── principal
│   └── Main.java
└── LiteraluraApplication.java
```

---

## Ejecución del proyecto

1. Compila el proyecto usando Maven:
   ```bash
   mvn clean install
   ```

2. Inicia la aplicación ejecutando la clase `LiteraluraApplication`:
   ```bash
   mvn spring-boot:run
   ```

3. Interactúa con el sistema desde la consola. Las opciones del menú principal son:
   - Buscar un libro por título.
   - Listar todos los libros.
   - Listar todos los autores.
   - Listar autores vivos en un año específico.
   - Mostrar estadísticas.

---

## Fuentes de datos
La aplicación utiliza la API de Gutendex para obtener información sobre libros y autores:
- Documentación: [https://gutendex.com/books/](https://gutendex.com/books/)
- Ejemplo de consulta:
  ```plaintext
  https://gutendex.com/books/?search=Anne%20of%20Green%20Gables
  ```

---

## Pruebas

Asegúrate de realizar pruebas completas para:
- Manejar entradas inválidas del usuario.
- Verificar que los libros y autores se guarden correctamente en la base de datos.
- Probar las funcionalidades de las consultas derivadas y estadísticas.

---

## Contribuciones
Si deseas contribuir a este proyecto, por favor abre un issue o un pull request en el repositorio.

---

## Licencia
Este proyecto se encuentra bajo la licencia MIT. Puedes ver los detalles en el archivo `LICENSE`.


 

package clase13_stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Clase0_13_Stream {
 public static void main(String[] args) {

        // Creamos una lista de cursos con espacios innecesarios al final de cada palabra
        List<String> courseList = new ArrayList<>(List.of(
            "Java ", "Frontend ", "Backend ", "FullaStack "
        ));

        //  Primer bucle: transformamos los cursos a minúsculas y reemplazamos espacio por ||
        for (String c : courseList) {
            String newCourse = c
                .toLowerCase()   
                .replace(" ", "||");  // reemplaza espacios por "||"

            System.out.println("Platzi " + newCourse); 
            // Platzi java||
            // Platzi frontend||
            // Platzi backend||
            // Platzi fullastack||
        }

        // Los streams una vez usados no se pueden volver a consumir
        
        // Así que lo volvemos a crear aquí abajo
        Stream<String> coursesStream = Stream.of("Java ", "Frontend ", "Backend ", "FullaStack ");

        // map transforma cada curso y le agrega un "!" al final
        Stream<String> emphasizedCourses = coursesStream.map(c -> c + "!");

        // Imprime los cursos con "!" al final
        emphasizedCourses.forEach(System.out::println);
        // Java !
        // Frontend !
        // Backend !
        // FullaStack !

        // Chaining de operaciones intermedias y finales en stream
        courseList.stream()
            .map(course -> course.toLowerCase())          // convierte a minúsculas
            .filter(c -> c.contains("java"))              // filtra los que contienen "java"
            .map(c -> c.toUpperCase() + "!!")             // los convierte a mayúsculas y añade "!!"
            .forEach(System.out::println);
        // Imprime:
        // JAVA!!

        // operaciones intermedias vs. finales
        // - map, filter, peek son intermedias porque devuelven un Stream
        // - forEach, collect, count, reduce son finales porque terminan el stream

        // Ejemplo de operación intermedia: peek
        // peek permite espiar el contenido en medio de un stream
        courseList.stream()
            .peek(c -> System.out.println("Espiando: " + c)) // solo imprime, no modifica
            .collect(Collectors.toList());  // operación final que recolecta el stream
        // Imprime:
        // Espiando: Java 
        // Espiando: Frontend 
        // Espiando: Backend 
        // Espiando: FullaStack 
    }
}

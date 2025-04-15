package clase7_analisis_inferencia;

import java.util.List;
import java.util.function.Function;

public class Clase0_7_Analisis_Inferencia {
    public static void main(String[] args) {
        
        // Inferencia de tipos en Java con la palabra clave "var"
        var nombre = "Juan";   // Se infiere que es de tipo String
        var edad = 25;         // Se infiere que es de tipo int
        var altura = 1.75;     // Se infiere que es de tipo double

        // Impresión de variables inferidas
        System.out.println("Nombre: " + nombre);
        System.out.println("Edad: " + edad);
        System.out.println("Altura: " + altura);
        System.out.println("-------------------------------------");

        // Uso de una función lambda con tipo genérico
        Function<Integer, String> funcionConvertidora = 
            nentero -> "Resultado: " + (nentero * 2);

        // Aplicar la función a un número
        System.out.println(funcionConvertidora.apply(10)); // Resultado: 20

        // Lista de alumnos usando List.of()
        List<String> alumnos = List.of("Juan", "Pedro", "Gaby");

        // Forma 1: forEach con lambda
        alumnos.forEach(alu -> System.out.println("Alumno: " + alu));

        // Forma 2: forEach con método de referencia
        alumnos.forEach(System.out::println);
        

        //Nota
        // El compilador infiere automáticamente los tipos de variables y parámetros
        // Esto hace que el código sea más limpio y legible
    }
}

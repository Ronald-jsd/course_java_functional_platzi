package clase4_bifunction_unary_binary;

import java.util.List;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.UnaryOperator;

public class BiFunctionExample {
    public static void main(String[] args) {
        
        // BiFunction<T, U, R> es una interfaz funcional que toma dos argumentos y devuelve un resultado.
        // T: puede ser cualquier tipo de dato, como Integer, String, etc.
        // U: puede ser cualquier tipo de dato, como Integer, String, etc.
        // R: puede ser cualquier tipo de dato, como Integer, String, etc.
        // Se utiliza para representar una función que acepta dos argumentos y produce un resultado.
        // Se puede utilizar para realizar operaciones en dos valores de entrada y devolver un resultado.
        // Para ejecutar BiFunction: .apply(arg1, arg2), donde arg1 y arg2 son los argumentos de entrada de tipo T y U respectivamente, y el resultado es de tipo R.

        // Ejemplo 1: Realizar una suma de dos números enteros
        BiFunction<Integer, Integer, Integer> suma = (a, b) -> a + b;
        System.out.println("La suma de 5 y 10 es: " + suma.apply(5, 10)); // Salida: La suma de 5 y 10 es: 15

        // Ejemplo 2: Uso de BiFunction con cadenas (concatenar)
        BiFunction<String, String, String> concatenar = (a, b) -> a + b;
        System.out.println("La concatenación de 'Hola' y ' Mundo' es: " + concatenar.apply("Hola", " Mundo")); // Salida: La concatenación de 'Hola' y ' Mundo' es: Hola Mundo

        // Ejemplo 3: Uso de BiFunction con diferentes tipos de datos
        // Descripción: Realizar una multiplicación de dos números enteros y convertir el resultado a cadena
        BiFunction<Integer, Integer, String> multiplicar = (s1, s2) -> String.valueOf(s1 * s2);
        System.out.println("La multiplicación de 5 y 10 es: " + multiplicar.apply(5, 10)); // Salida: La multiplicación de 5 y 10 es: "50"

        // Ejemplo 4: Uso de BiFunction con una lista de formateadores de cadenas
        List<BiFunction<String, Integer, String>> formateadores = new java.util.ArrayList<>();
        formateadores.add((s, n) -> String.format("%s %d", s, n)); // Formato: "Hola 5"
        formateadores.add((s, n) -> String.format("%d %s", n, s)); // Formato: "5 Hola"

        // Uso: Recorrer la lista de formateadores y aplicar cada uno a una cadena y un número entero
        String cadena = "Hola";
        int numero = 5;

        for (BiFunction<String, Integer, String> fmt : formateadores) {
            System.out.println(fmt.apply(cadena, numero)); // Salida: "Hola 5" y "5 Hola"
        }

        // Ejemplos de otras interfaces funcionales

        /** UnaryOperator<T> */
        // Es una interfaz funcional que representa una operación que toma un solo argumento y devuelve un resultado del mismo tipo.
        // Es un caso especial de Function<T, R> donde T y R son del mismo tipo.
        // Usos: cuadrar, duplicar, convertir a mayúsculas, etc.
        // Para ejecutar UnaryOperator: .apply(arg), donde arg es el argumento de entrada de tipo T y el resultado es de tipo T.

        // Ejemplo: Realizar una operación de cuadrado de un número entero
        UnaryOperator<Double> cuadrado = n -> Math.pow(n, 2);
        System.out.println("El cuadrado de 5 es: " + cuadrado.apply(5.0)); // Salida: El cuadrado de 5 es: 25.0

        /** BinaryOperator<T> */
        // Es una interfaz funcional que representa una operación que toma dos argumentos del mismo tipo y devuelve un resultado del mismo tipo.
        // Ideal para operaciones binarias (sumar, restar, concatenar, etc.)
        // Devuelve un resultado del mismo tipo que los argumentos de entrada.
        // Para ejecutar BinaryOperator: .apply(arg1, arg2)

        // Ejemplo: Realizar una suma con BinaryOperator
        BinaryOperator<Integer> sumaBinario = (a, b) -> a + b;
        System.out.println("La suma de 5 y 10 es: " + sumaBinario.apply(5, 10)); // Salida: La suma de 5 y 10 es: 15
    }
}

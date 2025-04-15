package clase8_lambdas;

import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class Lambdas {

    public static void main(String[] args) {

        // Lambdas son funciones anónimas que se pueden usar para implementar interfaces funcionales
        // Una interfaz funcional es una interfaz que tiene un solo método abstracto
        // Una lambda es una forma concisa de escribir una implementación de una interfaz funcional
        // Una lambda se puede usar en lugar de una clase anónima que implementa una interfaz funcional
        // Una lambda se define con la siguiente sintaxis:
        // (parametros) -> { cuerpo de la lambda }

        // ------------------------------------------------------------
        // 1. Lambda que recibe un parámetro y realiza una operación simple
        // ------------------------------------------------------------
        Consumer<String> imprimirTexto = text -> System.out.println(text);
        imprimirTexto.accept("Hola Mundo"); // Salida: Hola Mundo

        // ------------------------------------------------------------
        // 2. Lambda que recibe dos parámetros y realiza una operación simple (suma)
        // ------------------------------------------------------------
        BiFunction<Integer, Integer, Integer> sumar = (a, b) -> a + b;
        System.out.println(sumar.apply(5, 3)); // Salida: 8

        // ------------------------------------------------------------
        // 3. Lambda que no recibe parámetros y realiza una operación simple
        // ------------------------------------------------------------
        Runnable imprimirTexto2 = () -> System.out.println("Hello world");
        imprimirTexto2.run(); // Salida: Hello world

        // ------------------------------------------------------------
        // 4. Lambda que recibe varios parámetros y realiza una operación simple (multiplicación)
        // ------------------------------------------------------------
        BiFunction<Integer, Integer, Integer> multiplicar = (a, b) -> a * b;
        System.out.println(multiplicar.apply(2, 3)); // Salida: 6 (no 15, corregido el comentario)

        // ------------------------------------------------------------
        // 5. Lambda que realiza varias operaciones y no retorna nada (solo imprime)
        // ------------------------------------------------------------
        Consumer<Integer> imprimirSuma = a -> System.out.println("La suma es: " + a);
        imprimirSuma.accept(12 + 10); // Salida: La suma es: 22 (comentario corregido)

        // ------------------------------------------------------------
        // 6. Lambda que realiza varias operaciones, imprime y retorna un valor
        // ------------------------------------------------------------
        BiFunction<Integer, Integer, Integer> sumarYMultiplicar = (a, b) -> {
            System.out.println("Sumando " + a + " y " + b);
            int resultado = a + b;
            System.out.println("Multiplicando * 2: ");
            return resultado * 2;
        };
        System.out.println("--> " + sumarYMultiplicar.apply(2, 3)); // Salida: Sumando 2 y 3, 10

        // ------------------------------------------------------------
        // 7. Lambda con tipado explícito de parámetros
        // ------------------------------------------------------------
        BiFunction<Integer, Integer, Integer> sumarConTipado = (Integer a, Integer b) -> a + b;
        System.out.println(sumarConTipado.apply(5, 3)); // Salida: 8

        // ------------------------------------------------------------
        // 8. Lambda que retorna un bloque de texto multilínea (HTML)
        // ------------------------------------------------------------
        Supplier<String> htmlSupplier = () -> ("<div class='movieSearch'>"
                + " <div class='movie-close'>"
                + "   <button class='movie-close-button'>"
                + "     <figure>"
                + "       <img src='src/images/close.png'>"
                + "     </figure>"
                + "   </button>"
                + " </div>"
                + "</div>");
        System.out.println(htmlSupplier.get());
        // Salida: <div class='movieSearch'>...</div>

        // ------------------------------------------------------------
        // 9. Lambda que no recibe parámetros y no retorna nada (solo imprime)
        // ------------------------------------------------------------
        Runnable imprimirHola = () -> System.out.println("Hola no recibo nada");
        imprimirHola.run(); // Salida: Hola no recibo nada

        Runnable imprimirNada = () -> {
            System.out.println("No recibo nada");
            System.out.println("No retorno nada");
        };
        imprimirNada.run(); 
        // Salida: 
        //No recibo nada        
        //No retorno nada
    }
}

package clase3_1_consumer_supplier;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class Supplier_o {
    public static void main(String[] args) {

        /*
         * =========================================
         * SUPPLIER: Qué es y para qué se usa
         * =========================================
         * - Interfaz funcional que no recibe parámetros.
         * - Devuelve un valor de tipo T (String, Integer, Double, etc).
         * - Método principal: get()
         * 
         *  Se usa para:
         * - Generar datos (números aleatorios, valores por defecto).
         * - Crear objetos.
         * - Obtener valores de una fuente externa.
         */

        /*
         * =========================================
         * Ejemplo 1: Supplier que retorna un mensaje
         * =========================================
         */
        Supplier<String> supplier = () -> "Hola, mundo!";
        String mensaje = supplier.get(); // Llama al método get()
        System.out.println(mensaje);     // Imprime: Hola, mundo!

        /*
         * =========================================
         * Ejemplo 2: Supplier que retorna número aleatorio entre 35 y 75
         * =========================================
         */
        Supplier<Integer> randomSupplier = () -> 35 + (int)(Math.random() * (75 - 35 + 1));
        System.out.println("Número aleatorio: " + randomSupplier.get());

        /*
         * =========================================
         * Ejemplo 3: Combinar Supplier + Consumer
         * =========================================
         * - Supplier genera un número aleatorio (double)
         * - Consumer recibe ese número y lo imprime
         */
        Supplier<Double> generador = () -> Math.random() * 100;

        Consumer<Double> mostrar = num ->
            System.out.println("Número generado: " + num);

        Double numeroRandom = generador.get(); // Ejecuta Supplier
        mostrar.accept(numeroRandom);          // Usa Consumer
    }
}

package clase3_1_consumer_supplier;

import java.util.function.Consumer;

public class ConsumerClase {
    public static void main(String[] args) {

        /*
         * =========================================
         * CONSUMER: Qué es y para qué se usa
         * =========================================
         * Consumer<T>: Interfaz funcional que representa una operación
         * que acepta un solo argumento de entrada tipo T y no devuelve nada.
         * 
         * - No retorna valores, solo ejecuta una acción (como imprimir).
         * - Se usa para procesar datos sin devolver resultado.
         * - Muy útil con listas, mapas, colecciones, Streams, etc.
         * - Método principal: accept(T t)
         */

        /*
         * =========================================
         * Ejemplo 1: Consumer con String
         * =========================================
         */

        // 1.1 Imprimir un mensaje
        Consumer<String> imprimir = mensaje -> System.out.println(mensaje);
        imprimir.accept("Hola, mundo!"); // Imprime: Hola, mundo!

        // 1.2 Imprimir un nombre en mayúsculas
        Consumer<String> imprimirMayuscula = nombre ->
            System.out.println("Nombre mayúscula: " + nombre.toUpperCase());
        imprimirMayuscula.accept("bienvenido"); // Imprime: BIENVENIDO

        /*
         * =========================================
         * Ejemplo 2: Consumer con Integer
         * =========================================
         */

        Consumer<Integer> imprimirNumero = numero ->
            System.out.println("Número: " + numero);
        imprimirNumero.accept(45); // Imprime: Número: 45

        /*
         * =========================================
         * Ejemplo 3: Consumer con objeto (Clase Persona)
         * =========================================
         */

        Consumer<Persona> imprimirNombre = persona ->
            System.out.println(persona.getNombre());

        Persona persona = new Persona("Juan", 25);
        imprimirNombre.accept(persona); // Imprime: Juan
    }

    /*
     * =========================================
     * Clase Persona (usada en ejemplo 3)
     * =========================================
     */
    static class Persona {
        private String nombre;
        private int edad;

        public Persona(String nombre, int edad) {
            this.nombre = nombre;
            this.edad = edad;
        }

        // Getters y Setters
        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public int getEdad() {
            return edad;
        }

        public void setEdad(int edad) {
            this.edad = edad;
        }
    }
}

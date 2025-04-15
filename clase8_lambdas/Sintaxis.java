package clase8_lambdas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Predicate;

public class Sintaxis {
    
    public static void main(String[] args) {
        
        // Lista de cursos con elementos
        List<String> lcursos = new ArrayList<>(Arrays.asList("Java", "Gabriel", "Angel", "Kiara"));
        
        // Imprimir los elementos de la lista usando lambda
        lcursos.forEach(c -> System.out.println(c));

        // Uso de ejemplo 1: Llamada a la interfaz ZeroArgumentos
        int resultadoZero = usarZero(() -> 2); // Debe devolver 2
        System.out.println("Resultado Zero: " + resultadoZero);

        // Uso de ejemplo 2: Llamada a Predicate
        boolean resultadoPredicate = usarPredicate(text -> text.isEmpty());
        System.out.println("El texto está vacío: " + resultadoPredicate);

        // Uso de ejemplo 3: Llamada a BiFunction
        int resultadoBifunction = usarBifunction((x, y) -> x + y); // Ejemplo de suma
        System.out.println("Resultado BiFunction (Suma): " + resultadoBifunction);
        
        // Uso de BiFunction con más lógica (impresión)
        int resultadoBifunction2 = usarBifunction((x, y) -> {
            System.out.println("Sumando " + x + " y " + y);
            return x + y;
        });
        System.out.println("Resultado BiFunction con lógica extra: " + resultadoBifunction2);
        
        // Uso de OperarNada
        usarNada(() -> {
            System.out.println("Hola Nada");
        });
    }

    // Ejemplo 1: Método que recibe una interfaz funcional ZeroArgumentos
    static int usarZero(ZeroArgumentos z) {
        return z.get();
    }

    // Definición de la interfaz funcional ZeroArgumentos
    @FunctionalInterface
    interface ZeroArgumentos {
        int get();
    }

    // Ejemplo 2: Método que recibe un Predicate
    static boolean usarPredicate(Predicate<String> predicado) {
        return predicado.test("Hola Mundo");
    }

    // Ejemplo 3: Método que recibe un BiFunction
    static int usarBifunction(BiFunction<Integer, Integer, Integer> operacion) {
        return operacion.apply(5, 3); // Llamada al método apply de BiFunction
    }

    // Ejemplo 4: Método que recibe una interfaz funcional OperarNada
    @FunctionalInterface
    interface OperarNada { 
        void nada();
    }

    static void usarNada(OperarNada operarNada) {
        operarNada.nada(); // Ejecuta la operación sin retorno
    }
}

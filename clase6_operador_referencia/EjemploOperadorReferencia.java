package clase6_operador_referencia;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class EjemploOperadorReferencia {

    // Método que usaremos como referencia personalizada
    public static void imprimir(String mensaje) {
        System.out.println(mensaje);
    }

    // Método genérico que genera una lista a partir de un número variable de elementos
    @SafeVarargs
    static <T> List<T> getList(T... elements) {
        return Arrays.asList(elements);
    }

    public static void main(String[] args) {
        // === Parte 1: Lista de nombres ===
        List<String> nombres = Arrays.asList("Ana", "Luis", "Pedro", "Lucía");

        System.out.println("== Parte 1: Uso con lista de nombres ==");

        // Forma 1: Expresión lambda
        System.out.println("Usando expresión lambda:");
        nombres.forEach(nombre -> System.out.println(nombre));

        // Forma 2: Operador de referencia con método existente
        System.out.println("Usando operador de referencia (System.out::println):");
        nombres.forEach(System.out::println);

        // Forma 3: Referencia a método personalizado
        System.out.println("Usando referencia a método personalizado (EjemploOperadorReferencia::imprimir):");
        nombres.forEach(EjemploOperadorReferencia::imprimir);

        // === Parte 2: Lista de profesores usando método genérico ===
        List<String> profesores = getList("Nicolas", "Ana", "Zulema");

        System.out.println("== Parte 2: Uso con lista de profesores ==");

        // Forma 1: Consumer con expresión lambda
        Consumer<String> printer = text -> System.out.println(text);
        System.out.println("Impresión usando Consumer (lambda):");
        profesores.forEach(printer);

        // Forma 2: Operador de referencia directo
        System.out.println("Impresión usando operador de referencia (System.out::println):");
        profesores.forEach(System.out::println);
    }
}

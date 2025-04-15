package clase5_sam;

import java.time.LocalDate;
import java.time.Period;
import java.util.function.Function;

public class SAM {

    // SAM (Single Abstract Method): una interfaz con un solo método abstracto.
    // Se usa para crear instancias funcionales con expresiones lambda.

    /*
    // Este es un ejemplo incorrecto de interfaz funcional:
    @FunctionalInterface
    interface BiConsumer {
        void accept1();             // Primer método abstracto

        // ERROR: No se permite otro método abstracto en una @FunctionalInterface
        // int accept2(int a, int b);
    }
    */

    // TriFunction1: Interfaz funcional personalizada que acepta 3 parámetros y devuelve un resultado.
    interface TriFunction1<T, U, V, R> {
        R apply(T t, U u, V v);
    }

    // TriFunction2: Misma idea, pero con anotación @FunctionalInterface
    @FunctionalInterface
    interface TriFunction2<T, U, V, R> {
        R apply(T t, U u, V v);
    }

    // Función para añadir ceros a números menores que 10 (para formato de fecha)
    static Function<Integer, String> addCeros = x -> x < 10 ? "0" + x : String.valueOf(x);

    public static void main(String[] args) {

        // -------------------------------
        // Ejemplo 1: Concatenar 3 enteros
        // -------------------------------
        TriFunction1<Integer, Integer, Integer, String> triFunction1 = 
            (a, b, c) -> a + " " + b + " " + c;

        System.out.println("Concatenación: " + triFunction1.apply(1, 2, 3));

        // -------------------------------
        // Ejemplo 2: Calcular edad
        // -------------------------------

        // Paso 1: Crear fecha de nacimiento a partir de día, mes y año
        TriFunction2<Integer, Integer, Integer, LocalDate> parseDate = 
            (day, month, year) -> LocalDate.parse(
                year + "-" + addCeros.apply(month) + "-" + addCeros.apply(day)
            );

        // Paso 2: Calcular la edad usando Period.between
        TriFunction2<Integer, Integer, Integer, Integer> calculateAge = 
            (day, month, year) -> Period.between(
                parseDate.apply(day, month, year),
                LocalDate.now()
            ).getYears();

        // Mostrar resultado
        System.out.println("La diferencia de años es: " + calculateAge.apply(10, 10, 2000));
    }
}

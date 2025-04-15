package clase1_function;
import java.util.function.Function;

public class FunctionClase {
    public static void main(String[] args) {

        System.out.println("FUNCIÓN TRADICIONAL:");
        System.out.println(square(4)); // Uso de función tradicional

        // Forma 1: Uso de Function con clase anónima
        System.out.println("\n🔹 Function con Clase Anónima:");
        Function<Integer, Integer> squareFunction = new Function<Integer, Integer>() {
            @Override
            public Integer apply(Integer x) {
                return x * x;
            }
        };
        System.out.println("5² = " + squareFunction.apply(5));
        System.out.println("6² = " + squareFunction.apply(6));

        // Forma 2: Uso de Function con Expresión Lambda
        System.out.println("\n🔹 Function con Lambda:");
        Function<Integer, Integer> squareFunction2 = x -> x * x;
        System.out.println("7² = " + squareFunction2.apply(7));

        // Ejemplo: Function que recibe un String y devuelve un String en mayúsculas
        System.out.println("\n🔹 String → String:");
        Function<String, String> toUpperCase = s -> s.toUpperCase();
        System.out.println("hola → " + toUpperCase.apply("hola")); // HOLA

        // Ejemplo: Function que recibe un String y devuelve su longitud
        System.out.println("\n🔹 String → Integer:");
        Function<String, Integer> stringLength = s -> s.length();
        System.out.println("\"Java\" tiene " + stringLength.apply("Java") + " letras");

        // Ejemplo: Function que convierte Integer a String
        System.out.println("\n🔹 Integer → String:");
        Function<Integer, String> intToString = i -> String.valueOf(i);
        System.out.println("10 → \"" + intToString.apply(10) + "\"");

        // Ejemplo: Function que determina si un número es par
        System.out.println("\n🔹 Integer → Boolean:");
        Function<Integer, Boolean> isEven = n -> n % 2 == 0;
        System.out.println("10 es par? " + isEven.apply(10)); // true
        System.out.println("11 es par? " + isEven.apply(11)); // false
    }

    // Función tradicional (no funcional)
    public static int square(int x) {
        return x * x;
    }
}

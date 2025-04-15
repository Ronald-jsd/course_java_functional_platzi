package repaso_function;
import java.util.function.Function;

public class FunctionResumen {
    public static void main(String[] args) {

        // 1️ DECLARAR UNA FUNCIÓN LAMBDA COMO VARIABLE
        // Se guarda una función anónima que calcula el cuadrado de un número en una variable.
        Function<Integer, Integer> cuadrado = x -> x * x;

        int resultado1 = cuadrado.apply(6);
        System.out.println("Resultado cuadrado de 6: " + resultado1);
        /*
         x = 6 (valor de entrada)
         x * x = 36 (operación aplicada)
         Resultado: 36
        */

        // ---------------------------------------------------------------------
        // 2️ USAR UNA FUNCIÓN QUE RECIBE OTRA FUNCIÓN COMO PARÁMETRO
        // Se pasa directamente una función lambda al método "operar".
        // La función lambda calcula el cuadrado del número recibido.
        int resultado2 = operar(5, x -> x * x);
        System.out.println("Resultado cuadrado de 5: " + resultado2);
        /*
         x = 5 (valor recibido en la función)
         x * x = 25 (operación aplicada)
         Resultado: 25
        */

        // ---------------------------------------------------------------------
        // 3️ USAR UNA FUNCIÓN ANÓNIMA DIRECTAMENTE (inline)
        // Se pasa una función lambda sin guardarla en una variable.
        // Esta función suma 10 al número recibido.
        int resultado3 = operar(5, x -> x + 10);
        System.out.println("Resultado de 5 + 10: " + resultado3);
        /*
         x = 5 (valor recibido)
         x + 10 = 15 (operación)
         Resultado: 15
        */

        calcularPromedio(x -> x + 10);

    }

    // FUNCIÓN QUE RECIBE OTRA FUNCIÓN COMO PARÁMETRO
    public static int operar(int x, Function<Integer, Integer> operacion) {
        // Aplica la función recibida al valor x y devuelve el resultado.
        return operacion.apply(x);
    }

    /*
     Explicación de la función operar:
     - Recibe un entero x.
     - Recibe una función que acepta un entero y devuelve un entero.
     - Aplica la función al valor x y retorna el resultado.
     Ejemplo: operar(5, x -> x * x) retorna 25.
    */
    public static void calcularPromedio(Function<Integer, Integer> funcion) {
        int resultado = funcion.apply(5);
        System.out.println("El resultado es: " + resultado);
    }







}

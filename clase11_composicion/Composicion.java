package clase11_composicion;

import java.util.function.Function;

public class Composicion {

    public static void main(String[] args) {

        // 1️ Función que multiplica un número por 3
        Function<Integer, Integer> multiplyBy3 = x -> x * 3;

        // 2️ Composición: primero suma 1 al número, luego multiplica por 3
        Function<Integer, Integer> addThenMultiplyBy3 = 
            multiplyBy3.compose(y -> {
                System.out.println("Le agregaré 1 a: " + y);
                return y + 1;
            });
        // compose: se ejecuta PRIMERO la función que suma 1, luego multiplyBy30
        // 3️ Composición adicional: luego de addThenMultiplyBy3, eleva al cuadrado el resultado
        Function<Integer, Integer> fullPipeline = 
            addThenMultiplyBy3.andThen(x -> {
                System.out.println("Le haré el cuadrado a: " + x);
                return x * x;
            });
        // andThen: primero se ejecuta addThenMultiplyBy3, y luego se aplica el cuadrado

        // 4️ Ejecutar las funciones y mostrar resultados
        System.out.println("Resultado de addThenMultiplyBy3 con entrada 2: " + addThenMultiplyBy3.apply(2));
        System.out.println("Resultado de fullPipeline con entrada 2: " + fullPipeline.apply(2));
    }
}

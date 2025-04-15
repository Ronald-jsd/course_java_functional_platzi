package clase13_stream;

import java.util.stream.IntStream;

public class TypeStream {
    public static void main(String[] args) {
        // Stream infinito que genera números enteros desde 0 en adelante
        IntStream infiniteStream = IntStream.iterate(0, x -> x + 1);

        // Limitamos el stream a 100 elementos, filtramos los pares y los mostramos
        System.out.println("--- Números pares del 0 al 99 ---");
        infiniteStream
            .limit(100)                  // Limita la secuencia a los primeros 100 números
            .filter(x -> x % 2 == 0)     // Filtra solo los números pares
            .forEach(System.out::println); // Imprime cada número

        // Ejemplo de uso de allMatch: Validamos que todos los números del 0 al 99 sean menores que 100
        boolean todosMenoresDe100 = IntStream.range(0, 100)
                                             .allMatch(x -> x < 100);
        System.out.println("\n¿Todos los números son menores que 100? " + todosMenoresDe100);

        // Ejemplo de uso de parallel() sin garantizar el orden
        System.out.println("\n--- Paralelo (sin orden) ---");
        IntStream.range(0, 100)
                 .parallel()               // Habilita procesamiento concurrente
                 .filter(x -> x % 2 == 0)  // Filtra los números pares
                 .forEach(System.out::println); // El orden de impresión será aleatorio

        // Nota: forEach() + parallel() no garantiza el orden, se puede usar forEachOrdered() para mantenerlo.

        // Ejemplo de uso de parallel() con forEachOrdered() para mantener el orden
        System.out.println("\n--- Paralelo con orden ---");
        IntStream.range(0, 100)
                 .parallel()               // Habilita procesamiento concurrente
                 .filter(x -> x % 2 == 0)  // Filtra los números pares
                 .forEachOrdered(System.out::println); // El orden se respeta
    }
}

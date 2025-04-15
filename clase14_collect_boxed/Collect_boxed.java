package clase14_collect_boxed;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Collect_boxed {
    public static void main(String[] args) {
        // Creamos un IntStream infinito que empieza en 0 y se incrementa de uno en uno
        IntStream infinitiIntStream = IntStream.iterate(0, x -> x + 1);

        // Aplicamos operaciones sobre el stream
        List<Integer> number = infinitiIntStream
            .limit(100)                   // Tomamos solo los primeros 100 números
            .filter(x -> x % 2 == 0)      // Nos quedamos solo con los pares
            .boxed()                      // Convertimos de IntStream a Stream<Integer>
            .collect(Collectors.toList()); // Recolectamos los elementos en una lista

        // Mostramos el resultado
        System.out.println(number);
    }
}

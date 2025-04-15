package clase12_optional;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class OptionalExample {

    // Método principal que valida y opera con datos usando Optional
    public static void main(String[] args) {

        // Obtener los nombres sin Optional
        List<String> names = getNames();
        if (names != null) {
            // Operar con nombres
            names.forEach(System.out::println);
        }

        // Usar Optional para manejar la lista de nombres de forma más funcional
        Optional<List<String>> optionalNames = getOptionalNames();
        if (optionalNames.isPresent()) {
            // Operar con nombres si están presentes
            optionalNames.get().forEach(System.out::println);
        } else {
            // No hay nombres
            System.out.println("No hay nombres disponibles");
        }

        // Hacerlo más funcional utilizando ifPresent para evitar null checks explícitos
        optionalNames.ifPresent(namesValue -> namesValue.forEach(System.out::println));

        // Uso de orElse para devolver una lista vacía si no está presente
        List<String> namesList = optionalNames.orElse(Collections.emptyList());
        System.out.println("Tamaño de la lista de nombres: " + namesList.size());

        // Ejemplo con Optional de String, manejo de valores nulos
        String name = null;
        System.out.println(Optional.ofNullable(name).orElse("Sin nombre")); // Devuelve "Sin nombre" si el valor es nulo

        // Ejemplo con Optional para obtener el jugador más valioso (si está disponible)
        String valuablePlayer = mostValuablePlayer().orElse("Sin jugador destacado");
        System.out.println("Jugador destacado: " + valuablePlayer);

        // Ejemplo con Optional para el artículo más caro, devuelve un valor por defecto si no está disponible
        System.out.println("Valor más caro: " + mostExpensiveItem());
    }

    // Método que retorna una lista vacía dentro de un Optional
    static Optional<List<String>> getOptionalNames() {
        List<String> namesList = new LinkedList<>();
        // Podemos devolver una lista vacía dentro de un Optional
        return Optional.of(namesList);
    }

    // Método que simula obtener el jugador más valioso, usando Optional
    static Optional<String> mostValuablePlayer() {
        String player = null; // Simulamos que no se encuentra el jugador
        return Optional.ofNullable(player); // Devuelve Optional.empty() si player es null
    }

    // Método para obtener el valor más caro, retorna un valor por defecto si no está disponible
    static int mostExpensiveItem() {
        return -1; // Retorna un valor por defecto
    }

    // Método que retorna una lista vacía directamente (sin Optional)
    static List<String> getNames() {
        // Aquí estamos devolviendo una lista vacía directamente (no un Optional)
        return Collections.emptyList();
    }

    // Método que simula obtener un jugador valioso de una base de datos, usa Optional
    static Optional<String> optionalValuablePlayer() {
        try {
            // Simulamos la obtención de un jugador de una base de datos
            return Optional.of("Alex"); // Si encontramos un jugador llamado "Alex"
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Optional.empty(); // Retorna un Optional vacío si ocurre una excepción
    }
}

package clase3_2_consumer_with_supplier;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class CLIArgumentsUtils {
    // Función que muestra el manual únicamente cuando la propiedad isHelp esté presente
    static void showHelp(CLIArguments cliArguments) {
        // Consumer para mostrar el manual si isHelp es true
        Consumer<CLIArguments> consumerHelper = cliarguments1 -> {
            if (cliarguments1.getIsHelp()) {
                System.out.println("Manual Solicitado");
            }
        };

        // Invocar la función consumerHelper con el objeto cliArguments
        consumerHelper.accept(cliArguments);
    }

    // Función rápida que nos provee de un objeto CLIArguments sin necesidad de instanciarlo manualmente
    static CLIArguments generateCLI() {
        Supplier<CLIArguments> generator = () -> new CLIArguments();
        return generator.get();
    }

    // Ejemplo de utilidad: Generar configuraciones bajo demanda
    // Crear objetos o configuraciones sin tener que proveer una configuración completa
    // En lugar de proporcionar un objeto predefinido, generamos la configuración solo cuando es necesario
}

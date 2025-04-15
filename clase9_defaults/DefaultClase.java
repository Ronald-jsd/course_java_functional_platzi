package clase9_defaults;

public class DefaultClase {
    
    // Interfaz con un método abstracto y un método default
    @FunctionalInterface
    interface StringOperation {
        // Método abstracto que devuelve un entero
        int getAmount();
        
        // Método default que imprime un texto varias veces
        default void operate(String texto) {
            int x = getAmount();
            while (x-- > 0) {
                System.out.println(texto); // Imprime el texto
            }
        }
    }

    // Segunda interfaz con un método abstracto y un método default
    @FunctionalInterface
    interface DoOperation {
        // Método abstracto que toma un texto
        void take(String text);

        // Método default que ejecuta el método 'take' múltiples veces
        default void execute(int x, String text) {
            while (x-- > 0) {
                take(text); // Llama al método 'take' con el texto
            }
        }
    }

    // Implementación de interfaces en el método main
    public static void main(String[] args) {
        // Instancia de StringOperation: Imprime 6 veces el texto
        StringOperation six = () -> 6;
        six.operate("Hola Mundo"); // Se imprime "Hola Mundo" 6 veces
        
        // Instancia de DoOperation: Imprime "platzi" una vez
        DoOperation operate = text -> System.out.println(text);
        operate.take("platzi");
        
        // Ejemplo adicional de 'execute' que imprime "Platzi" 3 veces
        operate.execute(3, "Platzi");
    }

    // Ejemplo de interfaz para realizar una consulta a la base de datos
    @FunctionalInterface
    interface DatabaseQuery {
        // Método abstracto para realizar la consulta
        String query(String sql);
        
        // Método default para mostrar el resultado de la consulta
        default void executeQuery(String sql) {
            String result = query(sql);
            System.out.println("Resultado de la consulta: " + result);
        }
    }

    public static void testDatabaseQuery() {
        // Ejemplo de implementación de la interfaz 'DatabaseQuery' con lambda
        DatabaseQuery dbQuery = sql -> {
            // Simula una consulta y devuelve un resultado
            if (sql.equals("SELECT * FROM users")) {
                return "Usuario1, Usuario2, Usuario3"; // Resultado simulado
            } else {
                return "Consulta no válida";
            }
        };
        
        // Ejecuta una consulta
        dbQuery.executeQuery("SELECT * FROM users");
    }
}

package clase3_2_consumer_with_supplier;

// Esta clase contendrá los componentes que se le pasarán por terminal a nuestro programa
public class CLIArguments {
    // Booleano que, cuando esté presente, lanzará el manual de la terminal
    // Si no está presente, continuará operando normalmente
    private boolean isHelp;

    // Método que devuelve el valor de la propiedad isHelp
    public boolean getIsHelp() {
        return isHelp;
    }

    // Se puede agregar un setter si se desea modificar el valor de isHelp
    public void setIsHelp(boolean isHelp) {
        this.isHelp = isHelp;
    }
}

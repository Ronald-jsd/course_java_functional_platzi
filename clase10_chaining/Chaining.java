package clase10_chaining;

public class Chaining {

    public static void main(String[] args) {
        // Ejemplo de StringBuilder
        StringBuilder sb = new StringBuilder("Hola ");
        sb.append("Mundo")
          .append("!")
          .append(" ")
          .append(2023)
          .append(" ")
          .append(3.14)
          .append(" ")
          .append(true);
        System.out.println(sb.toString()); // Imprime la cadena concatenada

        // Ejemplo de Chaining con clase personalizada
        Chainer chainer = new Chainer();
        chainer
            .sayhi()
            .sayBye(); // Encadenamiento de métodos

        // Almacenar resultados intermedios
        Chainer chainer2 = chainer.sayhi(); // Almacena el resultado de sayhi()
        Chainer chainer3 = chainer2.sayBye(); // Almacena el resultado de sayBye()
    }

    // Clase para demostrar el chaining
    static class Chainer {
        // Atributo para almacenar el mensaje
        private String message = "";

        // Método que imprime "Hola" y devuelve el objeto para el chaining
        public Chainer sayhi() {
            message += "Hola ";
            System.out.println(message); // Imprime el mensaje actual
            return this; // Retorna el objeto actual para encadenar el siguiente método
        }

        // Método que imprime "Adios" y devuelve el objeto para el chaining
        public Chainer sayBye() {
            message += "Adios ";
            System.out.println(message); // Imprime el mensaje actual
            return this; // Retorna el objeto actual para encadenar el siguiente método
        }

        // Método que muestra el mensaje final
        public void showMessage() {
            System.out.println("Mensaje final: " + message);
        }
    }
}

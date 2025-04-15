package clase2_predicate;
import java.util.function.Predicate;

public class PredicateClase {
    public static void main(String[] args) {

        // Predicate es una interfaz funcional que:
        // - Recibe un solo argumento (T)
        // - Devuelve un booleano
        // Sintaxis: Predicate<T>
        // Se usa para validaciones y condiciones (filtros, pruebas lógicas)

        //  Predicate con Integer
        Predicate<Integer> isParPredicate = n -> n % 2 == 0;
        System.out.println("¿3 es par? (Predicate): " + isParPredicate.test(3)); // false

        //  Predicate con String
        Predicate<String> isEmptyPredicate = s -> s.isEmpty();
        System.out.println("\n¿Cadena vacía? (Predicate): " + isEmptyPredicate.test("")); // true

        //  Predicate con clase personalizada
        Student student1 = new Student(6.0, "Ana");
        Student student2 = new Student(5.8, "Ana");

        Predicate<Student> isApproved = st -> st.getCalificacion() >= 5.9;
        System.out.println("¿6.0 está aprobada? " + isApproved.test(student1)); // true
        System.out.println("¿5.8 está aprobada? " + isApproved.test(student2)); // false

        //  Métodos útiles de Predicate

        // and(): combinar condiciones
        Predicate<Student> isApprovedAndIsAna = 
                    st -> st.getCalificacion() >= 5.9 && st.getNombre().equals("Ana");
        System.out.println("¿Aprobada y se llama Ana? " + isApprovedAndIsAna.test(student1)); // true

        // negate(): invierte el resultado del Predicate
        Predicate<Student> isNotApproved = isApproved.negate();
        System.out.println("¿6.0 no está aprobada? " + isNotApproved.test(student1)); // false
        System.out.println("¿5.8 no está aprobada? " + isNotApproved.test(student2)); // true
    }

    // Clase auxiliar Student
    static class Student {
        private double calificacion;
        private String nombre;

        public Student(double calificacion, String nombre) {
            this.calificacion = calificacion;
            this.nombre = nombre;
        }

        public double getCalificacion() {
            return calificacion;
        }

        public String getNombre() {
            return nombre;
        }
    }
}

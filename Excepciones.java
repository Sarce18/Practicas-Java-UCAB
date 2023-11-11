public class Excepciones {

    public static void Lanzar() {
        try {
            throw new NumberFormatException("Nueva excepcion a lanzar");
        } catch (NumberFormatException e) {
            throw e;
        }
    }

    public static void main(String[] args) {

        try {
            Persona objP = new Persona("Sebas", 5);
        } catch (EdadExcepcion e) {
            System.out.println(e.getMessage());
        }

        try {
            Lanzar();
        } catch (NumberFormatException e) {
            System.out.println("Nueva captura: " + e);
        }

        String[] arreglo = { "1", "dos", "3", "4", "5" };

        int i, suma = 0;

        try {
            for (i = 0; i < arreglo.length; i++)
                suma += Integer.parseInt(arreglo[i]);
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("La suma es: " + suma);
    }

}
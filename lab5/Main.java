package lab5;

public class Main {
    public static void main(String args[]) {
        Pila<Libro> pila = new Pila<Libro>(3);
        Libro libro1 = new Libro("El señor de los anillos", "J.R.R. Tolkien", "Libro");
        Libro libro2 = new Libro("El hobbit", "J.R.R. Tolkien", "Libro");
        Libro libro3 = new Libro("El silmarillion", "J.R.R. Tolkien", "Libro");

        pila.apilar(libro1);
        pila.apilar(libro2);
        pila.apilar(libro3);
        pila.apilar(libro3);

        Pila<Cartas> pila2 = new Pila<Cartas>(3);
        Cartas carta1 = new Cartas("Rojo", "2", "Corazones", "Carta");
        Cartas carta2 = new Cartas("Negro", "5", "Diamante", "Carta");
        Cartas carta3 = new Cartas("Negro", "K", "Pica", "Carta");

        pila2.apilar(carta1);
        pila2.apilar(carta2);
        pila2.apilar(carta3);

        Pila<Objeto> pila3 = new Pila<Objeto>(pila.getTamaño() + pila2.getTamaño());

        pila3 = pila3.mezcla(pila, pila2);

        pila3.mostrarElementos();
    }

}

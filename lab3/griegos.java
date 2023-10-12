package lab3;

public class griegos extends guerreros {

    // ------------ CONSTRUCTORES ------------

    public griegos() {
        super();
    }

    public griegos(String nombre, int edad, int fuerza, boolean herido, boolean muerto) {
        super(nombre, edad, fuerza, herido, muerto);
    }

    // -------------FIN CONSTRUCTORES------------

    // ------------ METODOS ------------

    public void imprimir() {
        super.imprimir();
        System.out.println("Soy un griego");
    }
}
package lab3;

public class troyanos extends guerreros {

    // ------------ CONSTRUCTORES ------------

    public troyanos() {
        super();
    }

    public troyanos(String nombre, int edad, int fuerza, boolean herido, boolean muerto) {
        super(nombre, edad, fuerza, herido, muerto);
    }

    // -------------FIN CONSTRUCTORES------------

    // ------------ METODOS ------------

    public void imprimir() {
        super.imprimir();
        System.out.println("Soy un troyano");
    }
}
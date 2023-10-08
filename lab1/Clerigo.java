package lab1;

public class Clerigo extends Personaje {

    String dios;

    // Constructores

    public Clerigo() {
        super();
    }

    public Clerigo(String nombre, String raza, String dios, int fuerza, int inteligencia, int puntosVM, int puntosVA) {
        super(nombre, raza, fuerza, inteligencia, puntosVM, puntosVA);
        this.dios = dios;
    }

    // Metodos

    public void curar(Personaje personaje) {
        if (personaje.getPuntosVA() < personaje.getPuntosVM()) {
            personaje.setPuntosVA(personaje.getPuntosVA() + 10);
        }
    }

    public void imprimir() {
        super.imprimir();
        System.out.println("Tipo de personaje: Clerigo");
        System.out.println("Dios: " + dios);

    }

}
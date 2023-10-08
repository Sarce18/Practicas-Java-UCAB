package lab1;

public class Mago extends Personaje {

    String[] hechizos;

    // Constructores

    public Mago() {
        super();
        hechizos = new String[4];
    }

    public Mago(String nombre, String raza, int fuerza, int inteligencia, int puntosVM, int puntosVA) {
        super(nombre, raza, fuerza, inteligencia, puntosVM, puntosVA);
        this.hechizos = new String[10];
        for (int i = 0; i < hechizos.length; i++) {
            hechizos[i] = "";
        }
    }

    // Metodos

    public void aprendeHechizo(String hechizo) {
        for (int i = 0; i <= hechizos.length; i++) {
            if (hechizos[i].equals("")) {
                hechizos[i] = hechizo;
                break;
            }
        }
    }

    public void lanzaHechizo(Personaje personaje, String hechizo) {

        personaje.setPuntosVA(personaje.getPuntosVA() - 10);

        for (int i = 0; i < hechizos.length; i++) {
            if (hechizos[i].equals(hechizo)) {
                hechizos[i] = "";
                break;
            }
        }
    }

    public void imprimir() {
        super.imprimir();
        System.out.println("Tipo de personaje: Mago");
        System.out.println("Hechizos disponibles: ");
        for (String hechizo : hechizos) {
            System.out.println(hechizo);
        }
    }

}

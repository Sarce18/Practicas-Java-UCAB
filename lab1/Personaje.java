package lab1;

public class Personaje {

    // Atributos
    private String nombre, raza;
    private int fuerza, inteligencia, puntosVM, puntosVA;

    // Constructores con o sin parametros

    public Personaje() {
        nombre = "";
        raza = "";
        fuerza = 0;
        inteligencia = 0;
        puntosVM = 0;
        puntosVA = 0;
    }

    public Personaje(String nombre, String raza, int fuerza, int inteligencia, int puntosVM, int puntosVA) {
        this.nombre = nombre;
        this.raza = raza;
        this.fuerza = fuerza;
        this.inteligencia = inteligencia;
        this.puntosVM = puntosVM;
        this.puntosVA = puntosVA;
    }

    // Metodos SET y GET

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public String getRaza() {
        return raza;
    }

    public void setFuerza(int fuerza) {
        this.fuerza = fuerza;
    }

    public int getFuerza() {
        return fuerza;
    }

    public void setInteligencia(int inteligencia) {
        this.inteligencia = inteligencia;
    }

    public int getInteligencia() {
        return inteligencia;
    }

    public void setPuntosVM(int puntosVM) {
        this.puntosVM = puntosVM;
    }

    public int getPuntosVM() {
        return puntosVM;
    }

    public void setPuntosVA(int puntosVA) {
        this.puntosVA = puntosVA;
    }

    public int getPuntosVA() {
        return puntosVA;
    }

    // Otros metodos

    public void imprimir() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Raza: " + raza);
        System.out.println("Fuerza: " + fuerza);
        System.out.println("Inteligencia: " + inteligencia);
        System.out.println("Puntos de vida: " + puntosVM + "/" + puntosVA);
    }

}

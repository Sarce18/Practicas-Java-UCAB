package ejerciciosalon;

public abstract class Empleados {

    private String nombre, apellido;
    private int numSS;

    public Empleados() {
        nombre = apellido = "";
        numSS = 0;
    }

    public Empleados(String nombre, String apellido, int numSS) {

        this.nombre = nombre;
        this.apellido = apellido;
        this.numSS = numSS;
    }

    // setters y getters

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setApellido(String apellido) {

        this.apellido = apellido;
    }

    public String getApellido() {
        return apellido;
    }

    public void setNumSS(int numSS) {
        this.numSS = numSS;
    }

    public int getNumSS() {
        return numSS;
    }

    // metodos

    public void imprimir() {
        System.out.println("Nombre: " + nombre + " \nApellido: " + apellido + "\nNumero de Seguro Social: " + numSS);
    }

    public abstract double calcularSalario();

}

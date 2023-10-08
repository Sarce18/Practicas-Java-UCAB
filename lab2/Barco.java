package lab2;

public class Barco {

    // ----------- ATRIBUTOS -------------

    private int eslora, anioFabricacion;
    private String matricula;

    // ----------- FIN ATRIBUTOS ---------

    // ----------- CONSTRUCTORES ---------

    public Barco() {
        this.matricula = "";
        this.eslora = 0;
        this.anioFabricacion = 0;
    }

    public Barco(String matricula, int eslora, int anioFabricacion) {
        this.matricula = matricula;
        this.eslora = eslora;
        this.anioFabricacion = anioFabricacion;
    }

    // ----------- FIN CONSTRUCTORES ---------

    // ----------- SET/GET -------------

    public String getMatricula() {
        return matricula;
    }

    public int getEslora() {
        return eslora;
    }

    public int getAnioFabricacion() {
        return anioFabricacion;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public void setEslora(int eslora) {
        this.eslora = eslora;
    }

    public void setAnioFabricacion(int anioFabricacion) {
        this.anioFabricacion = anioFabricacion;
    }

    // ----------- FIN SET/GET ---------

    // ----------- METODOS -------------

    public void imprimirDatos() {
        System.out.println("Matricula: " + matricula);
        System.out.println("Eslora: " + eslora);
        System.out.println("Año de fabricacion: " + anioFabricacion);
    }

    public int calcularModFuncion() {
        return eslora * 10 * 1200;
    };

}

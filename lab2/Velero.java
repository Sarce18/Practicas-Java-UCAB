package lab2;

public class Velero extends Barco {

    // ----------- ATRIBUTOS -------------

    private int numeroMastiles;

    // ----------- FIN ATRIBUTOS ---------

    // ----------- CONSTRUCTORES ---------

    public Velero() {
        super();
        this.numeroMastiles = 0;

    }

    public Velero(String matricula, int eslora, int anioFabricacion, int numeroMastiles) {
        super(matricula, eslora, anioFabricacion);
        this.numeroMastiles = numeroMastiles;
    }

    // ----------- FIN CONSTRUCTORES ---------

    // ----------- SET/GET -------------

    public int getNumeroMastiles() {
        return numeroMastiles;
    }

    public void setNumeroMastiles(int numeroMastiles) {
        this.numeroMastiles = numeroMastiles;
    }

    // ----------- FIN SET/GET ---------

    // ----------- METODOS -------------

    public void imprimirDatos() {
        super.imprimirDatos();
        System.out.println("Numero de mastiles: " + numeroMastiles);
    }

    public int calcularModFuncion() {
        return super.calcularModFuncion() + numeroMastiles;
    }

}

package lab2;

public class Deportivo extends Barco {

    // ----------- ATRIBUTOS -------------

    private int potenciaCV;

    // ----------- FIN ATRIBUTOS ---------

    // ----------- CONSTRUCTORES ---------

    public Deportivo() {
        super();
        this.potenciaCV = 0;
    }

    public Deportivo(String matricula, int eslora, int anioFabricacion, int potenciaCV) {
        super(matricula, eslora, anioFabricacion);
        this.potenciaCV = potenciaCV;
    }

    // ----------- FIN CONSTRUCTORES ---------

    // ----------- SET/GET -------------

    public int getPotenciaCV() {
        return potenciaCV;
    }

    public void setPotenciaCV(int potenciaCV) {
        this.potenciaCV = potenciaCV;
    }

    // ----------- FIN SET/GET ---------

    // ----------- METODOS -------------

    public void imprimirDatos() {
        super.imprimirDatos();
        System.out.println("Potencia en CV: " + potenciaCV);
    }

    public int calcularModFuncion() {
        return super.calcularModFuncion() + potenciaCV;

    }

}

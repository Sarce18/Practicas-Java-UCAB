package lab2;

public class Yate extends Deportivo {

    // ----------- ATRIBUTOS -------------

    private int numeroCamarotes;

    // ----------- FIN ATRIBUTOS ---------

    // ----------- CONSTRUCTORES ---------

    public Yate() {
        super();
        this.numeroCamarotes = 0;
    }

    public Yate(String matricula, int eslora, int anioFabricacion, int potenciaCV, int numeroCamarotes) {
        super(matricula, eslora, anioFabricacion, potenciaCV);
        this.numeroCamarotes = numeroCamarotes;
    }

    // ----------- FIN CONSTRUCTORES ---------

    // ----------- SET/GET -------------

    public int getNumeroCamarotes() {
        return numeroCamarotes;
    }

    public void setNumeroCamarotes(int numeroCamarotes) {
        this.numeroCamarotes = numeroCamarotes;
    }

    // ----------- FIN SET/GET ---------

    // ----------- METODOS -------------

    public void imprimirDatos() {

        super.imprimirDatos();
        System.out.println("Numero de camarotes: " + numeroCamarotes);
    }

    public int modFuncion() {

        return super.modFuncion() + numeroCamarotes;
    }

}

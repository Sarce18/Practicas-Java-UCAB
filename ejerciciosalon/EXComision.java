package ejerciciosalon;

public class EXComision extends Empleados {

    private double montoTotalVentas;
    private double porcentaje;

    // Constructores

    public EXComision() {
        super();
        porcentaje = 30;
    }

    public EXComision(String nombre, String apellido, int numSS, double montoTotalVentas) {
        super(nombre, apellido, numSS);
        this.montoTotalVentas = montoTotalVentas;
        porcentaje = 30;
    }

    // metodos

    public double calcularSalario() {

        return montoTotalVentas * (porcentaje / 100);

    }

    public void imprimir() {
        super.imprimir();
        System.out.println("Salario: $" + calcularSalario());
    }

}

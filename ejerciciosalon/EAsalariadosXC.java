package ejerciciosalon;

public class EAsalariadosXC extends Empleados {
    private double salario, montoTotalVentas, porcentaje;

    // Constructores

    public EAsalariadosXC() {
        super();
        salario = montoTotalVentas = porcentaje = 0;
    }

    public EAsalariadosXC(String nombre, String apellido, int numSS, double salario, double montoTotalVentas,
            double porcentaje) {
        super(nombre, apellido, numSS);
        this.salario = salario;
        this.montoTotalVentas = montoTotalVentas;
        this.porcentaje = porcentaje;
    }

    // metodos

    public double calcularSalario() {
        return salario + (montoTotalVentas * porcentaje / 100);
    }

    public void imprimir() {
        super.imprimir();
        System.out.println("Pago: $" + calcularSalario());
    }

}

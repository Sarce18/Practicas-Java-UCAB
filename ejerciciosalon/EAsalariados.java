package ejerciciosalon;

public class EAsalariados extends Empleados {

    private double salario;

    // Constructores

    public EAsalariados() {
        super();
        salario = 0;
    }

    public EAsalariados(String nombre, String apellido, int numSS, double salario) {
        super(nombre, apellido, numSS);
        this.salario = salario;

    }

    // metodos

    public double calcularSalario() {
        return salario;
    }

    public void imprimir() {
        super.imprimir();
        System.out.println("Salario: $" + salario);
    }

}

package ejerciciosalon;

public class EXHoras extends Empleados {

    private double salario, pagoXH, pagoXTE;
    int horasT, horasE;

    // Constructores

    public EXHoras() {
        super();
        horasT = horasE = 0;
    }

    public EXHoras(String nombre, String apellido, int numss, int horasT, double pagoXH, double pagoXTE) {

        super(nombre, apellido, numss);
        this.horasT = horasT;
        this.pagoXH = pagoXH;
        this.pagoXTE = pagoXTE;
        salario = 0;
        horasE = 0;
    }

    // metodos

    public double calcularSalario() {

        if (horasT > 40) {
            horasE = horasT - 40;
            horasT -= horasE;

            salario = (pagoXH * horasT) + (pagoXTE * horasE);
        } else {
            salario = pagoXH * horasT;
        }
        return salario;
    }

    public void imprimir() {
        super.imprimir();
        System.out.println("Salario: $" + salario);
    }
}

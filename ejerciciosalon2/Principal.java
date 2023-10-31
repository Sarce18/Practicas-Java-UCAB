package ejerciciosalon2;

public class Principal {

    public static void main(String[] args) {
        Estudiante est1 = new Estudiante("Luis", 20);

        PAR<Estudiante, Double> par1 = new PAR<Estudiante, Double>();

        par1.setLlave(est1);
        par1.setValor(9.5);

        par1.imprimir();
    }
}

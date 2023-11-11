package piscina;

public class principal {

    public static void main(String[] args) {
        Piscina p = new Piscina(100);
        try {
            p.llenar(50);
            p.vaciar(20);
            p.llenar(100);
            p.vaciar(200);
        } catch (PiscinaExcepcion e) {
            System.out.println(e.getMessage());
        }
    }

}

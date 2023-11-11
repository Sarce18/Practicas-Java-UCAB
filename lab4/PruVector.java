package lab4;

public class PruVector {
    /**
     * Método principal de prueba de la clase Vector
     */
    public static void main(String[] args) {
        // crea vector (1, 2, 3)
        Vector v3a = new Vector(3);
        v3a.cambiaComponente(0, 1);
        v3a.cambiaComponente(1, 2);
        v3a.cambiaComponente(2, 3);
        // crea vector (10, 20, 30)

        Vector v3b = new Vector(3);
        v3b.cambiaComponente(0, 10);
        v3b.cambiaComponente(1, 20);
        v3b.cambiaComponente(2, 30);

        Vector sumaV = new Vector(3);
        Vector v5 = new Vector(3);
        sumaV = v5.suma(v3a, v3b);

        sumaV.imprimir();

        Vector v6 = new Vector(3);

        v6 = v6.acumula(v3a);

    }
}
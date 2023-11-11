package piscina;

public class Piscina {

    private int nivel;
    public final int MAX_NIVEL;

    public Piscina(int max) {
        if (max < 0)
            max = 0;
        MAX_NIVEL = max;
    }

    public int getNivel() {
        return nivel;
    }

    public void vaciar(int cantidad) throws PiscinaExcepcion {
        if (cantidad < 0)
            throw new PiscinaExcepcion("Cantidad negativa");
        else if (nivel - cantidad < 0)
            throw new PiscinaExcepcion("Nivel bajo en la piscina");
        else
            nivel -= cantidad;

    }

    public void llenar(int cantidad) throws PiscinaExcepcion {
        if (cantidad < 0)
            throw new PiscinaExcepcion("Cantidad negativa");
        else if (nivel + cantidad > MAX_NIVEL)
            throw new PiscinaExcepcion("Desbordamiento");
        else
            nivel += cantidad;
    }

}

package lab5;

public class ExcepcionPilaLlena extends RuntimeException {

    public ExcepcionPilaLlena(String mensaje) {
        super(mensaje);
    }
}

package lab4almacen;

public class Elemento<G> {

    private int clave;
    private G objeto;

    public int getClave() {
        return clave;
    }

    public G getObjeto() {
        return objeto;
    }

    public void setClave(int clave) {
        this.clave = clave;
    }

    public void setObjeto(G objeto) {
        this.objeto = objeto;
    }
}

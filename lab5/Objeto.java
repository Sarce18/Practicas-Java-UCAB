package lab5;

public class Objeto {

    String tipoObjeto;

    public Objeto() {
        tipoObjeto = "";
    }

    public Objeto(String tipoObjeto) {
        this.tipoObjeto = tipoObjeto;
    }

    public String getTipoObjeto() {
        return tipoObjeto;
    }

    public void setTipoObjeto(String tipoObjeto) {
        this.tipoObjeto = tipoObjeto;
    }

    @Override
    public String toString() {
        return "Objeto [tipoObjeto=" + tipoObjeto + "]";
    }
}

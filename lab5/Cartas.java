package lab5;

public class Cartas extends Objeto {
    private String color;
    private String valor;
    private String pinta;

    public Cartas(String color, String valor, String pinta, String tipoObjeto) {
        super(tipoObjeto);
        this.color = color;
        this.valor = valor;
        this.pinta = pinta;

    }

    public String getColor() {
        return color;
    }

    public String getValor() {
        return valor;
    }

    public String getPinta() {
        return pinta;
    }

    public String toString() {
        return String.format("%s, %s, %s", color, valor, pinta);
    }

}

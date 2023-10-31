package ejerciciosalon2;

public class PAR<l, v> {
    private l llave;
    private v valor;

    public l getLlave() {
        return llave;
    }

    public v getValor() {
        return valor;
    }

    public void setLlave(l llave) {
        this.llave = llave;
    }

    public void setValor(v valor) {
        this.valor = valor;
    }

    public void imprimir() {
        System.out.println("Llave: " + llave + " Valor: " + valor);
    }
}
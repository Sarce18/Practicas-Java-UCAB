package lab4almacen;

public class Almacen {

    private Elemento[] elementos;
    private int numElementos;

    public Almacen(int tam) {
        elementos = new Elemento[tam];
        numElementos = 0;
    }

    public void guardarAlmacen(Elemento obj) {
        for (int i = 0; i < numElementos; i++) {
            if (elementos[i].getClave() == obj.getClave()) {
                System.out.println("Ya existe un elemento con esa clave");
                return;
            } else {
                elementos[numElementos] = obj;
                numElementos++;
            }
        }

    }

}

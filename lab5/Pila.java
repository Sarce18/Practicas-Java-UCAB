package lab5;

public class Pila<E> {
    private final int tamaño;
    private int superior;
    private E[] elementos;

    public Pila() {
        this(10); // tamaño predeterminado de la pila
    }

    public Pila(int s) {
        tamaño = s > 0 ? s : 10;
        superior = -1;
        elementos = (E[]) new Object[tamaño];
    }

    public void apilar(E valor) {
        try {
            elementos[++superior] = valor;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public E desapilar() {
        if (superior == -1) {
            throw new ExcepcionPilaVacia("La Pila está vacía, no se puede desapilar");
        }

        return elementos[superior--];
    }

    public boolean estaVacia() {
        return superior == -1;
    }

    public boolean estaLlena() {
        return superior == tamaño - 1;
    }

    public int getTamaño() {
        return tamaño;
    }

    public int getSuperior() {
        return superior;
    }

    public E[] getElementos() {
        return elementos;
    }

    public E getElemento(int posicion) {
        return elementos[posicion];
    }

    public void setSuperior(int superior) {
        this.superior = superior;
    }

    public void setElementos(E[] elementos) {
        this.elementos = elementos;
    }

    public Pila mezcla(Pila p, Pila q) {
        Pila<Objeto> pilaR = new Pila<Objeto>(p.getTamaño() + q.getTamaño());

        for (int i = 0; i < p.tamaño; i++) {
            pilaR.apilar((Objeto) p.getElemento(i));
            pilaR.apilar((Objeto) q.getElemento(i));
        }

        return pilaR;
    }

    public void mostrarElementos() {
        for (int i = 0; i <= superior; i++) {
            System.out.println(elementos[i]);
        }
    }
}

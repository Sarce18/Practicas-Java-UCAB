package lab4;

public class Vector {
    // componentes del vector
    private int[] componentes;

    /**
     * Constructor que crea un vector de la dimensión indicada, inicialmente con
     * todas sus
     * componentes a cero.
     *
     * @param dimension
     *                  El número de componentes del vector
     */
    public Vector(int dimension) {
        componentes = new int[dimension];
    }

    /**
     * Este método cambia la componente i-ésima del vector por el valor pasado *
     * como
     * argumento.
     *
     * @param pos
     *              El índice de la posición cuyo valor se va a cambiar.
     * @param valor
     *              El nuevo valor que le damos a la componente i-ésima del *
     *              vector.
     */
    public void cambiaComponente(int pos, int valor) {
        componentes[pos] = valor;
    }

    /**
     * Este método suma dos vectores y retorna el vector resultante.
     *
     * @param otroVector
     *                   El vector que se va a sumar con el vector actual.
     * @return
     *         El vector resultante de la suma.
     */
    public Vector suma(Vector v1, Vector v2) {

        Vector sumaR = new Vector(3);

        for (int i = 0; i < componentes.length; i++) {
            sumaR.cambiaComponente(i, v1.componentes[i] + v2.componentes[i]);
        }

        return sumaR;
    }

    public void imprimir() {
        for (int i = 0; i < componentes.length; i++) {
            System.out.println(componentes[i]);
        }
    }

}
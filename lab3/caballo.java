package lab3;

public class caballo {

    // ------------ ATRIBUTOS ------------

    private int cantMaxCaballo, cantGuerreros;
    private guerreros[] ejercito;

    // -------------FIN ATRIBUTOS------------

    // ------------ CONSTRUCTORES ------------

    public caballo() {
        cantMaxCaballo = 10;
        cantGuerreros = 0;
        ejercito = new guerreros[cantMaxCaballo];
    }

    public caballo(int cantMaxCaballo, int cantGuerreros) {
        this.cantMaxCaballo = cantMaxCaballo;
        this.cantGuerreros = cantGuerreros;
        ejercito = new guerreros[cantMaxCaballo];
    }

    // -------------FIN CONSTRUCTORES------------

    // ------------ SET/GET ------------

    public void setcantMaxCaballo(int cantMax) {
        this.cantMaxCaballo = cantMax;
    }

    public void setcantGuerreros(int cantGuerreros) {
        this.cantGuerreros = cantGuerreros;
    }

    public void setejercito(guerreros[] ejercito) {
        this.ejercito = ejercito;
    }

    public int getcantMaxCaballo() {
        return cantMaxCaballo;
    }

    public int getcantGuerreros() {
        return cantGuerreros;
    }

    public guerreros[] getejercito() {
        return ejercito;
    }

    // -------------FIN SET/GET------------

    // ------------ METODOS ------------

    public int agregarGuerrero(guerreros guerrero) {
        if (guerrero.getClass().getSimpleName().equals("griegos")) {
            if (cantGuerreros < cantMaxCaballo) {
                ejercito[cantGuerreros] = guerrero;
                cantGuerreros++;
                return cantGuerreros;
            } else {
                return -1;
            }
        } else {
            return -2;
        }
    }

    public int buscarGuerrero(String nombre) {
        int posicion = 0;
        boolean encontrado = false;
        while (posicion < cantGuerreros && !encontrado) {
            if (ejercito[posicion].getNombre().equals(nombre)) {
                encontrado = true;
            } else {
                posicion++;
            }
        }
        if (encontrado) {
            return posicion;
        } else {
            return -1;
        }
    }

    public int eliminarGuerrero(String nombre) {
        int posicion = buscarGuerrero(nombre);
        if (posicion != -1) {
            for (int i = posicion; i < cantGuerreros - 1; i++) {
                ejercito[i] = ejercito[i + 1];
            }
            cantGuerreros--;
            return cantGuerreros;
        } else {
            return -1;
        }
    }

    public void imprimir() {
        System.out.println("Guerreros del caballo: ");
        for (int i = 0; i < cantGuerreros; i++) {
            ejercito[i].imprimir();
        }
    }

}
package lab3;

public class guerreros {

    // ------------ ATRIBUTOS ------------

    private String nombre;
    private int edad, fuerza;
    private boolean herido, muerto;

    // -------------FIN ATRIBUTOS------------

    // ------------ CONSTRUCTORES ------------

    public guerreros() {

        nombre = "GuerreroX";
        edad = 15;
        fuerza = 1;
        herido = muerto = false;
    }

    public guerreros(String nombre, int edad, int fuerza, boolean herido, boolean muerto) {
        this.nombre = nombre;
        this.edad = edad;
        this.fuerza = fuerza;
        this.herido = herido;
        this.muerto = muerto;
    }

    // -------------FIN CONSTRUCTORES------------

    // ------------ SET/GET ------------

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setFuerza(int fuerza) {
        this.fuerza = fuerza;
    }

    public void setHerido(boolean herido) {
        this.herido = herido;
    }

    public void setMuerto(boolean muerto) {
        this.muerto = muerto;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public int getFuerza() {
        return fuerza;
    }

    public boolean getHerido() {
        return herido;
    }

    public boolean getMuerto() {
        return muerto;
    }

    // -------------FIN SET/GET------------

    // ------------ METODOS ------------

    public void crearCopiaGuerrero(guerreros guerrero, String nombre) {
        this.nombre = nombre;
        this.edad = guerrero.getEdad();
        this.fuerza = guerrero.getFuerza();
        this.herido = guerrero.getHerido();
        this.muerto = guerrero.getMuerto();
    }

    public void imprimir() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Edad: " + edad);
        System.out.println("Fuerza: " + fuerza);

        if (herido == true) {
            System.out.println("Herido: Si");
        } else {
            System.out.println("Herido: No");
        }

        if (muerto == true) {
            System.out.println("Muerto: Si");
        } else {
            System.out.println("Muerto: No");
        }
    }

    public void retirarse(guerreros guerrero) {
        if (guerrero.getClass().getSimpleName().equals("griegos")) {
            if (guerrero.getHerido() == true) {
                System.out.println("No se puede retirar, esta herido");
            } else if (guerrero.getMuerto() == true) {
                System.out.println("No se puede retirar, esta muerto");
            } else {
                System.out.println("Se ha retirado");
            }
        } else {
            System.out.println("El guerrero no es griego, no se puede retirar");
        }
    }

    public void atacar(guerreros guerrero) {
        if (guerrero.getHerido() == false) {
            guerrero.setHerido(true);
        } else if (guerrero.getMuerto() == false) {
            guerrero.setMuerto(true);
        }
    }

}
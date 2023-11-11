public class Persona {
    String nombre;
    int edad;

    public Persona(String nombre, int edad) throws EdadExcepcion {

        if (edad < 10 || edad > 30)
            throw new EdadExcepcion("Edad fuera de rango");
        else {
            this.nombre = nombre;
            this.edad = edad;
        }
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

}
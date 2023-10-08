package lab2;

public class Cliente {

    String nombre, dni;

    public Cliente() {
        super();
        this.nombre = "";
        this.dni = "";
    }

    public Cliente(String nombre, String dni) {
        this.nombre = nombre;
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDni() {
        return dni;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public void imprimirDatos() {
        System.out.println("Nombre: " + nombre);
        System.out.println("DNI: " + dni);
    }
}

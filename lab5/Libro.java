package lab5;

public class Libro extends Objeto {
    private String titulo;
    private String autor;

    public Libro(String titulo, String autor, String tipoObjeto) {
        super(tipoObjeto);
        this.titulo = titulo;
        this.autor = autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public String toString() {
        return String.format("%s, %s", titulo, autor);
    }

}

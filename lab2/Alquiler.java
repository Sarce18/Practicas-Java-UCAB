package lab2;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Alquiler {

    // ----------- ATRIBUTOS -------------

    private Date firstDate;
    private Date secondDate;
    private int posicionAmarre;
    private Barco barco;
    private Cliente cliente;

    // ----------- FIN ATRIBUTOS ---------

    // ----------- CONSTRUCTORES ---------

    public Alquiler() {
        posicionAmarre = 0;
        barco = null;
        firstDate = null;
        secondDate = null;
        cliente = null;
    }

    public Alquiler(int posicionAmarre, Date firsDate, Date seconDate, Barco barco, Cliente cliente) {
        this.posicionAmarre = posicionAmarre;
        this.barco = barco;
        this.firstDate = firsDate;
        this.secondDate = seconDate;
        this.cliente = cliente;
    }

    // ----------- FIN CONSTRUCTORES ---------

    // ----------- SET/GET -------------

    public Cliente getCliente() {
        return cliente;
    }

    public Date getfirstDate() {
        return firstDate;
    }

    public Date getsecondDate() {
        return secondDate;
    }

    public int getposicionAmarre() {
        return posicionAmarre;
    }

    public Barco getBarco() {
        return barco;
    }

    public void setgetposicionAmarre(int posicionAmarre) {
        this.posicionAmarre = posicionAmarre;
    }

    public void setBarco(Barco barco) {
        this.barco = barco;
    }

    public void setfirstDate(Date firstDate) {
        this.firstDate = firstDate;
    }

    public void setsecondDate(Date secondDate) {
        this.secondDate = secondDate;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    // ----------- FIN SET/GET ---------

    // ----------- METODOS -------------

    public void imprimirDatos() throws ClassNotFoundException {

        cliente.imprimirDatos();
        System.out.println("Tipo de barco: " + barco.getClass().getSimpleName());
        barco.imprimirDatos();
        System.out.println("Posicion de amarre: " + posicionAmarre);
        System.out.println("Fecha de alquiler: " + firstDate);
        System.out.println("Fecha de devolucion: " + secondDate);
        System.out.println("Dias de ocupacion: " + calcularDiasOcupacion());
    }

    // METODO PARA CALCULAR LOS DIAS DE OCUPACION

    public int calcularDiasOcupacion() {

        // SE LE DA FORMATO A LAS FECHAS
        long diff = secondDate.getTime() - firstDate.getTime();

        // SE CONVIERTE EL TIEMPO A DIAS

        TimeUnit time = TimeUnit.DAYS;

        // SE RETORNA EL TIEMPO EN DIAS
        return (int) time.convert(diff, TimeUnit.MILLISECONDS);

    }

    // METODO PARA CALCULAR EL ALQUILER

    public int calcularAlquiler() {

        // DETERMINANDO EL TIPO DE BARCO PARA CALCULAR EL ALQUILER

        if (barco instanceof Velero) {
            return calcularDiasOcupacion() * ((Velero) barco).modFuncion();
        } else if (barco instanceof Deportivo) {
            return calcularDiasOcupacion() * ((Deportivo) barco).modFuncion();
        } else if (barco instanceof Yate) {
            return calcularDiasOcupacion() * ((Yate) barco).modFuncion();
        } else {
            return calcularDiasOcupacion() * barco.calcularModFuncion();
        }

    }

}

package lab2;

//------------- EJERCICIO 2 -------------

/*En un puerto se alquilan amarres para barcos de distinto tipo. Para cada
ALQUILER se guarda el nombre y CI del cliente, las fechas inicial y final de
alquiler, la posición del amarre y el barco que lo ocupará.
Un BARCO se caracteriza por su matrícula, su eslora en metros y año de
fabricación.
Un alquiler se calcula multiplicando el número de días de ocupación (incluyendo
los días inicial y final) por un módulo función de cada barco (obtenido simplemente
multiplicando por 10 los metros de eslora) y por un valor fijo (1.200 Bs en la
actualidad).
Sin embargo ahora se pretende diferenciar la información de algunos tipos de
barcos: número de mástiles para veleros, potencia en CV para embarcaciones
deportivas a motor, potencia en CV y número de camarotes para yates de lujo.
El módulo de los barcos de un tipo especial se obtiene como el módulo normal
más:
 El número de mástiles para veleros
 La potencia en CV para embarcaciones deportivas a motor
 La potencia en CV más el número de camarotes para yates de lujo.
La App debe permitir ingresar alquilar un barco de cada tipo, mostrar sus datos y el alquiler a pagar por cada uno de ellos.
*/

//----------------- CODIGO -----------------

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) throws ParseException, ClassNotFoundException {
        Alquiler alquiler[] = new Alquiler[10];
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
        String nombre, matricula, cedula;
        int opcion, posicionAmarre, tipoBarco, eslora, anioFabricacion, i = 0;
        Scanner sc = new Scanner(System.in);

        // INICIO DEL CICLO

        do {

            // MENU PRINCIPAL
            System.out.println("Bienvenido a Playa Waikiki");
            System.out.println("Aqui podra alquilar amarres para su barco");
            System.out.println(
                    "Por favor, selecione una opcion: \n 1. Registrar alquiler \n 2. Mostrar alquileres \n 3. Salir");
            opcion = sc.nextInt();

            // SWITCH PARA LAS OPCIONES DEL MENU

            switch (opcion) {
                case 1:
                    Date firstDate = null, secondDate = null;
                    boolean salir = true, flagdate = true;

                    // PEDIR INFORMACION PARA EL ALQUILER

                    System.out.println("Ingrese el nombre del cliente: ");
                    nombre = sc.next();
                    System.out.println("Ingrese la cedula del cliente: ");
                    sc.nextLine();
                    cedula = sc.next();

                    while (flagdate) {

                        try {
                            sdf.setLenient(false);
                            System.out.println("Ingrese la fecha de inicio del alquiler (dd/mm/yyyy): ");
                            firstDate = sdf.parse(sc.next());
                            System.out.println("Ingrese la fecha de fin del alquiler (dd/mm/yyyy): ");
                            secondDate = sdf.parse(sc.next());

                            if (firstDate.compareTo(secondDate) > 0) {
                                System.out.println("La fecha de inicio no puede ser mayor a la fecha de fin");
                                continue;
                            } else {
                                flagdate = false;
                            }
                        } catch (ParseException e) {
                            System.out.println("Fecha invalida");
                            continue;
                        }

                    }

                    System.out.println("Ingrese la posicion del amarre: ");
                    posicionAmarre = sc.nextInt();

                    System.out.println("Ingrese la matricula del barco: ");
                    matricula = sc.next();

                    System.out.println("Ingrese la eslora del barco: ");
                    eslora = sc.nextInt();

                    System.out.println("Ingrese el año de fabricacion del barco: ");
                    anioFabricacion = sc.nextInt();

                    // MENU PARA PEDIR EL TIPO DE BARCO

                    while (salir) {
                        System.out.println(
                                "Ingrese el tipo de barco: \n 1. Velero \n 2. Deportivo \n 3. Yate \n 4. Otro");
                        tipoBarco = sc.nextInt();

                        // SWITCH PARA LOS TIPOS DE BARCO

                        switch (tipoBarco) {
                            case 1:

                                // PEDIR INFORMACION PARA EL VELERO

                                System.out.println("Ingrese el numero de mastiles: ");
                                int numMastiles = sc.nextInt();
                                alquiler[i] = new Alquiler(posicionAmarre, firstDate, secondDate,
                                        new Velero(matricula, eslora, anioFabricacion, numMastiles),
                                        new Cliente(nombre, cedula));
                                break;
                            case 2:

                                // PEDIR INFORMACION PARA EL DEPORTIVO

                                System.out.println("Ingrese la potencia en CV: ");
                                int potenciaCV = sc.nextInt();
                                alquiler[i] = new Alquiler(posicionAmarre, firstDate, secondDate,
                                        new Deportivo(matricula, eslora, anioFabricacion, potenciaCV),
                                        new Cliente(nombre, cedula));

                                break;
                            case 3:

                                // PEDIR INFORMACION PARA EL YATE

                                System.out.println("Ingrese la potencia en CV: ");
                                int potenciaCV2 = sc.nextInt();
                                System.out.println("Ingrese el numero de camarotes: ");
                                int numCamarotes = sc.nextInt();
                                alquiler[i] = new Alquiler(posicionAmarre, firstDate, secondDate,
                                        new Yate(matricula, eslora, anioFabricacion, potenciaCV2, numCamarotes),
                                        new Cliente(nombre, cedula));
                                break;
                            case 4:

                                // PEDIR INFORMACION PARA OTRO TIPO DE BARCO

                                alquiler[i] = new Alquiler(posicionAmarre, firstDate, secondDate,
                                        new Barco(matricula, eslora, anioFabricacion), new Cliente(nombre, cedula));
                                break;
                            default:

                                // MENSAJE DE ERROR

                                System.out.println("Opcion invalida");
                                break;
                        }
                        salir = false;
                    }
                    i++;
                    break;
                case 2:

                    // MOSTRAR LOS ALQUILERES

                    System.out.println("Por favor ingrese la cedula del cliente: ");
                    cedula = sc.next();

                    System.out.println("Los alquileres registrados con la cedula " + cedula + " son: ");

                    // FOR PARA RECORRER EL ARREGLO DE ALQUILERES

                    for (int j = 0; j < alquiler.length; j++) {

                        // CONDICION PARA MOSTRAR LOS ALQUILERES CON LA CEDULA INGRESADA

                        if (alquiler[j] != null) {
                            if (alquiler[j].getCliente().getDni().equals(cedula)) {
                                alquiler[j].imprimirDatos();

                                System.out.println("El precio del alquiler es: "
                                        + alquiler[j].calcularAlquiler() + " Bs");
                            }
                        }
                    }
                    break;
                case 3:

                    // MENSAJE DE DESPEDIDA

                    System.out.println("Gracias por usar nuestro servicio");
                    break;
                default:

                    // MENSAJE DE ERROR

                    System.out.println("Opcion invalida");
                    break;
            }
        } while (opcion != 3);
    }

}

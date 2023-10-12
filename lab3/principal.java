package lab3;

import java.util.Scanner;

public class principal {

    // -------------- CODIGO PRINCIPAL----------------

    public static void main(String[] args) {

        String nombre, nombreCaballo;
        int edad = 0, fuerza = 0, opcion = 0, cantGuerrerosCaballo, i = 0, bando, cantMaxGuerreros;
        guerreros[] ejercitos;
        Scanner scanner = new Scanner(System.in);
        caballo caballo;

        // INGRESANDO DATOS PARA INICIALIZAR CABALLO Y EJERCITOS

        System.out.println("Ingrese la cantidad maxima de guerreros en partida");
        cantMaxGuerreros = scanner.nextInt();

        System.out.println("Ingrese la cantidad maxima de guerreros que podra ocupar el caballo");
        cantGuerrerosCaballo = scanner.nextInt();

        caballo = new caballo(cantGuerrerosCaballo, 0);
        ejercitos = new guerreros[cantMaxGuerreros];

        // ---------- CICLO PRINCIPAL -------------------

        do {
            int flag1 = 0, flag2 = 0;

            // MENU PRINCIPAL

            System.out.println("Ingrese una opcion");
            System.out.println("1. Crear guerrero");
            System.out.println("2. Opciones de caballo");
            System.out.println("3. Opciones de guerrero");
            System.out.println("4. Salir");
            opcion = scanner.nextInt();

            // SWITCH DE OPCIONES

            switch (opcion) {
                case 1:

                    // SE VERIFICA SI SE PUEDEN CREAR MAS GUERREROS
                    if (i < ejercitos.length) {

                        // MENU DE CREACION DE GUERREROS

                        System.out.println("Ingrese una opcion");
                        System.out.println("1. Crear guerrero personalizado");
                        System.out.println("2. Crear guerrero por defecto");
                        System.out.println("3. Crear copia de guerrero");
                        opcion = scanner.nextInt();

                        // SWITCH DE OPCIONES DE CREACION DE GUERREROS

                        switch (opcion) {
                            case 1:

                                // INGRESANDO DATOS PARA CREAR GUERRERO PERSONALIZADO

                                System.out.println("Ingrese el nombre del guerrero");
                                nombre = scanner.next();

                                // SE VERIFICA QUE LA EDAD Y LA FUERZA ESTEN EN EL RANGO CORRECTO

                                while (flag1 == 0) {
                                    System.out.println("Ingrese la edad del guerrero");
                                    edad = scanner.nextInt();
                                    flag1 = comprobarEdad(edad);
                                }

                                while (flag2 == 0) {
                                    System.out.println("Ingrese la fuerza del guerrero");
                                    fuerza = scanner.nextInt();
                                    flag2 = comprobarFuerza(fuerza);
                                }

                                // SE VERIFICA EL BANDO DEL GUERRERO

                                System.out.println("Ingrese el bando del guerrero");
                                System.out.println("1. Griego");
                                System.out.println("2. Troyano");
                                bando = scanner.nextInt();

                                if (bando == 1) {
                                    ejercitos[i] = new griegos(nombre, edad, fuerza, false, false);
                                    i++;
                                } else if (bando == 2) {
                                    ejercitos[i] = new troyanos(nombre, edad, fuerza, false, false);
                                    i++;
                                }
                                break;

                            case 2:

                                // MENU DE CREACION DE GUERREROS POR DEFECTO

                                System.out.println("Ingrese el bando del guerrero");
                                System.out.println("1. Griego");
                                System.out.println("2. Troyano");
                                bando = scanner.nextInt();

                                // SE CREA EL GUERRERO POR DEFECTO

                                if (bando == 1) {
                                    ejercitos[i] = new griegos();
                                    i++;
                                } else if (bando == 2) {
                                    ejercitos[i] = new troyanos();
                                    i++;
                                }
                                break;

                            case 3:

                                // MENU DE CREACION DE COPIA DE GUERREROS

                                System.out.println("Ingrese el nombre del guerrero que desea copiar");
                                nombre = scanner.next();

                                System.out.println("Ingrese el nombre del nuevo guerrero");
                                String nombreNuevo = scanner.next();

                                // SE CREA LA COPIA DEL GUERRERO

                                for (int j = 0; j < i; j++) {

                                    // SE VERIFICA EL BANDO DEL GUERRERO

                                    if (ejercitos[j].getNombre().equals(nombre)) {
                                        if (ejercitos[j].getClass().getSimpleName().equals("griegos")) {
                                            ejercitos[i] = new griegos();
                                            ejercitos[i].crearCopiaGuerrero(ejercitos[j], nombreNuevo);
                                            i++;
                                        } else if (ejercitos[j].getClass().getSimpleName().equals("troyanos")) {
                                            ejercitos[i] = new troyanos();
                                            ejercitos[i].crearCopiaGuerrero(ejercitos[j], nombreNuevo);
                                            i++;
                                        }
                                    }

                                }
                                break;

                            default:
                                break;

                        }

                        // ----------------- FIN SWITCH DE OPCIONES DE CREACION DE GUERREROS
                        // ----------------------
                    } else {
                        System.out.println("No hay espacio para mas guerreros");
                    }
                    break;

                case 2:

                    // MENU DE OPCIONES DE CABALLO

                    System.out.println("Ingrese una opcion");
                    System.out.println("1. Agregar guerrero al caballo");
                    System.out.println("2. Eliminar guerrero del caballo");
                    System.out.println("3. Imprimir guerreros del caballo");
                    int opcion3 = scanner.nextInt();

                    // SWITCH DE OPCIONES DE CABALLO

                    switch (opcion3) {
                        case 1:

                            // SE PIDE EL NOMRE DEL GUERRERO QUE SE DESEA AGREGAR AL CABALLO

                            System.out.println("Ingrese el nombre del guerrero que desea agregar al caballo");
                            nombreCaballo = scanner.next();

                            // SE BUSCA EL GUERRERO EN EL ARREGLO DE GUERREROS

                            // SE VERIFICA SI EL GUERRERO ESTA EN EL CABALLO

                            if (caballo.buscarGuerrero(nombreCaballo) == -1) {
                                for (guerreros guerrero : ejercitos) {
                                    if (guerrero.getNombre().equals(nombreCaballo)) {

                                        // SE INTENTA AGREGAR EL GUERRERO AL CABALLO
                                        cantGuerrerosCaballo = caballo.agregarGuerrero(guerrero);

                                        // SE VERIFICA SI EL GUERRERO ES GRIEGO O SI EL CABALLO ESTA LLENO

                                        if (cantGuerrerosCaballo == -1) {
                                            System.out.println("El caballo esta lleno");
                                            break;
                                        } else if (cantGuerrerosCaballo == -2) {
                                            System.out.println("El guerrero no es griego");
                                            break;

                                        } else {
                                            System.out.println("El guerrero ha sido agregado al caballo");
                                            break;
                                        }
                                    }
                                }
                            } else {
                                System.out.println("El guerrero ya esta en el caballo");
                            }
                            break;
                        case 2:

                            // SE PIDE EL NOMBRE DEL GUERRERO QUE SE DESEA ELIMINAR DEL CABALLO

                            System.out.println("Ingrese el nombre del guerrero que desea eliminar del caballo");
                            nombreCaballo = scanner.next();

                            // SE INTENTA ELIMINAR EL GUERRERO DEL CABALLO

                            cantGuerrerosCaballo = caballo.eliminarGuerrero(nombreCaballo);

                            // SE VERIFICA SI EL GUERRERO ESTA EN EL CABALLO

                            if (cantGuerrerosCaballo == -1) {
                                System.out.println("El guerrero no esta en el caballo");
                            } else {
                                System.out.println("El guerrero se ha bajado del caballo");
                            }
                            break;
                        case 3:

                            // SE IMPRIMEN LOS GUERREROS DEL CABALLO
                            caballo.imprimir();
                            break;

                        default:
                            break;
                    }
                    break;
                // ----------------- FIN SWITCH DE OPCIONES DE CABALLO ----------------------
                case 3:

                    // MENU DE OPCIONES DE GUERRERO

                    System.out.println("Ingrese una opcion");
                    System.out.println("1. Atacar guerrero");
                    System.out.println("2. Retirar guerrero");
                    System.out.println("3. Imprimir guerreros");
                    int opcion4 = scanner.nextInt();

                    // SWITCH DE OPCIONES DE GUERRERO

                    switch (opcion4) {
                        case 1:

                            // SE PIDE EL NOMBRE DEL GUERRERO QUE SE DESEA ATACAR

                            System.out.println("Ingrese el nombre del guerrero que desea atacar");
                            nombre = scanner.next();

                            // SE BUSCA EL GUERRERO EN EL ARREGLO DE GUERREROS

                            for (guerreros guerrero : ejercitos) {
                                if (guerrero.getNombre().equals(nombre)) {

                                    // SE ATACA AL GUERRERO

                                    guerrero.atacar(guerrero);
                                    break;
                                }
                            }
                            break;
                        case 2:

                            // SE PIDE EL NOMBRE DEL GUERRERO QUE SE DESEA RETIRAR

                            System.out.println("Ingrese el nombre del guerrero que desea retirar");
                            nombre = scanner.next();

                            // SE BUSCA EL GUERRERO EN EL ARREGLO DE GUERREROS

                            for (guerreros guerrero : ejercitos) {
                                if (guerrero.getNombre().equals(nombre)) {

                                    // SE RETIRA AL GUERRERO

                                    guerrero.retirarse(guerrero);
                                    break;
                                }
                            }
                            break;
                        case 3:

                            // SE IMPRIMEN LOS GUERREROS

                            for (int j = 0; j < i; j++) {
                                ejercitos[j].imprimir();
                            }
                            break;

                        default:
                            break;

                    }
                    // ----------------- FIN SWITCH DE OPCIONES DE GUERRERO ----------------------
                default:
                    break;
            }
        } while (opcion != 5);

        // ----------------- FIN CICLO PRINCIPAL ----------------------

    }

    // -------------- FIN CODIGO PRINCIPAL----------------

    // -------------- METODOS----------------

    public static int comprobarEdad(int edad) {
        if (edad >= 5 && edad <= 60) {
            return 1;
        } else {
            System.out.println("La edad debe estar entre 5 y 60");
            return 0;
        }

    }

    public static int comprobarFuerza(int fuerza) {
        if (fuerza >= 1 && fuerza <= 10) {
            return 1;
        } else {
            System.out.println("La fuerza debe estar entre 5 y 10");
            return 0;
        }

    }
}
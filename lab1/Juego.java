package lab1;

import java.util.Scanner;
import javax.swing.JOptionPane;

public class Juego {

    // Metodo main

    public static void main(String[] args) {

        Personaje[] personajes;
        Scanner sc = new Scanner(System.in);
        int rondas = 0, i = 0, opcionMenu, opcionHechizo, cantJugador = 0, opcionhechizo, controndas = 1;
        String hechizo = "", objetivo = "";
        Mago mago;
        Clerigo clerigo;

        // Registro de jugadores

        personajes = registroJugadores();

        // Contar la cantidad de jugadores

        for (Personaje personaje : personajes) {
            cantJugador++;
        }

        // Inicio del juego

        System.out.println("Por favor indique cuantas rondas desea jugar: ");
        rondas = sc.nextInt();

        // Inicio de las rondas

        do {
            System.out.println("Ronda #" + controndas);
            System.out.println("Es el turno de:");

            // Seleccion de menu dependiendo del tipo de personaje

            if (personajes[i].getFuerza() <= 15) {
                mago = (Mago) personajes[i];
                mago.imprimir();
                System.out.println("Seleccione una opcion:");
                System.out.println("1. Atacar");
                System.out.println("2. Aprender hechizo");
                opcionMenu = sc.nextInt();

                // -----Opciones del mago------

                // Atacar

                if (opcionMenu == 1) {

                    // Seleccion de objetivo

                    objetivo = buscarObjetivo(cantJugador, i, personajes);

                    // Seleccion de hechizo

                    System.out.println("Seleccione hechizo de los que tiene disponible:");
                    for (int j = 0; j < mago.hechizos.length; j++) {
                        if (mago.hechizos[j] != "") {
                            System.out.println((j + 1) + ". " + mago.hechizos[j]);
                        }
                    }
                    opcionhechizo = sc.nextInt();

                    // Buscar el hechizo

                    for (int j = 0; j < mago.hechizos.length; j++) {
                        if (j + 1 == opcionhechizo) {
                            hechizo = mago.hechizos[j];
                            break;
                        }
                    }

                    // Ataque

                    for (int j = 0; j < cantJugador; j++) {
                        if (personajes[j].getNombre().equals(objetivo)) {
                            mago.lanzaHechizo(personajes[j], hechizo);
                            hechizo = "";
                        }
                    }

                    JOptionPane.showMessageDialog(null, "El personaje " + objetivo + " ha sido atacado");
                    JOptionPane.showMessageDialog(null, "El personaje " + objetivo + " ha perdido 10 puntos de vida");

                    // Si un personaje muere, se elimina del juego

                    for (int j = 0; j < cantJugador; j++) {
                        if (personajes[j].getPuntosVA() == 0) {
                            JOptionPane.showInputDialog("El personaje " + personajes[j].getNombre() + " ha muerto");
                            for (int k = j; k < cantJugador - 1; k++) {
                                personajes[k] = personajes[k + 1];
                            }
                            cantJugador--;
                        }
                    }
                }
                // Aprender hechizo
                else if (opcionMenu == 2) {
                    System.out.println("Hechizos disponibles para aprender: ");
                    System.out.println("1. bola de fuego");
                    System.out.println("2. rayo");
                    System.out.println("3. bola de hielo");
                    System.out.println("4. Veneno");
                    System.out.println("5. espada oscura");
                    System.out.println("6. lanza magica");
                    System.out.println("Seleccione el hechizo que desea aprender: ");
                    opcionHechizo = sc.nextInt();

                    // switch para aprender hechizo
                    switch (opcionHechizo) {
                        case 1:
                            mago.aprendeHechizo("bola de fuego");
                            break;
                        case 2:
                            mago.aprendeHechizo("rayo");
                            break;
                        case 3:
                            mago.aprendeHechizo("bola de hielo");
                            break;
                        case 4:
                            mago.aprendeHechizo("Veneno");
                            break;
                        case 5:
                            mago.aprendeHechizo("espada oscura");
                            break;
                        case 6:
                            mago.aprendeHechizo("lanza magica");
                            break;

                        default:
                            break;
                    }

                    JOptionPane.showMessageDialog(null, "El personaje " + personajes[i].getNombre()
                            + " ha aprendido el hechizo " + mago.hechizos[mago.hechizos.length - 1]);
                }
            }

            else if (personajes[i].getFuerza() >= 18) {
                clerigo = (Clerigo) personajes[i];
                clerigo.imprimir();
                System.out.println("Seleccione una opcion:");
                System.out.println("1. Curar");
                opcionMenu = sc.nextInt();

                // -----Opciones del clerigo------

                // Curar
                if (opcionMenu == 1) {

                    // Seleccion de objetivo

                    objetivo = buscarObjetivo(cantJugador, i, personajes);

                    // Curar

                    for (int j = 0; j < cantJugador; j++) {

                        // Buscar el personaje

                        if (personajes[j].getNombre().equals(objetivo)) {

                            // Verificar que no tenga la salud al maximo

                            if (personajes[j].getPuntosVA() < personajes[j].getPuntosVM()) {
                                clerigo.curar(personajes[j]);
                                JOptionPane.showMessageDialog(null,
                                        "El personaje " + objetivo + " ha obtenido 10 puntos de vida");
                            } else {
                                JOptionPane.showMessageDialog(null, "El personaje ya tiene la salud al maximo");
                            }
                        }
                    }
                }
            }

            // Cambio de turno

            i++;
            controndas++;

            // Si se llega al ultimo jugador, se vuelve al primero

            if (i == cantJugador) {
                i = 0;
            }

            // Se resta una ronda

            rondas--;

        } while (rondas > 0);

        // Fin del juego

        JOptionPane.showMessageDialog(null, "El juego ha terminado");

        System.out.println("Resultados finales: ");
        for (Personaje personaje : personajes) {
            personaje.imprimir();
        }
    }

    // Metodo para buscar el objetivo

    private static String buscarObjetivo(int cantJugador, int i, Personaje[] personajes) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Seleccione el objetivo:");
        for (int j = 0; j < cantJugador; j++) {
            if (j != i) {
                System.out.println((j + 1) + ". " + personajes[j].getNombre());
            }
        }
        int opcionJugador = sc.nextInt();

        // Buscar el personaje

        String objetivo = "";
        for (int j = 0; j < cantJugador; j++) {
            if (j + 1 == opcionJugador) {
                objetivo = personajes[j].getNombre();
                break;
            }
        }

        return objetivo;
    }

    // Metodo para registrar jugadores

    private static Personaje[] registroJugadores() {
        Scanner sc = new Scanner(System.in);
        int opcion, contJugadores, opcionraza;
        boolean flagClerigo = true, flagMago = true;
        String raza;

        // Registro de jugadores

        System.out.println("Bienvenido al juego del Señor de los Anillos");
        System.out.println("Por favor indique cuantos jugadores desea en el juego: ");
        contJugadores = sc.nextInt();
        Personaje[] personajes = new Personaje[contJugadores];

        // Seleccion de personaje para creacion

        for (int i = 0; i < contJugadores; i++) {

            System.out.println("Por favor seleccione una opcion:");
            System.out.println("1. Crear Mago");
            System.out.println("2. Crear Clerigo");
            opcion = sc.nextInt();

            // Creacion de personaje

            System.out.println("Por favor ingrese el nombre del jugador #" + (i + 1) + ":");
            String nombre = sc.next();
            System.out.println("Por favor ingrese la salud maxima del jugador #" + (i + 1) + "(maximo 100): ");
            int saludMaxima = sc.nextInt();
            System.out.println("Por favor seleccione la raza de su preferencia: ");
            System.out.println("1. Humano");
            System.out.println("2. Elfo");
            System.out.println("3. Enano");
            System.out.println("4. Orco");
            opcionraza = sc.nextInt();

            // Seleccion de raza

            switch (opcionraza) {
                case 1:
                    raza = "Humano";
                    break;
                case 2:
                    raza = "Elfo";
                    break;
                case 3:
                    raza = "Enano";
                    break;
                case 4:
                    raza = "Orco";
                    break;
                default:
                    raza = "Humano";
                    break;
            }

            // Mago

            if (opcion == 1) {
                do {
                    System.out.println("Por favor ingrese la fuerza del jugador #" + (i + 1)
                            + "(un mago puede tener un maximo de 15): ");
                    int fuerza = sc.nextInt();
                    System.out.println("Por favor ingrese la inteligencia del jugador #" + (i + 1)
                            + "(un mago puede tener entre 17 y 20):");
                    int inteligencia = sc.nextInt();
                    if ((fuerza <= 15) && (inteligencia >= 17 && inteligencia <= 20)) {
                        personajes[i] = new Mago(nombre, raza, fuerza, inteligencia, saludMaxima, saludMaxima);
                        flagMago = false;
                    } else {
                        System.out
                                .println("El mago debe tener una fuerza maxima de 15 y una inteligencia entre 17 y 20");
                    }
                } while (flagMago);
            }
            // Clerigo

            else if (opcion == 2) {
                System.out.println("Por favor ingrese el dios del jugador #" + (i + 1) + ": ");
                String dios = sc.next();

                // Verificar que el clerigo cumpla con los requisitos

                while (flagClerigo) {
                    System.out.println(
                            "Por favor ingrese la fuerza del jugador #" + (i + 1)
                                    + "(un clerigo puede tener entre 18 y 20): ");
                    int fuerza = sc.nextInt();
                    System.out.println("Por favor ingrese la inteligencia del jugador #" + (i + 1)
                            + "(Un clerigo puede tener entre 12 y 16): ");
                    int inteligencia = sc.nextInt();
                    if ((fuerza >= 18 && fuerza <= 20) && (inteligencia <= 16 && inteligencia >= 12)) {
                        flagClerigo = false;
                        personajes[i] = new Clerigo(nombre, raza, dios, fuerza, inteligencia, saludMaxima,
                                saludMaxima);
                    } else {
                        System.out.println(
                                "El clerigo debe tener una fuerza entre 18 y 20 y una inteligencia entre 12 y 16");
                    }
                }
            }

        }
        // Retornar arreglo de personajes
        return personajes;
    }
}

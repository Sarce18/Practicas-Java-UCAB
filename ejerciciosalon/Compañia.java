package ejerciciosalon;

/* Una compañía paga a sus empleados por semana. De los empleados se conoce
los siguientes datos: Nombre, Apellido y Num. Del seguro social. Los empleados
son de 4 tipos:
    a) Empleados Asalariados: Reciben un salario semanal fijo sin importar las horas trabajadas.
    b) Empleados por horas: Reciben un sueldo por hora y pago por tiempo extra por todas las horas trabajadas que excedan a 40 horas.
    c) Empleados por comisión : Reciben el 30% de sus ventas,
    d) Empleados asalariados por comisión: Reciben un salario base más un porcentaje de sus ventas.
La compañía desea poder imprimir los datos de los empleados y los ingresos
correspondientes según el tipo de empleado.
*/

import java.util.Scanner;

public class Compañia {

    public static void main(String[] args) {
        String nombre, apellido;
        int nss, opcion, opcionmenu;
        double salario, salarioHora, pagoXTE, montoTotalVentas, porcentaje;
        Scanner sc = new Scanner(System.in);

        do {
            // Menu de opciones

            System.out.println("Bienvenido al sistema de pago de FromSoftware");
            System.out.println("Seleccione una opcion: ");
            System.out.println("1. Ingresar datos de empleado.");
            System.out.println("2. Salir.");
            opcionmenu = sc.nextInt();

            // Ingreso de datos de empleado

            if (opcionmenu == 1) {
                System.out.println("Ingrese el nombre del empleado:");
                sc.nextLine();
                nombre = sc.nextLine();
                System.out.println("Ingrese el apellido del empleado:");
                apellido = sc.nextLine();
                System.out.println("Ingrese el numero de seguro social del empleado:");
                nss = sc.nextInt();

                // Menu de opciones de tipo de empleado

                System.out.println("Seleccione la opcion que corresponda al tipo de empleado: ");
                System.out.println("1. Empleado Asalariado.");
                System.out.println("2. Empleado por Horas.");
                System.out.println("3. Empleado por Comision.");
                System.out.println("4. Empleado Base mas Comision.");
                opcion = sc.nextInt();
                switch (opcion) {

                    // Ingreso de datos de empleado asalariado

                    case 1:
                        System.out.println("Ingrese el salario semanal del empleado:");
                        salario = sc.nextDouble();
                        EAsalariados easalariados = new EAsalariados(nombre, apellido, nss, salario);

                        easalariados.calcularSalario();
                        easalariados.imprimir();

                        break;

                    // Ingreso de datos de empleado por horas

                    case 2:
                        System.out.println("Ingrese el salario por hora del empleado:");
                        salarioHora = sc.nextDouble();
                        System.out.println("Ingrese el numero de horas trabajadas por el empleado en la semana:");
                        int horasTrabajadas = sc.nextInt();
                        System.out.println("Ingrese el pago por horas extras del empleado:");
                        pagoXTE = sc.nextDouble();

                        EXHoras exhoras = new EXHoras(nombre, apellido, nss, horasTrabajadas, salarioHora, pagoXTE);

                        exhoras.calcularSalario();
                        exhoras.imprimir();
                        break;

                    // Ingreso de datos de empleado por comision

                    case 3:
                        System.out.println("Ingrese el monto total de ventas del empleado en la semana:");
                        montoTotalVentas = sc.nextDouble();
                        EXComision excomision = new EXComision(nombre, apellido, nss, montoTotalVentas);
                        excomision.imprimir();
                        break;

                    // Ingreso de datos de empleado base mas comision

                    case 4:
                        System.out.println("Ingrese el monto total de ventas del empleado en la semana:");
                        montoTotalVentas = sc.nextDouble();
                        System.out.println("Ingrese el salario base del empleado:");
                        salario = sc.nextDouble();
                        System.out.println("Ingrese el porcentaje de comision del empleado:");
                        porcentaje = sc.nextInt();
                        EAsalariadosXC easalariadosxc = new EAsalariadosXC(nombre, apellido, nss, salario,
                                montoTotalVentas,
                                porcentaje);
                        easalariadosxc.imprimir();
                        break;

                }
            }

            // Salida del programa

            else if (opcionmenu == 2) {
                System.out.println("Gracias por usar el sistema de pago de FromSoftware");
            } else {
                System.out.println("Opcion invalida, intente de nuevo.");
            }
        } while (opcionmenu != 2);
    }

}
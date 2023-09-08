package garageoop;

import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        Edificio edificio = Administrador.crearEdificio();

        int opcion;

        do {
            System.out.println("1. Meter vehículo");
            System.out.println("2. Sacar vehículo");
            System.out.println("3. Consultar plazas disponibles");
            System.out.println("4. Consultar dónde he aparcado mi vehículo");
            System.out.println("Salir");

            System.out.println("Introduce una opción: ");
            System.out.println(">>>");

            opcion = Integer.parseInt(teclado.nextLine());

            switch (opcion) {

                case 1:
                    Administrador.meterVehiculo(edificio);
                    break;

                case 2:Administrador.sacarVehiculo(edificio);
                    break;

                case 3:Administrador.opcionMenuVerdisponibles(edificio);
                    break;

                case 4:Administrador.opcionMenuDondeAparcado(edificio);
                    break;

                case 5:
                    System.out.println("Hasta luego!");
                    break;

                    default:
                        System.out.println("Opción incorrecta");
                        break;

            }
            System.out.println();


        } while (!Objects.equals(opcion, 5));

    }
}
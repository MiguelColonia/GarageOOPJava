package garageoop;

import java.util.ArrayList;
import java.util.Scanner;

public class Administrador {

    public static Edificio crearEdificio() {
        Edificio resultado = null;

        Scanner teclado = new Scanner(System.in);

        int numeroPlantas = 0;
        int numeroPlazas = 0;
        ArrayList<Planta> plantas = new ArrayList<>();

        System.out.println("Introduce el número de plantas: ");
        System.out.println(">>>");
        numeroPlantas = Integer.parseInt(teclado.nextLine());

        System.out.println("Introduce el número de plazas por planta: ");
        System.out.println(">>>");
        numeroPlazas = Integer.parseInt(teclado.nextLine());

        for (int i = 0; i < numeroPlantas; i++) {
            ArrayList<Plaza> plazas = new ArrayList<>();
            for (int j = 0; j < numeroPlazas; j++) {
                Plaza plaza = new Plaza(j, null);
                plazas.add(plaza);
            }
            Planta planta = new Planta(i, numeroPlazas, plazas);
            plantas.add(planta);
        }

        resultado = new Edificio(numeroPlantas, plantas);
        return resultado;
    }

    public static void meterVehiculo(Edificio edificio) {
        int totalPlazasDisponibles = consultarPlazasDisponibles(edificio);

        if (totalPlazasDisponibles == 0) {
            System.out.println("No hay plazas disponibles");
        } else {
            Scanner teclado = new Scanner(System.in);

            System.out.println("Dime la matrícula del vehículo: ");
            System.out.println(">>>");
            String matricula = teclado.nextLine();

            System.out.println("Es una moto o un coche? (m/c)");
            System.out.println(">>>");
            String tipoVehiculo = teclado.nextLine();

            boolean casco = false;
            Vehiculo vehiculoCliente;

            if (tipoVehiculo.equalsIgnoreCase("m")) {
                System.out.println("¿Lleva casco? (si/no)");
                String respuestaCasco = teclado.nextLine();

                if (respuestaCasco.equalsIgnoreCase("si")) {
                    casco = true;
                }

                vehiculoCliente = new Moto(matricula, " ", " ", 0, false, casco);
            } else {
                System.out.println("Tiene aire acondicionado? (si/no)");
                String respuestaAire = teclado.nextLine();
                boolean aire = false;

                if (respuestaAire.equalsIgnoreCase("si")) {
                    aire = true;
                }

                vehiculoCliente = new Coche(matricula, " ", " ", 0, false, aire);
            }

            int plantaConHueco = 0;
            int plazaConHueco = 0;
            boolean plazaEncontrada = false;

            int numeroPlantas = edificio.getNumeroPlantas();
            ArrayList<Planta> plantas = edificio.getPlantas();

            int i = 0;
            do {
                Planta planta = plantas.get(i);
                int numeroPlazas = planta.getNumeroPlazas();
                ArrayList<Plaza> plazas = planta.getPlazas();

                int j = 0;
                do {
                    Plaza plaza = plazas.get(j);
                    if (plaza == null) {
                        plazaEncontrada = true;
                        plantaConHueco = i;
                        plazaConHueco = j;
                    }
                    j++;
                } while (j < numeroPlazas && !plazaEncontrada);

                i++;
            } while (i < numeroPlantas && !plazaEncontrada);

            Planta planta = plantas.get(plantaConHueco);
            ArrayList<Plaza> plazas = planta.getPlazas();
            Plaza plaza = plazas.get(plazaConHueco);
            plaza.setVehiculoAparcado(vehiculoCliente);

            System.out.println("El vehículo se ha aparcado en la planta " + plantaConHueco + " y en la plaza " + plazaConHueco);
        }
    }

    public static void sacarVehiculo(Edificio edificio) {
        Scanner teclado = new Scanner(System.in);

        System.out.println("Dime en qué planta está el vehículo: ");
        System.out.println(">>>");
        int numeroPlanta = Integer.parseInt(teclado.nextLine());

        System.out.println("Dime en qué plaza está el vehículo: ");
        System.out.println(">>>");
        int numeroPlaza = Integer.parseInt(teclado.nextLine());

        ArrayList<Planta> plantas = edificio.getPlantas();

        Planta planta = plantas.get(numeroPlanta);
        ArrayList<Plaza> plazas = planta.getPlazas();
        Plaza plaza = plazas.get(numeroPlaza);

        Vehiculo vehiculo = plaza.getVehiculoAparcado();

        if (vehiculo == null) {
            System.out.println("No hay ningún vehículo en esa plaza");
        } else {
            plaza.setVehiculoAparcado(null);
            System.out.println("El vehículo con matrícula " + vehiculo.getMatricula() + " ha salido del garaje");
        }
    }

    public static int consultarPlazasDisponibles(Edificio edificio) {
        int resultado = 0;

        ArrayList<Planta> plantas = edificio.getPlantas();

        for (Planta planta : plantas) {
            int numeroPlazas = planta.getNumeroPlazas();
            ArrayList<Plaza> plazas = planta.getPlazas();

            for (Plaza plaza : plazas) {
                Vehiculo vehiculoAparcado = plaza.getVehiculoAparcado();

                if (vehiculoAparcado == null) {
                    resultado++;
                }
            }
        }

        return resultado;
    }

    public static void opcionMenuVerdisponibles(Edificio edificio) {
        Scanner teclado = new Scanner(System.in);

        System.out.println("Dime la matrícula del vehículo: ");
        String matriculaBuscada = teclado.nextLine();

        int plantaEncontrada = -1;
        int plazaEncontrada = -1;
        boolean encontrado = false;

        int numeroPlantas = edificio.getNumeroPlantas();
        ArrayList<Planta> plantas = edificio.getPlantas();

        for (int i = 0; i < numeroPlantas && !encontrado; i++) {
            Planta planta = plantas.get(i);
            ArrayList<Plaza> plazas = planta.getPlazas();

            for (int j = 0; j < plazas.size() && !encontrado; j++) {
                Plaza plaza = plazas.get(j);
                Vehiculo vehiculoAparcado = plaza.getVehiculoAparcado();

                if (vehiculoAparcado != null && vehiculoAparcado.getMatricula().equalsIgnoreCase(matriculaBuscada)) {
                    encontrado = true;
                    plantaEncontrada = i;
                    plazaEncontrada = j;
                }
            }
        }

        if (!encontrado) {
            System.out.println("El vehículo con matrícula " + matriculaBuscada + " no está en el garaje");
        } else {
            System.out.println("El vehículo con matrícula " + matriculaBuscada + " está en la planta " + plantaEncontrada + " y en la plaza " + plazaEncontrada);
        }
    }

    public static void opcionMenuDondeAparcado(Edificio edificio) {
        int totalPlazasDisponibles = Administrador.consultarPlazasDisponibles(edificio);

        if (totalPlazasDisponibles == 0) {
            System.out.println("No hay plazas disponibles");
        } else {
            System.out.println("Hay " + totalPlazasDisponibles + " plazas disponibles");
        }
    }

}



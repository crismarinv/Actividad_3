package ejercicio_3;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

public class Main {

	    public static void main(String[] args) {
	        Parqueadero parqueadero = new Parqueadero();
	        Scanner scanner = new Scanner(System.in);
	        int opcion;

	        do {
	            System.out.println("1. Ingresar un vehículo");
	            System.out.println("2. Registrar la salida de un vehículo");
	            System.out.println("3. Consultar estado del parqueadero");
	            System.out.println("4. Salir");
	            System.out.print("Elija una opción: ");
	            opcion = scanner.nextInt();

	            switch (opcion) {
	                case 1:
	                    ingresarVehiculo(parqueadero, scanner);
	                    break;
	                case 2:
	                    registrarSalida(parqueadero, scanner);
	                    break;
	                case 3:
	                    consultarEstado(parqueadero);
	                    break;
	                case 4:
	                    System.out.println("Saliendo del sistema...");
	                    break;
	                default:
	                    System.out.println("Opción inválida.");
	            }
	        } while (opcion != 4);
	    }

	    private static void ingresarVehiculo(Parqueadero parqueadero, Scanner scanner) {
	        System.out.print("Ingrese el tipo de vehículo (1. Automóvil, 2. Motocicleta, 3. Camión): ");
	        int tipo = scanner.nextInt();
	        scanner.nextLine(); // Consumir el salto de línea
	        System.out.print("Ingrese la placa: ");
	        String placa = scanner.nextLine();
	        System.out.print("Ingrese la marca: ");
	        String marca = scanner.nextLine();
	        System.out.print("Ingrese el modelo: ");
	        String modelo = scanner.nextLine();
	        LocalDateTime horaEntrada = LocalDateTime.now();

	        Vehiculo vehiculo;
	        switch (tipo) {
	            case 1:
	                System.out.print("Ingrese el tipo de combustible: ");
	                String tipoCombustible = scanner.nextLine();
	                vehiculo = new Automovil(placa, marca, modelo, horaEntrada, tipoCombustible);
	                break;
	            case 2:
	                System.out.print("Ingrese el cilindraje: ");
	                int cilindraje = scanner.nextInt();
	                vehiculo = new Motocicleta(placa, marca, modelo, horaEntrada, cilindraje);
	                break;
	            case 3:
	                System.out.print("Ingrese la capacidad de carga: ");
	                double capacidadCarga = scanner.nextDouble();
	                vehiculo = new Camion(placa, marca, modelo, horaEntrada, capacidadCarga);
	                break;
	            default:
	                System.out.println("Tipo de vehículo inválido.");
	                return;
	        }

	        parqueadero.registrarEntrada(vehiculo);
	    }

	    private static void registrarSalida(Parqueadero parqueadero, Scanner scanner) {
	        scanner.nextLine(); // Consumir el salto de línea pendiente
	        System.out.print("Ingrese la placa del vehículo que sale: ");
	        String placa = scanner.nextLine();
	        parqueadero.registrarSalida(placa);
	    }

	    private static void consultarEstado(Parqueadero parqueadero) {
	        List<Vehiculo> vehiculos = parqueadero.consultarEstado();
	        if (vehiculos.isEmpty()) {
	            System.out.println("No hay vehículos en el parqueadero.");
	        } else {
	            System.out.println("Vehículos en el parqueadero:");
	            for (Vehiculo vehiculo : vehiculos) {
	                System.out.println(vehiculo.getPlaca() + " - " + vehiculo.getMarca() + " " + vehiculo.getModelo());
	            }
	        }
	    }
	}

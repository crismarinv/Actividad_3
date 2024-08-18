package ejercicio_3;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Parqueadero {
    private List<Vehiculo> vehiculos = new ArrayList<>();
    
    // Tarifas por hora 
    
    private static final double TARIFA_MOTOCICLETA = 2000; // $2,000 pesos por hora
    private static final double TARIFA_AUTOMOVIL = 4000;   // $4,000 pesos por hora
    private static final double TARIFA_CAMION = 6000;      // $6,000 pesos por hora

    public void registrarEntrada(Vehiculo vehiculo) {
        vehiculos.add(vehiculo);
        System.out.println("Vehículo con placa " + vehiculo.getPlaca() + " ha ingresado al parqueadero.");
    }

    public double registrarSalida(String placa, String horaSalidaStr) {
        Vehiculo vehiculo = null;
        for (Vehiculo v : vehiculos) {
            if (v.getPlaca().equals(placa)) {
                vehiculo = v;
                break;
            }
        }

        if (vehiculo == null) {
            System.out.println("Vehículo no encontrado en el parqueadero.");
            return 0;
        }

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime horaSalida = LocalDateTime.parse(horaSalidaStr, formatter);
        long horasEstadia = (long) Math.ceil(Duration.between(vehiculo.getHoraEntrada(), horaSalida).toMinutes() / 60.0);

        double tarifaPorHora;
        if (vehiculo instanceof Automovil) {
            tarifaPorHora = TARIFA_AUTOMOVIL;
        } else if (vehiculo instanceof Motocicleta) {
            tarifaPorHora = TARIFA_MOTOCICLETA;
        } else if (vehiculo instanceof Camion) {
            tarifaPorHora = TARIFA_CAMION;
        } else {
            System.out.println("Tipo de vehículo desconocido.");
            return 0;
        }

        double costo = tarifaPorHora * horasEstadia;
        vehiculos.remove(vehiculo);
        System.out.println("Vehículo con placa " + placa + " salio del parqueadero.");
        System.out.println("Tiempo de estadía: " + horasEstadia + " horas.");
        System.out.println("Costo total: $" + costo);
        return costo;
    }
    public List<Vehiculo> consultarEstado() {
        return vehiculos;
        
        
    }
}
package ejercicio_3;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Parqueadero {
    private List<Vehiculo> vehiculos = new ArrayList<>();

    public void registrarEntrada(Vehiculo vehiculo) {
        vehiculos.add(vehiculo);
        System.out.println("Vehículo con placa " + vehiculo.getPlaca() + " ha ingresado al parqueadero.");
    }
    

    public double registrarSalida(String placa) {
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

        LocalDateTime horaSalida = LocalDateTime.now();
        long horasEstadia = Duration.between(vehiculo.getHoraEntrada(), horaSalida).toHours();
        if (Duration.between(vehiculo.getHoraEntrada(), horaSalida).toMinutesPart() > 0) {
            horasEstadia++;
        }

        double tarifa = calcularTarifa(vehiculo, horasEstadia);
        vehiculos.remove(vehiculo);
        System.out.println("Vehículo con placa " + placa + " ha salido del parqueadero. Costo: " + tarifa);
        return tarifa;
    }

    private double calcularTarifa(Vehiculo vehiculo, long horasEstadia) {
        double tarifaBase;
        if (vehiculo instanceof Automovil) {
            tarifaBase = 1000; // Tarifa por hora para Automóvil
        } else if (vehiculo instanceof Motocicleta) {
            tarifaBase = 500; // Tarifa por hora para Motocicleta
        } else if (vehiculo instanceof Camion) {
            tarifaBase = 2000; // Tarifa por hora para Camión
        } else {
            tarifaBase = 0;
        }
        return tarifaBase * horasEstadia;
    }

    public List<Vehiculo> consultarEstado() {
        return vehiculos;
    }
}
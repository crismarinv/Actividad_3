package ejercicio_3;

import java.time.LocalDateTime;


public class Herencia {
    public static void main(String[] args) {
        Vehiculo automovil = new Automovil("ABC123", "Toyota", "Corolla", LocalDateTime.now(), "Gasolina");
        Vehiculo motocicleta = new Motocicleta("XYZ987", "Yamaha", "R1", LocalDateTime.now(), 1000);
        Vehiculo camion = new Camion("LMN456", "Volvo", "FH16", LocalDateTime.now(), 15.5);

        System.out.println("Vehículo tipo Automóvil: " + automovil.getPlaca() + " - Tarifa: $" + automovil.calcularTarifa(2L));
        System.out.println("Vehículo tipo Motocicleta: " + motocicleta.getPlaca() + " - Tarifa: $" + motocicleta.calcularTarifa(2L));
        System.out.println("Vehículo tipo Camión: " + camion.getPlaca() + " - Tarifa: $" + camion.calcularTarifa(2L));
}
}

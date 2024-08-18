 package ejercicio_3;

 import java.time.LocalDateTime;

 public class Vehiculo {
     private String placa;
     private String marca;
     private String modelo;
     private String tipoCombustible;
     private LocalDateTime horaEntrada;
     public double calcularTarifa(long horasEstadia) {
		return horasEstadia;
	}
     
     public double calcularTarifa(int horasEstadia) {
         return calcularTarifa((long) horasEstadia);
     }

     public Vehiculo(String placa, String marca, String modelo, LocalDateTime horaEntrada) {
         this.placa = placa;
         this.marca = marca;
         this.modelo = modelo;
         this.horaEntrada = horaEntrada;
     }

     public String getPlaca() {
         return placa;
     }

     public void setPlaca(String placa) {
         this.placa = placa;
     }

     public String getMarca() {
         return marca;
     }

     public void setMarca(String marca) {
         this.marca = marca;
     }

     public String getModelo() {
         return modelo;
     }

     public void setModelo(String modelo) {
         this.modelo = modelo;
     }

     public LocalDateTime getHoraEntrada() {
         return horaEntrada;
     }

     public void setHoraEntrada(LocalDateTime horaEntrada) {
         this.horaEntrada = horaEntrada;
     }
     public String getTipoCombustible() {
         return tipoCombustible;
     }

     public void setTipoCombustible(String tipoCombustible) {
         this.tipoCombustible = tipoCombustible;
     }
 }
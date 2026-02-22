package ar.edu.unlp.info.oo2._Ejercicio9;

import java.time.LocalDate;

public class Reserva {
	private int cantidadDias;
	private LocalDate fecha;
	private Usuario conductor;
	private AutoEnAlquiler auto;
	
	public Reserva(int cantidadDias, Usuario conductor, AutoEnAlquiler auto) {
		this.cantidadDias = cantidadDias;
		this.fecha = LocalDate.now();
		this.conductor = conductor;
		this.auto = auto;
	}
	
	public double montoAPagar() {
		return auto.getPrecioPorDia() * this.cantidadDias;
	}
	
	public double montoAReembolsar(LocalDate fechaCancelacion) {
		return this.auto.montoAReembolsar(fecha, fechaCancelacion, this.montoAPagar());
	}
}

package ar.edu.unlp.info.oo2._Ejercicio14;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Alquiler extends Prenda {
	private LocalDate fechaInicio;
	private LocalDate fechaFin;
	private double costoMensual;
	
	public Alquiler(LocalDate fechaInicio, LocalDate fechaFin, double costoMensual) {
		super();
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.costoMensual = costoMensual;
	}

	public int calcularMesesRestantes() {
		return (int) ChronoUnit.MONTHS.between(fechaInicio, fechaFin);
	}
	
	@Override
	protected double getValor() {
		return this.calcularMesesRestantes() * this.costoMensual;
	}

	@Override
	protected double getLiquidez() {
		return 0.9;
	}

}

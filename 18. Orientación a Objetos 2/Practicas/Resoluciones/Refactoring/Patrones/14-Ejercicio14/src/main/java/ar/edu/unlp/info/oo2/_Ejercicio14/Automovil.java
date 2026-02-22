package ar.edu.unlp.info.oo2._Ejercicio14;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Automovil extends Prenda{
	private LocalDate modelo;
	private int kilometraje;
	private double costo0Km;
	
	public Automovil(LocalDate modelo, int kilometraje, double costo0Km) {
		super();
		this.modelo = modelo;
		this.kilometraje = kilometraje;
		this.costo0Km = costo0Km;
	}

	public int getAntiguedad() {
		return (int) ChronoUnit.YEARS.between(modelo, LocalDate.now());
	}
	
	@Override
	protected double getValor() {
		return this.costo0Km * (0.1 * this.getAntiguedad());
	}

	@Override
	protected double getLiquidez() {
		return 0.7;
	}

}

package ar.edu.unlp.info.oo2._Ejercicio9;

import java.time.LocalDate;

public class AutoEnAlquiler {
	private double precioPorDia;
	private int cantidadPlazas;
	private String marca;
	private PoliticaDeCancelacion politicaCancelacion;
	
	public AutoEnAlquiler(double precioPorDia, int cantidadPlazas, String marca, PoliticaDeCancelacion politicaCancelacion) {
        this.precioPorDia = precioPorDia;
        this.cantidadPlazas = cantidadPlazas;
        this.marca = marca;
        this.politicaCancelacion = politicaCancelacion;
    }
	
	public double getPrecioPorDia() {
		return this.precioPorDia;
	}
	
	public void setPoliticaCancelacion(PoliticaDeCancelacion politicaCancelacion) {
        this.politicaCancelacion = politicaCancelacion;
    }
	
	public double montoAReembolsar(LocalDate fechaInicio, LocalDate fechaCancelacion, double montoReembolso) {
		return this.politicaCancelacion.montoAReembolsar(fechaInicio, fechaCancelacion, montoReembolso);
	}
}

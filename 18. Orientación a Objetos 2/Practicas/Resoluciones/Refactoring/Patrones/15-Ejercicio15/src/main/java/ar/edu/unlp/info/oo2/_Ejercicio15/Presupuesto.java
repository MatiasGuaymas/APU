package ar.edu.unlp.info.oo2._Ejercicio15;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Presupuesto {
	private List<Componente> componentes;
	private String nombre;
	private LocalDate fechaRealizacion;
	
	public Presupuesto() {
		this.componentes = new ArrayList<>();
		this.fechaRealizacion = LocalDate.now();
	}
	
	public void add(Componente com) {
		this.componentes.add(com);
	}
	
	public void setProcesador(Componente com) {
		this.add(com);
	}
	
	public void setMemoriaRAM(Componente com) {
		this.add(com);
	}	
	public void setDisco(Componente com) {
		this.add(com);
	}
	
	public void setTarjetaGrafica(Componente com) {
		this.add(com);
	}
	public void setGabinete(Componente com) {
		this.add(com);
	}
	
	public double calcularConsumo() {
		return this.componentes.stream()
				.mapToDouble(comp -> comp.getConsumo())
				.sum();
	}
	
	public double calcularPrecio() {
		return this.componentes.stream()
				.mapToDouble(comp -> comp.getPrecio())
				.sum();	
	}
	
	public void setUsuario(String nombre) {
		this.nombre = nombre;
	}
}

package ar.edu.unlp.info.oo2._Ejercicio6;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Excursion {
	private String nombre;
	private LocalDate fechaInicio;
	private LocalDate fechaFin;
	private String puntoEncuentro;
	private double costo;
	private int cupoMinimo;
	private int cupoMaximo;
	private List<Usuario> inscriptosExcursion;
	private List<Usuario> esperaExcursion;
	private EstadoInscripcion estado;
	
	public Excursion(String nombre, LocalDate fechaInicio, LocalDate fechaFin, String puntoEncuentro,
			double costo, int cupoMinimo, int cupoMaximo) {
		this.nombre = nombre;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.puntoEncuentro = puntoEncuentro;
		this.costo = costo;
		this.cupoMinimo = cupoMinimo;
		this.cupoMaximo = cupoMaximo;
		this.inscriptosExcursion = new ArrayList<Usuario>();
		this.esperaExcursion = new ArrayList<Usuario>();
		this.estado = new Provisoria(this);
	}
	
	public void changeState(EstadoInscripcion estado) {
		this.estado = estado;
	}
	
	public EstadoInscripcion getState() {
		return this.estado;
	}
	
	public void agregarInscripto(Usuario unUsuario) {
		this.inscriptosExcursion.add(unUsuario);
	}
	
	public List<Usuario> getInscriptos() {
		return this.inscriptosExcursion;
	}
	
	public void agregarAEspera(Usuario unUsuario) {
		this.esperaExcursion.add(unUsuario);
	}
	
	public List<Usuario> getEnEspera() {
		return this.esperaExcursion;
	}
	
	public void inscribir (Usuario unUsuario) {
		this.estado.inscribir(unUsuario);
	}
	
	public String obtenerInformacion() {
		return this.estado.obtenerInformacion();
	}
	
	public String toString() {
		return "Nombre: " + this.nombre + "\n"
					+ "Costo: " + this.costo + "\n"
					+ "Fecha de Inicio: " + this.fechaInicio + "\n"
					+ "Fecha de Fin: " + this.fechaFin + "\n"
					+ "Punto de Encuentro: " + this.puntoEncuentro + "\n";
	}
	
	public String mailsDeInscriptos() {
		StringBuilder mails = new StringBuilder();
		this.inscriptosExcursion.stream()
		.forEach(usuario -> mails.append(usuario.getEmail()).append("\n"));
		return mails.toString();
	}

	public int cantFaltantesParaMinimo() {
		return this.cupoMinimo > this.inscriptosExcursion.size() ? this.cupoMinimo - this.inscriptosExcursion.size() : 0;
	}
	
	public boolean cumpleMinimoCuposInscriptos() {
		return this.cantFaltantesParaMinimo() == 0;
	}
	
	public int cantFaltantesParaMaximo() {
		return this.cupoMaximo > this.inscriptosExcursion.size() ? this.cupoMaximo - this.inscriptosExcursion.size() : 0;
	}
	
	public boolean cumpleMaximoCuposInscriptos() {
		return this.cantFaltantesParaMaximo() == 0;
	}
}

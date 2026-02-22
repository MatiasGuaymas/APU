package ar.edu.unlp.info.oo2._Ejercicio21;

import java.time.LocalDate;

public class Mamifero implements IMamifero{
	private String identificador;
	private String especie;
	private LocalDate fechaNacimiento;
	private IMamifero padre;
	private IMamifero madre;

	public Mamifero(String identificador) {
		this.inicializarValores(identificador);
	}
	
	public Mamifero(String identificador, String especie) {
		this.inicializarValores(identificador);
		this.especie = especie;
	}
	
	private void inicializarValores(String identificador) {
		this.identificador = identificador;
		this.padre = new Desconocido();
		this.madre = new Desconocido();
	}
 
	public String getIdentificador() {
		return this.identificador;
	}

	public String getEspecie() {
		return this.especie;
	}
	
	public LocalDate getFechaNacimiento() {
		return this.fechaNacimiento;
	}

	public IMamifero getPadre() {
		return this.padre;
	}
	
	public IMamifero getMadre() {
		return this.madre;
	}
	
	public IMamifero getAbueloMaterno() {
		return this.madre.getPadre();
	}

	public IMamifero getAbuelaMaterna() {
		return this.madre.getMadre();
	}

	public IMamifero getAbueloPaterno() {
		return this.padre.getPadre();
	}

	public IMamifero getAbuelaPaterna() {
		return this.padre.getMadre();
	}
	
	public void setIdentificador(String id) {
		this.identificador = id;
	}

	public void setEspecie(String especie) {
		this.especie = especie;
	}

	public void setFechaNacimiento(LocalDate fecha) {
		this.fechaNacimiento = fecha;
	}

	public void setPadre(IMamifero padre) {
		this.padre = padre;
	}


	public void setMadre(IMamifero madre) {
		this.madre = madre;
	}

	public Boolean tieneComoAncestroA(IMamifero unMamifero) {
		return ((this.padre == unMamifero) || (this.madre == unMamifero)
				|| this.padre.tieneComoAncestroA(unMamifero)
						|| this.madre.tieneComoAncestroA(unMamifero));
	}

}
package ar.edu.unlp.info.oo2._Ejercicio21;

import java.time.LocalDate;

public class Desconocido implements IMamifero {

	public String getIdentificador() {
		return "Desconocido";
	}

	public String getEspecie() {
		return "Desconocido";
	}
	
	public LocalDate getFechaNacimiento() {
		return null;
	}

	public IMamifero getPadre() {
		return this;
	}
	
	public IMamifero getMadre() {
		return this;
	}
	
	public IMamifero getAbueloMaterno() {
		return this;
	}

	public IMamifero getAbuelaMaterna() {
		return this;
	}

	public IMamifero getAbueloPaterno() {
		return this;
	}

	public IMamifero getAbuelaPaterna() {
		return this;
	}
	
	public void setIdentificador(String id) {}

	public void setEspecie(String especie) {}

	public void setFechaNacimiento(LocalDate fecha) {}

	public void setPadre(IMamifero padre) {}

	public void setMadre(IMamifero madre) {}

	public Boolean tieneComoAncestroA(IMamifero unMamifero) {
		return false;
	}

}

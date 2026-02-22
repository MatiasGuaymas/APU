package ar.edu.unlp.info.oo2._Ejercicio21;

import java.time.LocalDate;

public interface IMamifero {
	public String getIdentificador();
	public String getEspecie();
	public LocalDate getFechaNacimiento();
	public IMamifero getPadre();
	public IMamifero getMadre();
	public IMamifero getAbueloMaterno();
	public IMamifero getAbuelaMaterna();
	public IMamifero getAbueloPaterno();
	public IMamifero getAbuelaPaterna();
	public void setIdentificador(String id);
	public void setEspecie(String especie);
	public void setFechaNacimiento(LocalDate fecha);
	public void setPadre(IMamifero padre);
	public void setMadre(IMamifero madre);
	public Boolean tieneComoAncestroA(IMamifero unMamifero);
}

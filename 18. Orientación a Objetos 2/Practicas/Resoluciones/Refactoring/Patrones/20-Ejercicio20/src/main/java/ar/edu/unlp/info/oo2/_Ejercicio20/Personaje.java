package ar.edu.unlp.info.oo2._Ejercicio20;

import java.util.List;

public class Personaje {
	private String nombre;
	private int vida;
	private Armadura armadura;
	private Arma arma;
	private List<String> habilidades;
	
	public void enfrentar(Personaje rival) {
	    if (this.isAlive() && rival.isAlive()) {
	        rival.recibirDaño(this.arma);
	        if (rival.isAlive()) {
	            this.recibirDaño(rival.getArma());
	        }
	    } else {
	        throw new RuntimeException("Personaje con vida insuficiente para el combate");
	    }
	}
	
	protected void recibirDaño(Arma arma) {
	    int daño = this.armadura.recibirDaño(arma);
	    this.vida = Math.max(this.vida - daño, 0);
	}
	
	public boolean isAlive() {
		return this.vida > 0;
	}
	
	public String getNombre() {
		return nombre;
	}
	public int getVida() {
		return vida;
	}
	public Armadura getArmadura() {
		return armadura;
	}
	public Arma getArma() {
		return arma;
	}
	public List<String> getHabilidades() {
		return habilidades;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setVida(int vida) {
		this.vida = vida;
	}
	public void setArmadura(Armadura armadura) {
		this.armadura = armadura;
	}
	public void setArma(Arma arma) {
		this.arma = arma;
	}
	public void setHabilidades(List<String> habilidades) {
		this.habilidades = habilidades;
	}
	
}

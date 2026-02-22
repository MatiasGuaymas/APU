package ar.edu.unlp.info.oo2._Ejercicio20;

import java.util.Arrays;

public class GuerreroBuilder extends PersonajeBuilder {

	@Override
	public void setArmadura() {
		this.getPersonaje().setArmadura(new ArmaduraDeAcero());
	}

	@Override
	public void setArma() {
		this.getPersonaje().setArma(new Espada());
	}

	@Override
	public void setHabilidades() {
		this.getPersonaje().setHabilidades(Arrays.asList("Combate cuerpo a cuerpo"));
	}

}

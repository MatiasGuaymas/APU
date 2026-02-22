package ar.edu.unlp.info.oo2._Ejercicio20;

import java.util.Arrays;

public class ThoorBuilder extends PersonajeBuilder {

	@Override
	public void setArmadura() {
		this.getPersonaje().setArmadura(new ArmaduraDeHierro());
	}

	@Override
	public void setArma() {
		this.getPersonaje().setArma(new Martillo());
	}

	@Override
	public void setHabilidades() {
		this.getPersonaje().setHabilidades(Arrays.asList("Rayos", "Combate a distancia"));
	}

}

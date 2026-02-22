package ar.edu.unlp.info.oo2._Ejercicio20;

import java.util.Arrays;

public class ArqueroBuilder extends PersonajeBuilder {
	@Override
	public void setArmadura() {
		this.getPersonaje().setArmadura(new ArmaduraDeCuero());
	}

	@Override
	public void setArma() {
		this.getPersonaje().setArma(new Arco());
	}

	@Override
	public void setHabilidades() {
		this.getPersonaje().setHabilidades(Arrays.asList("Combate a distancia"));
	}
}

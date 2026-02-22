package ar.edu.unlp.info.oo2._Ejercicio15;

public class BuilderIntermedio extends PCBuilder{
	@Override
	public void setProcesador() {
		this.getPresupuesto().setProcesador(Catalogo.getComponente("Procesador Intermedio"));
	}

	@Override
	public void setMemoriaRAM() {
		this.getPresupuesto().setMemoriaRAM(Catalogo.getComponente("16 GB"));
	}

	@Override
	public void setDisco() {
		this.getPresupuesto().setDisco(Catalogo.getComponente("SDD 500 GB"));
	}

	@Override
	public void setTarjetaGrafica() {
		this.getPresupuesto().setTarjetaGrafica(Catalogo.getComponente("GTX 1650"));
	}

	@Override
	public void setGabinete() {
		this.getPresupuesto().setGabinete(Catalogo.getComponente("Gabinete Intermedio"));
		this.getPresupuesto().add(Catalogo.getComponente("Fuente 800 W"));
	}
}

package ar.edu.unlp.info.oo2._Ejercicio15;

public class BuilderGamer extends PCBuilder{
	@Override
	public void setProcesador() {
		this.getPresupuesto().setProcesador(Catalogo.getComponente("Procesador Gamer"));
		this.getPresupuesto().add(Catalogo.getComponente("Pad térmico"));
		this.getPresupuesto().add(Catalogo.getComponente("Cooler"));
	}

	@Override
	public void setMemoriaRAM() {
		this.getPresupuesto().setMemoriaRAM(Catalogo.getComponente("32 GB"));
		this.getPresupuesto().setMemoriaRAM(Catalogo.getComponente("32 GB"));
	}

	@Override
	public void setDisco() {
		this.getPresupuesto().setDisco(Catalogo.getComponente("SSD 500gb"));
		this.getPresupuesto().setDisco(Catalogo.getComponente("SSD 1TB"));
	}

	@Override
	public void setTarjetaGrafica() {
		this.getPresupuesto().setTarjetaGrafica(Catalogo.getComponente("RTX 4090"));
	}

	@Override
	public void setGabinete() {
		this.getPresupuesto().setGabinete(Catalogo.getComponente("Gabinete Gamer"));
		double aux = this.getPresupuesto().calcularConsumo();
		String fuente = "fuente " + (aux + aux * 0.5) + " w";
		this.getPresupuesto().add(Catalogo.getComponente(fuente));
	}
}

package ar.edu.unlp.info.oo2._Ejercicio15;

public abstract class PCBuilder {
	private Presupuesto presupuesto;
	
	public PCBuilder() {
		this.reset();
	}
	
	public void reset() {
		this.presupuesto = new Presupuesto();
	}
	
	public abstract void setProcesador();
	
	public abstract void setMemoriaRAM();
	
	public abstract void setDisco();
	
	public abstract void setTarjetaGrafica();
	
	public abstract void setGabinete();
	
	public Presupuesto getPresupuesto() {
		return this.presupuesto;
	}
	
	public void setUsuario(String nombre) {
		this.presupuesto.setUsuario(nombre);
	}
	
}

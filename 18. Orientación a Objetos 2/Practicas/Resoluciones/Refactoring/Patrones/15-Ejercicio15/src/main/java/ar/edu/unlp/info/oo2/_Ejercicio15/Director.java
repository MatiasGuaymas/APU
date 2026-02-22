package ar.edu.unlp.info.oo2._Ejercicio15;

public class Director {
	private PCBuilder builder;
	
	public Director (PCBuilder builder) {
		this.builder = builder;
	}
	
	public void setBuilder (PCBuilder builder) {
		this.builder = builder;
	}
	
	public Presupuesto build (String nombre) {
		this.builder.reset();
		this.builder.setProcesador();
		this.builder.setMemoriaRAM();
		this.builder.setDisco();
		this.builder.setTarjetaGrafica();
		this.builder.setGabinete();
		this.builder.setUsuario(nombre);
		return this.builder.getPresupuesto();
	}
}

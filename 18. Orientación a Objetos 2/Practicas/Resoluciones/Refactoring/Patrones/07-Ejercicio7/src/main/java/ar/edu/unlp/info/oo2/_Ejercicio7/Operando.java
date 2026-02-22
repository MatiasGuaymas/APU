package ar.edu.unlp.info.oo2._Ejercicio7;

public abstract class Operando implements EstadoCalculadora{
	@Override
	public void mas(Calculadora c) {
		c.setEstado(new Error());
	}
	
	@Override
	public void menos(Calculadora c) {
		c.setEstado(new Error());
	}
	
	@Override
	public void por(Calculadora c) {
		c.setEstado(new Error());
	}
	
	@Override
	public void dividido(Calculadora c) {
		c.setEstado(new Error());
	}
	
	@Override
    public abstract void setValor(double unValor, Calculadora c);
	
	@Override
	public String getResultado(Calculadora c) {
		c.setEstado(new Error());
		//return c.getResultado();
		return "Error";
	}
}

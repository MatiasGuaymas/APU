package ar.edu.unlp.info.oo2._Ejercicio7;

public class Restando extends Operando{

	@Override
	public void setValor(double unValor, Calculadora c) {
		c.setValorAcumulado(c.getValorAcumulado() - unValor);
		c.setEstado(new Inicial());
	}
	
}

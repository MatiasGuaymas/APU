package ar.edu.unlp.info.oo2._Ejercicio2;

public class EmpleadoTemporario extends Empleado{
	private int cantHorasTrabajadas;
	private int cantHijos;
	private boolean esCasado;
	
	public EmpleadoTemporario(int cantHorasTrabajadas, int cantHijos, boolean esCasado) {
		this.cantHorasTrabajadas = cantHorasTrabajadas;
		this.cantHijos = cantHijos;
		this.esCasado = esCasado;
	}

	@Override
	public double sueldoBasico() {
		return 20000 + this.cantHorasTrabajadas * 300;
	}

	@Override
	public double calcularAdicionales() {
		return esCasado ? 5000 + 2000 * this.cantHijos : 2000 * this.cantHijos;
	}
	
}

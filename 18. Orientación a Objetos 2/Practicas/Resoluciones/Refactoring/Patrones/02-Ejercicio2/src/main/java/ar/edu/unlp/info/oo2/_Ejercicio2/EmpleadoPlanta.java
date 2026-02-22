package ar.edu.unlp.info.oo2._Ejercicio2;

public class EmpleadoPlanta extends Empleado{
	private boolean esCasado;
	private int cantHijos;
	private int aniosAntiguedad;
	
	public EmpleadoPlanta (boolean esCasado, int cantHijos, int aniosAntiguedad) {
		this.esCasado = esCasado;
		this.cantHijos = cantHijos;
		this.aniosAntiguedad = aniosAntiguedad;
	}

	@Override
	public double sueldoBasico() {
		return 50000;
	}

	@Override
	public double calcularAdicionales() {
		int adicional = 2000 * this.cantHijos + 2000 * this.aniosAntiguedad;
		return esCasado ? 5000 + adicional : adicional;
	}
	
	
}

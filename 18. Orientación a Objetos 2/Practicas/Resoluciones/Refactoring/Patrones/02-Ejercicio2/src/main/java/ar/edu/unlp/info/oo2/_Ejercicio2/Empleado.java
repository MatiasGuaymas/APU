package ar.edu.unlp.info.oo2._Ejercicio2;

public abstract class Empleado {
	public double sueldo() {
		return this.sueldoBasico() + this.calcularAdicionales() - this.calcularDescuentos();
	}
	protected abstract double sueldoBasico();
	protected abstract double calcularAdicionales();
	public double calcularDescuentos() {
		return this.sueldoBasico() * 0.13 + this.calcularAdicionales() * 0.05;
	}
}

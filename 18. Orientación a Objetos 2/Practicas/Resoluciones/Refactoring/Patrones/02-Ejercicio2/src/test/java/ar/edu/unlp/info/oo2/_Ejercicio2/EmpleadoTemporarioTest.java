package ar.edu.unlp.info.oo2._Ejercicio2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EmpleadoTemporarioTest {
	private Empleado empCasadoSinHijos;
	private Empleado empCasadoConHijos;
	private Empleado empSolteroSinHijos;
	private Empleado empSolteroConHijos;
	
	@BeforeEach
	public void setUp() throws Exception {
		empCasadoSinHijos = new EmpleadoTemporario(1, 0, true);
		empCasadoConHijos = new EmpleadoTemporario(1, 1, true);
		empSolteroSinHijos = new EmpleadoTemporario(1, 0, false);
		empSolteroConHijos = new EmpleadoTemporario(1, 1, false);
	}

	@Test
	public void testSueldoBasico() {
		assertEquals(20300, empCasadoSinHijos.sueldoBasico());
		assertEquals(20300, empCasadoConHijos.sueldoBasico());
		assertEquals(20300, empSolteroSinHijos.sueldoBasico());
		assertEquals(20300, empSolteroConHijos.sueldoBasico());
	}
	
	@Test
	public void testCalcularAdicionales() {
		assertEquals(5000, empCasadoSinHijos.calcularAdicionales());
		assertEquals(7000, empCasadoConHijos.calcularAdicionales());
		assertEquals(0, empSolteroSinHijos.calcularAdicionales());
		assertEquals(2000, empSolteroConHijos.calcularAdicionales());
	}
	
	@Test
	public void testCalcularDescuentos() {
	    assertEquals(2889, empCasadoSinHijos.calcularDescuentos());
	    assertEquals(2989, empCasadoConHijos.calcularDescuentos());
	    assertEquals(2639, empSolteroSinHijos.calcularDescuentos());
	    assertEquals(2739, empSolteroConHijos.calcularDescuentos());
	}

	@Test
	public void sueldo() {
	    assertEquals(22411, empCasadoSinHijos.sueldo());
	    assertEquals(24311, empCasadoConHijos.sueldo());
	    assertEquals(17661, empSolteroSinHijos.sueldo());
	    assertEquals(19561, empSolteroConHijos.sueldo());
	}
	

}

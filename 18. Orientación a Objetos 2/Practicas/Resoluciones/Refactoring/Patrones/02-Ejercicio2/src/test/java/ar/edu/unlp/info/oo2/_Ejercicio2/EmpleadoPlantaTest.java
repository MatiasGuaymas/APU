package ar.edu.unlp.info.oo2._Ejercicio2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EmpleadoPlantaTest {
    private Empleado empCasadoSinHijos;
    private Empleado empCasadoConHijos;
    private Empleado empSolteroSinHijos;
    private Empleado empSolteroConHijos;

    @BeforeEach
    public void setUp() throws Exception {
        empCasadoSinHijos = new EmpleadoPlanta(true, 0, 1); 
        empCasadoConHijos = new EmpleadoPlanta(true, 1, 1);  
        empSolteroSinHijos = new EmpleadoPlanta(false, 0, 1);
        empSolteroConHijos = new EmpleadoPlanta(false, 1, 1);
    }

    @Test
    public void testSueldoBasico() {
        assertEquals(50000, empCasadoSinHijos.sueldoBasico());
        assertEquals(50000, empCasadoConHijos.sueldoBasico());
        assertEquals(50000, empSolteroSinHijos.sueldoBasico());
        assertEquals(50000, empSolteroConHijos.sueldoBasico());
    }

    @Test
    public void testCalcularAdicionales() {
        assertEquals(7000, empCasadoSinHijos.calcularAdicionales()); 
        assertEquals(9000, empCasadoConHijos.calcularAdicionales());
        assertEquals(2000, empSolteroSinHijos.calcularAdicionales());
        assertEquals(4000, empSolteroConHijos.calcularAdicionales());
    }

    @Test
    public void testCalcularDescuentos() {
        assertEquals(6850, empCasadoSinHijos.calcularDescuentos()); 
        assertEquals(6950, empCasadoConHijos.calcularDescuentos());  
        assertEquals(6600, empSolteroSinHijos.calcularDescuentos());
        assertEquals(6700, empSolteroConHijos.calcularDescuentos()); 
    }

    @Test
    public void testSueldo() {
        assertEquals(50150, empCasadoSinHijos.sueldo());  
        assertEquals(52050, empCasadoConHijos.sueldo());  
        assertEquals(45400, empSolteroSinHijos.sueldo()); 
        assertEquals(47300, empSolteroConHijos.sueldo());
    }
}
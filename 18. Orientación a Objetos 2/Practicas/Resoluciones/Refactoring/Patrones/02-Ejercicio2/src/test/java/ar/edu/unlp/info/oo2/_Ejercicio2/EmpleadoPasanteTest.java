package ar.edu.unlp.info.oo2._Ejercicio2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EmpleadoPasanteTest {
    private Empleado empSinExamenes;
    private Empleado empConUnExamen;
    private Empleado empConDosExamenes;

    @BeforeEach
    public void setUp() throws Exception {
        empSinExamenes = new EmpleadoPasante(0);   
        empConUnExamen = new EmpleadoPasante(1);   
        empConDosExamenes = new EmpleadoPasante(2); 
    }

    @Test
    public void testSueldoBasico() {
        assertEquals(20000, empSinExamenes.sueldoBasico());
        assertEquals(20000, empConUnExamen.sueldoBasico());
        assertEquals(20000, empConDosExamenes.sueldoBasico());
    }

    @Test
    public void testCalcularAdicionales() {
        assertEquals(0, empSinExamenes.calcularAdicionales());   
        assertEquals(2000, empConUnExamen.calcularAdicionales());
        assertEquals(4000, empConDosExamenes.calcularAdicionales()); 
    }

    @Test
    public void testCalcularDescuentos() {
        assertEquals(2600, empSinExamenes.calcularDescuentos());   
        assertEquals(2700, empConUnExamen.calcularDescuentos());  
        assertEquals(2800, empConDosExamenes.calcularDescuentos());
    }

    @Test
    public void testSueldo() {
        assertEquals(17400, empSinExamenes.sueldo());   
        assertEquals(19300, empConUnExamen.sueldo());    
        assertEquals(21200, empConDosExamenes.sueldo()); 
    }
}
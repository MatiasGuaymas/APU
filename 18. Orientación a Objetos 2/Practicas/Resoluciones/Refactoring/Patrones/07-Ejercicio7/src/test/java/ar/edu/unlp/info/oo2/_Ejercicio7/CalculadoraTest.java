package ar.edu.unlp.info.oo2._Ejercicio7;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalculadoraTest {
    private Calculadora calculadora;

    @BeforeEach
    public void setUp() {
        calculadora = new Calculadora();
    }

    @Test
    public void testEstadoInicial() {
        assertEquals("0.0", calculadora.getResultado());
        calculadora.setValor(42.5);
        assertEquals("42.5", calculadora.getResultado());
    }

    @Test
    public void testSumaCorrecta() {
        calculadora.setValor(10);
        calculadora.mas();
        calculadora.setValor(5);
        assertEquals("15.0", calculadora.getResultado());
    }

    @Test
    public void testRestaCorrecta() {
        calculadora.setValor(10);
        calculadora.menos();
        calculadora.setValor(3);
        assertEquals("7.0", calculadora.getResultado());
    }

    @Test
    public void testMultiplicacionCorrecta() {
        calculadora.setValor(4);
        calculadora.por();
        calculadora.setValor(5);
        assertEquals("20.0", calculadora.getResultado());
    }

    @Test
    public void testDivisionCorrecta() {
        calculadora.setValor(15);
        calculadora.dividido();
        calculadora.setValor(3);
        assertEquals("5.0", calculadora.getResultado());
    }

    @Test
    public void testDivisionPorCero() {
        calculadora.setValor(10);
        calculadora.dividido();
        calculadora.setValor(0);
        assertEquals("Error", calculadora.getResultado());
    }

    @Test
    public void testOperacionIncompletaSuma() {
        calculadora.setValor(10);
        calculadora.mas();
        assertEquals("Error", calculadora.getResultado());
    }

    @Test
    public void testOperacionIncompletaResta() {
        calculadora.setValor(10);
        calculadora.menos();
        assertEquals("Error", calculadora.getResultado());
    }

    @Test
    public void testOperacionIncompletaMultiplicacion() {
        calculadora.setValor(10);
        calculadora.por();
        assertEquals("Error", calculadora.getResultado());
    }

    @Test
    public void testOperacionIncompletaDivision() {
        calculadora.setValor(10);
        calculadora.dividido();
        assertEquals("Error", calculadora.getResultado());
    }

    @Test
    public void testMensajeNoPermitidoEnSumando() {
        calculadora.setValor(10);
        calculadora.mas();
        calculadora.menos(); // Mensaje no permitido
        assertEquals("Error", calculadora.getResultado());
    }

    @Test
    public void testMensajeNoPermitidoEnRestando() {
        calculadora.setValor(10);
        calculadora.menos();
        calculadora.por(); // Mensaje no permitido
        assertEquals("Error", calculadora.getResultado());
    }

    @Test
    public void testMensajeNoPermitidoEnMultiplicando() {
        calculadora.setValor(10);
        calculadora.por();
        calculadora.dividido(); // Mensaje no permitido
        assertEquals("Error", calculadora.getResultado());
    }

    @Test
    public void testMensajeNoPermitidoEnDividiendo() {
        calculadora.setValor(10);
        calculadora.dividido();
        calculadora.mas(); // Mensaje no permitido
        assertEquals("Error", calculadora.getResultado());
    }

    @Test
    public void testBorrarEnEstadoInicial() {
        calculadora.setValor(100);
        calculadora.borrar();
        assertEquals("0.0", calculadora.getResultado());
    }

    @Test
    public void testBorrarEnEstadoOperando() {
        calculadora.setValor(10);
        calculadora.mas();
        calculadora.borrar();
        assertEquals("0.0", calculadora.getResultado());
    }

    @Test
    public void testBorrarEnEstadoError() {
        calculadora.setValor(10);
        calculadora.dividido();
        calculadora.setValor(0); // Estado Error
        calculadora.borrar();
        assertEquals("0.0", calculadora.getResultado());
    }

    @Test
    public void testOperacionesEncadenadas() {
        calculadora.setValor(10);
        calculadora.mas();
        calculadora.setValor(5); // 15
        calculadora.por();
        calculadora.setValor(2); // 30
        assertEquals("30.0", calculadora.getResultado());
    }

    @Test
    public void testEstadoErrorIgnoraOperaciones() {
        calculadora.setValor(10);
        calculadora.dividido();
        calculadora.setValor(0); // Estado Error
        calculadora.mas();
        calculadora.setValor(5);
        assertEquals("Error", calculadora.getResultado());
    }
}
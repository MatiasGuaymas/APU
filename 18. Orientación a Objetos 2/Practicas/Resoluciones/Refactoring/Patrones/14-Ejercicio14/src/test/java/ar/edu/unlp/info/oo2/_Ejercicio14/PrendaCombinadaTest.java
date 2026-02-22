package ar.edu.unlp.info.oo2._Ejercicio14;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PrendaCombinadaTest {

    private PrendaCombinada prendaCombinada;
    private Alquiler alquiler;
    private Automovil automovil;

    @BeforeEach
    public void setUp() {
        prendaCombinada = new PrendaCombinada();
        alquiler = new Alquiler(LocalDate.of(2024, 1, 1), LocalDate.of(2025, 1, 1), 1000.0);
        automovil = new Automovil(LocalDate.of(2020, 1, 1), 50000, 20000.0);
    }

    @Test
    public void testGetValorConMultiplesPrendas() {
        prendaCombinada.agregarPrenda(alquiler);
        prendaCombinada.agregarPrenda(automovil);
        assertEquals(22000.0, prendaCombinada.getValor(), 0.001);
    }

    @Test
    public void testGetValorConUnaPrenda() {
        prendaCombinada.agregarPrenda(alquiler);
        assertEquals(12000.0, prendaCombinada.getValor(), 0.001);
    }

    @Test
    public void testGetValorSinPrendas() {
        assertEquals(0.0, prendaCombinada.getValor(), 0.001);
    }

    @Test
    public void testGetLiquidez() {
        assertEquals(0.5, prendaCombinada.getLiquidez(), 0.001);
    }

    @Test
    public void testCalcularValorConMultiplesPrendas() {
        prendaCombinada.agregarPrenda(alquiler);
        prendaCombinada.agregarPrenda(automovil);
        assertEquals(11000.0, prendaCombinada.calcularValor(), 0.001);
    }

    @Test
    public void testCalcularValorConUnaPrenda() {
        prendaCombinada.agregarPrenda(alquiler);
        assertEquals(6000.0, prendaCombinada.calcularValor(), 0.001);
    }

    @Test
    public void testCalcularValorSinPrendas() {
        assertEquals(0.0, prendaCombinada.calcularValor(), 0.001);
    }
}
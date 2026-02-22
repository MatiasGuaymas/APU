package ar.edu.unlp.info.oo2._Ejercicio14;

import java.time.LocalDate;

public class Ejemplo {

	public static void main(String[] args) {
		PrendaCombinada prendaCombinada = new PrendaCombinada();
		prendaCombinada.agregarPrenda(new Alquiler(LocalDate.of(2025, 1, 31), LocalDate.of(2025, 5, 1), 1000));
		prendaCombinada.agregarPrenda(new Automovil(LocalDate.of(2023, 1, 31), 1000, 500));
		// Valor Alquiler: 3 * 1000 = 3000 
		// Valor Automovil: 500 * 0.2 = 100
		// Prenda Combinada: 3000 + 100 = 3100 * 0.5 = 1550
		System.out.println(prendaCombinada.calcularValor());
	}

}

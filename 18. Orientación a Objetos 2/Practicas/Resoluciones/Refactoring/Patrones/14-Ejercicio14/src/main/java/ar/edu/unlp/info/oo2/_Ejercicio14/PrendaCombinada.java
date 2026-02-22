package ar.edu.unlp.info.oo2._Ejercicio14;

import java.util.ArrayList;
import java.util.List;

public class PrendaCombinada extends Prenda {
	private List<Prenda> prendas;
	
	public PrendaCombinada() {
		this.prendas = new ArrayList<Prenda>();
	}
	
	public void agregarPrenda(Prenda p) {
		this.prendas.add(p);
	}

	@Override
	protected double getValor() {
		return this.prendas.stream().mapToDouble(p -> p.getValor()).sum();
	}

	@Override
	protected double getLiquidez() {
		return 0.5;
	}
}

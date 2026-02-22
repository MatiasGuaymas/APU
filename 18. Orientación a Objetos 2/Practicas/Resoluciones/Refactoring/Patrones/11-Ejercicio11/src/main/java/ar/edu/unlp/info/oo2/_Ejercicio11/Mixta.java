package ar.edu.unlp.info.oo2._Ejercicio11;

import java.util.ArrayList;
import java.util.List;

public class Mixta implements Topografia{
	private List<Topografia> topografias;
	
	public Mixta() {
		this.topografias = new ArrayList<>();
	}

	@Override
	public double calcularProporcionAgua() {
		return (this.topografias.stream().mapToDouble(topo -> topo.calcularProporcionAgua()).sum()) / 4;
	}

	@Override
	public boolean esIgualaMixta(Mixta topo) {
		return this.topografias.equals(topo.topografias);
	}
	
	public void add(Topografia topo) {
		if(this.topografias.size() < 4) {
			this.topografias.add(topo);
		}
	}

	@Override
	public boolean equals(Object topo) {
		return ((Topografia)topo).esIgualaMixta(this);
	}
}

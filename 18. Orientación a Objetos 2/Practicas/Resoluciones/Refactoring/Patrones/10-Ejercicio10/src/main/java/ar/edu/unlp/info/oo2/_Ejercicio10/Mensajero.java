package ar.edu.unlp.info.oo2._Ejercicio10;

public class Mensajero {
	private AlgoritmoDeCifrado estrategia;
	
	public Mensajero (AlgoritmoDeCifrado estrategia) {
		this.setStrategy(estrategia);
	}
	
	public void setStrategy(AlgoritmoDeCifrado estrategia) {
		this.estrategia = estrategia;
	}
	
	public void enviar(String mensaje) {
		this.estrategia.encriptar(mensaje);
	}
	
	public void recibir(String mensaje) {
		this.estrategia.desencriptar(mensaje);
	}
}

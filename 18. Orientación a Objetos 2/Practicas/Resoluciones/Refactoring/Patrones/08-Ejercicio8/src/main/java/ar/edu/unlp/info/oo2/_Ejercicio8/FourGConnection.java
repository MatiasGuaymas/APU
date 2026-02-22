package ar.edu.unlp.info.oo2._Ejercicio8;

public class FourGConnection {
	private String symb;
	
	public FourGConnection() {
		this.symb = "4G";
	}
	
	public String transmit (String data, int crc) {
		return "4G: " + data + " " + crc;
	}
	
	public String symb() {
		return this.symb;
	}
}

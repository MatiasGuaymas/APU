package ar.edu.unlp.info.oo2._Ejercicio8;

public class WifiConn implements Connection{
	private String pict;
	
	public WifiConn() {
		this.pict = "Wifi";
	}
	
	@Override
	public String sendData(String data, int crc) {
		return "Wifi: " + data + " " + crc;
	}
	
	@Override
	public String pict() {
		return this.pict;
	}
}

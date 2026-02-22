package ar.edu.unlp.info.oo2._Ejercicio8;

public class Dispositivo {
	private CRC_Calculator crcCalculator;
	private Display display;
	private Connection connection;
	private Ringer ringer;
	
	public Dispositivo() {
		this.crcCalculator = new CRC16_Calculator();
		this.display = new Display();
		this.connection = new WifiConn();
		this.ringer = new Ringer();
	}
	
	public String send(String data) {
		int crc = (int) this.crcCalculator.crcFor(data);
		return this.connection.sendData(data, crc);
	}
	
	public String conectarCon(Connection connection) {
		this.connection = connection;
		this.display.showBanner(this.connection.pict());
		this.ringer.ring();
		return "Connection has changed";
	}
	
	public String configurarCRC(CRC_Calculator strategy) {
		this.crcCalculator = strategy;
		return "CRC Configuration has changed";
	}
}

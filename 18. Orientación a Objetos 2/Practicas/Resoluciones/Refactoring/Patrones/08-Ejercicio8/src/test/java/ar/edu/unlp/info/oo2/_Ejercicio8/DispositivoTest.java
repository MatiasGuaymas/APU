package ar.edu.unlp.info.oo2._Ejercicio8;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DispositivoTest {

	private Dispositivo dispositivo;
		
	@BeforeEach
	void setUp() throws Exception {
		this.dispositivo = new Dispositivo();
	}

	@Test
	void testSendCRC16Wifi() {
		assertEquals("Wifi: Cuando lo sabes lo sabes 15071", this.dispositivo.send("Cuando lo sabes lo sabes"));
	}
	
	@Test
	void testSendCRC32Wifi() {
		this.dispositivo.configurarCRC(new CRC32_Calculator());
		assertEquals("Wifi: Cuando lo sabes lo sabes -1741497163", this.dispositivo.send("Cuando lo sabes lo sabes"));
	}
	
	@Test
	void testSendCRC164G() {
		this.dispositivo.conectarCon(new FourGAdapter());
		assertEquals("4G: Cuando lo sabes lo sabes 15071", this.dispositivo.send("Cuando lo sabes lo sabes"));
	}
	
	@Test
	void testSendCRC324G() {
		this.dispositivo.conectarCon(new FourGAdapter());
		this.dispositivo.configurarCRC(new CRC32_Calculator());
		assertEquals("4G: Cuando lo sabes lo sabes -1741497163", this.dispositivo.send("Cuando lo sabes lo sabes"));
	}
	
	@Test
	void testConectarCon() {
		assertEquals("Connection has changed", this.dispositivo.conectarCon(new FourGAdapter()));
		assertEquals("Connection has changed", this.dispositivo.conectarCon(new WifiConn()));
	}
	
	@Test
	void testConfigurarCRC() {
		assertEquals("CRC Configuration has changed", this.dispositivo.configurarCRC(new CRC32_Calculator()));
		assertEquals("CRC Configuration has changed", this.dispositivo.configurarCRC(new CRC16_Calculator()));
	}

}
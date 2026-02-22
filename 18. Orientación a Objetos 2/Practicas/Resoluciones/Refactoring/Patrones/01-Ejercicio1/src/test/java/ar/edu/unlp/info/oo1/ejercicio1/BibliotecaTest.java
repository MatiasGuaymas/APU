package ar.edu.unlp.info.oo1.ejercicio1;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BibliotecaTest {
	
	private Biblioteca biblioteca;
	private Socio socio1;
	private Socio socio2;
	private JSONParser parseo;

	@BeforeEach
	void setUp() throws Exception {
		biblioteca = new Biblioteca();
		socio1 = new Socio("Arya Stark", "needle@stark.com", "5234-5");
		socio2 = new Socio("Tyron Lannister", "tyron@thelannisters.com", "2345-2");
		biblioteca.agregarSocio(socio1);
		biblioteca.agregarSocio(socio2);
		parseo = new JSONParser();
	}

	@Test
	void testJSONSimple() throws ParseException {
		VoorheesExporter adapter = new JSONSimpleAdapter();
		String salida = "[\n"
				+ "	{\n"
				+ "		\"nombre\": \"Arya Stark\",\n"
				+ "		\"email\": \"needle@stark.com\",\n"
				+ "		\"legajo\": \"5234-5\"\n"
				+ "	},\n"
				+ "	{\n"
				+ "		\"nombre\": \"Tyron Lannister\",\n"
				+ "		\"email\": \"tyron@thelannisters.com\",\n"
				+ "		\"legajo\": \"2345-2\"\n"
				+ "	}\n"
				+ "]\n"
				+ "";
		biblioteca.setExporter(adapter);
		assertEquals(parseo.parse(salida), parseo.parse(this.biblioteca.exportarSocios()));
	}

}

package ar.edu.unlp.info.oo2._Ejercicio18;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FileComponentTest {
	private FileComponent fileOO2;
	private FileDecorator nombreDecorator;
	private FileDecorator extensionDecorator;
	private FileDecorator tamDecorator;
	private FileDecorator fechaCreacionDecorator;
	private FileDecorator fechaModificacionrator;
	private FileDecorator permisosDecorator;
	private FileDecorator todosLosDecoradores;
	private FileDecorator todosLosDecoradores2;

	@BeforeEach
	void setUp() throws Exception {
		this.fileOO2 = new FileOO2("file",".exe","500",LocalDate.of(2025, 4, 29),LocalDate.of(2025, 4, 29),"user");
		this.nombreDecorator = new NombreDecorator(this.fileOO2);
		this.extensionDecorator = new ExtensionDecorator(this.fileOO2);
		this.tamDecorator = new TamDecorator(this.fileOO2);
		this.fechaCreacionDecorator = new FechaCreacionDecorator(this.fileOO2); 
		this.fechaModificacionrator = new FechaModificacionDecorator(this.fileOO2);
		this.permisosDecorator = new PermisosDecorator(this.fileOO2);
		this.todosLosDecoradores = new PermisosDecorator(new FechaModificacionDecorator(new FechaCreacionDecorator(new TamDecorator(new ExtensionDecorator(new NombreDecorator(fileOO2))))));
		this.todosLosDecoradores2 = new NombreDecorator(new FechaModificacionDecorator(new FechaCreacionDecorator(new TamDecorator(new ExtensionDecorator(new PermisosDecorator(fileOO2))))));
	}

	@Test
	void testPrettyPrintUnDecorador() {
		//nombre - extension
		assertEquals("file - .exe",this.extensionDecorator.prettyPrint());
		//nombre - tamaño 
		assertEquals("file - 500",this.tamDecorator.prettyPrint());
		//nombre - fecha creacion
		assertEquals("file - 2025-04-29",this.fechaCreacionDecorator.prettyPrint());
		//nombre - fecha modificacion
		assertEquals("file - 2025-04-29",this.fechaModificacionrator.prettyPrint());
		//nombre - permisos
		assertEquals("file - user",this.permisosDecorator.prettyPrint());
	}
	
	@Test
	void testPrettyPrintSinDecoraciones() {
		assertEquals("file",this.fileOO2.prettyPrint());
	}

	@Test
	void testPrettyPrintCompleto() {
		assertEquals("file - .exe - 500 - 2025-04-29 - 2025-04-29 - user", this.todosLosDecoradores.prettyPrint());
		assertEquals("file - user - .exe - 500 - 2025-04-29 - 2025-04-29", this.todosLosDecoradores2.prettyPrint());
	}
}

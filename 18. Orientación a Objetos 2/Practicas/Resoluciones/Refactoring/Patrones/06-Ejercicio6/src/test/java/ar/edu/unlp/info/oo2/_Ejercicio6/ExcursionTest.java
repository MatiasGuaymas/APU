package ar.edu.unlp.info.oo2._Ejercicio6;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ExcursionTest {
    
    private Excursion excursionProvisorio;
    private Excursion excursionDefinitivo;
    private Excursion excursionCompleta;
    private Usuario user1;
    private Usuario user2;
    private Usuario user3;
    private Usuario user4;
    private Usuario user5;

    @BeforeEach
    void setUp() throws Exception {
        excursionProvisorio = new Excursion("Aventura en los Andes", LocalDate.of(2025, 6, 10), LocalDate.of(2025, 6, 20), "Cusco",
                150.0, 3, 6);
        excursionDefinitivo = new Excursion("Ruta del Vino", LocalDate.of(2025, 7, 5), LocalDate.of(2025, 7, 12), "Mendoza",
                250.0, 2, 4);
        excursionCompleta = new Excursion("Playas del Caribe", LocalDate.of(2025, 8, 1), LocalDate.of(2025, 8, 8), "Cartagena",
                400.0, 1, 5);
        user1 = new Usuario("Ana", "Gomez", "ana.gomez@email.com");
        user2 = new Usuario("Carlos", "Lopez", "carlos.lopez@email.com");
        user3 = new Usuario("Sofia", "Martinez", "sofia.martinez@email.com");
        user4 = new Usuario("Diego", "Fernandez", "diego.fernandez@email.com");
        user5 = new Usuario("Lucia", "Ramirez", "lucia.ramirez@email.com");
        
        excursionDefinitivo.inscribir(user1);
        excursionDefinitivo.inscribir(user2);
        excursionDefinitivo.inscribir(user3);
        
        excursionCompleta.inscribir(user1);
        excursionCompleta.inscribir(user2);
        excursionCompleta.inscribir(user3);
        excursionCompleta.inscribir(user4);
        excursionCompleta.inscribir(user5);
    }

    @Test
    void testExcursionProvisorioObtenerInformacion() {
        String cadena = "Nombre: Aventura en los Andes\n" +
                       "Costo: 150.0\n" +
                       "Fecha de Inicio: 2025-06-10\n" +
                       "Fecha de Fin: 2025-06-20\n" +
                       "Punto de Encuentro: Cusco\n" +
                       "Cantidad de usuarios faltantes para alcanzar el cupo minimo: 3";
        assertEquals(cadena, excursionProvisorio.obtenerInformacion());
    }
    
    @Test
    void testExcursionProvisorioInscribir() {
        excursionProvisorio.inscribir(user1);
        assertTrue(excursionProvisorio.getState() instanceof Provisoria);
        
        excursionProvisorio.inscribir(user2);
        assertTrue(excursionProvisorio.getState() instanceof Provisoria);
        
        excursionProvisorio.inscribir(user3);
        assertTrue(excursionProvisorio.getState() instanceof Definitiva);
    }
    
    @Test
    void testExcursionDefinitivoObtenerInformacion() {
        String cadena = "Nombre: Ruta del Vino\n" +
                       "Costo: 250.0\n" +
                       "Fecha de Inicio: 2025-07-05\n" +
                       "Fecha de Fin: 2025-07-12\n" +
                       "Punto de Encuentro: Mendoza\n" +
                       "Cantidad de usuarios faltantes para alcanzar el cupo maximo: 1\n" +
                       "Mails de los Usuarios Inscriptos: ana.gomez@email.com\n" +
                       "carlos.lopez@email.com\n" +
                       "sofia.martinez@email.com\n";

        assertEquals(cadena, excursionDefinitivo.obtenerInformacion());
    }
    
    @Test
    void testExcursionDefinitivoInscribir() {
        assertTrue(excursionDefinitivo.getState() instanceof Definitiva);
        
        excursionDefinitivo.inscribir(user4);
        assertTrue(excursionDefinitivo.getState() instanceof Completa);
    }
    
    @Test
    void testExcursionCompletaObtenerInformacion() {
        String cadena = "Nombre: Playas del Caribe\n" +
                       "Costo: 400.0\n" +
                       "Fecha de Inicio: 2025-08-01\n" +
                       "Fecha de Fin: 2025-08-08\n" +
                       "Punto de Encuentro: Cartagena\n";

        assertEquals(cadena, excursionCompleta.obtenerInformacion());
    }
    
    @Test
    void testExcursionCompletaInscribir() {
        assertTrue(excursionCompleta.getState() instanceof Completa);
        
        excursionCompleta.inscribir(user1);
        assertEquals(1, excursionCompleta.getEnEspera().size());
    }
}
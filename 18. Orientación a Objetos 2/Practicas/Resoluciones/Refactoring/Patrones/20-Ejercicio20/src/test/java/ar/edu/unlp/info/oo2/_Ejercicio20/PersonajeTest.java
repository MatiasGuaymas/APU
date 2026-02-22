package ar.edu.unlp.info.oo2._Ejercicio20;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PersonajeTest {
    private Director director;
    private GuerreroBuilder guerreroBuilder;
    private ArqueroBuilder arqueroBuilder;
    private MagoBuilder magoBuilder;
    private ThoorBuilder thoorBuilder;

    @BeforeEach
    public void setUp() {
        guerreroBuilder = new GuerreroBuilder();
        arqueroBuilder = new ArqueroBuilder();
        magoBuilder = new MagoBuilder();
        thoorBuilder = new ThoorBuilder();
        director = new Director(guerreroBuilder); // Se cambia según la prueba
    }

    @Test
    public void testGuerreroVsMago() {
        // Guerrero (Espada, Armadura de Acero) vs Mago (Bastón, Armadura de Cuero)
        director.setBuilder(guerreroBuilder);
        Personaje guerrero = director.build("Guerrero");
        director.setBuilder(magoBuilder);
        Personaje mago = director.build("Mago");

        guerrero.enfrentar(mago);

        // Guerrero ataca a Mago: Espada contra Cuero = 8 daño
        // Mago ataca a Guerrero: Bastón contra Acero = 1 daño
        assertEquals(100 - 1, guerrero.getVida()); // 100 - 1 = 99
        assertEquals(100 - 8, mago.getVida());     // 100 - 8 = 92
    }

    @Test
    public void testArqueroVsThoor() {
        // Arquero (Arco, Armadura de Cuero) vs Thoor (Martillo, Armadura de Hierro)
        director.setBuilder(arqueroBuilder);
        Personaje arquero = director.build("Arquero");
        director.setBuilder(thoorBuilder);
        Personaje thoor = director.build("Thoor");

        arquero.enfrentar(thoor);

        // Arquero ataca a Thoor: Arco contra Hierro = 3 daño
        // Thoor ataca a Arquero: Martillo contra Cuero = 15 daño
        assertEquals(100 - 15, arquero.getVida()); // 100 - 15 = 85
        assertEquals(100 - 3, thoor.getVida());    // 100 - 3 = 97
    }

    @Test
    public void testMagoVsGuerrero_MagoMuere() {
        // Mago (Bastón, Armadura de Cuero) vs Guerrero (Espada, Armadura de Acero)
        director.setBuilder(magoBuilder);
        Personaje mago = director.build("Mago");
        director.setBuilder(guerreroBuilder);
        Personaje guerrero = director.build("Guerrero");

        mago.setVida(5);

        
        guerrero.enfrentar(mago);

        // Guerrero ataca a Mago: Espada contra Cuero = 8 daño (Mago muere, vida = 0)
        // Como Mago muere, no debería atacar de vuelta
        assertEquals(0, mago.getVida());           // Mago muerto
        assertEquals(100, guerrero.getVida());     // Guerrero no recibe daño
    }

    @Test
    public void testPersonajeSinVidaLanzaExcepcion() {
        // Guerrero vs Arquero, pero Arquero está muerto
        director.setBuilder(guerreroBuilder);
        Personaje guerrero = director.build("Guerrero");
        director.setBuilder(arqueroBuilder);
        Personaje arquero = director.build("Arquero");

        arquero.setVida(0);

        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            guerrero.enfrentar(arquero);
        });

        assertEquals("Personaje con vida insuficiente para el combate", exception.getMessage());
    }

    @Test
    public void testAmbosPersonajesSinVidaLanzaExcepcion() {
        // Ambos personajes están muertos
        director.setBuilder(guerreroBuilder);
        Personaje guerrero = director.build("Guerrero");
        director.setBuilder(magoBuilder);
        Personaje mago = director.build("Mago");

        guerrero.setVida(0);
        mago.setVida(0);

        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            guerrero.enfrentar(mago);
        });

        assertEquals("Personaje con vida insuficiente para el combate", exception.getMessage());
    }

    @Test
    public void testThoorVsArquero_ArqueroMuere() {
        // Thoor (Martillo, Armadura de Hierro) vs Arquero (Arco, Armadura de Cuero)
        director.setBuilder(thoorBuilder);
        Personaje thoor = director.build("Thoor");
        director.setBuilder(arqueroBuilder);
        Personaje arquero = director.build("Arquero");

        arquero.setVida(10);

        thoor.enfrentar(arquero);

        // Thoor ataca a Arquero: Martillo contra Cuero = 15 daño (Arquero muere)
        // Arquero no ataca porque está muerto
        assertEquals(0, arquero.getVida());        // Arquero muerto
        assertEquals(100, thoor.getVida());        // Thoor no recibe daño
    }
}
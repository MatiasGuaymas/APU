package ar.edu.unlp.info.oo2._Ejercicio19;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class WeatherStationTest {
    private HomeWeatherStation homeWeatherStation;
    private CelciusAdapter celciusAdapter;

    @BeforeEach
    public void setUp() {
        // Inicializa con 86°F, presión 1008, radiación 200
        homeWeatherStation = new HomeWeatherStation(86, 1008, 200);
        // Temperaturas: [82.4°F (28°C), 86°F (30°C), 89.6°F (32°C)]
        // Promedio Celsius: (28 + 30 + 32) / 3 = 30
        // Promedio Fahrenheit: (82.4 + 86 + 89.6) / 3 = 86
        homeWeatherStation.addTemperatura(82.4);
        homeWeatherStation.addTemperatura(86.0);
        homeWeatherStation.addTemperatura(89.6);

        celciusAdapter = new CelciusAdapter(homeWeatherStation);
    }

    @Test
    public void testEj1_HomeWeatherStation() {

        String expected = "Temperatura F: 86.0; Presión atmosf: 1008.0; Radiación solar: 200.0;";
        assertEquals(expected, homeWeatherStation.displayData());
    }

    @Test
    public void testEj2_CelsiusAdapter() {
        String expected = "Temperatura C: 30; Presión atmosf: 1008; Radiación solar: 200;";
        assertEquals(expected, celciusAdapter.displayData());
    }

    @Test
    public void testEj3_CelsiusWithPromDecorator() {
        WeatherData decorated = new PromDecorator(celciusAdapter);
        String expected = "Temperatura C: 30; Presión atmosf: 1008; Radiación solar: 200; Promedio: 30;";
        assertEquals(expected, decorated.displayData());
    }

    @Test
    public void testEj4_HomeWeatherStationWithPromDecorator() {
        WeatherData decorated = new PromDecorator(homeWeatherStation);
        String expected = "Temperatura F: 86.0; Presión atmosf: 1008.0; Radiación solar: 200.0; Promedio: 86;";
        assertEquals(expected, decorated.displayData());
    }

    @Test
    public void testEj5_CelsiusWithPromMinMaxDecorators() {
        WeatherData decorated = new PromDecorator(celciusAdapter);
        decorated = new MinDecorator(decorated);
        decorated = new MaxDecorator(decorated);
        String expected = "Temperatura C: 30; Presión atmosf: 1008; Radiación solar: 200; Promedio: 30; Mínimo: 27; Máximo: 32;";
        assertEquals(expected, decorated.displayData());
    }

    @Test
    public void testEj6_CelsiusWithMinMaxDecorators() {
        WeatherData decorated = new MinDecorator(celciusAdapter);
        decorated = new MaxDecorator(decorated);
        String expected = "Temperatura C: 30; Presión atmosf: 1008; Radiación solar: 200; Mínimo: 27; Máximo: 32;";
        assertEquals(expected, decorated.displayData());
    }

    @Test
    public void testEj7_CelsiusWithMinMaxPromDecorators() {
        WeatherData decorated = new MinDecorator(celciusAdapter);
        decorated = new MaxDecorator(decorated);
        decorated = new PromDecorator(decorated);
        String expected = "Temperatura C: 30; Presión atmosf: 1008; Radiación solar: 200; Mínimo: 27; Máximo: 32; Promedio: 30;";
        assertEquals(expected, decorated.displayData());
    }
}
package edu.fiuba.algo3.testsUnitarios;

import edu.fiuba.algo3.modelo.Pista;
import edu.fiuba.algo3.modelo.Tiempo;
import edu.fiuba.algo3.modelo.Ciudad;
import edu.fiuba.algo3.modelo.sitios.edificios.Aeropuerto;
import edu.fiuba.algo3.modelo.sitios.edificios.Edificio;
import edu.fiuba.algo3.modelo.sitios.edificios.Puerto;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EdificioTest {
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }

    @Test
    public void test01EdificioMuestraPista() {
        Edificio edif = new Aeropuerto("Soy una pista");

        Pista pista =  edif.mostrarPista();
        assertEquals("Soy una pista", pista.mostrar());
    }

    @Test
    public void test02EdificioAumentaTiempoUnaVez() {
        /**
         * TODO: Tratar de solucionar usando mockito
         */
        // Tiempo tiempoMock = mock(Tiempo.class);
        Tiempo tiempo = new Tiempo();
        Edificio edif = new Aeropuerto("Soy una pista");

        // edif.aumentarTiempo(tiempoMock);
        // verify(tiempoMock).sumarHoras(1);

        edif.aumentarTiempo(tiempo);

        assertEquals(1, tiempo.obtenerHorasPasadas());
    }

    @Test
    public void test03EdificioAumentaTiempoDosVeces() {
        /**
         * TODO: Tratar de solucionar usando mockito
         */
        // Tiempo tiempoMock = mock(Tiempo.class);
        Tiempo tiempo = new Tiempo();
        Edificio edif = new Aeropuerto("Soy una pista");

        // edif.aumentarTiempo(tiempoMock);
        // verify(tiempoMock).sumarHoras(1);

        // +1 hora
        edif.aumentarTiempo(tiempo);
        //+2 horas
        edif.aumentarTiempo(tiempo);

        assertEquals(3, tiempo.obtenerHorasPasadas());
    }

    @Test
    public void test03EdificioAumentaTiempoTresVeces() {
        /**
         * TODO: Tratar de solucionar usando mockito
         */
        // Tiempo tiempoMock = mock(Tiempo.class);
        Tiempo tiempo = new Tiempo();
        Edificio edif = new Aeropuerto("Soy una pista");

        // edif.aumentarTiempo(tiempoMock);
        // verify(tiempoMock).sumarHoras(1);

        // +1 hora
        edif.aumentarTiempo(tiempo);
        //+2 horas
        edif.aumentarTiempo(tiempo);
        //+3 horas
        edif.aumentarTiempo(tiempo);

        assertEquals(6, tiempo.obtenerHorasPasadas());
    }

    @Test
    public void test04EdificioAumentaTiempoDiezVeces() {
        /**
         * TODO: Tratar de solucionar usando mockito
         */
        // Tiempo tiempoMock = mock(Tiempo.class);
        Tiempo tiempo = new Tiempo();
        Edificio edif = new Aeropuerto("Soy una pista");

        // edif.aumentarTiempo(tiempoMock);
        // verify(tiempoMock).sumarHoras(1);

        for(int i = 0; i <10; i++)
            edif.aumentarTiempo(tiempo);

        assertEquals(27, tiempo.obtenerHorasPasadas());
    }
/*
    //Caso de uso 04
    @Test
    public void test05AeropuertoAumentaTiempoTresVeces() {
        Edificio puerto = new Puerto("Soy una Pista de un puerto.");
        Edificio aeropuerto = new Aeropuerto("Soy una Pista de una aeropuerto.");
        List<Edificio> edificios = new ArrayList<Edificio>();
        Ciudad montreal = new Ciudad("Montreal", edificios);
        List<Ciudad> ciudades = new ArrayList<Ciudad>();

        Tiempo tiempo = new Tiempo();

        edificios.add(aeropuerto);
        ciudades.add(montreal);

        for(int i = 0; i <3; i++)
            aeropuerto.aumentarTiempo(tiempo);

        assertEquals(6, tiempo.obtenerHorasPasadas());
    }

    //Caso de uso 04
    @Test
    public void test06PuertoAumentaTiempoCincuentaYCincoVeces() {
        Edificio puerto = new Puerto("Soy una Pista de un puerto.");
        List<Edificio> edificios = new ArrayList<Edificio>();
        Ciudad montreal = new Ciudad("Montreal", edificios);
        List<Ciudad> ciudades = new ArrayList<Ciudad>();

        Tiempo tiempo = new Tiempo(200);

        edificios.add(puerto);
        ciudades.add(montreal);

        for(int i = 0; i <55; i++)
            puerto.aumentarTiempo(tiempo);

        assertEquals(162, tiempo.obtenerHorasPasadas());
    }

*/
}

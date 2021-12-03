package edu.fiuba.algo3.testsUnitarios;

import edu.fiuba.algo3.modelo.Tiempo;
import edu.fiuba.algo3.modelo.edificios.Edificio;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

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
        Edificio edif = new Edificio("Soy una pista");

        edif.mostrarPista();
        assertEquals("Soy una pista", outputStreamCaptor.toString().trim());

    }

    @Test
    public void test02EdificioAumentaTiempoUnaVez() {
        /**
         * TODO: Tratar de solucionar usando mockito
         */
        // Tiempo tiempoMock = mock(Tiempo.class);
        Tiempo tiempo = new Tiempo(10);
        Edificio edif = new Edificio("Soy una pista");

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
        Tiempo tiempo = new Tiempo(10);
        Edificio edif = new Edificio("Soy una pista");

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
        Tiempo tiempo = new Tiempo(10);
        Edificio edif = new Edificio("Soy una pista");

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
        Tiempo tiempo = new Tiempo(50);
        Edificio edif = new Edificio("Soy una pista");

        // edif.aumentarTiempo(tiempoMock);
        // verify(tiempoMock).sumarHoras(1);

        for(int i = 0; i <10; i++)
            edif.aumentarTiempo(tiempo);

        assertEquals(27, tiempo.obtenerHorasPasadas());
    }

}

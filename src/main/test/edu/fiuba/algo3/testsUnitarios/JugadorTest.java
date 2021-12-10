package edu.fiuba.algo3.testsUnitarios;

import edu.fiuba.algo3.modelo.Tiempo;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.cargos.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import javax.xml.catalog.Catalog;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.when;

public class JugadorTest {

    private String nombre = "Mateo";

    //Caso de uso 05
    @Test
    public void test01JugadorRecibeHeridaDeCuchilloPorPrimeraVez() {
        Tiempo tiempo = new Tiempo(10);
        Jugador jugador = new Jugador(nombre);
        jugador.recibirHeridaCuchillo(tiempo);

        assertEquals(2, tiempo.obtenerHorasPasadas());
    }

    //Caso de uso 05
    @Test
    public void test02JugadorRecibeHeridaDeCuchilloPorSegundaVez() {
        Tiempo tiempo = new Tiempo(10);
        Jugador jugador = new Jugador(nombre);

        jugador.recibirHeridaCuchillo(tiempo);
        jugador.recibirHeridaCuchillo(tiempo);

        assertEquals(3, tiempo.obtenerHorasPasadas());
    }

    //Caso de uso 05
    @Test
    public void test03JugadorDuerme() {
        Tiempo tiempo = new Tiempo(10);
        Jugador jugador = new Jugador(nombre);

        jugador.dormir(tiempo);

        assertEquals(8, tiempo.obtenerHorasPasadas());
    }

    @Test
    public void test04JugadorConMenosDe5ArrestosTieneCargoNovato(){
        Jugador jugador = new Jugador("Lucas");
        int i = 0;
        while (i < 3) {
            jugador.agregarArresto();
            i += 1;
        }
        Cargo aux = new Novato();
        assertEquals(aux.getClass(), jugador.getCargo().getClass());
    }
    @Test
    public void test05JugadorCon5ArrestosTieneCargoDetective(){
        Jugador jugador = new Jugador("Lucas");
        int i = 0;
        while (i < 5) {
            jugador.agregarArresto();
            i += 1;
        }
        Cargo aux = new Detective();
        assertEquals(aux.getClass(), jugador.getCargo().getClass());
    }
    @Test
    public void test06JugadorCon10ArrestosTieneCargoInvestigador(){
        Jugador jugador = new Jugador("Lucas");
        int i = 0;
        while (i < 10) {
            jugador.agregarArresto();
            i += 1;
        }
        Cargo aux = new Investigador();
        assertEquals(aux.getClass(), jugador.getCargo().getClass());
    }
    @Test
    public void test07JugadorCon20ArrestosTieneCargoInvestigador(){
        Jugador jugador = new Jugador("Lucas");
        int i = 0;
        while (i < 20) {
            jugador.agregarArresto();
            i += 1;
        }
        Cargo aux = new Sargento();
        assertEquals(aux.getClass(), jugador.getCargo().getClass());
    }
}

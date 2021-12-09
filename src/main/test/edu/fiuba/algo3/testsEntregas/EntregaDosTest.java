package edu.fiuba.algo3.testsEntregas;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.cargos.Cargo;
import edu.fiuba.algo3.modelo.cargos.Investigador;
import edu.fiuba.algo3.modelo.cargos.Novato;
import edu.fiuba.algo3.modelo.objetos.ObjetoComun;
import edu.fiuba.algo3.modelo.sitios.edificios.Banco;
import edu.fiuba.algo3.modelo.sitios.edificios.Edificio;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EntregaDosTest {

    @Test
    public void test01JugadorConCargoInvestigadorViajaDeMontrealAMexico() {
        int horasPasadasEsperadas = 3;

        Cargo investigador = new Investigador();
        Jugador jugador = new Jugador("Mateo");
        jugador.asignarCargo(investigador);

        Ubicacion uMontreal = new Ubicacion(-73.575439, 45.498646);
        Ubicacion uMexico = new Ubicacion(-99.228515, 19.394067);
        Ciudad montreal = new Ciudad("Montreal", null, uMontreal);
        Ciudad mexico = new Ciudad("México", null, uMexico);

        List<Ciudad> ciudades = new ArrayList<Ciudad>();
        ciudades.add(montreal);
        ciudades.add(mexico);

        Nivel nivel = new Nivel(montreal, jugador, null, null, ciudades);

        assertEquals(nivel.obtenerCiudadActual(), montreal);
        nivel.visitarCiudad(mexico);
        assertEquals(horasPasadasEsperadas, nivel.obtenerTiempo());
        assertEquals(nivel.obtenerCiudadActual(), mexico);
    }

    @Test
    public void test02CargarDatosEnComputadoraYBuscarSospechosos() {

        Ciudad mexico = new Ciudad("México", null, null);
        List<Ciudad> ciudades = new ArrayList<Ciudad>();
        ciudades.add(mexico);

        ObjetoComun tesoro = new ObjetoComun("perla");

        Ladron ladron1 = new Ladron("masculino","escalar", "negro", "anillo", "motocicleta");
        Ladron ladron2 = new Ladron("femenino","tenis", "rubio", "tatuaje", "limusina");
        Ladron ladron3 = new Ladron("masculino","croquet", "negro", "joya", "motocicleta");

        List<Ladron> ladrones= new ArrayList<>();
        ladrones.add(ladron1);
        ladrones.add(ladron2);
        ladrones.add(ladron3);

        Ladron sospechoso = new Ladron("masculino","", "", "", "motocicleta");
        Nivel nivel = new Nivel(mexico, null, tesoro, ladron1, ciudades,ladrones);

        List<Ladron> resultado= nivel.buscarLadrones(sospechoso.obtenerDatos());
        List<Ladron> sospechosos= new ArrayList<>();
        sospechosos.add(ladron1);
        sospechosos.add(ladron3);


        assertEquals(sospechosos,resultado);
    }


    @Test
    public void test04IntentarDeAtraparAlSospechosoSinLaOrdenEmitida(){

        int horasPasadasEsperadas = 3;
        Jugador jugador = new Jugador("Mateo");

        Ubicacion uMontreal = new Ubicacion(-73.575439, 45.498646);
        Ubicacion uMexico = new Ubicacion(-99.228515, 19.394067);
        Ubicacion uBuenosAires = new Ubicacion(-58.3712, -34.6083);
        Ubicacion uColombo = new Ubicacion(79.8477800, 6.9319400);

        Ciudad montreal = new Ciudad("Montreal", null, uMontreal);
        Ciudad mexico = new Ciudad("México", null, uMexico);
        Ciudad buenosAires = new Ciudad("Buenos Aires", null, uMontreal);
        Ciudad colombo = new Ciudad("Colombo", null, uMontreal);

        List<Ciudad> ciudades = new ArrayList<Ciudad>();
        ciudades.add(montreal);
        ciudades.add(mexico);
        ciudades.add(colombo);
        ciudades.add(buenosAires);

        ObjetoComun tesoro = new ObjetoComun("perla");

        Ladron ladron = new Ladron("masculino","escalar", "negro", "anillo", "motocicleta");

        Nivel nivel = new Nivel(montreal, jugador, tesoro, ladron, ciudades);
    }
}

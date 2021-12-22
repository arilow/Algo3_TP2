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

import static org.junit.jupiter.api.Assertions.*;

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
//
//    @Test
//    public void test02CargarDatosEnComputadoraYBuscarSospechosos() {
//
//        Ciudad mexico = new Ciudad("México", null, null);
//        List<Ciudad> ciudades = new ArrayList<Ciudad>();
//        ciudades.add(mexico);
//
//        ObjetoComun tesoro = new ObjetoComun("perla");
//
//        Ladron ladron1 = new Ladron("masculino","escalar", "negro", "anillo", "motocicleta");
//        Ladron ladron2 = new Ladron("femenino","tenis", "rubio", "tatuaje", "limusina");
//        Ladron ladron3 = new Ladron("masculino","croquet", "negro", "joya", "motocicleta");
//
//        List<Ladron> ladrones= new ArrayList<>();
//        ladrones.add(ladron1);
//        ladrones.add(ladron2);
//        ladrones.add(ladron3);
//
//        Ladron sospechoso = new Ladron("masculino","", "", "", "motocicleta");
//        Nivel nivel = new Nivel(mexico, null, tesoro, ladron1, ciudades,ladrones);
//
//        /*List<Ladron> resultado= nivel.buscarLadrones(sospechoso.obtenerDatos());
//        List<Ladron> sospechosos= new ArrayList<>();
//        sospechosos.add(ladron1);
//        sospechosos.add(ladron3);
//
//        assertEquals(sospechosos,resultado);*/
//    }
//
//
//    @Test
//    public void test04IntentarAtraparAlSospechosoSinLaOrdenEmitida(){
//    //No se contempla la cantidad de ciudades visitadas
//        int horasPasadasEsperadas = 3;
//        Jugador jugador = new Jugador("Mateo");
//
//        Ubicacion uMontreal = new Ubicacion(-73.575439, 45.498646);
//        Ubicacion uMexico = new Ubicacion(-99.228515, 19.394067);
//        Ubicacion uBuenosAires = new Ubicacion(-58.3712, -34.6083);
//        Ubicacion uColombo = new Ubicacion(79.8477800, 6.9319400);
//
//        Edificio aeropuerto = new Banco("Soy una Pista de un aeropuerto.");
//        Edificio puerto = new Banco("Soy una Pista de un puerto.");
//        Edificio banco = new Banco("Soy una Pista de un banco.");
//        List<Edificio> edificios = new ArrayList<Edificio>();
//        edificios.add(banco);
//        edificios.add(puerto);
//        edificios.add(aeropuerto);
//
//        Ciudad montreal = new Ciudad("Montreal", edificios, uMontreal);
//        Ciudad mexico = new Ciudad("México", edificios, uMexico);
//        Ciudad buenosAires = new Ciudad("Buenos Aires", edificios, uBuenosAires);
//        Ciudad colombo = new Ciudad("Colombo", edificios, uColombo);
//
//        List<Ciudad> ciudades = new ArrayList<Ciudad>();
//        ciudades.add(montreal);
//        ciudades.add(mexico);
//        ciudades.add(colombo);
//        ciudades.add(buenosAires);
//
//        ObjetoComun tesoro = new ObjetoComun("papiro");
//
//        Ladron ladron = new Ladron("masculino","escalar", "negro", "anillo", "motocicleta", buenosAires, 2, "Smiggle");
//
//        Nivel nivel = new Nivel(montreal, jugador, tesoro, ladron, ciudades);
//
//        nivel.visitarCiudad(buenosAires);
//        nivel.entrarAEdificio(2);
//
//        assertTrue(ladron.estaLibre());
//
//    }
//
//    @Test
//    public void test05IntentarAtraparAlSospechosoConLaOrdenEmitida(){
//
//        Jugador jugador = new Jugador("Ari");
//
//        Ubicacion uMontreal = new Ubicacion(-73.575439, 45.498646);
//        Ubicacion uMexico = new Ubicacion(-99.228515, 19.394067);
//        Ubicacion uBuenosAires = new Ubicacion(-58.3712, -34.6083);
//        Ubicacion uColombo = new Ubicacion(79.8477800, 6.9319400);
//
//        Edificio aeropuerto = new Banco("Soy una Pista de un aeropuerto.");
//        Edificio puerto = new Banco("Soy una Pista de un puerto.");
//        Edificio banco = new Banco("Soy una Pista de un banco.");
//        List<Edificio> edificios = new ArrayList<Edificio>();
//        edificios.add(banco);
//        edificios.add(puerto);
//        edificios.add(aeropuerto);
//
//        Ciudad montreal = new Ciudad("Montreal", edificios, uMontreal);
//        Ciudad mexico = new Ciudad("México", edificios, uMexico);
//        Ciudad buenosAires = new Ciudad("Buenos Aires", edificios, uBuenosAires);
//        Ciudad colombo = new Ciudad("Colombo", edificios, uColombo);
//
//        List<Ciudad> ciudades = new ArrayList<Ciudad>();
//        ciudades.add(montreal);
//        ciudades.add(mexico);
//        ciudades.add(colombo);
//        ciudades.add(buenosAires);
//
//        ObjetoComun tesoro = new ObjetoComun("papiro");
//
//        Ladron ladron = new Ladron("masculino","escalar", "negro", "anillo", "motocicleta", buenosAires, 2, "Smiggle");
//
//        Nivel nivel = new Nivel(montreal, jugador, tesoro, ladron, ciudades);
//
//        nivel.visitarCiudad(buenosAires);
//        nivel.emitirOrdenDeArresto("Smiggle");
//        nivel.entrarAEdificio(2);
//
//        assertFalse(ladron.estaLibre());
//    }
//
//    @Test
//    public void test06IDetectiveRealiza6ArrestosSospechosoRobaUnIcanGoldMaskYSeAtrapaElSospechoso(){
//        //No se contempla la cantidad de ciudades visitadas
//        int horasPasadasEsperadas = 3;
//        Jugador jugador = new Jugador("Mateo");
//        //Se agregan 6 arrestos para replicar el caso de uso
//        jugador.agregarArresto();
//        jugador.agregarArresto();
//        jugador.agregarArresto();
//        jugador.agregarArresto();
//        jugador.agregarArresto();
//        jugador.agregarArresto();
//
//        CreadorDeNiveles creadorDeNiveles= new CreadorDeNiveles();
//        Nivel nivel2= creadorDeNiveles.crearNivel(jugador);
//
//
//        //Se visitan 4 ciudades, asumiendo que Ican Gold Mask es un objeto Común
//        nivel2.visitarCiudad(0);
//        nivel2.entrarAEdificio(2);
//
//        nivel2.visitarCiudad(1);
//        nivel2.entrarAEdificio(2);
//
//        nivel2.visitarCiudad(2);
//        nivel2.entrarAEdificio(2);
//
//        nivel2.visitarCiudad(3);
//        nivel2.entrarAEdificio(2);
//
//        nivel2.visitarCiudad(0);
//        nivel2.emitirOrdenDeArresto("Jorge el malevolo");
//        nivel2.entrarAEdificio(0);
//
//        assertFalse(nivel2.obtenerLadron().estaLibre());
//    }

}

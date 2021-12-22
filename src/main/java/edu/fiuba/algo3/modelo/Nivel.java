package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.objetos.ObjetoComun;
import edu.fiuba.algo3.modelo.objetos.ObjetoRobado;
import edu.fiuba.algo3.modelo.sitios.edificios.Edificio;
//import javafx.beans.Observable;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class Nivel {

    private List<Ciudad> ciudades;
    private Ladron ladron;
    private List<Ladron> ladronesNivel;
    private List<Ladron> ladronesSospechosos;
    private ObjetoRobado tesoro;
    private Ciudad ciudadActual;
    private Tiempo tiempo;
    private Jugador jugador;
    private OrdenDeArresto ordenDeArresto;
    private Interpol interpol;
    private Mapa mapa;

    ComunicadorEstadoPartida comunicadorEstadoPartida;

    public Nivel(Ciudad ciudad, Jugador jugador, ObjetoRobado tesoro, Ladron ladron, List<Ciudad> ciudades){
        tiempo = new Tiempo(10);
        this.ciudades = ciudades;
        this.ciudadActual = ciudad;
        this.jugador = jugador;
        this.tesoro = tesoro;
        this.ladron = ladron;
        this.ordenDeArresto = new OrdenDeArresto();
//        this.mapa = new Mapa(ciudades);
    }

    /*public Nivel(Ciudad ciudad, Jugador jugador, ObjetoRobado tesoro, Ladron ladron, List<Ciudad> ciudades, List<Ladron> ladronesNivel){
        tiempo = new Tiempo(10);
        this.ciudades = ciudades;
        this.ciudadActual = ciudad;
        ciudadActual.esVisitada();
        this.jugador = jugador;
        this.tesoro = tesoro;
        this.ladron = ladron;
        this.ladronesNivel= ladronesNivel;
        this.ordenDeArresto = new OrdenDeArresto();
    }*/

    public void jugar(ComunicadorEstadoPartida comunicadorEstadoPartida) {
        this.comunicadorEstadoPartida = comunicadorEstadoPartida;
//        this.jugador = jugador;

        //aca va el game loop.
    }

    public void visitarCiudad(Ciudad ciudad){
        jugador.viajar(ciudadActual.obtenerDistancia(ciudad), tiempo);
        ciudadActual = ciudad;
        ciudadActual.esVisitada();
        comunicadorEstadoPartida.definirEstado(EstadoPartida.VIAJAR);
    }

    public void visitarCiudad(int ciudad) {
        ciudadActual = ciudades.get(ciudad);
        jugador.viajar(ciudadActual.obtenerDistancia(ciudades.get(ciudad)), tiempo);
        ciudadActual.esVisitada();
    }

    public Ciudad obtenerCiudadActual() { return ciudadActual;}

    //TODO edificio no es un int
    public void entrarAEdificio(int edificio){
        if (ladron.estaEn(ciudadActual.obtenerNombre(), edificio)){
            if(ladronArrestado()){
                jugador.agregarArresto();
                // todo terminar nivel
            }else{
                // Pierdo el nivel
            }
        }
        System.out.println("Nivel: entrarAEdificio");
        System.out.println(ciudadActual.entrarAEdificio(edificio, tiempo).mostrar());

        comunicadorEstadoPartida.definirEstado(EstadoPartida.ENTRAR_A_EDIFICIO);

    }

    private boolean ladronArrestado() {
        return this.ordenDeArresto.verificarLadron(ladron);
    }

    public void asignarUbicacionALadron(Ciudad ciudad, int edificio){
        ladron.moverserA(ciudad, edificio);
    }

    public void salirDeEdificio() {
        ciudadActual.salirDeEdificio();
    }

    public int obtenerTiempo() {
        return tiempo.obtenerHorasPasadas();
    }

    public boolean tieneTesoro(String tesoro) {
        return this.tesoro.es(tesoro);
    }

    public boolean constatarDatosLadron(DatosLadron datos) {
        return ladron.constatarDatos(datos);
    }//Usado unicamente en un assert dentro de NivelTest

    public void buscarLadrones(DatosLadron datosLadron){
        interpol = new Interpol(ciudades, ladron);
        ladronesSospechosos = interpol.buscarLadrones(datosLadron);
        if (ladronesSospechosos.size() == 1){
            emitirOrdenDeArresto(ladronesSospechosos.get(0).obtenerNombre());
        }
        comunicadorEstadoPartida.definirEstado(EstadoPartida.BUSCAR_SOSPECHOSOS);
    }

    public List<Ladron> obtenerListaSospechosos(){
        return ladronesSospechosos;
    }
    public int obtenerCantidadCiudadesEscape() {
       return tesoro.obtenerCantidadCiudadesEscape();
    }

    public void emitirOrdenDeArresto(String nombreLadron){
        this.ordenDeArresto.emitirOrdenDeArresto(nombreLadron);
        System.out.print("Se emite orden de arresto para: " + nombreLadron);
    }
    public Ladron obtenerLadron(){
        return ladron;
    }

    /*public boolean estaEn(String ciudad) {
        return ciudadActual.es(ciudad);
    }*/

    public List<String> listarEdificios() {
        return ciudadActual.listarEdificios();
    }

    public String obtenerFecha() {
        return tiempo.aString();
    }
    public void agregarObservadorDeEdificios(Observer observer) {
        ciudadActual.agregarObservadorDeEdificios(observer);
    }

    public List<Ciudad> listarCiudades() {
        return ciudades;
    }

    public void arribarACiudadActual() {
        comunicadorEstadoPartida.definirEstado(EstadoPartida.ARRIBADO_A_CIUDAD_ACTUAL);
    }

    public Edificio obtenerEdificioActual() {
        return ciudadActual.obtenerEdificioActual();
    }

    public Jugador obtenerJugador() {
        return jugador;
    }

    public String nombreTesoro() {
        return ((ObjetoComun)tesoro).nombre();
    }


    public void cambiarCiudadActual(Ciudad ciudad) {
        ciudadActual = ciudad;
    }
}

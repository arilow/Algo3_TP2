package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.objetos.ObjetoRobado;
//import javafx.beans.Observable;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class Nivel extends Observable {

    private List<Ciudad> ciudades;
    private Ladron ladron;
    private List<Ladron> ladronesNivel;
    private ObjetoRobado tesoro;
    private Ciudad ciudadActual;
    private Tiempo tiempo;
    private Jugador jugador;
    private OrdenDeArresto ordenDeArresto;
    private Interpol interpol;

    ComunicadorEstadoPartida comunicadorEstadoPartida;

    public Nivel(Ciudad ciudad, Jugador jugador, ObjetoRobado tesoro, Ladron ladron, List<Ciudad> ciudades){
        tiempo = new Tiempo(10);
        this.ciudades = ciudades;
        this.ciudadActual = ciudad;
        this.jugador = jugador;
        this.tesoro = tesoro;
        this.ladron = ladron;
        this.ordenDeArresto = new OrdenDeArresto();
    }

    public Nivel(Ciudad ciudad, Jugador jugador, ObjetoRobado tesoro, Ladron ladron, List<Ciudad> ciudades, List<Ladron> ladronesNivel){
        tiempo = new Tiempo(10);
        this.ciudades = ciudades;
        this.ciudadActual = ciudad;
        ciudadActual.esVisitada();
        this.jugador = jugador;
        this.tesoro = tesoro;
        this.ladron = ladron;
        this.ladronesNivel= ladronesNivel;
        this.ordenDeArresto = new OrdenDeArresto();
    }

    public void jugar(ComunicadorEstadoPartida comunicadorEstadoPartida) {
        this.comunicadorEstadoPartida = comunicadorEstadoPartida;
//        this.jugador = jugador;

        //aca va el game loop.
    }

    public void visitarCiudad(Ciudad ciudad){
        jugador.viajar(ciudadActual.obtenerDistancia(ciudad), tiempo);
        this.ciudadActual = ciudad;
        this.ciudadActual.esVisitada();
    }

    public void visitarCiudad(int ciudad) {
        this.ciudadActual = ciudades.get(ciudad);
        jugador.viajar(ciudadActual.obtenerDistancia(ciudades.get(ciudad)), tiempo);
        this.ciudadActual.esVisitada();
    }

    public Ciudad obtenerCiudadActual() { return ciudadActual;}

    //TODO edificio no es un int
    public void entrarAEdificio(int edificio){
        if (ladron.estaEn(ciudadActual.obtenerNombre(), edificio)){ //La verificación de las ciudades visitadas no funciona. Tira true no importa lo que le pongas
            if(this.ladronArrestado()){
                jugador.agregarArresto();
            }else{
                // Pierdo el nivel
            }
        }

        System.out.println("Nivel: entrarAEdificio");
        System.out.println(ciudadActual.entrarAEdificio(edificio, tiempo).mostrar());

        setChanged();
        notifyObservers();

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

    //TODO reemplazar por fecha
    // Obtiene la cantidad de tiempo que paso en la partida
    public int obtenerTiempo() {
        return tiempo.obtenerHorasPasadas();
    }

    public boolean tieneTesoro(String tesoro) {
        return this.tesoro.es(tesoro);
    }

    public boolean constatarDatosLadron(DatosLadron datos) {
        return ladron.constatarDatos(datos);
    }//Usado unicamente en un assert dentro de NivelTest

    //public List<Ladron> buscarLadrones(DatosLadron datosLadron, List<Ladron> listaLadrones){
        //TODO: mejorar el método de búsqueda para que no sea tan restrictivo(utilizacción de ANDs en contrastarDatos()) de filtros para encontrar los ladrones que tienen los datos buscados
    //    return listaLadrones.stream().filter( l-> l.constatarDatos(datosLadron)).collect(Collectors.toList());
    //}

    public List<Ladron> buscarLadrones(DatosLadron datosLadron){
        interpol = new Interpol();
        return interpol.buscarLadrones(datosLadron);
    }

    public int obtenerCantidadCiudadesEscape() {
       return this.tesoro.obtenerCantidadCiudadesEscape();
    }

    public void emitirOrdenDeArresto(String nombreLadron){
        this.ordenDeArresto.ejecutarOrdenDeArresto(nombreLadron);
    }
    public Ladron obtenerLadron(){
        return this.ladron;
    }

    /*public boolean estaEn(String ciudad) {
        return ciudadActual.es(ciudad);
    }*/

    public List<String> listarEdificios() {
        List<String> edificios = new ArrayList<String>();
        // TODO: pasar la listas de edificios actuales.
        edificios.add("Edificio1");
        edificios.add("Edificio2");
        edificios.add("Edificio3");

        return edificios;
    }

    public String obtenerFecha() {
        return tiempo.aString();
    }
    public void agregarObservadorDeEdificios(Observer observer) {
        ciudadActual.agregarObservadorDeEdificios(observer);
    }

    public void agregarObervadorDeTiempo(Observer observer) {
        tiempo.addObserver(observer);
    }

    public void arribarACiudadActual() {
        comunicadorEstadoPartida.definirEstado(EstadoPartida.ARRIBADO_A_CIUDAD_ACTUAL);
        System.out.println("Empezando Investigacion");
    }
}

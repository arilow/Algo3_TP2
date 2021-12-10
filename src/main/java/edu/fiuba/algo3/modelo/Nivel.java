package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.objetos.ObjetoRobado;
import edu.fiuba.algo3.modelo.sitios.edificios.Edificio;
import javafx.beans.Observable;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Nivel {
    private List<Ciudad> ciudades;
    private Ladron ladron;
    private List<Ladron> ladronesNivel;
    private ObjetoRobado tesoro;
    private Ciudad ciudadActual;
    private Tiempo tiempo;
    private Jugador jugador;
    private int ciudadesVisitadas;
    private OrdenDeArresto ordenDeArresto;


    public Nivel(Ciudad ciudad, Jugador jugador, ObjetoRobado tesoro, Ladron ladron, List<Ciudad> ciudades){
        tiempo = new Tiempo(10);
        this.ciudades = ciudades;
        this.ciudadActual = ciudad;
        this.jugador = jugador;
        this.tesoro = tesoro;
        this.ladron = ladron;
        this.ciudadesVisitadas = 1;
    }
    public Nivel(Ciudad ciudad, Jugador jugador, ObjetoRobado tesoro, Ladron ladron, List<Ciudad> ciudades, List<Ladron> ladronesNivel){
        tiempo = new Tiempo(10);
        this.ciudades = ciudades;
        this.ciudadActual = ciudad;
        this.jugador = jugador;
        this.tesoro = tesoro;
        this.ladron = ladron;
        this.ladronesNivel= ladronesNivel;
        this.ciudadesVisitadas = 1;
        this.ordenDeArresto = new OrdenDeArresto();
    }

    public void jugar(/*Jugador jugador*/) {
//        this.jugador = jugador;

        //aca va el game loop.
    }

    public void visitarCiudad(Ciudad ciudad){
        jugador.viajar(ciudadActual.obtenerDistancia(ciudad), tiempo);
        this.ciudadActual = ciudad;
    }

    public Ciudad obtenerCiudadActual() { return ciudadActual;}

    public int obtenerCiudadesVisitadas() { return ciudadesVisitadas;}

    //TODO edificio no es un int
    public void entrarAEdificio(int edificio){
        if (ladron.estaEn(ciudadActual.obtenerNombre(), edificio)){
            if(this.atraparLadron()){
                //ladron.encarcelar();
            }
        }
        ciudadActual.entrarAEdificio(edificio, tiempo);
    }

    private boolean atraparLadron() {
        if(this.ordenDeArresto.fueEjecutada()){
            return true;
        }else {
            return false;
        }
    }

    public void asignarUbicacionALadron(Ciudad ciudad, int edificio){
        ladron.moverserA(ciudad, edificio);
    }

    public void arrestarLadron(){

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
        List<Ladron> sospechosos= new ArrayList<>();
        Ladron aux= new Ladron(null,null,null,null,null);
        for(Ladron ladron: ladronesNivel){
            if(ladron.constatarDatos(datosLadron)) {
                sospechosos.add(ladron);
            }
        }
        return sospechosos;
    }

    public int obtenerCantidadCiudadesEscape() {
       return this.tesoro.obtenerCantidadCiudadesEscape();
    }

    /*public void emitirOrdenDeArresto(String nombreLadron){
        this.ordenDeArresto = new OrdenDeArresto(nombreLadron);
    }*/

    /*public boolean estaEn(String ciudad) {
        return ciudadActual.es(ciudad);
    }*/
}

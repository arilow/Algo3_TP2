package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.objetos.ObjetoRobado;

import java.util.ArrayList;
import java.util.List;

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
        this.ciudadActual.esVisitada();
        ciudadesVisitadas+=1;
    }
    public void visitarCiudad(int ciudad) {
        this.ciudadActual = ciudades.get(ciudad);
        jugador.viajar(ciudadActual.obtenerDistancia(ciudades.get(ciudad)), tiempo);
        this.ciudadActual.esVisitada();
        ciudadesVisitadas+=1;
    }

    public Ciudad obtenerCiudadActual() { return ciudadActual;}

    public int obtenerCiudadesVisitadas() { return ciudadesVisitadas;}

    //TODO edificio no es un int
    public void entrarAEdificio(int edificio){
        if (ladron.estaEn(ciudadActual.obtenerNombre(), edificio)){ //La verificación de las ciudades visitadas no funciona. Tira true no importa lo que le pongas
            if(this.ladronArrestado() && ciudadesVisitadas>=this.tesoro.obtenerCantidadCiudadesEscape()){
                jugador.agregarArresto();
            }else{
                return;
                /*Random rand = new Random();
                for (int i = 0; i < ciudades.size(); i+=1){
                }
                Ciudad ciudadDestino = ciudades.get(rand.nextInt(ciudades.size()));
                ciudadDestino.asignarLadron();
                ciudadDestino.asignarLadronAEdificio(rand.nextInt(4));*/
            }
        }
        ciudadActual.entrarAEdificio(edificio, tiempo);
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

    public void emitirOrdenDeArresto(String nombreLadron){
        this.ordenDeArresto.ejecutarOrdenDeArresto(nombreLadron);
    }
    public Ladron obtenerLadron(){
        return this.ladron;
    }

    /*public boolean estaEn(String ciudad) {
        return ciudadActual.es(ciudad);
    }*/
}

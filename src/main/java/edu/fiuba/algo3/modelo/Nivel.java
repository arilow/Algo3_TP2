package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.objetos.ObjetoComun;
import edu.fiuba.algo3.modelo.objetos.ObjetoRobado;
import edu.fiuba.algo3.modelo.sitios.edificios.Edificio;

import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class Nivel implements Observer{
    private Ladron ladron;
    private List<Ladron> ladronesSospechosos;
    private ObjetoRobado tesoro;
    private Ciudad ciudadActual;
    private Tiempo tiempo;
    private Jugador jugador;
    private OrdenDeArresto ordenDeArresto;
    private Interpol interpol;
    private Mapa mapa;

    ComunicadorEstadoPartida comunicadorEstadoPartida;

    public Nivel(String ciudad, Jugador jugador, ObjetoRobado tesoro, Ladron ladron, Mapa mapa){
        tiempo = new Tiempo();
        tiempo.addObserver(this);
        this.ciudadActual = mapa.obtenerCiudad(ciudad);
        this.jugador = jugador;
        this.tesoro = tesoro;
        this.ladron = ladron;
        this.ordenDeArresto = new OrdenDeArresto();
        this.mapa = mapa;
    }

    public void jugar(ComunicadorEstadoPartida comunicadorEstadoPartida) {
        this.comunicadorEstadoPartida = comunicadorEstadoPartida;
//        this.jugador = jugador;

        //aca va el game loop.
    }

    // TODO: Preguntar porque se esta usando esta version de visitar ciudad.
    public void visitarCiudad(Ciudad ciudad){
        jugador.viajar(ciudadActual.obtenerDistancia(ciudad), tiempo);
        this.ciudadActual = ciudad;
        comunicadorEstadoPartida.definirEstado(EstadoPartida.VIAJAR);
    }

    public Ciudad obtenerCiudadActual() { return ciudadActual;}

    //TODO edificio no es un int
    public void entrarAEdificio(int edificio){
        if (ladron.estaEn(ciudadActual.obtenerNombre(), edificio)){

            System.out.println("Nivel: entrarAEdificio");
            System.out.println(ciudadActual.entrarAEdificio(edificio, tiempo).mostrar());

            if(ladronArrestado()){
                jugador.agregarArresto();
                comunicadorEstadoPartida.definirEstado(EstadoPartida.LADRON_ARRESTADO);;
                // todo terminar nivel
            }else{
                System.out.println("Nivel perdido");
                comunicadorEstadoPartida.definirEstado(EstadoPartida.PERDER_NIVEL);
                // Pierdo el nivel
            }
            return;
        }

        ciudadActual.entrarAEdificio(edificio, tiempo);
        comunicadorEstadoPartida.definirEstado(EstadoPartida.ENTRAR_A_EDIFICIO);

    }

    private boolean ladronArrestado() {
        return this.ordenDeArresto.verificarLadron(ladron);
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
    
    public void buscarLadrones(DatosLadron datosLadron){
        interpol = new Interpol(ladron);
        ladronesSospechosos = interpol.buscarLadrones(datosLadron);
        if (ladronesSospechosos.size() == 1){
            emitirOrdenDeArresto(ladronesSospechosos.get(0).obtenerNombre());
        }
        comunicadorEstadoPartida.definirEstado(EstadoPartida.BUSCAR_SOSPECHOSOS);
    }

    public List<Ladron> obtenerListaSospechosos(){
        return ladronesSospechosos;
    }

    public void emitirOrdenDeArresto(String nombreLadron){
        this.ordenDeArresto.emitirOrdenDeArresto(nombreLadron);
        System.out.print("Se emite orden de arresto para: " + nombreLadron);
    }

    public Ladron obtenerLadron(){
        return ladron;
    }

    public List<String> listarEdificios() {
        return ciudadActual.listarEdificios();
    }

    public String obtenerFecha() {
        return tiempo.aString();
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

    public Ciudad obtenerCiudad(String ciudad) {
        return mapa.obtenerCiudad(ciudad);
    }

    @Override
    public void update(Observable o, Object arg) {
         // Lunes: 24-7 = 17hs
         // Martes a Sabada: 24hs
         // Domingo: 17hs
         // Total de horas: 17 + 24x5 + 17 = 154
        if(tiempo.obtenerHorasPasadas() >= 154) {
            comunicadorEstadoPartida.definirEstado(EstadoPartida.PERDER_NIVEL);
            System.out.println("P");
        }

    }
}

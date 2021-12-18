package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.sitios.AireLibre;
import edu.fiuba.algo3.modelo.sitios.Sitio;
import edu.fiuba.algo3.modelo.sitios.edificios.Edificio;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class Ciudad extends Observable {
    private String nombre;
    private List<Edificio> edificios;
    private Sitio sitioActual;

    private Sitio aireLibre;  // Espacio fuera de los edificios
    private boolean visitada;
    private Ubicacion ubicacion;
    private boolean tieneLadron;
    private List<Ciudad> ciudadesVisitables;
    private Mapa mapaJuego;

    protected void recibirJugador(Jugador jugador) {
        /* TODO */
    }

    public Ciudad(String nombre, List<Edificio> edificio) {
        this.nombre = nombre;
        this.edificios = edificio;
        this.aireLibre = new AireLibre();
        this.sitioActual = aireLibre;
        this.tieneLadron = false;
    }

    public Ciudad(String nombre, List<Edificio> edificio, Ubicacion ubicacion) {
        this.nombre = nombre;
        this.edificios = edificio;
        this.aireLibre = new AireLibre();
        this.sitioActual = aireLibre;
        this.ubicacion = ubicacion;
        this.tieneLadron = false;
        this.visitada = false;
    }

    public boolean es(String nombre) {
        return this.nombre.equals(nombre);
    }

    public Pista entrarAEdificio(int edificio, Tiempo tiempo) {
        this.sitioActual = edificios.get(edificio);
        edificios.get(edificio).aumentarTiempo(tiempo);

        System.out.println("Ciudad: entrarAEdificio");
        return edificios.get(edificio).mostrarPista();
    }

    public Ubicacion obtenerUbicacion(){ return ubicacion; }

    public void salirDeEdificio() {
        this.sitioActual = aireLibre;
    }

    public double obtenerDistancia(Ciudad otraCiudad) {
        return this.ubicacion.calcularDistancia(otraCiudad.obtenerUbicacion());
    }

    public void asignarLadronAEdificio(int edificio){
        edificios.get(edificio).asignarLadron();
    }

    public void asignarLadron(){
        this.tieneLadron = true;
    }

    public boolean tieneLadron(){ return tieneLadron; }

    public String obtenerNombre() {
        return nombre;
    }

    public void esVisitada() {
        visitada = true;
    }

    public void agregarObservadorDeEdificios(Observer observer) {
        for(Edificio edificio: edificios) {
            edificio.addObserver(observer);
        }
    }

    public void agregarObservadorDeCiudades(Observer observer) {
        for(Ciudad ciudad: ciudadesVisitables) {
            ciudad.addObserver(observer);
        }
    }

    public Edificio obtenerEdificioActual() {
        return (Edificio) sitioActual;
    }

    public List<String> listarEdificios() {
        List<String> strEdifLista = new ArrayList<>();
        for(Edificio edificio: edificios) {
            strEdifLista.add(edificio.nombre());
        }

        return strEdifLista;
    }
}

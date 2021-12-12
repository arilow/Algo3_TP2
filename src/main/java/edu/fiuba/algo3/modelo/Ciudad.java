package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.sitios.AireLibre;
import edu.fiuba.algo3.modelo.sitios.Sitio;
import edu.fiuba.algo3.modelo.sitios.edificios.Edificio;

import java.util.List;
import java.util.Observer;

public class Ciudad {
    private String nombre;
    private List<Edificio> edificios;
    private Sitio sitioActual;
    // Representa el espacio fuera de los edificios de la ciudad
    private Sitio aireLibre;
    private boolean visitada;
    private Ubicacion ubicacion;
    private boolean tieneLadron;

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

        /*if (ladron.obtenerCiudadActual() == this) {
            if (edificios.get(edificio).tieneLadron() == true) {
                //      return "Sí, tiene ladron"
            } else {

            }
        }else {*/

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

}

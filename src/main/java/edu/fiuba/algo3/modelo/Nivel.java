package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.objetos.ObjetoRobado;

import java.util.List;

public class Nivel {
    private List<Ciudad> ciudades;
    private Ladron ladron;
    private ObjetoRobado tesoro;
    private Ciudad ciudadActual;
    private Tiempo tiempo;
    private Jugador jugador;

    public Nivel(Ciudad ciudad, Jugador jugador, ObjetoRobado tesoro, Ladron ladron, List<Ciudad> ciudades){
        tiempo = new Tiempo(10);
        this.ciudades = ciudades;
        this.ciudadActual = ciudad;
        this.jugador = jugador;
        this.tesoro = tesoro;
        this.ladron = ladron;
    }

    public void visitarCiudad(Ciudad ciudad){
        jugador.viajar(ciudadActual.obtenerDistancia(ciudad), tiempo);
        this.ciudadActual = ciudad;
    }

    public Ciudad obtenerCiudadActual() { return ciudadActual;}

    //TODO edificio no es un int
    public void entrarAEdificio(int edificio){
        ciudadActual.entrarAEdificio(edificio, tiempo);
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

    public List<Ladron> buscarLadrones(List<DatosLadron> datosLadrones, List<Ladron> listaLadrones){
       // return listaLadrones.stream().filter(d -> datosLadrones.equalsIgnoreCase(d.getColor())).map(Car::getModel).findAny();
        //TODO: implementación de filtros para encontrar los ladrones que tienen los datos buscados
        return listaLadrones; // Hay que modificar eso. Es simplemente para que no tire error
    }
    public int obtenerCantidadCiudadesEscape() {
       return this.tesoro.obtenerCantidadCiudadesEscape();
    }

    /*public boolean estaEn(String ciudad) {
        return ciudadActual.es(ciudad);
    }*/
}

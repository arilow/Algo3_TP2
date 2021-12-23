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
    private String descripcion;

    private List<Edificio> edificios;
    private Sitio sitioActual;

    private Sitio aireLibre;  // Espacio fuera de los edificios
    private Ubicacion ubicacion;
    private List<String> ciudadesVisitables;
    private String imagen;

    public Ciudad(String nombre, String descripcion, List<Edificio> edificio, List<String> ciudadesVisitables,double longitud, double latitud) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.edificios = edificio;
        this.aireLibre = new AireLibre();
        this.sitioActual = aireLibre;
        this.ubicacion = new Ubicacion(longitud,latitud);
        this.ciudadesVisitables=ciudadesVisitables;
        this.imagen = this.nombre+".png";
    }

    public boolean es(String nombre) {
        return this.nombre.equals(nombre);
    }

    public Pista entrarAEdificio(int edificio, Tiempo tiempo) {
        this.sitioActual = edificios.get(edificio);
        edificios.get(edificio).aumentarTiempo(tiempo);
        return edificios.get(edificio).mostrarPista();
    }

    public void agregarUbicacion(double longitud, double latitud) {
        this.ubicacion= new Ubicacion(longitud,latitud);
    }

    public Ubicacion obtenerUbicacion() {
        return ubicacion;
    }

    public void salirDeEdificio() {
        this.sitioActual = aireLibre;
    }

    public double obtenerDistancia(Ciudad otraCiudad) {
        return this.ubicacion.calcularDistancia(otraCiudad.obtenerUbicacion());
    }

    public String obtenerNombre() {
        return nombre;
    }

    public Edificio obtenerEdificioActual() {
        return (Edificio) sitioActual;
    }

    public List<String> obtenerCiudadesVisitables() {
        return ciudadesVisitables;
    }

    public List<String> listarEdificios() {
        List<String> strEdifLista = new ArrayList<>();
        for (Edificio edificio : edificios) {
            strEdifLista.add(edificio.nombre());
        }

        return strEdifLista;
    }

    public String obtenerImagen() {
        return imagen;
    }

    public void definirEdificios(List <Edificio> edificios) {
        this.edificios=edificios;
    }

    public String obtenerDescripcion() {
        return descripcion;
    }
}
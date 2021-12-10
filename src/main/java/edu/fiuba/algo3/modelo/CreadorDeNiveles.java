package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.objetos.ObjetoComun;
import edu.fiuba.algo3.modelo.objetos.ObjetoRobado;
import edu.fiuba.algo3.modelo.sitios.edificios.Aeropuerto;
import edu.fiuba.algo3.modelo.sitios.edificios.Banco;
import edu.fiuba.algo3.modelo.sitios.edificios.Biblioteca;
import edu.fiuba.algo3.modelo.sitios.edificios.Edificio;

import java.util.ArrayList;
import java.util.List;

public class CreadorDeNiveles {
    private List<Ladron> ladrones;
    private List<Ciudad> ciudades;
    private List<ObjetoRobado> objetosRobados;
    /*
        private class PartidaMock {
            Jugador jugador;
            public PartidaMock() {
                jugador = new Jugador("mock");
            }
            public Nivel GenerarNivel() {
                ObjetoRobado tesoroNacionalDeMontreal = new ObjetoComun("Tesoro Nacional de Montreal");
                Ladron ladrona = new Ladron("femenino","","","","");
                List<Edificio> listaEdificios= new ArrayList<Edificio>();

                listaEdificios.add(new Banco("Pista Banco"));
                listaEdificios.add(new Biblioteca("Pista Biblioteca"));
                listaEdificios.add(new Aeropuerto("Pista Aeropuerto"));

                Ciudad montreal = new Ciudad("Montreal", listaEdificios);
                List<Ciudad> ciudades = new ArrayList<Ciudad>();
                ciudades.add(montreal);

                return new Nivel(0, jugador, tesoroNacionalDeMontreal, ladrona, ciudades);
            }
        }
    */
    public CreadorDeNiveles() {
        inicializarCiudades();
        inicializarLadrones();
        inicializarObjetosRobados();
    }

    public Nivel crearNivel(Jugador jugador) {
        return new Nivel(ciudades.get(0), jugador, objetosRobados.get(0), ladrones.get(0), ciudades, ladrones);
    }

    private void inicializarCiudades() {
        ciudades = new ArrayList<>();

        Edificio banco = new Banco("Soy una Pista de un banco.");
        Edificio biblioteca = new Biblioteca("Soy una Pista de una biblioteca.");
        Edificio aeropuerto = new Aeropuerto("Soy una Pista de una aeropuerto.");
        List<Edificio> edificios = new ArrayList<>();
        edificios.add(banco);
        edificios.add(biblioteca);
        edificios.add(aeropuerto);

        Ubicacion uMontreal = new Ubicacion(-73.575439, 45.498646);
        Ubicacion uMexico = new Ubicacion(-99.228515, 19.394067);
        Ubicacion uBuenosAires = new Ubicacion(-58.3712, -34.6083);
        Ubicacion uColombo = new Ubicacion(79.8477800, 6.9319400);

        Ciudad montreal = new Ciudad("Montreal", edificios, uMontreal);
        Ciudad mexico = new Ciudad("México", edificios, uMexico);
        Ciudad buenosAires = new Ciudad("Buenos Aires", edificios, uBuenosAires);
        Ciudad colombo = new Ciudad("Colombo", edificios, uColombo);

        ciudades.add(montreal);
        ciudades.add(mexico);
        ciudades.add(colombo);
        ciudades.add(buenosAires);
    }

    private void inicializarLadrones() {
        ladrones = new ArrayList<>();

        ladrones.add(new Ladron("masculino", "golf", "rubio", "lunar", "auto", ciudades.get(0),0,"Jorge el malevolo"));
        ladrones.add(new Ladron("masculino","escalar", "negro", "anillo", "motocicleta",ciudades.get(1),1,"Chichiwolen"));
        ladrones.add(new Ladron( "masculino","dar clases de algoritmos y programacion 3", "negro", "la facha", "aeroplano",ciudades.get(2),2,"Joaquin"));
        //ladrones.add(new Ladron("Lolo", "femenino","guitarra", "castaño", "nalgueable", "a pata"));
    }

    private void inicializarObjetosRobados() {
        objetosRobados = new ArrayList<>();
        objetosRobados.add(new ObjetoComun("Objeto robado"));
    }

}
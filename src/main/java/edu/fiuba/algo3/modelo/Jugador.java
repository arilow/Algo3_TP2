package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.cargos.*;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.io.FileNotFoundException;

public class Jugador {

    private final String nombre;
    private Cargo cargo;
    public int cantidadArrestos = 0;
    private boolean fueAcuchillado = false;

    public Jugador(String nombre) {
        this.nombre = nombre;
        asignarCargo(new Novato());
    }

    public void asignarCargo(Cargo cargo) {
        this.cargo = cargo;
        this.cargo.asignarJugador(this);
    }

    public void recibirHeridaCuchillo(Tiempo tiempo) {
        int cantidadHoras = this.fueAcuchillado ? 1 : 2;
        tiempo.sumarHoras(cantidadHoras);
        this.fueAcuchillado = true; // Cuando fue aculliado una vez ya suma siempre 1 hs
    }
    public void recibirHeridaArmaFuego(Tiempo tiempo) {
        tiempo.sumarHoras(4);
    }
    public void dormir(Tiempo tiempo) {
        tiempo.sumarHoras(8);
    }

    public void viajar(double distancia, Tiempo tiempo) {
        cargo.viajar(distancia, tiempo);
    }

    public void agregarArresto (){
        this.cargo.agregarArresto();
    }

    public void setCantidadArrestos(int cantidadArrestos) {
        this.cantidadArrestos = cantidadArrestos;
    }
    public int getCantidadArrestos() { return this.cantidadArrestos; }

    public Cargo getCargo() {
        return this.cargo;
    }
}

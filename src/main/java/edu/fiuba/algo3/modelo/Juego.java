package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.vista.OyenteEstadoPartida;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Juego {
    private Partida partida;

    public Juego() {
    }

    public void comenzarPartida(OyenteEstadoPartida oyenteEstadoPartida) {
        partida = new Partida(oyenteEstadoPartida);
        partida.empezar();
    }

    public Nivel nivelActual() {
        return partida.nivelActual();
    }

    public Partida partidaActual() { return partida;}
}

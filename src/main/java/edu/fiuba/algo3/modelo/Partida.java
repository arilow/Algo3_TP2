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

public class Partida {
    private CreadorDeNiveles creadorDeNiveles;
    private Nivel nivelActual;
    private Jugador jugador;
    private ComunicadorEstadoPartida estado;

    public Partida(OyenteEstadoPartida oyenteEstadoPartida) {
        estado = new ComunicadorEstadoPartida(EstadoPartida.CREAR);
        estado.addObserver(oyenteEstadoPartida);

        creadorDeNiveles = new CreadorDeNiveles();
    }

    public void empezar() {
        estado.definirEstado(EstadoPartida.EMPEZAR);
    }

    public void registrarJugador(String nombre) {

        String fileName = "config/partidas.json";
        jugador = new Jugador(nombre);
        try {
            JSONParser parser = new JSONParser();
            JSONObject lecturaArchivo = (JSONObject) parser.parse(new FileReader(fileName));
            JSONArray jugadores= (JSONArray) lecturaArchivo.get("Jugadores");

            for(Object jugador_ : jugadores){
                if(nombre.equals((String) ((JSONObject)jugador_).get("nombre"))){
                    jugador.setCantidadArrestos(Integer.parseInt(((JSONObject)jugador_).get("cantidadArrestos").toString()));
                    break;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        catch (ParseException e) {
            e.printStackTrace();
        }
        crearNivel();
        comenzarNivel();
    }
    public void terminarNivel(){

        String nombreJugador= jugador.nombre();
        int cantidadDeArrestos = jugador.getCantidadArrestos();
        String fileName = "config/partidas.json";
        boolean nuevo_jugador= true;
        try {
            JSONParser parser = new JSONParser();
            JSONObject lecturaArchivo = (JSONObject) parser.parse(new FileReader(fileName));
            JSONArray jugadores= (JSONArray) lecturaArchivo.get("Jugadores");

            for(Object jugador_ : jugadores){
                if(nombreJugador.equals((String) ((JSONObject)jugador_).get("nombre"))){
                    ((JSONObject)jugador_).put("cantidadArrestos",Integer.toString(cantidadDeArrestos));
                    nuevo_jugador=false;
                }
            }
            if(nuevo_jugador)
            {
                JSONObject datosPartida = new JSONObject();
                datosPartida.put("nombre",nombreJugador);
                datosPartida.put("cantidadArrestos",Integer.toString(cantidadDeArrestos));
                jugadores.add(datosPartida);
            }
            FileWriter file = new FileWriter(fileName);
            lecturaArchivo.put("Jugadores",jugadores);
            file.write(lecturaArchivo.toJSONString());
            file.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        catch (ParseException e) {
            e.printStackTrace();
        }
        return;
    }


    public void crearNivel() {
        nivelActual = creadorDeNiveles.crearNivel(jugador);
    }

    public void comenzarNivel() {
        nivelActual.jugar(estado);
        estado.definirEstado(EstadoPartida.COMIENZA_NIVEL);
    }

    public Nivel nivelActual() {
        return nivelActual;
    }

    public void siguienteNivel() {
        terminarNivel();
        crearNivel();
        comenzarNivel();
    }
    public Jugador obtenerJugador(){return  jugador;}
}


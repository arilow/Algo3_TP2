package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.objetos.*;
import edu.fiuba.algo3.modelo.sitios.edificios.*;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CreadorDeNiveles {
    private final int min = 1;
    private final int max = 3;

    public CreadorDeNiveles() {};

    public Nivel crearNivel(Jugador jugador) {
        String cargoJugador = jugador.obtenerCargo();

        // Lectura del archivo del Nivel
        JSONObject lecturaArchivo = cargarArchivo(cargoJugador);

        // Obtiene un mapa partir del archivo JSON
        JSONArray lecturaCiudades = (JSONArray) lecturaArchivo.get("ciudades");
        Mapa mapa = new Mapa();
        cargarCiudadesNivel(mapa,lecturaCiudades);

        // Obtiene un ladron a partir del archivo JSON
        JSONObject lecturaLadron = (JSONObject) lecturaArchivo.get("ladron");
        JSONObject ciudadLadron = (JSONObject) lecturaCiudades.get(lecturaCiudades.size()-1);

        Ladron ladron  = cargarLadron(lecturaLadron,(String)ciudadLadron.get("nombre") );

        // Obtiene un objeto robado a partir del archivo JSON
        String nombreObjetoRobado = (String) lecturaArchivo.get("ObjetoRobado");
        ObjetoRobado tesoro = cargarObjetoRobado(cargoJugador, nombreObjetoRobado);
        JSONObject ciudadInicial = (JSONObject) lecturaCiudades.get(0);
        return new Nivel( (String)ciudadInicial.get("nombre"), jugador, tesoro, ladron, mapa);
    }

    private void cargarCiudadesNivel(Mapa mapaNivel, JSONArray ciudades){
        for(Object ciudad_ : ciudades) {
            JSONObject ciudad = (JSONObject) ciudad_;
            JSONArray lecturaEdificios = (JSONArray) ciudad.get("edificios");
            List<Edificio> edificios = new ArrayList<Edificio>();
            for (Object edificio_ : lecturaEdificios) {
                JSONObject edificio = (JSONObject) edificio_;
                switch ((String) edificio.get("nombre")) {
                    case "Aeropuerto":
                        Aeropuerto aeropuerto = new Aeropuerto((String) edificio.get("pista"));
                        edificios.add(aeropuerto);
                        break;
                    case "Banco":
                        Banco banco = new Banco((String) edificio.get("pista"));
                        edificios.add(banco);
                        break;
                    case "Biblioteca":
                        Biblioteca biblioteca = new Biblioteca((String) edificio.get("pista"));
                        edificios.add(biblioteca);
                        break;
                    case "Bolsa":
                        Bolsa bolsa = new Bolsa((String) edificio.get("pista"));
                        edificios.add(bolsa);
                        break;
                    case "Puerto":
                        Puerto puerto = new Puerto((String) edificio.get("pista"));
                        edificios.add(puerto);
                        break;
                }
            }
            mapaNivel.agregarCiudadDeNivel((String) ciudad.get("nombre"),edificios);
        }
    }
    private JSONObject cargarArchivo(String nivel) {
        JSONParser parser = new JSONParser();
        Random rand = new Random();
        int n = rand.nextInt(max - min + 1) + min;
        String fileName = "config/";
        switch(nivel) {
            case "novato":
                fileName += "Facil/Nivel" + n + ".json";
                break;
            case "detective": //Podriamos hacer que se repita un nivel o crear uno nuevo
            case "investigador":
                fileName += "Medio/Nivel" + n + ".json";
                break;
            case "sargento":
                fileName += "Dificil/Nivel" + n + ".json";
                break;
        }
        fileName= "config/Facil/Nivel4.json";
        try {
            JSONObject lecturaArchivo = (JSONObject) parser.parse(new FileReader(fileName));
            return lecturaArchivo;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    private Ladron cargarLadron(JSONObject lecturaLadron, String ciudad) {
        String nombre = (String) lecturaLadron.get("nombre");
        String sexo = (String) lecturaLadron.get("sexo");
        String hobby = (String) lecturaLadron.get("hobby");
        String cabello = (String) lecturaLadron.get("cabello");
        String senia = (String) lecturaLadron.get("senia");
        String vehiculo = (String) lecturaLadron.get("vehiculo");

        return new Ladron(sexo, hobby, cabello, senia, vehiculo, ciudad, 0, nombre);
    }

    private ObjetoRobado cargarObjetoRobado(String nivel, String nombreObjetoRobado) {
        switch(nivel) {
            case "novato":
                return new ObjetoComun(nombreObjetoRobado);
            case "detective":
                return new ObjetoValioso(nombreObjetoRobado);
            case "investigador":
                return new ObjetoValioso(nombreObjetoRobado);
            case "sargento":
                return new ObjetoMuyValioso(nombreObjetoRobado);
        }
        return null;
    }
}
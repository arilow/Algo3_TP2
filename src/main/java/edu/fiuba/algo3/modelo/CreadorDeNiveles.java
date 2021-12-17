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

//      JSONObject lecturaArchivo = (JSONObject) parser.parse(new FileReader("config/Nivel1.json"));
        JSONObject lecturaArchivo = cargarArchivo(cargoJugador);

        JSONArray lecturaCiudades = (JSONArray) lecturaArchivo.get("ciudades");

        // Obtiene una lista de ciudades a partir del archivo JSON
        List<Ciudad> ciudades = new ArrayList<Ciudad>();
        cargarCiudades(ciudades, lecturaCiudades);

        // Obtiene un ladron a partir del archivo JSON
        JSONObject lecturaLadron = (JSONObject) lecturaArchivo.get("ladron");
        Ladron ladron  = cargarLadron(lecturaLadron, ciudades);

        // Obtiene un objeto robado a partir del archivo JSON
        String nombreObjetoRobado = (String) lecturaArchivo.get("ObjetoRobado");
        ObjetoRobado tesoro = cargarObjetoRobado(cargoJugador, nombreObjetoRobado);

        return new Nivel(ciudades.get(0), jugador, tesoro, ladron, ciudades);
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
            case "detective":
            case "investigador":
                fileName += "Medio/Nivel" + n + ".json";
                break;
            case "sargento":
                fileName += "Dificil/Nivel" + n + ".json";
                break;
        }
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
    private void cargarCiudades(List<Ciudad> ciudades, JSONArray listaCiudades) {
        for(Object ciudad_ : listaCiudades) {
            JSONObject ciudad = (JSONObject) ciudad_;
            String nombre = (String) ciudad.get("nombre");

            JSONArray lecturaEdificios = (JSONArray) ciudad.get("edificios");
            List<Edificio> edificios = new ArrayList<Edificio>();
            for (Object edificio_: lecturaEdificios) {
                JSONObject edificio = (JSONObject) edificio_;
                switch((String) edificio.get("nombre")) {
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

            Ciudad c = new Ciudad(nombre, edificios);
            ciudades.add(c);
        }
    }

    private Ladron cargarLadron(JSONObject lecturaLadron, List<Ciudad> ciudades) {
        String nombre = (String) lecturaLadron.get("nombre");
        String sexo = (String) lecturaLadron.get("sexo");
        String hobby = (String) lecturaLadron.get("hobby");
        String cabello = (String) lecturaLadron.get("cabello");
        String senia = (String) lecturaLadron.get("senia");
        String vehiculo = (String) lecturaLadron.get("vehiculo");

        return new Ladron(sexo, hobby, cabello, senia, vehiculo, ciudades.get(0), 0, nombre);
    }

    private ObjetoRobado cargarObjetoRobado(String nivel, String nombreObjetoRobado) {
        switch(nivel) {
            case "novato":
                return new ObjetoComun(nombreObjetoRobado);
            case "detective":
            case "investigador":
                return new ObjetoValioso(nombreObjetoRobado);
            case "sargento":
                return new ObjetoMuyValioso(nombreObjetoRobado);
        }
        return null;
    }
}
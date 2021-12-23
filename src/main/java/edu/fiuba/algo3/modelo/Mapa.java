package edu.fiuba.algo3.modelo;
import edu.fiuba.algo3.modelo.sitios.edificios.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Mapa {
    Map<String, Ciudad> mapeo_aux;
    //private List<Ciudad> ciudades;

    public Mapa() {
        this.mapeo_aux= new HashMap<>();
        JSONArray lecturaMapa= cargarArchivoMapa();
        cargarCiudades(lecturaMapa);

        /*for(Ciudad ciudad: ciudadesMapa) {
            mapeo_aux.get(ciudad.toString()).agregarPistas();
            mapeo_aux.put(ciudad.toString(), ciudad);
        }*/
    }

    public void viajar(Jugador jugador,Ciudad ciudadPartida, String ciudadLLlegada, Tiempo tiempo) {
            jugador.viajar(ciudadPartida.obtenerDistancia(mapeo_aux.get(ciudadLLlegada)), tiempo);
    }
    public void viajar(Jugador jugador,Ciudad ciudadPartida, Ciudad ciudadLLlegada, Tiempo tiempo) {
        jugador.viajar(ciudadPartida.obtenerDistancia(ciudadLLlegada), tiempo);
    }
    public Ciudad obtenerCiudad(String ciudad){
        System.out.println("Obtener ciduad:" + ciudad);
            return mapeo_aux.get(ciudad);
    }

    private JSONArray cargarArchivoMapa() {
        JSONParser parser = new JSONParser();
        String fileName = "config/Mapa2.json"; //Si cambia la ruta se puede pasar por parámetro y  cambiar esta línea por
        // esa variable
        try {
            JSONArray lecturaArchivoMapa = (JSONArray) parser.parse(new FileReader(fileName));
            return lecturaArchivoMapa;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    private void cargarCiudades(JSONArray listaCiudadesMapa) {
        for(Object ciudad_ : listaCiudadesMapa) {
            JSONObject ciudad = (JSONObject) ciudad_;
            String nombre = (String) ciudad.get("nombre");
            List<Edificio> edificios = new ArrayList<Edificio>();
            Aeropuerto aeropuerto = new Aeropuerto("No tengo informacion sobre el asunto");
            edificios.add(aeropuerto);
            Banco banco = new Banco("No tengo informacion sobre el asunto");
            edificios.add(banco);
            Biblioteca biblioteca = new Biblioteca("No tengo informacion sobre el asunto");
            edificios.add(biblioteca);
            double latitud = Double.parseDouble((String)ciudad.get("latitud"));
            double longitud = Double.parseDouble((String)ciudad.get("latitud"));

            // Leo las ciudades visitables
            JSONArray lecturaCiudadesVisitables = (JSONArray) ciudad.get("ciudadesVisitables");
            List<String> ciudadesVisitables = new ArrayList<String>();
            for(Object ciudadVisitable_: lecturaCiudadesVisitables) {
                String ciudadVisitable = ciudadVisitable_.toString();
                ciudadesVisitables.add(ciudadVisitable);
            }
            Ciudad c = new Ciudad(nombre, edificios, ciudadesVisitables,longitud,latitud);
            System.out.println("Ciudad cargada: " + c.toString());
            mapeo_aux.put(c.obtenerNombre(),c);
        }
    }
    public void agregarCiudadDeNivel(String nombre, List<Edificio> edificios){
        System.out.println(nombre);
            mapeo_aux.get(nombre).definirEdificios(edificios);
    }
}

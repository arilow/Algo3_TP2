package edu.fiuba.algo3.modelo;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Interpol {
    List<Ladron> listaLadrones;

    public Interpol(){
        listaLadrones = new ArrayList<Ladron>();
        cargarLadrones();
    }

    private void cargarLadrones(){
        try {
            JSONParser parser = new JSONParser();
            JSONObject lecturaArchivo = (JSONObject) parser.parse(new FileReader("config/ladrones.json"));
            JSONArray datosLadrones = (JSONArray) lecturaArchivo.get("ladrones");
            for (Object datosladron_ : datosLadrones) {
                JSONObject datosladron = (JSONObject) datosladron_;
                String nombre = (String) datosladron.get("nombre");
                String sexo = (String) datosladron.get("sexo");
                String hobby = (String) datosladron.get("hobby");
                String cabello = (String) datosladron.get("cabello");
                String senia = (String) datosladron.get("seña");
                String vehiculo = (String) datosladron.get("vehiculo");
                Ladron ladron = new Ladron(sexo, hobby, cabello, senia, vehiculo, null, 0, nombre);
                this.listaLadrones.add(ladron);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
    public List<Ladron> buscarLadrones(DatosLadron datosLadron){
        List<Ladron> sospechosos= new ArrayList<Ladron>();
        for(Ladron ladron: listaLadrones){
            if(ladron.constatarDatos(datosLadron)) {
                sospechosos.add(ladron);
            }
        }
        return sospechosos;
    }
}

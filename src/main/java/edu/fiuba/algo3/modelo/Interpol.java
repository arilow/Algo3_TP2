package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.sitios.edificios.Edificio;

import java.lang.reflect.AnnotatedArrayType;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class Interpol {

    DatosLadron datosLadron;
    List<Ladron> listaLadrones;

    public Interpol(List<Ciudad> ciudades){
        for(Ciudad ciudad: ciudades){
            System.out.println(ciudad.obtenerNombre());
        }
        listaLadrones = new ArrayList<Ladron>();
        this.listaLadrones.add(new Ladron("Guiduito","masculino","golf", "rubio", "lunar", "auto"));
        this.listaLadrones.add(new Ladron("Pelusa","masculino","escalar", "negro", "anillo", "motocicleta"));
        this.listaLadrones.add(new Ladron("Franky","masculino","dar clases de algoritmos y programacion 3", "negro", "la facha", "aeroplano"));
        this.listaLadrones.add(new Ladron("masculino","escalar", "negro", "anillo", "monopatin", ciudades.get(1), 1, "Smiggle"));
    }

    public List<Ladron> buscarLadrones(DatosLadron datosLadron){
        List<Ladron> sospechosos= new ArrayList<Ladron>();
        Ladron aux = new Ladron(null,null,null,null,null);
        for(Ladron ladron: listaLadrones){
            if(ladron.constatarDatos(datosLadron)) {
                sospechosos.add(ladron);
            }
        }
        return sospechosos;
    }
}

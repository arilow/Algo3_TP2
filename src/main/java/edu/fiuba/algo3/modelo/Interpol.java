package edu.fiuba.algo3.modelo;

import java.lang.reflect.AnnotatedArrayType;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class Interpol {

    DatosLadron datosLadron;
    List<Ladron> listaLadrones;

    public Interpol(){
        listaLadrones = new ArrayList<Ladron>();
        this.listaLadrones.add(new Ladron("Guiduito","masculino","golf", "rubio", "lunar", "auto"));
        this.listaLadrones.add(new Ladron("Pelusa","masculino","escalar", "negro", "anillo", "motocicleta"));
        this.listaLadrones.add(new Ladron("Franky","masculino","dar clases de algoritmos y programacion 3", "negro", "la facha", "aeroplano"));
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

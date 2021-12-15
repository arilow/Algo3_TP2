package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.Nivel;
import javafx.scene.control.Label;

import java.util.Observable;
import java.util.Observer;

public class LabelCiudad extends Label implements Observer {
    public LabelCiudad(Nivel nivel) {
        setText(nivel.obtenerCiudadActual().obtenerNombre());
    }

    @Override
    public void update(Observable o, Object arg) {

    }
}

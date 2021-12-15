package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.Nivel;
import edu.fiuba.algo3.modelo.Tiempo;
import javafx.scene.control.Label;

import java.util.Observable;
import java.util.Observer;

public class LabelFecha extends Label implements Observer {

    public LabelFecha(Nivel nivel) {
        setText(nivel.obtenerFecha());
        nivel.agregarObervadorDeTiempo(this);
    }

    @Override
    public void update(Observable o, Object arg) {
        setText(((Tiempo)arg).aString());
    }
}

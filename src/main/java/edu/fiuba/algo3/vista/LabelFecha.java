package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.Nivel;
import edu.fiuba.algo3.modelo.Tiempo;
import javafx.scene.control.Label;

import java.util.Observable;
import java.util.Observer;

public class LabelFecha extends Label {

    public LabelFecha(Nivel nivel) {
        setText("Lunes, 7hs");
    }
}

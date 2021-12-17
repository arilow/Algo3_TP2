package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.Nivel;
import javafx.scene.control.Label;

import java.util.Observable;
import java.util.Observer;

public class LabelCiudad extends Label {
    public LabelCiudad(Nivel nivel) {
        setText("Cuartel General");
    }
}

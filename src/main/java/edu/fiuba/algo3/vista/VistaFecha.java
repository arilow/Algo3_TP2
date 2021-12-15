package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.Nivel;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

import java.util.Observable;
import java.util.Observer;

public class VistaFecha extends VBox {
    Label etiquetaCiudad;
    Label etiquetaTiempo;
    public VistaFecha(Nivel nivel, double ancho, double alto) {
        etiquetaTiempo = new LabelFecha(nivel);
        etiquetaCiudad = new LabelCiudad(nivel);

        getChildren().addAll(etiquetaCiudad, etiquetaTiempo);
        setPrefHeight(alto);
    }

}

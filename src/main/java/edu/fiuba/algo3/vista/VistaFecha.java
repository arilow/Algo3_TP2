package edu.fiuba.algo3.vista;

import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class VistaFecha extends VBox {

    public VistaFecha(double ancho, double alto) {
        Label etiquetaCiudad = new Label("Ciudad");
        Label etiquetaTiempo = new Label("Dia, hora");

        getChildren().addAll(etiquetaCiudad, etiquetaTiempo);
        setPrefHeight(alto);
    }
}

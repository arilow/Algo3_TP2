package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.Nivel;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class VistaDatos extends VBox {
    private Label etiquetaCiudad;
    private Label etiquetaTiempo;

    public VistaDatos(String ciudad, String fecha, double ancho, double alto) {
        etiquetaTiempo = new Label(ciudad);
        etiquetaCiudad = new Label(fecha);

        getChildren().addAll(etiquetaCiudad, etiquetaTiempo);
        setPrefHeight(alto);
    }

    public void actualizar(String ciudad, String fecha) {
        etiquetaCiudad.setText(ciudad);
        etiquetaTiempo.setText(fecha);
    }
}

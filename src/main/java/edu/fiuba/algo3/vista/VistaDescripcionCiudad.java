package edu.fiuba.algo3.vista;

import javafx.scene.control.ScrollPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class VistaDescripcionCiudad extends ScrollPane {
    public VistaDescripcionCiudad(String descripcion, double ancho, double alto) {
        this.setPrefHeight(alto);
        this.setPrefWidth(ancho);

        Text text = new Text();
        text.setFont(new Font("Times New Roman", 16));

        text.setText(descripcion);
        text.setWrappingWidth(ancho);

        this.setContent(text);
    }
}

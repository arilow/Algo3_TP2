package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.Pista;
import javafx.scene.control.ScrollPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class VistaEdificio extends ScrollPane {

    public VistaEdificio(Pista pista, double ancho, double alto) {
        this.setPrefHeight(alto);
        this.setPrefWidth(ancho);

        Text text = new Text();
        text.setFont(new Font("Times New Roman", 16));

        text.setText(pista.mostrar());
        text.setWrappingWidth(ancho);

        this.setContent(text);
    }
}

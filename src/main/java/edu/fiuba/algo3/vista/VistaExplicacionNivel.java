package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.ControladorBotonRegistrarJugador;
import edu.fiuba.algo3.controlador.ControladorBotonSiguienteExplicacionNivel;
import edu.fiuba.algo3.modelo.Nivel;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class VistaExplicacionNivel extends VBox {
    public VistaExplicacionNivel(Nivel nivel, double ancho, double alto) {
        String nombreJugador = nivel.obtenerJugador().nombre();

        ScrollPane scrollPane = new ScrollPane();

        scrollPane.setPrefHeight(alto);
        scrollPane.setPrefWidth(ancho);

        Text text = new Text();
        text.setFont(new Font("Times New Roman", 16));

        text.setText("Hola " + nombreJugador +"!!!!" + '\n' +
                "Se han robado el " + nivel.nombreTesoro() + '\n' +
                "Ayudanos a resolver este caso y te daremos una galleta.");

        text.setWrappingWidth(ancho);
        scrollPane.setContent(text);

        Button botonSiguiente = new Button("Siguiente");
        botonSiguiente.setOnAction(new ControladorBotonSiguienteExplicacionNivel(nivel));

        getChildren().addAll(scrollPane, botonSiguiente);
    }
}

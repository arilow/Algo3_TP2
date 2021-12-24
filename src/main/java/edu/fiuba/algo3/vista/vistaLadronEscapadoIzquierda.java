package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.ControladorBotonSiguienteNivel;
import edu.fiuba.algo3.modelo.Partida;
import javafx.scene.Node;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class vistaLadronEscapadoIzquierda extends VBox {
    public vistaLadronEscapadoIzquierda(Partida partida, double anchoPantalla, double altoPantallaIzquierdaActual) {

        ScrollPane scrollPane= new ScrollPane();
        scrollPane.setPrefHeight(altoPantallaIzquierdaActual);
        scrollPane.setPrefWidth(anchoPantalla);

        Text text= new Text("Nivel Perdido :( \n No tenías orden de arresto, así que tuvimos que dejar ir al ladrón.");
        text.setWrappingWidth(anchoPantalla);

        scrollPane.setContent(text);

        Button botonSiguienteNivel = new Button("Siguiente");
        botonSiguienteNivel.setPrefWidth(anchoPantalla);
        botonSiguienteNivel.setOnAction(new ControladorBotonSiguienteNivel(partida));
        this.getChildren().addAll(scrollPane,botonSiguienteNivel);
    }
}

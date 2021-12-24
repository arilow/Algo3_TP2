package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.ControladorBotonRegistrarJugador;
import edu.fiuba.algo3.controlador.ControladorBotonSiguienteNivel;
import edu.fiuba.algo3.modelo.Jugador;
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

public class vistaLadronEncarceladoIzquierda extends VBox {
    private GraphicsContext gcI;

    public vistaLadronEncarceladoIzquierda(Partida partida, double anchoPantalla, double altoPantallaIzquierdaActual) {

        ScrollPane scrollPane= new ScrollPane();
        scrollPane.setPrefHeight(altoPantallaIzquierdaActual);
        scrollPane.setPrefWidth(anchoPantalla);

        Text text= new Text("¡¡¡Nivel Ganado!!! \n Atrapaste al ladrón \n Atrapaste a "+partida.obtenerJugador().getCantidadArrestos()
                + " ladrones. \n Tu cargo es "+ partida.obtenerJugador().obtenerCargo());
        text.setWrappingWidth(anchoPantalla);

        scrollPane.setContent(text);

        Button botonSiguienteNivel = new Button("Siguiente");
        botonSiguienteNivel.setPrefWidth(anchoPantalla);
        botonSiguienteNivel.setOnAction(new ControladorBotonSiguienteNivel(partida));
        this.getChildren().addAll(scrollPane,botonSiguienteNivel);

    }
}
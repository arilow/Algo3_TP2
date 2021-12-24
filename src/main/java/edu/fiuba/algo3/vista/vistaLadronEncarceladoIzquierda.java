package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.ControladorBotonRegistrarJugador;
import edu.fiuba.algo3.modelo.Jugador;
import javafx.scene.Node;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class vistaLadronEncarceladoIzquierda extends Canvas {
    private GraphicsContext gcI;

    public vistaLadronEncarceladoIzquierda(Jugador jugador, double anchoPantalla, double altoPantallaIzquierdaActual) {

        super(anchoPantalla, altoPantallaIzquierdaActual);

        gcI = getGraphicsContext2D();

        gcI.setFill(Color.YELLOWGREEN);
        gcI.setLineWidth(2);
        gcI.fillRect(0,0, anchoPantalla, altoPantallaIzquierdaActual);

        gcI.setFill(Color.BLACK);
        Font theFont = Font.font( "Times New Roman", FontWeight.BOLD, 15 );
        gcI.setFont( theFont );
        gcI.fillText("¡¡¡Nivel Ganado!!!", 91,200);
        gcI.fillText("Atrapaste al ladrón.", 95,220);
        gcI.fillText(jugador.nombre(), 99,220);

        gcI.fillText("Atrapaste a "+Integer.toString(jugador.getCantidadArrestos()) + "ladrones", 103,220);

        Button botonSiguienteNivel = new Button("Siguiente");
        //botonSiguienteNivel.setOnAction(new ControladorBotonSiguienteNivel(jugador));

    }
}

package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.Nivel;
import javafx.scene.Node;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

import java.util.List;

public class VistaIzquierdaComputadoraInterpol extends Canvas {

    private GraphicsContext gcI;
    public VistaIzquierdaComputadoraInterpol(Nivel nivelActual, double anchoPantalla, double altoPantallaIzquierdaActual) {

        super(anchoPantalla, altoPantallaIzquierdaActual);
        gcI = getGraphicsContext2D();

        Font theFont = Font.font( "Times New Roman", FontWeight.BOLD, 12 );
        gcI.setFont( theFont );
        gcI.fillText("LISTO", 200,200 );

        gcI.setFill(Color.YELLOWGREEN);
        gcI.setLineWidth(2);

        gcI.fillRect(0,0, anchoPantalla, altoPantallaIzquierdaActual);

    }

    public void enlistarLadrones(List<String> nombreLadrones){

        //  desplegar una lista de ladrones
        //  si la lista es unitaria asiganar orden de arresto al ladron

    }
}

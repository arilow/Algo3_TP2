package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.Ladron;
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
    private double anchoPantalla;
    private double altoPantallaIzquierdaActual;
    public VistaIzquierdaComputadoraInterpol(Nivel nivelActual, double anchoPantalla, double altoPantallaIzquierdaActual) {

        super(anchoPantalla, altoPantallaIzquierdaActual);

        this.altoPantallaIzquierdaActual = altoPantallaIzquierdaActual;
        this.anchoPantalla = anchoPantalla;
        gcI = getGraphicsContext2D();

        gcI.setFill(Color.YELLOWGREEN);
        gcI.setLineWidth(2);
        gcI.fillRect(0,0, anchoPantalla, altoPantallaIzquierdaActual);

        gcI.setFill(Color.BLACK);
        Font theFont = Font.font( "Times New Roman", FontWeight.BOLD, 15 );
        gcI.setFont( theFont );
        gcI.fillText("Listo para buscar", 91,200 );
        gcI.fillText("en computadora.", 95,220 );

    }

//    public void enlistarLadrones(List<Ladron> nombreLadrones){
//
//        gcI.setFill(Color.YELLOWGREEN);
//        gcI.setLineWidth(2);
//        gcI.fillRect(0,0, anchoPantalla, altoPantallaIzquierdaActual);
//
//        gcI.setFill(Color.YELLOWGREEN);
//
//        for (Ladron ladron: nombreLadrones){
//            gcI.fillText(ladron.obtenerNombre(), 91,200 );
//        }
//    }
}

package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.ControladorBotonSiguienteNivel;
import edu.fiuba.algo3.modelo.Partida;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class vistaIzquierdaPerderPorTiempo extends VBox {
    public vistaIzquierdaPerderPorTiempo(Partida partida, double anchoPantalla, double altoPantallaIzquierdaActual) {
        ScrollPane scrollPane= new ScrollPane();
        scrollPane.setPrefHeight(altoPantallaIzquierdaActual);
        scrollPane.setPrefWidth(anchoPantalla);

        Text text= new Text("Hola");
        text.setText("Nivel Perdido :( \n Se te terminó el tiempo  chinchulin.");
        text.setWrappingWidth(anchoPantalla);

        scrollPane.setContent(text);

        Button botonSiguienteNivel = new Button("Siguiente");
        botonSiguienteNivel.setPrefWidth(anchoPantalla);
        botonSiguienteNivel.setOnAction(new ControladorBotonSiguienteNivel(partida));
        this.getChildren().addAll(scrollPane,botonSiguienteNivel);
    }
}

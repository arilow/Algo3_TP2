package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.ControladorBotonRegistrarJugador;
import edu.fiuba.algo3.modelo.Nivel;
import edu.fiuba.algo3.modelo.Partida;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class VistaRegistroJugador extends VBox {

    TextField entradaNombreJugador;

    public VistaRegistroJugador(Partida partida, double ancho, double alto, ConstructorDeEscenas constructorDeEscenas) {
        Label labelNombreJugador = new Label("Nombre:");
        labelNombreJugador.setPrefWidth(ancho);
        entradaNombreJugador = new TextField();

        Button botonRegistrarJugador = new Button("Registrar");
        botonRegistrarJugador.setOnAction(new ControladorBotonRegistrarJugador(partida, this));

        getChildren().addAll(labelNombreJugador, entradaNombreJugador, botonRegistrarJugador);
    }

    public String obtenerInfoJugador() {
        return entradaNombreJugador.getText();
    }
}

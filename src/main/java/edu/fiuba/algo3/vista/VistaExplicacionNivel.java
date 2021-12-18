package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.ControladorBotonRegistrarJugador;
import edu.fiuba.algo3.controlador.ControladorBotonSiguienteExplicacionNivel;
import edu.fiuba.algo3.modelo.Nivel;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class VistaExplicacionNivel extends VBox {
    public VistaExplicacionNivel(Nivel nivel, double ancho, double alto) {
        String nombreJugador = nivel.obtenerJugador().nombre();

        Label texto0 = new Label("Hola " + nombreJugador +"!!!!");
        Label texto1 = new Label("Se han robado el ");
        Label labelNombreObjetoRobado = new Label(nivel.nombreTesoro());
        Label texto2 = new Label("Ayudanos a resolver este caso y te daremos una galleta.");


        labelNombreObjetoRobado.setPrefWidth(ancho);

        Button botonSiguiente = new Button("Siguiente");
        botonSiguiente.setOnAction(new ControladorBotonSiguienteExplicacionNivel(nivel));

        getChildren().addAll(texto0, texto1, labelNombreObjetoRobado, texto2, botonSiguiente);
    }
}

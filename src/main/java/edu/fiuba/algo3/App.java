package edu.fiuba.algo3;

import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.vista.VentanaPrincipal;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {
    @Override
    public void start(Stage stage) {
        stage.setTitle("Where in the World is Carmen San Diego?");
        Juego juego = new Juego();

        VentanaPrincipal ventanaPrincipal = new VentanaPrincipal(stage, juego);

        stage.show();
    }
    public static void main(String[] args) {
        launch();
    }

}
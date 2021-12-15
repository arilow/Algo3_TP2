package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.ControladorBotonEntrarEdificio;
import edu.fiuba.algo3.controlador.ControladorBotonInvestigar;
import edu.fiuba.algo3.modelo.Nivel;
import edu.fiuba.algo3.modelo.Pista;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.List;

public class ConstructorDeEscenas {
    VentanaPrincipal ventanaPrincipal;
    Stage stage;
    Nivel nivelActual;
    int anchoVentana;
    int altoVentana;

    double anchoPantalla;
    double altoPantallaIzquierdaActual;
    double altoPantallaDerechaActual;

    Node pantallaIzquierdaActual;
    Node pantallaDerechaActual;

    public ConstructorDeEscenas(VentanaPrincipal ventanaPrincipal, Stage stage, Nivel nivel, int anchoVentana, int altoVentana) {
        this.ventanaPrincipal = ventanaPrincipal;
        this.stage = stage;
        this.nivelActual = nivel;
        this.anchoVentana = anchoVentana;
        this.altoVentana = altoVentana;
        anchoPantalla = anchoVentana * 0.5;
    }

    public void construirEscenaPrincipal() {
        contruirNodosEscenaPrincipal();
        mostrarEscenaEnPantalla();
    }

    public void construirPantallaSeleccionEdificios(List<String> edificios) {
        contruirNodosEscenaSeleccionEdificios(edificios);
        mostrarEscenaEnPantalla();
    }

    public void construirPantallaEdificio(Pista pista) {
        contruirNodosEscenaEdificio(pista);
        mostrarEscenaEnPantalla();
    }

    private void mostrarEscenaEnPantalla() {
        VBox pantallaIzquierda = construirPantallaIzquierda(pantallaIzquierdaActual, anchoPantalla, altoPantallaIzquierdaActual);
        VBox pantallaDerecha = construirPantallaDerecha(pantallaDerechaActual, anchoPantalla, altoPantallaDerechaActual);

        HBox layout = new HBox();
        layout.getChildren().addAll(pantallaIzquierda, pantallaDerecha);

        Scene scene = new Scene(layout, anchoVentana, altoVentana);
        stage.setScene(scene);
    }

    private void contruirNodosEscenaEdificio(Pista pista) {
        altoPantallaDerechaActual = altoVentana * 0.75;
        pantallaDerechaActual = new VistaEdificio(pista, anchoPantalla, altoPantallaDerechaActual);

        // Pantalla Izquierda se mantiene igual.
    }

    private void contruirNodosEscenaPrincipal() {
        double anchoCanvas = anchoPantalla;

        // Nodo Izquierdo
        double altoCanvasIzquierdo = altoVentana * 0.9;
        Canvas nodoIzquierdo = new VistaImagenCiudad(anchoCanvas, altoCanvasIzquierdo);

        // Nodo Derecho
        double altoCanvasDerecho = altoVentana * 0.75;
        Canvas nodoDerecho = new VistaDescripcionCiudad(anchoCanvas, altoCanvasDerecho);

        // Se actualizan pantallas actuales
        pantallaIzquierdaActual = nodoIzquierdo;
        pantallaDerechaActual = nodoDerecho;
    }

    private void contruirNodosEscenaSeleccionEdificios(List<String> edificios) {
        altoPantallaIzquierdaActual = altoVentana * 0.8;
        pantallaIzquierdaActual = new VistaListaEdificios(nivelActual, anchoPantalla, altoPantallaIzquierdaActual, this);
    }

    private VBox construirPantallaIzquierda(Node nodo, double anchoNodo, double altoNodo) {
        double altoVistaFecha = altoVentana - altoNodo;
        VBox infoFecha = new VistaFecha(nivelActual, anchoNodo, altoVistaFecha);
        VBox pantallaizquierda = new VBox(infoFecha, nodo);
        return pantallaizquierda;
    }

    private VBox construirPantallaDerecha(Node nodo, double anchoNodo, double altoNodo) {
        double altoVistaBotones = altoVentana - altoNodo;
        VBox optionButons = new VistaOpcionesJuego(nivelActual, ventanaPrincipal, anchoNodo, altoVistaBotones);
        VBox verticalDerecha = new VBox(nodo, optionButons);
        return verticalDerecha;
    }

}

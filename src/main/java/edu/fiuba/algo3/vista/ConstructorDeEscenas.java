package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.ControladorBotonInvestigar;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class ConstructorDeEscenas {
    VentanaPrincipal ventanaPrincipal;
    int anchoVentana;
    int altoVentana;

    double anchoPantalla;
    double altoPantallaIzquierdaActual;
    double altoPantallaDerechaActual;

    Node pantallaIzquierdaActual;
    Node pantallaDerechaActual;

    public ConstructorDeEscenas(VentanaPrincipal ventanaPrincipal, int anchoVentana, int altoVentana) {
        this.ventanaPrincipal = ventanaPrincipal;
        this.anchoVentana = anchoVentana;
        this.altoVentana = altoVentana;
        anchoPantalla = anchoVentana * 0.5;
    }

    public Scene construirEscenaPrincipal() {
        contruirNodosEscenaPrincipal();
        VBox pantallaIzquierda = construirPantallaIzquierda(pantallaIzquierdaActual, anchoPantalla, altoPantallaIzquierdaActual);
        VBox pantallaDerecha = construirPantallaDerecha(pantallaDerechaActual, anchoPantalla, altoPantallaDerechaActual);

        HBox layout = new HBox();
        layout.getChildren().addAll(pantallaIzquierda, pantallaDerecha);

        Scene scene = new Scene(layout, anchoVentana, altoVentana);
        return scene;
    }

    public Scene construirPantallaSeleccionEdificios() {
        contruirNodosEscenaSeleccionEdificios();
        VBox pantallaIzquierda = construirPantallaIzquierda(pantallaIzquierdaActual, anchoPantalla, altoPantallaIzquierdaActual);
        VBox pantallaDerecha = construirPantallaDerecha(pantallaDerechaActual, anchoPantalla, altoPantallaDerechaActual);

        HBox layout = new HBox();
        layout.getChildren().addAll(pantallaIzquierda, pantallaDerecha);

        Scene scene = new Scene(layout, anchoVentana, altoVentana);
        return scene;
    }

    private void contruirNodosEscenaPrincipal() {
        double anchoCanvas = anchoPantalla;

        // Nodo Izquierdo
        double altoCanvasIzquierdo = altoVentana * 0.9;
        Canvas nodoIzquierdo = new Canvas(anchoCanvas, altoCanvasIzquierdo);
        GraphicsContext gcI = nodoIzquierdo.getGraphicsContext2D();

        gcI.setFill(Color.RED);
        gcI.fillRect(0,0, altoCanvasIzquierdo, altoCanvasIzquierdo);

        // Nodo Derecho
        double altoCanvasDerecho = altoVentana * 0.75;
        Canvas nodoDerecho = new Canvas(anchoCanvas, altoCanvasDerecho);
        GraphicsContext gcD = nodoDerecho.getGraphicsContext2D();

        gcD.setFill(Color.BLUE);
        gcD.fillRect(0,0,anchoCanvas, altoCanvasDerecho);

        // Se actualizan pantallas actuales
        pantallaIzquierdaActual = nodoIzquierdo;
        pantallaDerechaActual = nodoDerecho;
    }

    private void contruirNodosEscenaSeleccionEdificios() {
        double anchoCanvas = anchoPantalla;

        // Canvas izquierdo
        double altoIzquierdo = altoVentana * 0.9;
        double altoCanvas = altoIzquierdo * 0.8;
        Canvas canvasIzquierdo = new Canvas(anchoCanvas, altoCanvas);
        GraphicsContext gcI = canvasIzquierdo.getGraphicsContext2D();

        gcI.setFill(Color.GREEN);
        gcI.fillRect(0,0, anchoCanvas, altoCanvas);

        // Botones efificios izquierda
        double altoBotones = altoIzquierdo - altoCanvas;
        Button botonBanco;
        botonBanco = new Button("Banco");
        botonBanco.setPrefHeight(altoVentana - altoBotones);
        botonBanco.setPrefWidth(anchoVentana * 0.33);

        Button botonBiblioteca;
        botonBiblioteca = new Button("Biblioteca");
        botonBiblioteca.setPrefHeight(altoVentana - altoBotones);
        botonBiblioteca.setPrefWidth(anchoVentana * 0.33);

        Button botonPuerto;
        botonPuerto = new Button("Puerto");
        botonPuerto.setPrefHeight(altoVentana - altoBotones);
        botonPuerto.setPrefWidth(anchoVentana * 0.33);

        HBox botones = new HBox(botonBanco, botonBiblioteca, botonPuerto);

        // Nodo Izquierdo
        pantallaIzquierdaActual = new VBox(canvasIzquierdo, botones);
        altoPantallaIzquierdaActual = altoIzquierdo;

        // Pantalla derecha se mantiene igual.
    }

    private VBox construirPantallaIzquierda(Node nodo, double anchoNodo, double altoNodo) {

        Label etiquetaCiudad = new Label("Ciudad");
        Label etiquetaTiempo = new Label("Dia, hora");

        VBox info = new VBox(etiquetaCiudad, etiquetaTiempo);
        info.setPrefHeight(altoVentana - altoNodo);

        VBox pantallaizquierda = new VBox();
        pantallaizquierda.getChildren().addAll(info, nodo);

        return pantallaizquierda;
    }

    private VBox construirPantallaDerecha(Node nodo, double anchoNodo, double altoNodo) {
        double altoBotones = altoVentana - altoNodo;
        Button botonConexiones = new Button("Ver conexiones");
        botonConexiones.setPrefHeight(altoBotones * 0.25);
        botonConexiones.setPrefWidth(anchoVentana - anchoNodo);

        Button botonMapa;
        botonMapa = new Button("Viajar");
        botonMapa.setPrefHeight(altoBotones * 0.25);
        botonMapa.setPrefWidth(anchoVentana - anchoNodo);

        Button botonEdificios;
        botonEdificios = new Button("Investigar");
        botonEdificios.setPrefHeight(altoBotones * 0.25);
        botonEdificios.setPrefWidth(anchoVentana - anchoNodo);
        botonEdificios.setOnAction(new ControladorBotonInvestigar(ventanaPrincipal));

        Button botonCompu;
        botonCompu = new Button("Visitar Interpol");
        botonCompu.setPrefHeight(altoBotones * 0.25);
        botonCompu.setPrefWidth(anchoVentana - anchoNodo);

        VBox optionButons = new VBox();
        optionButons.getChildren().addAll(botonConexiones, botonMapa, botonEdificios, botonCompu);

        VBox verticalDerecha = new VBox();
        verticalDerecha.getChildren().addAll(nodo, optionButons);
        return verticalDerecha;
    }

}

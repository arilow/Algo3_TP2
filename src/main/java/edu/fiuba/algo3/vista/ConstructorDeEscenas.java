package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.Pista;
import javafx.scene.Node;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class ConstructorDeEscenas {
    VentanaPrincipal ventanaPrincipal;
    Stage stage;
    Juego juego;
    int anchoVentana;
    int altoVentana;

    double anchoPantalla;
    double altoPantallaIzquierdaActual;
    double altoPantallaDerechaActual;

    Node pantallaDatos;
    Node pantallaOpciones;
    Node pantallaIzquierdaActual;
    Node pantallaDerechaActual;

    public ConstructorDeEscenas(VentanaPrincipal ventanaPrincipal, Stage stage, Juego juego, int anchoVentana, int altoVentana) {
        this.ventanaPrincipal = ventanaPrincipal;
        this.stage = stage;
        this.juego = juego;
        this.anchoVentana = anchoVentana;
        this.altoVentana = altoVentana;
        anchoPantalla = anchoVentana * 0.5;
        altoPantallaIzquierdaActual = altoVentana * 0.9;
        altoPantallaDerechaActual = altoVentana * 0.75;
    }

    public HBox construirPantallaInicioCiudad() {
        // Pantalla Izquierda
        pantallaIzquierdaActual = new VistaImagenCiudad(anchoPantalla, altoPantallaIzquierdaActual);
        VBox infoFecha = construirPantallaDatos(juego.nivelActual().obtenerCiudadActual().obtenerNombre(), juego.nivelActual().obtenerFecha());
        VBox pantallaizquierda = new VBox(infoFecha, pantallaIzquierdaActual);

        // Pantalla Derecha
        pantallaDerechaActual = new VistaDescripcionCiudad(anchoPantalla, altoPantallaDerechaActual);
        VBox pantallaDerecha = new VBox(pantallaDerechaActual, construirPantallaOpciones());

        return new HBox(pantallaizquierda, pantallaDerecha);
    }

    public HBox construirPantallaSeleccionEdificios() {
        // Pantalla izquierda
        pantallaIzquierdaActual = new VistaListaEdificios(juego.nivelActual(), anchoPantalla, altoPantallaIzquierdaActual);
        VBox infoFecha = construirPantallaDatos(juego.nivelActual().obtenerCiudadActual().obtenerNombre(), juego.nivelActual().obtenerFecha());
        VBox pantallaizquierda = new VBox(infoFecha, pantallaIzquierdaActual);

        // Pantalla derecha no cambia (Por ahora)
        VBox pantallaDerecha = new VBox(pantallaDerechaActual, construirPantallaOpciones());

        return new HBox(pantallaizquierda, pantallaDerecha);
    }

    public HBox construirPantallaComputadoraInterpol() {
        // Pantalla izquierda
        pantallaIzquierdaActual = new VistaIzquierdaComputadoraInterpol(juego.nivelActual(), anchoPantalla, altoPantallaIzquierdaActual);
        VBox infoFecha = construirPantallaDatos(juego.nivelActual().obtenerCiudadActual().obtenerNombre(), juego.nivelActual().obtenerFecha());
        VBox pantallaizquierda = new VBox(infoFecha, pantallaIzquierdaActual);

        // Pantalla Derecha
        pantallaDerechaActual = new VistaComputadoraInterpol(juego.nivelActual(), anchoPantalla, altoPantallaDerechaActual);
        VBox pantallaDerecha = new VBox(pantallaDerechaActual, construirPantallaOpciones());

        return new HBox(pantallaizquierda, pantallaDerecha);
    }


    public HBox construirPantallaEdificio(Pista pista) {
        //Pantalla izquierda
        pantallaDerechaActual = new VistaEdificio(pista, anchoPantalla, altoPantallaDerechaActual);
        VBox infoFecha = construirPantallaDatos(juego.nivelActual().obtenerCiudadActual().obtenerNombre(), juego.nivelActual().obtenerFecha());
        VBox pantallaizquierda = new VBox(infoFecha, pantallaIzquierdaActual);

        // Pantalla Derecha no cambia (En principio)
        VBox pantallaDerecha = new VBox(pantallaDerechaActual, construirPantallaOpciones());

        return new HBox(pantallaizquierda, pantallaDerecha);
    }

    public HBox construirPantallaRegistroJugador() {
        // Pantalla izquierda.
        pantallaIzquierdaActual = new VistaRegistroJugador(juego.partidaActual(), anchoPantalla, altoPantallaIzquierdaActual, this);
        VBox infoFecha = construirPantallaDatos("Cuartel General", "Lunes, 7hs");
        VBox pantallaizquierda = new VBox(infoFecha, pantallaIzquierdaActual);

        // Patalla derecha
        double anchoCanvas = anchoPantalla;
        double altoCanvas = altoVentana;
        Canvas canvas = new Canvas(anchoCanvas, altoCanvas);
        GraphicsContext gcD = canvas.getGraphicsContext2D();
        gcD.setFill(Color.BLACK);
        gcD.fillRect(0,0, anchoCanvas, altoCanvas);
        pantallaDerechaActual = canvas;

        VBox pantallaDerecha = new VBox(pantallaDerechaActual);

        return new HBox(pantallaizquierda, pantallaDerecha);
    }

    public HBox construirPantallaInicioNivel() {
        // Pantalla izquierda
        pantallaIzquierdaActual = new VistaExplicacionNivel(juego.nivelActual(), anchoPantalla, altoPantallaIzquierdaActual);
        // TODO:Se podria hacer un "Actualizar ciudad/ actualizar hora.
        VBox infoFecha = construirPantallaDatos(juego.nivelActual().obtenerCiudadActual().obtenerNombre(), juego.nivelActual().obtenerFecha());
        VBox pantallaizquierda = new VBox(infoFecha, pantallaIzquierdaActual);

        // Pantalla derecha actual pareciera mantenerse constante por ahora
        VBox pantallaDerecha = new VBox(pantallaDerechaActual, construirPantallaOpciones());

        return new HBox(pantallaizquierda, pantallaDerecha);
    }

    private VBox construirPantallaOpciones() {
        double altoVistaBotones = altoVentana - altoPantallaDerechaActual;
        pantallaOpciones = new VistaOpcionesJuego(ventanaPrincipal, anchoPantalla, altoVistaBotones);
        return (VBox) pantallaOpciones;
    }

    private VBox construirPantallaDatos(String ciudad, String fecha) {
        double altoVistaFecha = altoVentana - altoPantallaIzquierdaActual;
        pantallaDatos = new VistaDatos(ciudad, fecha, anchoPantalla, altoVistaFecha);
        return (VBox) pantallaDatos;
    }
}

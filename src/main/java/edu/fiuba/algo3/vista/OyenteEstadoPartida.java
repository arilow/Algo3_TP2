package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.ComunicadorEstadoPartida;
import edu.fiuba.algo3.modelo.EstadoPartida;

import java.util.Observable;
import java.util.Observer;

public class OyenteEstadoPartida implements Observer {

    VentanaPrincipal ventana;
    public OyenteEstadoPartida(VentanaPrincipal ventana) {
        this.ventana = ventana;
    }

    @Override
    public void update(Observable o, Object arg) {
        EstadoPartida estadoPartida = ((ComunicadorEstadoPartida) o).obtenerEstado();

        switch (estadoPartida) {
            case EMPEZAR:
                ventana.abrirPantallaRegistroJugador();
                break;
            case COMIENZA_NIVEL:
                ventana.mostrarPantallaInicioNivel();
                break;
            case ARRIBADO_A_CIUDAD_ACTUAL:
                ventana.mostrarPantallaInicioCiudad();
                break;
            case ENTRAR_A_EDIFICIO:
                ventana.mostrarPantallaEdificio();
                break;
            case BUSCAR_SOSPECHOSOS:
                ventana.mostrarPantallaInterpol();
                break;
            case VIAJAR:
                ventana.mostrarPantallaMapa();
                break;
            case LADRON_ARRESTADO:
                ventana.mostrarPantallaGanador();
                break;
            case LADRON_ESCAPADO:
                ventana.mostrarPantallaNivelPerdido();
                break;
            case NIVEL_SE_QUEDO_SIN_TIEMPO:
                ventana.mostrarPantallaNivelPerdidoPorTiempo();
                break;
            default:
                // TODO: Lanzar excepcion.
                System.out.println("Ninguno");
        }
    }
}

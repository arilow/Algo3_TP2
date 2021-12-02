package edu.fiuba.algo3.modelo.cargos;

import edu.fiuba.algo3.modelo.Tiempo;

public interface Cargo {
    int getCantidadArrestos();
    void setCantidadArrestos(int cantidadArrestos);
    void viajar(float diatancia, Tiempo tiempo);
}

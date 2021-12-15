package edu.fiuba.algo3.modelo.objetos;

public class ObjetoComun implements ObjetoRobado{
    String nombre;
    int cantidadCiudadesEscape;

    public ObjetoComun(String nombre) {
        this.nombre = nombre;
        this.cantidadCiudadesEscape = 4;
    }

    public boolean es(String nombre) {
        return this.nombre.equals(nombre);
    }

    public int obtenerCantidadCiudadesEscape(){
        return cantidadCiudadesEscape;
    }
}

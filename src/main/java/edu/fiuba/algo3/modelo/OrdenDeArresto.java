package edu.fiuba.algo3.modelo;

public class OrdenDeArresto {


    private boolean ejecutada;
    private String nombreLadronDeOrden;

    public OrdenDeArresto(){
        this.ejecutada = false;
        nombreLadronDeOrden = "Ninguno";
    }

    public void emitirOrdenDeArresto(String nombreLadron){
        if (!this.ejecutada)
        {
            this.nombreLadronDeOrden = nombreLadron;
            this.ejecutada = true;
        }else{return;}
    }

    public boolean fueEjecutada(){
        return ejecutada;
    }

    public String obtenerNombre(){
        return this.nombreLadronDeOrden;
    }

    public void ejecutarOrden(){
        this.ejecutada = true;
    }

    public boolean verificarLadron(Ladron ladron) {
        if(ladron.obtenerNombre() == nombreLadronDeOrden) {
            ladron.arrestar();
            return true;
        }
        return false;
    }

    public void emitirOrden(String nombre) {
        this.ejecutada = true;
        this.nombreLadronDeOrden = nombre;
    }
}

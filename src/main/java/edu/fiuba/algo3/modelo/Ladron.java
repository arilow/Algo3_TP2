package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.objetos.ObjetoRobado;

public class Ladron {

    private DatosLadron datos;

    public Ladron(String sexo, String hobby, String cabello, String senia, String vehiculo){
        datos = new DatosLadron(sexo, hobby, cabello, senia, vehiculo);
    };


    public boolean constatarDatos(DatosLadron datos) {
        return this.datos.constatar(datos);
    }
}

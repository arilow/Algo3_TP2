package edu.fiuba.algo3.modelo;

public class DatosLadron {
    private String sexo;
    private String hobby;
    private String cabello;
    private String senia;
    private String vehiculo;

    public DatosLadron(String sexo, String hobby, String cabello, String senia, String vehiculo){
        this.sexo = sexo;
        this.hobby = hobby;
        this.cabello = cabello;
        this.senia = senia;
        this.vehiculo = vehiculo;
    };

    public boolean constatar(DatosLadron otro) {
        return (this.sexo.equals(otro.sexo) &&
                this.hobby.equals(otro.hobby) &&
                this.cabello.equals(otro.cabello) &&
                this.senia.equals(otro.senia) &&
                this.vehiculo.equals(otro.vehiculo));
    }

}

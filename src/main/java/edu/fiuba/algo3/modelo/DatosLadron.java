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
        boolean output = true;
        if(!otro.sexo.isEmpty()) {
            output = output && sexo.equals(otro.sexo);
        }
        if(!otro.hobby.isEmpty()) {
            output = output && hobby.equals(otro.hobby);
        }
        if(!otro.senia.isEmpty()) {
            output = output && senia.equals(otro.senia);
        }
        if(!otro.cabello.isEmpty()) {
            output = output && cabello.equals(otro.cabello);
        }
        if(!otro.vehiculo.isEmpty()) {
            output = output && vehiculo.equals(otro.vehiculo);
        }
        return output;
    }

    public String toString(){
        return sexo + " " + hobby + " " + cabello + " " + senia + " " + vehiculo;
    }

}

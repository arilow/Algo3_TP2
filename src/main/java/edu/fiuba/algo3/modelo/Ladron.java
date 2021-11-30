package edu.fiuba.algo3.modelo;

public class Ladron {

    private String sexo;
    private String hobby;
    private String cabello;
    private String seña;
    private String vehiculo;

    public Ladron(String sexo, String hobby, String cabello, String seña, String vehiculo){};

    public String getSexo() {
        return sexo;
    }

    public String getHobby() {
        return hobby;
    }

    public String getCabello() {
        return cabello;
    }

    public String getSeña() {
        return seña;
    }

    public String getVehiculo() {
        return vehiculo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public void setCabello(String cabello) {
        this.cabello = cabello;
    }
}

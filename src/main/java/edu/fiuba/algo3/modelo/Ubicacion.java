package edu.fiuba.algo3.modelo;

public class Ubicacion {
    private double latitud;
    private double longitud;

    public Ubicacion(double longitud, double latitud){
        this.longitud = longitud;
        this.latitud = latitud;
    }
    public Ubicacion(String longitud, String latitud){
        this.longitud = Double.parseDouble(longitud);
        this.latitud = Double.parseDouble(latitud);
    }

    public double obtenerLatitud() { return latitud; }
    public double obtenerLongitud() { return longitud; }

    public double calcularDistancia(Ubicacion otraUbicacion){

        double lon1 = Math.toRadians(this.longitud);
        double lon2 = Math.toRadians(otraUbicacion.obtenerLongitud());
        double lat1 = Math.toRadians(this.latitud);
        double lat2 = Math.toRadians(otraUbicacion.obtenerLatitud());

        // Formula de Haversine
        double dlon = lon2 - lon1;
        double dlat = lat2 - lat1;

        double a = Math.pow(Math.sin(dlat / 2), 2)
                + Math.cos(lat1) * Math.cos(lat2)
                * Math.pow(Math.sin(dlon / 2),2);

        double c = 2 * Math.asin(Math.sqrt(a));

        // Radio de la Tierra en kilometros
        double r = 6371;

        // calcular el resultado
        return(c * r);
    }
}

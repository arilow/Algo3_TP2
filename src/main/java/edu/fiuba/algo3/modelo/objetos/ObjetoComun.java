package edu.fiuba.algo3.modelo.objetos;

import edu.fiuba.algo3.modelo.ciudades.Ciudad;

public class ObjetoComun implements ObjetoRobado{
    private Ciudad ciudad;

    ObjetoComun(Ciudad ciudad){
        this.ciudad = ciudad;
    }
}

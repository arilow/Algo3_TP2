package edu.fiuba.algo3.modelo.objetos;

import edu.fiuba.algo3.modelo.ciudades.Ciudad;

public class ObjetoValioso implements ObjetoRobado{
    private Ciudad ciudad;

    ObjetoValioso(Ciudad ciudad){
        this.ciudad = ciudad;
    }
}

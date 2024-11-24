package edu.fiuba.algo3.modelo.comodin;

import edu.fiuba.algo3.modelo.mano.Mano;

public class EstrategiaSumarPuntos implements EstrategiaComodin {

    public void realizarModificacion(Mano mano, int multiplicador, int puntos) {
        mano.sumarPuntos(puntos);
    }
}

package edu.fiuba.algo3.modelo.comodin;

import edu.fiuba.algo3.modelo.mano.Mano;

public class EstrategiaSumarPuntos implements EstrategiaModificador {
    public void realizarModificacion(Mano mano, int multiplicador, int puntos) {
        mano.sumarPuntos(puntos);
    }
}

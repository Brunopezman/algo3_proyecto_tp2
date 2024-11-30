package edu.fiuba.algo3.modelo.comodin;

import edu.fiuba.algo3.modelo.mano.Mano;

public class EstrategiaSumarMultiplicar implements EstrategiaComodin{
    @Override
    public void realizarModificacion(int puntos, int multiplicador, Mano mano) {
        mano.aumentarYMultiplicar(puntos, multiplicador);
    }
}

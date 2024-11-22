package edu.fiuba.algo3.modelo.comodin;
import edu.fiuba.algo3.modelo.mano.Mano;


public interface EstrategiaModificador {

    void realizarModificacion(Mano mano, int multiplicador, int puntos);
}

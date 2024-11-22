package edu.fiuba.algo3.modelo.comodin;

import edu.fiuba.algo3.modelo.juego.Jugada;

public interface EstrategiaModificador {

    void realizarModificacion(Jugada jugada, int multiplicador, int puntos);
}

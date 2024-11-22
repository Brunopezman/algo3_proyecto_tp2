package edu.fiuba.algo3.modelo.comodin;

import edu.fiuba.algo3.modelo.juego.Jugada;

public interface estrategiaModificador {

    void realizarModificacion(Jugada jugada, int multiplicador, int puntos);
}

package edu.fiuba.algo3.modelo.comodin;

import edu.fiuba.algo3.modelo.juego.Jugada;

public class estrategiaSumarPuntos {
    void realizarModificacion(Jugada jugada, int multiplicador, int puntos){
        jugada.sumarPuntos(puntos);
    }
}

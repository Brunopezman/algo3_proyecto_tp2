package edu.fiuba.algo3.modelo.comodin;

import edu.fiuba.algo3.modelo.mano.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ComodinRegularTests {
    @Test
    public void testComodinRegularSumaAlMultiplicadorCorrectamente(){
        Mano manoJugada = new Color();
        manoJugada.sumarPuntos(20);
        EstrategiaComodin estrategia = new EstrategiaSumarMultiplicador();
        Comodin comodin = new ComodinRegular(10,10,estrategia);
        comodin.aplicarEfecto(manoJugada);
        int puntajeEsperado = 770;
        //act
        int puntajeObtenido = manoJugada.puntajeFinal();
        //assert
        assertEquals(puntajeEsperado, puntajeObtenido);
    }

    @Test
    public void testComodinRegularMultiplicaAlMultiplicadorCorrectamente(){
        Mano manoJugada = new Color();
        manoJugada.sumarPuntos(20);
        EstrategiaComodin estrategia = new EstrategiaMultiplicarMultiplicador();
        Comodin comodin = new ComodinRegular(10,10,estrategia);
        comodin.aplicarEfecto(manoJugada);
        int puntajeEsperado = 2200;
        //act
        int puntajeObtenido = manoJugada.puntajeFinal();
        //assert
        assertEquals(puntajeEsperado, puntajeObtenido);
    }

    @Test
    public void testComodinSumaAlPuntajeCorrectamente(){
        Mano manoJugada = new Color();
        manoJugada.sumarPuntos(20);
        EstrategiaComodin estrategia = new EstrategiaSumarPuntos();
        Comodin comodin = new ComodinRegular(10,10,estrategia);
        comodin.aplicarEfecto(manoJugada);
        int puntajeEsperado = 260;
        //act
        int puntajeObtenido = manoJugada.puntajeFinal();
        //assert
        assertEquals(puntajeEsperado, puntajeObtenido);
    }
}
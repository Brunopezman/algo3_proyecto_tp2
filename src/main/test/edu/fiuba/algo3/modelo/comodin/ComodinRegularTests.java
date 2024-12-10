package edu.fiuba.algo3.modelo.comodin;

import edu.fiuba.algo3.modelo.mano.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ComodinRegularTests {
    @Test
    public void testComodinRegularMultiplicaAlMultiplicadorCorrectamente() {
        //arrange
        Mano manoJugada = new Color();
        manoJugada.sumarPuntos(20);
        EstrategiaComodin estrategia = new EstrategiaSumarMultiplicar();
        Comodin comodin = new ComodinRegular("Comodin Regular","...",0,4,estrategia);
        comodin.aplicarEfecto(manoJugada);
        int puntajeEsperado = 880;
        //act
        int puntajeObtenido = manoJugada.puntajeFinal();
        //assert
        assertEquals(puntajeEsperado, puntajeObtenido);
    }

    @Test
    public void testComodinRegularSumaAlPuntajeCorrectamente(){
        //arrange
        Mano manoJugada = new Color();
        manoJugada.sumarPuntos(20);
        EstrategiaComodin estrategia = new EstrategiaSumarMultiplicar();
        Comodin comodin = new ComodinRegular("Comodin Regular","...",10,1,estrategia);
        comodin.aplicarEfecto(manoJugada);
        int puntajeEsperado = 260;
        //act
        int puntajeObtenido = manoJugada.puntajeFinal();
        //assert
        assertEquals(puntajeEsperado, puntajeObtenido);
    }

    @Test
    public void testComodinRegularAplicaSuEfectoCompletoCorrectamente(){
        //arrange
        Mano manoJugada = new Color();
        manoJugada.sumarPuntos(20);
        EstrategiaComodin estrategia = new EstrategiaSumarMultiplicar();
        Comodin comodin = new ComodinRegular("Comodin Regular","...",10,4,estrategia);
        comodin.aplicarEfecto(manoJugada);
        int puntajeEsperado = 1040;
        //act
        int puntajeObtenido = manoJugada.puntajeFinal();
        //assert
        assertEquals(puntajeEsperado, puntajeObtenido);
    }
}
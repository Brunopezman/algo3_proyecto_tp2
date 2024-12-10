package edu.fiuba.algo3.modelo.comodin;

import edu.fiuba.algo3.modelo.mano.Color;
import edu.fiuba.algo3.modelo.mano.Mano;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ComodinAleatorioTests {

    @Test
    public void testComodinSumaAlPuntajeAleatoriamente() {
        //arrange
        Mano mano = new Color();
        EstrategiaComodin estrategia = new EstrategiaSumarMultiplicar();
        mano.sumarPuntos(20);
        Comodin comodin = new ComodinAleatorio("Comodin Descarte", "...", 10,1,estrategia,1);
        comodin.aplicarEfecto(mano);
        int puntajeEsperado = 260;
        //act
        int puntajeObtenido = mano.puntajeFinal();
        //assert
        assertEquals(puntajeEsperado, puntajeObtenido);
    }

    @Test
    public void testComodinMultiplicaAlMultiplicadorAleatoriamente(){
        //arrange
        Mano mano = new Color();
        EstrategiaComodin estrategia = new EstrategiaSumarMultiplicar();
        mano.sumarPuntos(20);
        Comodin comodin = new ComodinAleatorio("Comodin Descarte", "...", 0,4,estrategia,1);
        comodin.aplicarEfecto(mano);
        int puntajeEsperado = 880;
        //act
        int puntajeObtenido = mano.puntajeFinal();
        //assert
        assertEquals(puntajeEsperado, puntajeObtenido);
    }

    @Test
    public void testComodinAplicaSuEfectoCompletoAleatoriamente(){
        //arrange
        Mano mano = new Color();
        EstrategiaComodin estrategia = new EstrategiaSumarMultiplicar();
        mano.sumarPuntos(20);
        Comodin comodin = new ComodinAleatorio("Comodin Descarte", "...", 10,4,estrategia,1);
        comodin.aplicarEfecto(mano);
        int puntajeEsperado = 1040;
        //act
        int puntajeObtenido = mano.puntajeFinal();
        //assert
        assertEquals(puntajeEsperado, puntajeObtenido);
    }

    @Test
    public void testComodinNoAplicaSuEfectoAleatoriamente(){
        //arrange
        Mano mano = new Color();
        EstrategiaComodin estrategia = new EstrategiaSumarMultiplicar();
        mano.sumarPuntos(20);
        Comodin comodin = new ComodinAleatorio("Comodin Descarte", "...", 10,4,estrategia,1000000000);
        comodin.aplicarEfecto(mano);
        int puntajeEsperado = 220;
        //act
        int puntajeObtenido = mano.puntajeFinal();
        //assert
        assertEquals(puntajeEsperado, puntajeObtenido);
    }
}

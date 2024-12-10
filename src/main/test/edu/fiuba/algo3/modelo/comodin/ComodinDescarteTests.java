package edu.fiuba.algo3.modelo.comodin;

import edu.fiuba.algo3.modelo.mano.Color;
import edu.fiuba.algo3.modelo.mano.Mano;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ComodinDescarteTests {

    @Test
    public void testComodinSumaAlPuntajeSiSeDescarto() {
        Mano mano = new Color();
        EstrategiaComodin estrategia = new EstrategiaSumarMultiplicar();
        mano.sumarPuntos(20);
        mano.sumarDescartes(1);
        Comodin comodin = new ComodinDescarte("Comodin Descarte", "...", 10, 1, estrategia);
        comodin.aplicarEfecto(mano);
        int puntajeEsperado = 260;
        //act
        int puntajeObtenido = mano.puntajeFinal();
        //assert
        assertEquals(puntajeEsperado, puntajeObtenido);
    }

    @Test
    public void testComodinMultiplicaAlMultiplicadorSiSeDescarto() {
        Mano mano = new Color();
        EstrategiaComodin estrategia = new EstrategiaSumarMultiplicar();
        mano.sumarPuntos(20);
        mano.sumarDescartes(1);
        Comodin comodin = new ComodinDescarte("Comodin Descarte", "...", 0, 4, estrategia);
        comodin.aplicarEfecto(mano);
        int puntajeEsperado = 880;
        //act
        int puntajeObtenido = mano.puntajeFinal();
        //assert
        assertEquals(puntajeEsperado, puntajeObtenido);
    }

    @Test
    public void testComodinAplicaSuEfectoCompletoSiSeDescarto() {
        Mano mano = new Color();
        EstrategiaComodin estrategia = new EstrategiaSumarMultiplicar();
        mano.sumarPuntos(20);
        mano.sumarDescartes(1);
        Comodin comodin = new ComodinDescarte("Comodin Descarte", "...", 10, 4, estrategia);
        comodin.aplicarEfecto(mano);
        int puntajeEsperado = 1040;
        //act
        int puntajeObtenido = mano.puntajeFinal();
        //assert
        assertEquals(puntajeEsperado, puntajeObtenido);
    }

    @Test
    public void testComodinNoAplicaSuEfectoSiNoSeDescarto() {
        Mano mano = new Color();
        EstrategiaComodin estrategia = new EstrategiaSumarMultiplicar();
        mano.sumarPuntos(20);
        Comodin comodin = new ComodinDescarte("Comodin Descarte", "...", 10, 4, estrategia);
        comodin.aplicarEfecto(mano);
        int puntajeEsperado = 220;
        //act
        int puntajeObtenido = mano.puntajeFinal();
        //assert
        assertEquals(puntajeEsperado, puntajeObtenido);
    }
}


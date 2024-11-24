package edu.fiuba.algo3.modelo.comodin;

import edu.fiuba.algo3.modelo.mano.Color;
import edu.fiuba.algo3.modelo.mano.Mano;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ComodinDescarteTests {

    @Test
    public void testComodinSumaAlPuntajeSiSeDescarto(){
        Mano mano = new Color();
        EstrategiaComodin estrategia = new EstrategiaSumarPuntos();
        mano.sumarPuntos(20);
        mano.sumarDescartes(1);
        Comodin comodin = new ComodinDescarte(10,10,estrategia);
        comodin.aplicarEfecto(mano);
        int puntajeEsperado = 260;
        //act
        int puntajeObtenido = mano.puntajeFinal();
        //assert
        assertEquals(puntajeEsperado, puntajeObtenido);
    }

    @Test
    public void testComodinNoSumaAlPuntajeSiNoSeDescarto(){
        Mano mano = new Color();
        EstrategiaComodin estrategia = new EstrategiaSumarPuntos();
        mano.sumarPuntos(20);
        Comodin comodin = new ComodinDescarte(10,10,estrategia);
        comodin.aplicarEfecto(mano);
        int puntajeEsperado = 220;
        //act
        int puntajeObtenido = mano.puntajeFinal();
        //assert
        assertEquals(puntajeEsperado, puntajeObtenido);
    }

    @Test
    public void testComodinSumaAlMultiplicadorSiSeDescarto(){
        Mano mano = new Color();
        EstrategiaComodin estrategia = new EstrategiaSumarMultiplicador();
        mano.sumarPuntos(20);
        mano.sumarDescartes(1);
        Comodin comodin = new ComodinDescarte(10,10,estrategia);
        comodin.aplicarEfecto(mano);
        int puntajeEsperado = 770;
        //act
        int puntajeObtenido = mano.puntajeFinal();
        //assert
        assertEquals(puntajeEsperado, puntajeObtenido);
    }

    @Test
    public void testComodinNoSumaAlMultiplicadorSiNoSeDescarto(){
        Mano mano = new Color();
        EstrategiaComodin estrategia = new EstrategiaSumarMultiplicador();
        mano.sumarPuntos(20);
        Comodin comodin = new ComodinDescarte(10,10,estrategia);
        comodin.aplicarEfecto(mano);
        int puntajeEsperado = 220;
        //act
        int puntajeObtenido = mano.puntajeFinal();
        //assert
        assertEquals(puntajeEsperado, puntajeObtenido);
    }

    @Test
    public void testComodinMultiplicaAlMultiplicadorSiSeDescarto(){
        Mano mano = new Color();
        EstrategiaComodin estrategia = new EstrategiaMultiplicarMultiplicador();
        mano.sumarPuntos(20);
        mano.sumarDescartes(1);
        Comodin comodin = new ComodinDescarte(10,10,estrategia);
        comodin.aplicarEfecto(mano);
        int puntajeEsperado = 2200;
        //act
        int puntajeObtenido = mano.puntajeFinal();
        //assert
        assertEquals(puntajeEsperado, puntajeObtenido);
    }

    @Test
    public void testComodinNoMultiplicaAlMultiplicadorSiNoSeDescarto(){
        Mano mano = new Color();
        EstrategiaComodin estrategia = new EstrategiaMultiplicarMultiplicador();
        mano.sumarPuntos(20);
        Comodin comodin = new ComodinDescarte(10,10,estrategia);
        comodin.aplicarEfecto(mano);
        int puntajeEsperado = 220;
        //act
        int puntajeObtenido = mano.puntajeFinal();
        //assert
        assertEquals(puntajeEsperado, puntajeObtenido);
    }
}

package edu.fiuba.algo3.modelo.comodin;

import edu.fiuba.algo3.modelo.mano.Color;
import edu.fiuba.algo3.modelo.mano.Escalera;
import edu.fiuba.algo3.modelo.mano.Mano;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ComodinManoEspecificaTests {

    @Test
    public void testComodinSumaAlPuntajeSiSeJuegaManoEspecifica() {
        Mano manoJugada = new Color();
        Mano manoEspecifica = new Color();
        EstrategiaComodin estrategia = new EstrategiaSumarPuntos();
        manoJugada.sumarPuntos(20);
        Comodin comodin = new ComodinManoEspecifica(10,10,estrategia,manoEspecifica);
        comodin.aplicarEfecto(manoJugada);
        int puntajeEsperado = 260;
        //act
        int puntajeObtenido = manoJugada.puntajeFinal();
        //assert
        assertEquals(puntajeEsperado, puntajeObtenido);
    }

    @Test
    public void testComodinNoSumaAlPuntajeSiNoSeJuegaManoEspecifica() {
        Mano manoJugada = new Color();
        Mano manoEspecifica = new Escalera();
        EstrategiaComodin estrategia = new EstrategiaSumarPuntos();
        manoJugada.sumarPuntos(20);
        Comodin comodin = new ComodinManoEspecifica(10,10,estrategia,manoEspecifica);
        comodin.aplicarEfecto(manoJugada);
        int puntajeEsperado = 220;
        //act
        int puntajeObtenido = manoJugada.puntajeFinal();
        //assert
        assertEquals(puntajeEsperado, puntajeObtenido);
    }

    @Test
    public void testComodinSumaAlMultiplicadorSiSeJuegaManoEspecifica() {
        Mano manoJugada = new Color();
        Mano manoEspecifica = new Color();
        EstrategiaComodin estrategia = new EstrategiaSumarMultiplicador();
        manoJugada.sumarPuntos(20);
        Comodin comodin = new ComodinManoEspecifica(10,10,estrategia,manoEspecifica);
        comodin.aplicarEfecto(manoJugada);
        int puntajeEsperado = 770;
        //act
        int puntajeObtenido = manoJugada.puntajeFinal();
        //assert
        assertEquals(puntajeEsperado, puntajeObtenido);
    }

    @Test
    public void testComodinNoSumaAlMultiplicadorSiNoSeJuegaManoEspecifica() {
        Mano manoJugada = new Color();
        Mano manoEspecifica = new Escalera();
        EstrategiaComodin estrategia = new EstrategiaSumarMultiplicador();
        manoJugada.sumarPuntos(20);
        Comodin comodin = new ComodinManoEspecifica(10,10,estrategia,manoEspecifica);
        comodin.aplicarEfecto(manoJugada);
        int puntajeEsperado = 220;
        //act
        int puntajeObtenido = manoJugada.puntajeFinal();
        //assert
        assertEquals(puntajeEsperado, puntajeObtenido);
    }

    @Test
    public void testComodinMultiplicaAlMultiplicadorSiSeJuegaManoEspecifica() {
        Mano manoJugada = new Color();
        Mano manoEspecifica = new Color();
        EstrategiaComodin estrategia = new EstrategiaMultiplicarMultiplicador();
        manoJugada.sumarPuntos(20);
        Comodin comodin = new ComodinManoEspecifica(10,10,estrategia,manoEspecifica);
        comodin.aplicarEfecto(manoJugada);
        int puntajeEsperado = 2200;
        //act
        int puntajeObtenido = manoJugada.puntajeFinal();
        //assert
        assertEquals(puntajeEsperado, puntajeObtenido);
    }

    @Test
    public void testComodinNoMultiplicaAlMultiplicadorSiNoSeJuegaManoEspecifica() {
        Mano manoJugada = new Color();
        Mano manoEspecifica = new Escalera();
        EstrategiaComodin estrategia = new EstrategiaMultiplicarMultiplicador();
        manoJugada.sumarPuntos(20);
        Comodin comodin = new ComodinManoEspecifica(10,10,estrategia,manoEspecifica);
        comodin.aplicarEfecto(manoJugada);
        int puntajeEsperado = 220;
        //act
        int puntajeObtenido = manoJugada.puntajeFinal();
        //assert
        assertEquals(puntajeEsperado, puntajeObtenido);
    }
}

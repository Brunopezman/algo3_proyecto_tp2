package edu.fiuba.algo3.modelo.comodin;

import edu.fiuba.algo3.modelo.mano.Color;
import edu.fiuba.algo3.modelo.mano.Escalera;
import edu.fiuba.algo3.modelo.mano.Mano;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ComodinManoEspecificaTests {

    @Test
    public void testComodinSumaAlPuntajeSiSeJuegaManoEspecifica() {
        //arrange
        Mano manoJugada = new Color();
        Mano manoEspecifica = new Color();
        String nombreMano = manoEspecifica.getNombre();
        EstrategiaComodin estrategia = new EstrategiaSumaSuma();
        manoJugada.sumarPuntos(20);
        Comodin comodin = new ComodinManoEspecifica("Comodin Mano Especifica", "...",10,0,estrategia,nombreMano);
        comodin.aplicarEfecto(manoJugada);
        int puntajeEsperado = 260;
        //act
        int puntajeObtenido = manoJugada.puntajeFinal();
        //assert
        assertEquals(puntajeEsperado, puntajeObtenido);
    }

    @Test
    public void testComodinSumaAlMultiplicadorSiSeJuegaManoEspecifica() {
        //arrange
        Mano manoJugada = new Color();
        Mano manoEspecifica = new Color();
        String nombreMano = manoEspecifica.getNombre();
        EstrategiaComodin estrategia = new EstrategiaSumaSuma();
        manoJugada.sumarPuntos(20);
        Comodin comodin = new ComodinManoEspecifica("Comodin Mano Especifica", "...",0,4,estrategia,nombreMano);
        comodin.aplicarEfecto(manoJugada);
        int puntajeEsperado = 880;
        //act
        int puntajeObtenido = manoJugada.puntajeFinal();
        //assert
        assertEquals(puntajeEsperado, puntajeObtenido);
    }

    @Test
    public void testComodinAplicaSuEfectoCompletoSiSeJuegaManoEspecifica() {
        //arrange
        Mano manoJugada = new Color();
        Mano manoEspecifica = new Color();
        String nombreMano = manoEspecifica.getNombre();
        EstrategiaComodin estrategia = new EstrategiaSumaSuma();
        manoJugada.sumarPuntos(20);
        Comodin comodin = new ComodinManoEspecifica("Comodin Mano Especifica", "...",10,4,estrategia,nombreMano);
        comodin.aplicarEfecto(manoJugada);
        int puntajeEsperado = 1040;
        //act
        int puntajeObtenido = manoJugada.puntajeFinal();
        //assert
        assertEquals(puntajeEsperado, puntajeObtenido);
    }

    @Test
    public void testComodinNoAplicaSuEfectoSiNoSeJuegaManoEspecifica() {
        //arrange
        Mano manoJugada = new Escalera();
        Mano manoEspecifica = new Color();
        String nombreMano = manoEspecifica.getNombre();
        EstrategiaComodin estrategia = new EstrategiaSumaSuma();
        manoJugada.sumarPuntos(20);
        Comodin comodin = new ComodinManoEspecifica("Comodin Mano Especifica", "...",10,4,estrategia,nombreMano);
        comodin.aplicarEfecto(manoJugada);
        int puntajeEsperado = 220;
        //act
        int puntajeObtenido = manoJugada.puntajeFinal();
        //assert
        assertEquals(puntajeEsperado, puntajeObtenido);
    }
}
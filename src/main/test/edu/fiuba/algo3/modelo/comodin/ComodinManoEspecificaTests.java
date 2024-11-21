package edu.fiuba.algo3.modelo.comodin;

import edu.fiuba.algo3.modelo.juego.Jugada;
import edu.fiuba.algo3.modelo.mano.Color;
import edu.fiuba.algo3.modelo.mano.Escalera;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ComodinManoEspecificaTests {
    private static final char SIMBOLOSUMAR = '+';
    private static final char SIMBOLOMULTIPLICAR = '*';

    @Test
    public void testComodinSumaAlPuntajeSiSeJuegaManoEspecifica() {
        Jugada jugada = new Jugada(new Color(), 0, 20);
        Comodin comodin_a_puntaje = new ComodinPuntaje(10, SIMBOLOSUMAR);
        Comodin comodin = new ComodinManoEspecifica(new Color(), comodin_a_puntaje);
        comodin.aplicarEfecto(jugada);
        int puntajeEsperado = 260;
        //act
        int puntajeObtenido = jugada.calcularPuntaje();
        //assert
        assertEquals(puntajeEsperado, puntajeObtenido);
    }

    @Test
    public void testComodinNoSumaAlPuntajeSiNoSeJuegaManoEspecifica() {
        Jugada jugada = new Jugada(new Color(), 0, 20);
        Comodin comodin_a_puntaje = new ComodinPuntaje(10, SIMBOLOSUMAR);
        Comodin comodin = new ComodinManoEspecifica(new Escalera(), comodin_a_puntaje);
        comodin.aplicarEfecto(jugada);
        int puntajeEsperado = 220;
        //act
        int puntajeObtenido = jugada.calcularPuntaje();
        //assert
        assertEquals(puntajeEsperado, puntajeObtenido);

    }

    @Test
    public void testComodinMultiplicaAlPuntajeSiSeJuegaManoEspecifica() {
        Jugada jugada = new Jugada(new Color(), 1, 20);
        Comodin comodin_a_puntaje = new ComodinPuntaje(10, SIMBOLOMULTIPLICAR);
        Comodin comodin = new ComodinManoEspecifica(new Color(), comodin_a_puntaje);
        comodin.aplicarEfecto(jugada);
        int puntajeEsperado = 1480;
        //act
        int puntajeObtenido = jugada.calcularPuntaje();
        //assert
        assertEquals(puntajeEsperado, puntajeObtenido);
    }

    @Test
    public void testComodinNoMultiplicaAlPuntajeSiNoSeJuegaManoEspecifica() {
        Jugada jugada = new Jugada(new Color(), 0, 20);
        Comodin comodin_a_puntaje = new ComodinPuntaje(10, SIMBOLOMULTIPLICAR);
        Comodin comodin = new ComodinManoEspecifica(new Escalera(), comodin_a_puntaje);
        comodin.aplicarEfecto(jugada);
        int puntajeEsperado = 220;
        //act
        int puntajeObtenido = jugada.calcularPuntaje();
        //assert
        assertEquals(puntajeEsperado, puntajeObtenido);
    }

    @Test
    public void testComodinSumaAlMultiplicadorSiSeJuegaManoEspecifica() {
        Jugada jugada = new Jugada(new Color(), 1, 20);
        Comodin comodin_a_multiplicador = new ComodinMultiplicador(10, SIMBOLOSUMAR);
        Comodin comodin = new ComodinManoEspecifica(new Color(), comodin_a_multiplicador);
        comodin.aplicarEfecto(jugada);
        int puntajeEsperado = 770;
        //act
        int puntajeObtenido = jugada.calcularPuntaje();
        //assert
        assertEquals(puntajeEsperado, puntajeObtenido);
    }

    @Test
    public void testComodinNoSumaAlMultiplicadorSiNoSeJuegaManoEspecifica() {
        Jugada jugada = new Jugada(new Color(), 0, 20);
        Comodin comodin_a_multiplicador = new ComodinMultiplicador(10, SIMBOLOSUMAR);
        Comodin comodin = new ComodinManoEspecifica(new Escalera(), comodin_a_multiplicador);
        comodin.aplicarEfecto(jugada);
        int puntajeEsperado = 220;
        //act
        int puntajeObtenido = jugada.calcularPuntaje();
        //assert
        assertEquals(puntajeEsperado, puntajeObtenido);
    }

    @Test
    public void testComodinMultiplicaAlMultiplicadorSiSeJuegaManoEspecifica() {
        Jugada jugada = new Jugada(new Color(), 1, 20);
        Comodin comodin_a_multiplicador = new ComodinMultiplicador(10, SIMBOLOMULTIPLICAR);
        Comodin comodin = new ComodinManoEspecifica(new Color(), comodin_a_multiplicador);
        comodin.aplicarEfecto(jugada);
        int puntajeEsperado = 2200;
        //act
        int puntajeObtenido = jugada.calcularPuntaje();
        //assert
        assertEquals(puntajeEsperado, puntajeObtenido);
    }

    @Test
    public void testComodinNoMultiplicaAlMultiplicadorSiNoSeJuegaManoEspecifica() {
        Jugada jugada = new Jugada(new Color(), 0, 20);
        Comodin comodin_a_multiplicador = new ComodinMultiplicador(10, SIMBOLOMULTIPLICAR);
        Comodin comodin = new ComodinManoEspecifica(new Escalera(), comodin_a_multiplicador);
        comodin.aplicarEfecto(jugada);
        int puntajeEsperado = 220;
        //act
        int puntajeObtenido = jugada.calcularPuntaje();
        //assert
        assertEquals(puntajeEsperado, puntajeObtenido);
    }

}

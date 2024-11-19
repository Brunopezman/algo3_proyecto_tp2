package edu.fiuba.algo3.modelo_tests.comodin;

import edu.fiuba.algo3.modelo.comodin.*;
import edu.fiuba.algo3.modelo.juego.Jugada;
import edu.fiuba.algo3.modelo.mano.Color;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ComodinAleatorioTests {
    private static final char SIMBOLOSUMAR = '+';
    private static final char SIMBOLOMULTIPLICAR = '*';

    @Test
    public void testComodinSumaAlPuntajeAleatoriamente() {
        Jugada jugada = new Jugada(new Color(), 0, 20);
        Comodin comodin_a_puntaje = new ComodinPuntaje(10, SIMBOLOSUMAR);
        Comodin comodin = new ComodinAleatorio(comodin_a_puntaje);
        comodin.aplicarEfecto(jugada);
        int puntajeEsperado = 260;
        //act
        int puntajeObtenido = jugada.calcularPuntaje();
        //assert
        assertEquals(puntajeEsperado, puntajeObtenido);
    }

    @Test
    public void testComodinMultiplicaAlPuntajeAleatoriamente() {
        Jugada jugada = new Jugada(new Color(), 1, 20);
        Comodin comodin_a_puntaje = new ComodinPuntaje(10, SIMBOLOMULTIPLICAR);
        Comodin comodin = new ComodinAleatorio(comodin_a_puntaje);
        comodin.aplicarEfecto(jugada);
        int puntajeEsperado = 1480;
        //act
        int puntajeObtenido = jugada.calcularPuntaje();
        //assert
        assertEquals(puntajeEsperado, puntajeObtenido);
    }

    @Test
    public void testComodinSumaAlMultiplicadorAleatoriamente(){
        Jugada jugada = new Jugada(new Color(), 1, 20);
        Comodin comodin_a_multiplicador = new ComodinMultiplicador(10, SIMBOLOSUMAR);
        Comodin comodin = new ComodinAleatorio(comodin_a_multiplicador);
        comodin.aplicarEfecto(jugada);
        int puntajeEsperado = 770;
        //act
        int puntajeObtenido = jugada.calcularPuntaje();
        //assert
        assertEquals(puntajeEsperado, puntajeObtenido);

    }

    @Test
    public void testComodinMultiplicaAlMultiplicadorAleatoriamente(){
        Jugada jugada = new Jugada(new Color(), 1, 20);
        Comodin comodin_a_multiplicador = new ComodinMultiplicador(10, SIMBOLOMULTIPLICAR);
        Comodin comodin = new ComodinAleatorio(comodin_a_multiplicador);
        comodin.aplicarEfecto(jugada);
        int puntajeEsperado = 2200;
        //act
        int puntajeObtenido = jugada.calcularPuntaje();
        //assert
        assertEquals(puntajeEsperado, puntajeObtenido);

    }
}

package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.carta.Carta;
import edu.fiuba.algo3.modelo.juego.*;
import edu.fiuba.algo3.modelo.mano.Color;
import edu.fiuba.algo3.modelo.mano.Mano;
import edu.fiuba.algo3.modelo.tarot.Tarot;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class CasosDeUsoTest {
/*
    private static final char SIMBOLOSUMAR = '+';
    private static final char SIMBOLOMULTIPLICAR = '*';

    @Test
    public void testJugadorPoseeCartasSuficientesParaEmpezar() {
        //arrange
        Mazo mazo = new Mazo();
        int esperado = 52;
        //act
        int obtenido = mazo.cartasRestantes();
        //assert
        assertEquals(esperado, obtenido);
    }

    @Test
    public void testJugadorRecibe8CartasDeMazo() {
        //arrange
        Jugador jugador = new Jugador("Franco");
        Mazo mazo = new Mazo();
        int esperado = 8;
        //act
        List<Carta> obtenido = jugador.recibirCartas(mazo);
        //assert
        assertEquals(esperado, obtenido.size());
    }


    @Test
    public void testSePuedeJugarManoDeUnMazo() {
        //arrange
        Jugador jugador = new Jugador("Bruno");
        Mazo mazo = new Mazo();
        //act
        jugador.recibirCartas(mazo);
        boolean respuesta = jugador.pudeJugarAlgunaMano();
        //assert
        assert (respuesta);
    }

    @Test
    public void testJugarManoAplicaValorCorrespondiente() {
        //arrange
        Ronda ronda = new Ronda();
        Turno turno = ronda.iniciarRonda();
        Jugador jugador = new Jugador("Migliore");
        List<Carta> cartas = new ArrayList<>();
        Color color = new Color();
        Carta carta1 = new CartaNumerica("2", "Picas");
        Carta carta2 = new CartaNumerica("3", "Picas");
        Carta carta3 = new CartaNumerica("4", "Picas");
        Carta carta4 = new CartaNumerica("5", "Picas");
        Carta carta5 = new CartaNumerica("6", "Picas");
        cartas.addAll(Arrays.asList(carta1, carta2, carta3, carta4, carta5));
        int esperado = 220;
        //act
        Jugada jugada = jugador.jugarMano(cartas, color);
        turno.calcularJugada(jugada);
        int resultado = turno.puntajeDelTurno();
        //assert
        assertEquals(esperado, resultado);
    }


    @Test
    public void testImportaOrdenDePuntuacionDeCartas() {
        //arrange
        Ronda ronda1 = new Ronda();
        Ronda ronda2 = new Ronda();
        ComodinPuntaje comodin1 = new ComodinPuntaje(10, SIMBOLOSUMAR);
        ComodinPuntaje comodin2 = new ComodinPuntaje(2, SIMBOLOMULTIPLICAR);
        ronda1.agregarComodin(comodin1);
        ronda1.agregarComodin(comodin2);
        ronda2.agregarComodin(comodin2);
        ronda2.agregarComodin(comodin1);
        Turno turno1 = ronda1.iniciarRonda();
        Turno turno2 = ronda2.iniciarRonda();
        Jugador jugador = new Jugador("Riquelme");
        List<Carta> cartas = new ArrayList<>();
        Mano color = new Color();
        Carta carta1 = new CartaNumerica("2", "Picas");
        Carta carta2 = new CartaNumerica("3", "Picas");
        Carta carta3 = new CartaNumerica("4", "Picas");
        Carta carta4 = new CartaNumerica("5", "Picas");
        Carta carta5 = new CartaNumerica("6", "Picas");
        cartas.addAll(Arrays.asList(carta1, carta2, carta3, carta4, carta5));
        //act
        Jugada jugada = jugador.jugarMano(cartas, color);
        turno1.calcularJugada(jugada);
        turno2.calcularJugada(jugada);
        int resultado1 = turno1.puntajeDelTurno();
        int resultado2 = turno2.puntajeDelTurno();
        //assert
        assertNotEquals(resultado1, resultado2);
    }

    @Test
    public void modificarCartaConTarotCambiaPuntos() {
        //arrange
        Tarot tarot = new Tarot(10);
        Mazo mazo = new Mazo();
        Carta carta = new CartaNumerica("2", "Picas");
        //act
        carta = tarot.modificarValorCarta(mazo, carta);
        //assert
        assertEquals(carta.getPuntaje(), 10);
    }



    @Test
    public void modificarCartaConTarotCambiarMultiplicador() {
        //arrange
        Jugador jugador = new Jugador("Simon");
        Tarot tarot = new Tarot(6);
        Mano color = new Color();
        //act
        color = tarot.modificarMultiplicador(color);
        //assert
        assertEquals(color.getMultiplicador(), 6);
    }

 */
}

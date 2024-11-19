package edu.fiuba.algo3.entrega_2;

import edu.fiuba.algo3.modelo.carta.Carta;
import edu.fiuba.algo3.modelo.carta.CartaNumerica;
import edu.fiuba.algo3.modelo.comodin.ComodinDescarte;
import edu.fiuba.algo3.modelo.comodin.ComodinManoEspecifica;
import edu.fiuba.algo3.modelo.comodin.ComodinMultiplicador;
import edu.fiuba.algo3.modelo.comodin.ComodinPuntaje;
import edu.fiuba.algo3.modelo.juego.*;
import edu.fiuba.algo3.modelo.mano.Color;
import edu.fiuba.algo3.modelo.mano.Escalera;
import edu.fiuba.algo3.modelo.mano.Mano;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CasosDeUsoTest {

    private static final char SIMBOLOSUMAR = '+';
    private static final char SIMBOLOMULTIPLICAR = '*';

    @Test
    public void ComodinSuma8AlMultiplicador(){
        //arrange
        Ronda ronda = new Ronda();
        ComodinMultiplicador comodin = new ComodinMultiplicador(8, SIMBOLOSUMAR);
        ronda.agregarComodin(comodin);
        Turno turno = ronda.iniciarRonda();
        Jugador jugador = new Jugador("Colapinto");
        List<Carta> cartas = new ArrayList<>();
        Mano color = new Color();
        Carta carta1 = new CartaNumerica("2", "Picas");
        Carta carta2 = new CartaNumerica("3", "Picas");
        Carta carta3 = new CartaNumerica("4", "Picas");
        Carta carta4 = new CartaNumerica("5", "Picas");
        Carta carta5 = new CartaNumerica("6", "Picas");
        cartas.addAll(Arrays.asList(carta1, carta2, carta3, carta4, carta5));
        int esperado = 660;
        //act
        Jugada jugada = jugador.jugarMano(cartas, color);
        turno.calcularJugada(jugada);
        int resultado = turno.puntajeDelTurno();
        //assert
        assertEquals(esperado, resultado);
    }

    @Test
    public void ComodinAEscaleraAumentaMultiplicadorPor3(){
        //arrange
        Ronda ronda = new Ronda();
        Mano escalera = new Escalera();
        ComodinMultiplicador multiplicador = new ComodinMultiplicador(3,SIMBOLOMULTIPLICAR);
        ComodinManoEspecifica comodin = new ComodinManoEspecifica(escalera,multiplicador);
        ronda.agregarComodin(comodin);
        Turno turno = ronda.iniciarRonda();
        Jugador jugador = new Jugador("Aleksandra");
        List<Carta> cartas = new ArrayList<>();
        Carta carta1 = new CartaNumerica("2", "Picas");
        Carta carta2 = new CartaNumerica("3", "Picas");
        Carta carta3 = new CartaNumerica("4", "Picas");
        Carta carta4 = new CartaNumerica("5", "Picas");
        Carta carta5 = new CartaNumerica("6", "Picas");
        cartas.addAll(Arrays.asList(carta1, carta2, carta3, carta4, carta5));
        int esperado = 600;
        //act
        Jugada jugada = jugador.jugarMano(cartas, escalera);
        turno.calcularJugada(jugada);
        int resultado = turno.puntajeDelTurno();
        //assert
        assertEquals(esperado, resultado);
    }

    @Test
    public void ComodinSuma10PorDescarte(){
        //arrange
        Ronda ronda = new Ronda();
        ComodinDescarte comodin = new ComodinDescarte(new ComodinPuntaje(10, SIMBOLOSUMAR));
        ronda.agregarComodin(comodin);
        Turno turno = ronda.iniciarRonda();
        Jugador jugador = new Jugador("Aleksandra");
        Mazo mazo = new Mazo();
        List<Carta> cartas = new ArrayList<>();
        Color color = new Color();
        Carta carta1 = new CartaNumerica("2", "Corazones");
        Carta carta2 = new CartaNumerica("3", "Corazones");
        Carta carta3 = new CartaNumerica("4", "Corazones");
        Carta carta4 = new CartaNumerica("5", "Corazones");
        Carta carta5 = new CartaNumerica("6", "Corazones");
        Carta carta6 = new CartaNumerica("9", "Corazones");
        cartas.addAll(Arrays.asList(carta1, carta2, carta3, carta4, carta5));
        jugador.recibirCartas(mazo);
        List<Carta> cartasDescarte = new ArrayList<Carta>();
        cartasDescarte.add(carta6);
        int esperado = 260;
        //act
        jugador.descartar(mazo,cartasDescarte);
        Jugada jugada = jugador.jugarMano(cartas, color);
        turno.calcularJugada(jugada);
        int resultado = turno.puntajeDelTurno();
        //assert
        assertEquals(esperado, resultado);
    }

    @Test
    public void ComodinConChance1Sobre1000SeRompe(){
    }

    @Test
    public void ComodinDeCombinacionSeAplicaCorrectamente(){
        //arrange
        Ronda ronda = new Ronda();
        ComodinDescarte comodin1 = new ComodinDescarte(new ComodinPuntaje(10, SIMBOLOSUMAR));
        Mano escalera = new Escalera();
        ComodinMultiplicador multiplicador = new ComodinMultiplicador(3,SIMBOLOMULTIPLICAR);
        ComodinManoEspecifica comodin2 = new ComodinManoEspecifica(escalera,multiplicador);
        ComodinPuntaje comodin3 = new ComodinPuntaje(5,SIMBOLOSUMAR);
        ronda.agregarComodin(comodin1);
        ronda.agregarComodin(comodin2);
        ronda.agregarComodin(comodin3);
        Turno turno = ronda.iniciarRonda();
        Jugador jugador = new Jugador("Federico");
        Mazo mazo = new Mazo();
        List<Carta> cartas = new ArrayList<>();
        Carta carta1 = new CartaNumerica("2", "Corazones");
        Carta carta2 = new CartaNumerica("3", "Corazones");
        Carta carta3 = new CartaNumerica("4", "Corazones");
        Carta carta4 = new CartaNumerica("5", "Corazones");
        Carta carta5 = new CartaNumerica("6", "Corazones");
        Carta carta6 = new CartaNumerica("9", "Corazones");
        cartas.addAll(Arrays.asList(carta1, carta2, carta3, carta4, carta5));
        jugador.recibirCartas(mazo);
        List<Carta> cartasDescarte = new ArrayList<Carta>();
        cartasDescarte.add(carta6);
        int esperado = 780;
        //act
        jugador.descartar(mazo,cartasDescarte);
        Jugada jugada = jugador.jugarMano(cartas, escalera);
        turno.calcularJugada(jugada);
        int resultado = turno.puntajeDelTurno();
        //assert
        assertEquals(esperado, resultado);
    }

}

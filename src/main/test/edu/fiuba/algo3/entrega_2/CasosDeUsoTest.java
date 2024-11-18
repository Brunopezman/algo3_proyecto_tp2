package edu.fiuba.algo3.entrega_2;

import edu.fiuba.algo3.modelo.carta.Carta;
import edu.fiuba.algo3.modelo.carta.CartaNumerica;
import edu.fiuba.algo3.modelo.comodin.ComodinDescarte;
import edu.fiuba.algo3.modelo.comodin.ComodinMultiplicador;
import edu.fiuba.algo3.modelo.comodin.ComodinPuntaje;
import edu.fiuba.algo3.modelo.juego.Jugador;
import edu.fiuba.algo3.modelo.juego.Mazo;
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
        Jugador jugador = new Jugador("Colapinto");
        ComodinMultiplicador comodin = new ComodinMultiplicador(8, SIMBOLOSUMAR);
        List<Carta> cartas = new ArrayList<>();
        Mano color = new Color();
        Carta carta1 = new CartaNumerica("2", "Picas");
        Carta carta2 = new CartaNumerica("3", "Picas");
        Carta carta3 = new CartaNumerica("4", "Picas");
        Carta carta4 = new CartaNumerica("5", "Picas");
        Carta carta5 = new CartaNumerica("6", "Picas");
        cartas.addAll(Arrays.asList(carta1, carta2, carta3, carta4, carta5));
        jugador.agregarComodin(comodin);
        int esperado = 660;
        //act
        int resultado = jugador.jugarMano(cartas, color);
        //assert
        assertEquals(esperado, resultado);
    }

    @Test
    public void ComodinAEscaleraAumentaMultiplicadorPor3(){
        //arrange
        Jugador jugador = new Jugador("Aleksandra");
        ComodinMultiplicador comodin = new ComodinMultiplicador(3, SIMBOLOMULTIPLICAR);
        List<Carta> cartas = new ArrayList<>();
        Mano escalera = new Escalera();
        Carta carta1 = new CartaNumerica("2", "Picas");
        Carta carta2 = new CartaNumerica("3", "Picas");
        Carta carta3 = new CartaNumerica("4", "Picas");
        Carta carta4 = new CartaNumerica("5", "Picas");
        Carta carta5 = new CartaNumerica("6", "Picas");
        cartas.addAll(Arrays.asList(carta1, carta2, carta3, carta4, carta5));
        jugador.agregarComodin(comodin);
        int esperado = 600;
        //act
        int resultado = jugador.jugarMano(cartas, escalera);
        //assert
        assertEquals(esperado, resultado);
    }

    @Test
    public void ComodinSuma10PorDescarte(){
        Jugador jugador = new Jugador("Aleksandra");
        Mazo mazo = new Mazo();
        jugador.recibirCartas(mazo);
        ComodinDescarte comodin = new ComodinDescarte(new ComodinPuntaje(10, SIMBOLOSUMAR));
        jugador.agregarComodin(comodin);


    }

    @Test
    public void ComodinConChance1Sobre1000SeRompe(){
    }

    @Test
    public void ComodinDeCombinacionSeAplicaCorrectamente(){
    }

}

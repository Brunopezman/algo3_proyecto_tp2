package edu.fiuba.algo3.modelo.mano;

import edu.fiuba.algo3.modelo.carta.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ManoTests {

    @Test
    public void testCartaAltaReconoceSiEsJugable(){
        List<Carta> cartas = new ArrayList<>();
        Carta carta1 = new CartaNumerica("2", "Corazones");
        Carta carta2 = new CartaNumerica("3", "Corazones");
        Carta carta3 = new CartaNumerica("4", "Corazones");
        Carta carta4 = new CartaNumerica("5", "Corazones");
        Carta carta5 = new CartaNumerica("6", "Corazones");
        cartas.addAll(Arrays.asList(carta1, carta2, carta3, carta4, carta5));
        Mano cartaAlta = new CartaAlta();
        assert cartaAlta.esJugable(cartas);
    }

    @Test
    public void testColorReconoceSiEsJugable(){
        List<Carta> cartas = new ArrayList<>();
        Carta carta1 = new CartaNumerica("2", "Corazones");
        Carta carta2 = new CartaNumerica("3", "Corazones");
        Carta carta3 = new CartaNumerica("4", "Corazones");
        Carta carta4 = new CartaNumerica("5", "Corazones");
        Carta carta5 = new CartaNumerica("6", "Corazones");
        cartas.addAll(Arrays.asList(carta1, carta2, carta3, carta4, carta5));
        Mano color = new Color();
        assert color.esJugable(cartas);
    }

    @Test
    public void testDobleParReconoceSiEsJugable(){
        List<Carta> cartas = new ArrayList<>();
        Carta carta1 = new CartaNumerica("2", "Corazones");
        Carta carta2 = new CartaNumerica("2", "Picas");
        Carta carta3 = new CartaNumerica("4", "Corazones");
        Carta carta4 = new CartaNumerica("4", "Picas");
        Carta carta5 = new CartaNumerica("6", "Treboles");
        cartas.addAll(Arrays.asList(carta1, carta2, carta3, carta4, carta5));
        Mano doblePar = new DoblePar();
        assert doblePar.esJugable(cartas);
    }

    @Test
    public void testEscaleraReconoceSiEsJugable(){
        List<Carta> cartas = new ArrayList<>();
        Carta carta1 = new CartaNumerica("2", "Corazones");
        Carta carta2 = new CartaNumerica("3", "Picas");
        Carta carta3 = new CartaNumerica("4", "Treboles");
        Carta carta4 = new CartaNumerica("5", "Corazones");
        Carta carta5 = new CartaNumerica("6", "Corazones");
        cartas.addAll(Arrays.asList(carta1, carta2, carta3, carta4, carta5));
        Mano escalera = new Escalera();
        assert escalera.esJugable(cartas);
    }

    @Test
    public void testEscaleraColorReconoceSiEsJugable(){
        List<Carta> cartas = new ArrayList<>();
        Carta carta1 = new CartaNumerica("2", "Corazones");
        Carta carta2 = new CartaNumerica("3", "Corazones");
        Carta carta3 = new CartaNumerica("4", "Corazones");
        Carta carta4 = new CartaNumerica("5", "Corazones");
        Carta carta5 = new CartaNumerica("6", "Corazones");
        cartas.addAll(Arrays.asList(carta1, carta2, carta3, carta4, carta5));
        Mano escaleraColor = new EscaleraColor();
        assert escaleraColor.esJugable(cartas);
    }

    @Test
    public void testEscaleraRealReconoceSiEsJugable(){
        List<Carta> cartas = new ArrayList<>();
        Carta carta1 = new CartaNumerica("10", "Corazones");
        Carta carta2 = new CartaNoNumerica("A", "Corazones");
        Carta carta3 = new CartaNoNumerica("J", "Corazones");
        Carta carta4 = new CartaNoNumerica("Q", "Corazones");
        Carta carta5 = new CartaNoNumerica("K", "Corazones");
        cartas.addAll(Arrays.asList(carta1, carta2, carta3, carta4, carta5));
        Mano escaleraReal = new EscaleraReal();
        assert escaleraReal.esJugable(cartas);
    }

    @Test
    public void testFullHouseReconoceSiEsJugable(){
        List<Carta> cartas = new ArrayList<>();
        Carta carta1 = new CartaNumerica("2", "Corazones");
        Carta carta2 = new CartaNumerica("2", "Picas");
        Carta carta3 = new CartaNumerica("2", "Treboles");
        Carta carta4 = new CartaNumerica("3", "Corazones");
        Carta carta5 = new CartaNumerica("3", "Picas");
        cartas.addAll(Arrays.asList(carta1, carta2, carta3, carta4, carta5));
        Mano fullHouse = new FullHouse();
        assert fullHouse.esJugable(cartas);
    }

    @Test
    public void testParReconoceSiEsJugable(){
        List<Carta> cartas = new ArrayList<>();
        Carta carta1 = new CartaNumerica("2", "Corazones");
        Carta carta2 = new CartaNumerica("2", "Picas");
        Carta carta3 = new CartaNumerica("4", "Diamantes");
        Carta carta4 = new CartaNumerica("5", "Diamantes");
        Carta carta5 = new CartaNumerica("6", "Diamantes");
        cartas.addAll(Arrays.asList(carta1, carta2, carta3, carta4, carta5));
        Mano par = new Par();
        assert par.esJugable(cartas);
    }

    @Test
    public void testPokerReconoceSiEsJugable(){
        List<Carta> cartas = new ArrayList<>();
        Carta carta1 = new CartaNumerica("2", "Corazones");
        Carta carta2 = new CartaNumerica("2", "Picas");
        Carta carta3 = new CartaNumerica("2", "Treboles");
        Carta carta4 = new CartaNumerica("2", "Diamantes");
        Carta carta5 = new CartaNumerica("6", "Corazones");
        cartas.addAll(Arrays.asList(carta1, carta2, carta3, carta4, carta5));
        Mano poker = new Poker();
        assert poker.esJugable(cartas);
    }

    @Test
    public void testTrioReconoceSiEsJugable(){
        List<Carta> cartas = new ArrayList<>();
        Carta carta1 = new CartaNumerica("2", "Corazones");
        Carta carta2 = new CartaNumerica("2", "Picas");
        Carta carta3 = new CartaNumerica("2", "Diamantes");
        Carta carta4 = new CartaNumerica("5", "Corazones");
        Carta carta5 = new CartaNumerica("6", "Picas");
        cartas.addAll(Arrays.asList(carta1, carta2, carta3, carta4, carta5));
        Mano trio = new Trio();
        assert trio.esJugable(cartas);
    }
}

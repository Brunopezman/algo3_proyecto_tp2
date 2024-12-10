package edu.fiuba.algo3.modelo.tarot;

import edu.fiuba.algo3.modelo.carta.Carta;
import edu.fiuba.algo3.modelo.mano.Escalera;
import edu.fiuba.algo3.modelo.mano.Mano;
import edu.fiuba.algo3.modelo.mano.Par;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class TarotTest {

    private List<Carta> cartasPrueba() {
        List<Carta> cartas = new ArrayList<>();
        Carta carta1 = new Carta("2 de Corazones", "Corazones", "2", "3", 2);
        Carta carta2 = new Carta("3 de Corazones", "Corazones", "3", "4", 3);
        Carta carta3 = new Carta("4 de Corazones", "Corazones", "4", "5", 4);
        Carta carta5 = new Carta("5 de Corazones", "Corazones", "5", "6", 5);
        Carta carta6 = new Carta("6 de Corazones", "Corazones", "6", "7", 6);
        cartas.add(carta1);
        cartas.add(carta2);
        cartas.add(carta3);
        cartas.add(carta5);
        cartas.add(carta6);
        return cartas;
    }

    @Test
    public void testTarotCartaAplicaALaCartaMasAlta() {
        Tarot tarot = new TarotCarta("tarot", "...", 10,2,"cualquiera");
        List<Carta> cartas = this.cartasPrueba();
        Mano mano = new Escalera();
        tarot.aplicarEfectos(cartas,mano);
        Carta carta = cartas.get(4);
        int puntajeEsperado = 32;
        int puntajeObtenido = carta.puntaje();
        assert(puntajeEsperado == puntajeObtenido);
    }

    @Test
    public void testTarotManoModificaElPuntaje() {
        Tarot tarot = new TarotMano("tarot", "...", 10,2,"par");
        List<Carta> cartas = this.cartasPrueba();
        Mano mano = new Par();
        tarot.aplicarEfectos(cartas,mano);
        int puntajeEsperado = 20;
        int puntajeObtenido = mano.getPuntaje();
        assert(puntajeEsperado == puntajeObtenido);
    }

    @Test
    public void testTarotManoModificaElMultiplicador() {
        Tarot tarot = new TarotMano("tarot", "...", 10,2,"par");
        List<Carta> cartas = this.cartasPrueba();
        Mano mano = new Par();
        tarot.aplicarEfectos(cartas,mano);
        int puntajeEsperado = 4;
        int puntajeObtenido = mano.getMultiplicador();
        assert(puntajeEsperado == puntajeObtenido);
    }

    @Test
    public void testTarotManoModificaLaManoIndicada() {
        Tarot tarot = new TarotMano("tarot", "...", 10,2,"par");
        List<Carta> cartas = this.cartasPrueba();
        Mano mano = new Par();
        tarot.aplicarEfectos(cartas,mano);
        int puntajeEsperado = 80;
        int puntajeObtenido = mano.puntajeFinal();
        assert(puntajeEsperado == puntajeObtenido);
    }

    @Test
    public void testTarotManoNoModificaLaManoIncorrecta() {
        Tarot tarot = new TarotMano("tarot", "...", 10,2,"escalera");
        List<Carta> cartas = this.cartasPrueba();
        Mano mano = new Par();
        tarot.aplicarEfectos(cartas,mano);
        int puntajeEsperado = 20;
        int puntajeObtenido = mano.puntajeFinal();
        assert(puntajeEsperado == puntajeObtenido);
    }
}

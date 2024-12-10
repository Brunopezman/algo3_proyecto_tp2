package edu.fiuba.algo3.modelo.juego;

import edu.fiuba.algo3.modelo.carta.Carta;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MazoTests {

    public Mazo iniciarMazoPrueba() {
        Carta carta1 = new Carta("10 de Corazones", "Corazones", "10", "Jota", 10);
        Carta carta2 = new Carta("9 de Corazones", "Corazones", "9", "10", 9);
        Carta carta3 = new Carta("8 de Corazones", "Corazones", "8", "9", 8);
        Carta carta4 = new Carta("7 de Corazones", "Corazones", "7", "8", 7);
        Carta carta5 = new Carta("6 de Corazones", "Corazones", "6", "7", 6);
        Carta carta6 = new Carta("5 de Corazones", "Corazones", "5", "6", 5);
        Carta carta7 = new Carta("4 de Corazones", "Corazones", "4", "5", 4);
        Carta carta8 = new Carta("3 de Corazones", "Corazones", "3", "4", 3);
        Carta carta9 = new Carta("2 de Corazones", "Corazones", "2", "3", 2);
        Carta carta10 = new Carta("As de Corazones", "Corazones", "As", "2", 1);
        List<Carta> cartas = new ArrayList<>();
        cartas.add(carta1);
        cartas.add(carta2);
        cartas.add(carta3);
        cartas.add(carta4);
        cartas.add(carta5);
        cartas.add(carta6);
        cartas.add(carta7);
        cartas.add(carta8);
        cartas.add(carta9);
        cartas.add(carta10);
        return new Mazo(cartas);
    }

    public List<Carta> cartasPrueba(){
        Carta carta1 = new Carta("10 de Corazones", "Corazones", "10", "Jota", 10);
        Carta carta2 = new Carta("9 de Corazones", "Corazones", "9", "10", 9);
        Carta carta3 = new Carta("8 de Corazones", "Corazones", "8", "9", 8);
        Carta carta4 = new Carta("7 de Corazones", "Corazones", "7", "8", 7);
        Carta carta5 = new Carta("6 de Corazones", "Corazones", "6", "7", 6);
        List<Carta> cartas = new ArrayList<>();
        cartas.add(carta1);
        cartas.add(carta2);
        cartas.add(carta3);
        cartas.add(carta4);
        cartas.add(carta5);
        return cartas;
    }
    @Test
    public void testUnMazoSeCreaConLaCantidadDeCartasCorrecta() {
        Mazo mazo = this.iniciarMazoPrueba();
        int cantidadCartasMazo = mazo.cantidadCartasTotales();
        int cantidadEsperada = 10;
        assertEquals(cantidadCartasMazo, cantidadEsperada);
    }

    @Test
    public void testUnMazoDaLaCantidadDeCartasCorrecta() {
        Mazo mazo = this.iniciarMazoPrueba();
        List<Carta> cartas = mazo.darCartas(8);
        int catidadRecibida = cartas.size();
        int cantidadEsperada = 8;
        assertEquals(cantidadEsperada,catidadRecibida);
    }

    @Test
    public void testUnMazoDaUnaCantidadDeCartasYActualizaSuCantidadDeCartas() {
        Mazo mazo = this.iniciarMazoPrueba();
        mazo.darCartas(8);
        int catidadRestante = mazo.cartasRestantes();
        int cantidadEsperada = 2;
        assertEquals(cantidadEsperada,catidadRestante);
    }

    @Test
    public void testUnMazoAgregaCartasCompradasCorrectamente() {
        Mazo mazo = this.iniciarMazoPrueba();
        List<Carta> cartas = this.cartasPrueba();
        mazo.agregarCartasCompradas(cartas);
        int catidadRestante = mazo.cartasRestantes();
        int cantidadEsperada = 15;
        assertEquals(cantidadEsperada,catidadRestante);
    }
}

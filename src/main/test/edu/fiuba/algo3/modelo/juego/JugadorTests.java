package edu.fiuba.algo3.modelo.juego;

import edu.fiuba.algo3.modelo.carta.Carta;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JugadorTests {

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

    @Test
    public void testSeCreaUnJugadorConElNombreCorrecto() {
        Jugador jugador = new Jugador("Muniain");
        String nombre = jugador.getNombre();
        String nombreEsperado = "Muniain";
        assertEquals(nombre, nombreEsperado);
    }

    @Test
    public void testSeCreaUnJugadorSinCartasEnMano() {
        Jugador jugador = new Jugador("Muniain");
        int cantidadEsperada = 0;
        int cantidadRecibida = jugador.getCantidadCartasActuales();
        assertEquals(cantidadEsperada, cantidadRecibida);
    }

    @Test
    public void testUnJugadorRecibeLasCartas() {
        //arrange
        Jugador jugador = new Jugador("Reali");
        Mazo mazo = this.iniciarMazoPrueba();
        int esperado = 8;
        //act
        List<Carta> obtenido = jugador.recibirCartas(mazo, 8);
        //assert
        assertEquals(esperado, obtenido.size());
    }

    @Test
    public void testUnJugadorDescartaSusCartasUsadas() {
        //arrange
        Jugador jugador = new Jugador("Reali");
        Mazo mazo = this.iniciarMazoPrueba();
        int esperado = 0;
        List<Carta> obtenido = jugador.recibirCartas(mazo, 8);
        //act
        jugador.eliminarCartasUsadas(obtenido);
        //assert
        assertEquals(esperado, jugador.getCantidadCartasActuales());
    }
}



package edu.fiuba.algo3.modelo.mano;

import edu.fiuba.algo3.modelo.carta.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertNull;

public class ManoTests {

    @Test
    public void testCartaAltaReconoceSiEsMismaMano() {
        Mano cartaAlta = new CartaAlta();
        Mano otraCartaAlta = new CartaAlta();
        assert(cartaAlta.esMismaMano(otraCartaAlta.getNombre()));
    }

    @Test
    public void testCartaAltaReconoceSiNoEsMismaMano() {
        Mano cartaAlta = new CartaAlta();
        Mano otraMano = new Color();
        assert(!cartaAlta.esMismaMano(otraMano.getNombre()));
    }

    @Test
    public void testColorReconoceSiEsMismaMano() {
        Mano Color = new Color();
        Mano otraColor = new Color();
        assert(Color.esMismaMano(otraColor.getNombre()));
    }

    @Test
    public void testColorReconoceSiNoEsMismaMano() {
        Mano Color = new Color();
        Mano otraMano = new FullHouse();
        assert(!Color.esMismaMano(otraMano.getNombre()));
    }

    @Test
    public void testDobleParReconoceSiEsMismaMano() {
        Mano doblePar = new DoblePar();
        Mano otraDoblePar = new DoblePar();
        assert(doblePar.esMismaMano(otraDoblePar.getNombre()));
    }

    @Test
    public void testDobleParReconoceSiNoEsMismaMano() {
        Mano doblePar = new DoblePar();
        Mano otraMano = new Color();
        assert(!doblePar.esMismaMano(otraMano.getNombre()));
    }

    @Test
    public void testEscaleraReconoceSiEsMismaMano() {
        Mano escalera = new Escalera();
        Mano otraEscalera = new Escalera();
        assert(escalera.esMismaMano(otraEscalera.getNombre()));
    }

    @Test
    public void testEscaleraReconoceSiNoEsMismaMano() {
        Mano escalera = new Escalera();
        Mano otraMano = new Trio();
        assert(!escalera.esMismaMano(otraMano.getNombre()));
    }

    @Test
    public void testEscaleraColorReconoceSiEsMismaMano() {
        Mano escaleraColor = new EscaleraColor();
        Mano otraEscaleraColor = new EscaleraColor();
        assert(escaleraColor.esMismaMano(otraEscaleraColor.getNombre()));
    }

    @Test
    public void testEscaleraColorReconoceSiNoEsMismaMano() {
        Mano escaleraColor = new EscaleraColor();
        Mano otraMano = new Trio();
        assert(!escaleraColor.esMismaMano(otraMano.getNombre()));
    }

    @Test
    public void testEscaleraRealReconoceSiEsMismaMano() {
        Mano escaleraReal = new EscaleraReal();
        Mano otraEscaleraReal = new EscaleraReal();
        assert(escaleraReal.esMismaMano(otraEscaleraReal.getNombre()));
    }

    @Test
    public void testEscaleraRealReconoceSiNoEsMismaMano() {
        Mano escaleraReal = new EscaleraReal();
        Mano otraMano = new EscaleraColor();
        assert(!escaleraReal.esMismaMano(otraMano.getNombre()));
    }

    @Test
    public void testFullHouseReconoceSiEsMismaMano() {
        Mano fullHouse = new FullHouse();
        Mano otraFullHouse = new FullHouse();
        assert(fullHouse.esMismaMano(otraFullHouse.getNombre()));
    }

    @Test
    public void testFullHouseReconoceSiNoEsMismaMano() {
        Mano fullHouse = new FullHouse();
        Mano otraMano = new Par();
        assert(!fullHouse.esMismaMano(otraMano.getNombre()));
    }

    @Test
    public void testTrioReconoceSiEsMismaMano() {
        Mano trio = new Trio();
        Mano otraTrio = new Trio();
        assert(trio.esMismaMano(otraTrio.getNombre()));
    }

    @Test
    public void testTrioReconoceSiNoEsMismaMano() {
        Mano trio = new Trio();
        Mano otraMano = new Par();
        assert(!trio.esMismaMano(otraMano.getNombre()));
    }

    @Test
    public void testPokerReconoceSiEsMismaMano() {
        Mano poker = new Poker();
        Mano otraPoker = new Poker();
        assert(poker.esMismaMano(otraPoker.getNombre()));
    }

    @Test
    public void testPokerReconoceSiNoEsMismaMano() {
        Mano poker = new Poker();
        Mano otraMano = new FullHouse();
        assert(!poker.esMismaMano(otraMano.getNombre()));
    }

    @Test
    public void testCartaAltaReconoceSiEsJugable() {
        List<Carta> cartas = new ArrayList<>();
        Carta carta1 = new Carta("10 de Corazones", "Corazones", "10", "Jota", 10);
        Carta carta2 = new Carta("9 de Corazones", "Corazones", "9", "10", 9);
        Carta carta3 = new Carta("8 de Corazones", "Corazones", "8", "9", 8);
        Carta carta4 = new Carta("7 de Corazones", "Corazones", "7", "8", 7);
        Carta carta5 = new Carta("6 de Corazones", "Corazones", "6", "7", 6);
        cartas.addAll(Arrays.asList(carta1, carta2, carta3, carta4, carta5));
        Mano manoEsperada = new CartaAlta();
        Mano manoRecibida = manoEsperada.esJugable(cartas);
        assert (manoEsperada.esMismaMano(manoRecibida.getNombre()));
    }

    @Test
    public void testColorReconoceSiEsJugable() {
        List<Carta> cartas = new ArrayList<>();
        Carta carta1 = new Carta("10 de Corazones", "Corazones", "10", "Jota", 10);
        Carta carta2 = new Carta("9 de Corazones", "Corazones", "9", "10", 9);
        Carta carta3 = new Carta("8 de Corazones", "Corazones", "8", "9", 8);
        Carta carta4 = new Carta("7 de Corazones", "Corazones", "7", "8", 7);
        Carta carta5 = new Carta("6 de Corazones", "Corazones", "6", "7", 6);
        cartas.addAll(Arrays.asList(carta1, carta2, carta3, carta4, carta5));
        Mano manoEsperada = new Color();
        Mano manoRecibida = manoEsperada.esJugable(cartas);
        assert (manoEsperada.esMismaMano(manoRecibida.getNombre()));
    }

    @Test
    public void testColorReconoceSiNoEsJugable() {
        List<Carta> cartas = new ArrayList<>();
        Carta carta1 = new Carta("10 de Corazones", "Corazones", "10", "Jota", 10);
        Carta carta2 = new Carta("9 de Corazones", "Corazones", "9", "10", 9);
        Carta carta3 = new Carta("8 de Corazones", "Corazones", "8", "9", 8);
        Carta carta4 = new Carta("7 de Corazones", "Corazones", "7", "8", 7);
        Carta carta5 = new Carta("6 de Diamantes", "Diamantes", "6", "7", 6);
        cartas.addAll(Arrays.asList(carta1, carta2, carta3, carta4, carta5));
        Mano manoEsperada = new Color();
        Object resultado = manoEsperada.esJugable(cartas);
        assertNull(resultado);
    }

    @Test
    public void testDobleParReconoceSiEsJugable(){
        List<Carta> cartas = new ArrayList<>();
        Carta carta1 = new Carta("2 de Corazones", "Corazones", "2", "3", 2);
        Carta carta2 = new Carta("2 de Picas", "Picas", "2", "3", 2);
        Carta carta3 = new Carta("4 de Corazones", "Corazones", "4", "5", 4);
        Carta carta4 = new Carta("4 de Picas", "Picas", "4", "5", 4);
        Carta carta5 = new Carta("5 de Diamantes", "Diamantes", "5", "6", 5);
        cartas.addAll(Arrays.asList(carta1, carta2, carta3, carta4, carta5));
        Mano manoEsperada = new DoblePar();
        Mano manoRecibida = manoEsperada.esJugable(cartas);
        assert (manoEsperada.esMismaMano(manoRecibida.getNombre()));
    }

    @Test
    public void testDobleParReconoceSiNoEsJugable(){
        List<Carta> cartas = new ArrayList<>();
        Carta carta1 = new Carta("1 de Corazones", "Corazones", "1", "2", 1);
        Carta carta2 = new Carta("2 de Picas", "Picas", "2", "3", 2);
        Carta carta3 = new Carta("4 de Corazones", "Corazones", "4", "5", 4);
        Carta carta4 = new Carta("4 de Picas", "Picas", "4", "5", 4);
        Carta carta5 = new Carta("5 de Diamantes", "Diamantes", "5", "6", 5);
        cartas.addAll(Arrays.asList(carta1, carta2, carta3, carta4, carta5));
        Mano manoEsperada = new DoblePar();
        Object resultado = manoEsperada.esJugable(cartas);
        assertNull(resultado);
    }

    @Test
    public void testEscaleraReconoceSiEsJugable(){
        List<Carta> cartas = new ArrayList<>();
        Carta carta1 = new Carta("10 de Diamantes", "Corazones", "10", "Jota", 10);
        Carta carta2 = new Carta("9 de Corazones", "Corazones", "9", "10", 9);
        Carta carta3 = new Carta("8 de Picas", "Corazones", "8", "9", 8);
        Carta carta4 = new Carta("7 de Trebol", "Corazones", "7", "8", 7);
        Carta carta5 = new Carta("6 de Corazones", "Corazones", "6", "7", 6);
        cartas.addAll(Arrays.asList(carta1, carta2, carta3, carta4, carta5));
        Mano manoEsperada = new Escalera();
        Mano manoRecibida = manoEsperada.esJugable(cartas);
        assert (manoEsperada.esMismaMano(manoRecibida.getNombre()));
    }

    @Test
    public void testEscaleraReconoceSiNoEsJugable(){
        List<Carta> cartas = new ArrayList<>();
        Carta carta1 = new Carta("10 de Diamantes", "Corazones", "10", "Jota", 10);
        Carta carta2 = new Carta("9 de Corazones", "Corazones", "9", "10", 9);
        Carta carta3 = new Carta("8 de Picas", "Corazones", "8", "9", 8);
        Carta carta4 = new Carta("5 de Trebol", "Corazones", "5", "6", 5);
        Carta carta5 = new Carta("6 de Corazones", "Corazones", "6", "7", 6);
        cartas.addAll(Arrays.asList(carta1, carta2, carta3, carta4, carta5));
        Mano manoEsperada = new Escalera();
        Object resultado = manoEsperada.esJugable(cartas);
        assertNull(resultado);
    }

    @Test
    public void testEscaleraColorReconoceSiEsJugable(){
        List<Carta> cartas = new ArrayList<>();
        Carta carta1 = new Carta("10 de Diamantes", "Diamantes", "10", "Jota", 10);
        Carta carta2 = new Carta("9 de Diamantes", "Diamantes", "9", "10", 9);
        Carta carta3 = new Carta("8 de Diamantes", "Diamantes", "8", "9", 8);
        Carta carta4 = new Carta("7 de Diamantes", "Diamantes", "7", "8", 7);
        Carta carta5 = new Carta("6 de Diamantes", "Diamantes", "6", "7", 6);
        cartas.addAll(Arrays.asList(carta1, carta2, carta3, carta4, carta5));
        Mano manoEsperada = new EscaleraColor();
        Mano manoRecibida = manoEsperada.esJugable(cartas);
        assert (manoEsperada.esMismaMano(manoRecibida.getNombre()));
    }

    @Test
    public void testEscaleraColorReconoceSiNoEsJugable(){
        List<Carta> cartas = new ArrayList<>();
        Carta carta1 = new Carta("10 de Diamantes", "Diamantes", "10", "Jota", 10);
        Carta carta2 = new Carta("9 de Diamantes", "Diamantes", "9", "10", 9);
        Carta carta3 = new Carta("8 de Diamantes", "Diamantes", "8", "9", 8);
        Carta carta4 = new Carta("7 de Corazones", "Corazones", "7", "8", 7);
        Carta carta5 = new Carta("6 de Diamantes", "Diamantes", "6", "7", 6);
        cartas.addAll(Arrays.asList(carta1, carta2, carta3, carta4, carta5));
        Mano manoEsperada = new EscaleraColor();
        Object resultado = manoEsperada.esJugable(cartas);
        assertNull(resultado);
    }

    @Test
    public void testEscaleraRealReconoceSiEsJugable(){
        List<Carta> cartas = new ArrayList<>();
        Carta carta1 = new Carta("10 de Corazones", "Corazones", "10", "Jota", 10);
        Carta carta2 = new Carta("As de Corazones", "Corazones", "As", "2", 9);
        Carta carta3 = new Carta("Jota de Corazones", "Corazones", "Jota", "As", 8);
        Carta carta4 = new Carta("Reina de Corazones", "Corazones", "Reina", "Jota", 7);
        Carta carta5 = new Carta("Rey de Corazones", "Corazones", "Rey", "Reina", 6);
        cartas.addAll(Arrays.asList(carta1, carta2, carta3, carta4, carta5));
        Mano manoEsperada = new EscaleraReal();
        Mano manoRecibida = manoEsperada.esJugable(cartas);
        assert (manoEsperada.esMismaMano(manoRecibida.getNombre()));
    }

    @Test
    public void testEscaleraRealReconoceSiNoEsJugable(){
        List<Carta> cartas = new ArrayList<>();
        Carta carta1 = new Carta("10 de Corazones", "Corazones", "10", "Jota", 10);
        Carta carta2 = new Carta("As de Diamantes", "Diamantes", "As", "2", 1);
        Carta carta3 = new Carta("Jota de Corazones", "Corazones", "Jota", "As", 11);
        Carta carta4 = new Carta("Reina de Corazones", "Corazones", "Reina", "Jota", 12);
        Carta carta5 = new Carta("Rey de Corazones", "Corazones", "Rey", "Reina", 13);
        cartas.addAll(Arrays.asList(carta1, carta2, carta3, carta4, carta5));
        Mano manoEsperada = new EscaleraReal();
        Object resultado = manoEsperada.esJugable(cartas);
        assertNull(resultado);
    }

    @Test
    public void testFullHouseReconoceSiEsJugable(){
        List<Carta> cartas = new ArrayList<>();
        Carta carta1 = new Carta("2 de Corazones", "Corazones", "2", "3", 2);
        Carta carta2 = new Carta("2 de Picas", "Picas", "2", "3", 2);
        Carta carta3 = new Carta("2 de Treboles", "Treboles", "2", "3", 2);
        Carta carta4 = new Carta("3 de Corazones", "Corazones", "3", "4", 3);
        Carta carta5 = new Carta("3 de Picas", "Picas", "3", "4", 3);
        cartas.addAll(Arrays.asList(carta1, carta2, carta3, carta4, carta5));
        Mano manoEsperada = new FullHouse();
        Mano manoRecibida = manoEsperada.esJugable(cartas);
        assert (manoEsperada.esMismaMano(manoRecibida.getNombre()));
    }

    @Test
    public void testFullHouseReconoceSiNoEsJugable(){
        List<Carta> cartas = new ArrayList<>();
        Carta carta1 = new Carta("2 de Corazones", "Corazones", "2", "3", 2);
        Carta carta2 = new Carta("2 de Picas", "Picas", "2", "3", 2);
        Carta carta3 = new Carta("4 de Treboles", "Treboles", "4", "5", 4);
        Carta carta4 = new Carta("3 de Corazones", "Corazones", "3", "4", 3);
        Carta carta5 = new Carta("3 de Picas", "Picas", "3", "4", 3);
        cartas.addAll(Arrays.asList(carta1, carta2, carta3, carta4, carta5));
        Mano manoEsperada = new FullHouse();
        Object resultado = manoEsperada.esJugable(cartas);
        assertNull(resultado);
    }

    @Test
    public void testParReconoceSiEsJugable(){
        List<Carta> cartas = new ArrayList<>();
        Carta carta1 = new Carta("2 de Corazones", "Corazones", "2", "3", 2);
        Carta carta2 = new Carta("2 de Picas", "Picas", "2", "3", 2);
        Carta carta3 = new Carta("4 de Treboles", "Treboles", "4", "5", 4);
        Carta carta4 = new Carta("5 de Treboles", "Treboles", "5", "6", 5);
        Carta carta5 = new Carta("6 de Treboles", "Treboles", "6", "7", 6);
        cartas.addAll(Arrays.asList(carta1, carta2, carta3, carta4, carta5));
        Mano manoEsperada = new Par();
        Mano manoRecibida = manoEsperada.esJugable(cartas);
        assert (manoEsperada.esMismaMano(manoRecibida.getNombre()));
    }

    @Test
    public void testParReconoceSiNoEsJugable(){
        List<Carta> cartas = new ArrayList<>();
        Carta carta1 = new Carta("2 de Corazones", "Corazones", "2", "3", 2);
        Carta carta2 = new Carta("3 de Picas", "Picas", "3", "4", 3);
        Carta carta3 = new Carta("4 de Treboles", "Treboles", "4", "5", 4);
        Carta carta4 = new Carta("5 de Treboles", "Treboles", "5", "6", 5);
        Carta carta5 = new Carta("6 de Treboles", "Treboles", "6", "7", 6);
        cartas.addAll(Arrays.asList(carta1, carta2, carta3, carta4, carta5));
        Mano manoEsperada = new Par();
        Object resultado = manoEsperada.esJugable(cartas);
        assertNull(resultado);
    }

    @Test
    public void testPokerReconoceSiEsJugable(){
        List<Carta> cartas = new ArrayList<>();
        Carta carta1 = new Carta("2 de Corazones", "Corazones", "2", "3", 2);
        Carta carta2 = new Carta("2 de Picas", "Picas", "2", "3", 2);
        Carta carta3 = new Carta("2 de Treboles", "Treboles", "2", "3", 2);
        Carta carta4 = new Carta("2 de Diamantes", "Diamantes", "2", "3", 2);
        Carta carta5 = new Carta("6 de Treboles", "Treboles", "6", "7", 7);
        cartas.addAll(Arrays.asList(carta1, carta2, carta3, carta4, carta5));
        Mano manoEsperada = new Poker();
        Mano manoRecibida = manoEsperada.esJugable(cartas);
        assert (manoEsperada.esMismaMano(manoRecibida.getNombre()));
    }

    @Test
    public void testPokerReconoceSiNoEsJugable(){
        List<Carta> cartas = new ArrayList<>();
        Carta carta1 = new Carta("2 de Corazones", "Corazones", "2", "3", 2);
        Carta carta2 = new Carta("3 de Picas", "Picas", "3", "4", 3);
        Carta carta3 = new Carta("2 de Treboles", "Treboles", "2", "3", 2);
        Carta carta4 = new Carta("2 de Diamantes", "Diamantes", "2", "3", 2);
        Carta carta5 = new Carta("6 de Treboles", "Treboles", "6", "7", 7);
        cartas.addAll(Arrays.asList(carta1, carta2, carta3, carta4, carta5));
        Mano manoEsperada = new Poker();
        Object resultado = manoEsperada.esJugable(cartas);
        assertNull(resultado);
    }

    @Test
    public void testTrioReconoceSiEsJugable(){
        List<Carta> cartas = new ArrayList<>();
        Carta carta1 = new Carta("2 de Corazones", "Corazones", "2", "3", 2);
        Carta carta2 = new Carta("2 de Picas", "Picas", "2", "3", 2);
        Carta carta3 = new Carta("2 de Treboles", "Treboles", "2", "3", 2);
        Carta carta4 = new Carta("5 de Diamantes", "Diamantes", "5", "6", 5);
        Carta carta5 = new Carta("6 de Treboles", "Treboles", "6", "7", 6);
        cartas.addAll(Arrays.asList(carta1, carta2, carta3, carta4, carta5));
        Mano manoEsperada = new Trio();
        Mano manoRecibida = manoEsperada.esJugable(cartas);
        assert (manoEsperada.esMismaMano(manoRecibida.getNombre()));
    }

    @Test
    public void testTrioReconoceSiNoEsJugable(){
        List<Carta> cartas = new ArrayList<>();
        Carta carta1 = new Carta("2 de Corazones", "Corazones", "2", "3", 2);
        Carta carta2 = new Carta("3 de Picas", "Picas", "3", "4", 3);
        Carta carta3 = new Carta("2 de Treboles", "Treboles", "2", "3", 2);
        Carta carta4 = new Carta("5 de Diamantes", "Diamantes", "5", "6", 5);
        Carta carta5 = new Carta("6 de Treboles", "Treboles", "6", "7", 6);
        cartas.addAll(Arrays.asList(carta1, carta2, carta3, carta4, carta5));
        Mano manoEsperada = new Trio();
        Object resultado = manoEsperada.esJugable(cartas);
        assertNull(resultado);
    }
}

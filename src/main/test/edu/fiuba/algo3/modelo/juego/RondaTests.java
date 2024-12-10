package edu.fiuba.algo3.modelo.juego;

import edu.fiuba.algo3.modelo.NoHayMasTurnosException;
import edu.fiuba.algo3.modelo.carta.Carta;
import edu.fiuba.algo3.modelo.comodin.*;
import edu.fiuba.algo3.modelo.mano.Color;
import edu.fiuba.algo3.modelo.mano.Escalera;
import edu.fiuba.algo3.modelo.mano.EscaleraColor;
import edu.fiuba.algo3.modelo.mano.Mano;
import edu.fiuba.algo3.modelo.tarot.Tarot;
import edu.fiuba.algo3.modelo.tarot.TarotCarta;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RondaTests {

    private List<Comodin> comodinesPrueba(){
        Comodin comodin1 = new ComodinRegular("Comodin", "...", 10, 10, new EstrategiaSumarMultiplicar());
        Comodin comodin2 = new ComodinRegular("Comodin", "...", 10, 10, new EstrategiaSumarMultiplicar());
        Comodin comodin3 = new ComodinRegular("Comodin", "...", 10, 10, new EstrategiaSumarMultiplicar());
        List<Comodin> comodines = new ArrayList<>();
        comodines.add(comodin1);
        comodines.add(comodin2);
        comodines.add(comodin3);
        return comodines;
    }

    private List<Tarot> tarotsPrueba() {
        Tarot tarot1 = new TarotCarta("Tarot","...",10,10,"algo");
        Tarot tarot2 = new TarotCarta("Tarot","...",10,10,"algo");
        Tarot tarot3 = new TarotCarta("Tarot","...",10,10,"algo");
        List<Tarot> tarots = new ArrayList<>();
        tarots.add(tarot1);
        tarots.add(tarot2);
        tarots.add(tarot3);
        return tarots;
    }

    private Tienda tiendaPrueba() {
        List<Comodin> comodines = new ArrayList<>();
        Comodin comodin = new ComodinRegular("Comodin", "...", 10, 10, new EstrategiaSumarMultiplicar());
        comodines.add(comodin);
        List<Tarot> tarots = new ArrayList<>();
        Tarot tarot = new TarotCarta("Tarot", "...", 10, 10, "As");
        tarots.add(tarot);
        return new Tienda(comodines, tarots, new Carta("As", "Corazones", "10", "Jota", 10));
    }

    private Mazo iniciarMazoPrueba() {
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

    private List<Carta> cartasDescartarPrueba() {
        List<Carta> cartas = new ArrayList<>();
        Carta carta1 = new Carta("2 de Corazones", "Corazones", "2", "3", 2);
        Carta carta2 = new Carta("3 de Corazones", "Corazones", "3", "4", 3);
        cartas.add(carta1);
        cartas.add(carta2);
        return cartas;
    }

    @Test
    public void testSeCreaUnaRondaConLaCantidadDeTurnosCorrecta() {
        Jugador jugador = new Jugador("CHIPA GOMEZ");
        Tienda tienda = this.tiendaPrueba();
        Ronda ronda = new Ronda(1, 5, 10, 1000, tienda);
        ronda.iniciarRonda();
        int cantidadTurnos = ronda.cantidadTurnos();
        int turnosEsperados = 5;
        assertEquals(cantidadTurnos, turnosEsperados);
    }

    @Test
    public void testAlIniciarUnaRondaSeIniciaEnElPrimerTurno() {
        Jugador jugador = new Jugador("CAMPING");
        Tienda tienda = this.tiendaPrueba();
        Ronda ronda = new Ronda(1, 5, 10, 1000, tienda);
        ronda.iniciarRonda();
        int numeroTurno = ronda.turnoActual();
        int turnoEsperado = 1;
        assertEquals(numeroTurno, turnoEsperado);
    }

    @Test
    public void testSeAvanzaDeTurnoEnRonda() {
        Jugador jugador = new Jugador("PERRITO");
        Tienda tienda = this.tiendaPrueba();
        Ronda ronda = new Ronda(1, 5, 10, 1000, tienda);
        ronda.iniciarRonda();
        ronda.avanzarTurno();
        ronda.avanzarTurno();
        int numeroTurno = ronda.turnoActual();
        int turnoEsperado = 3;
        assertEquals(numeroTurno, turnoEsperado);
    }

    @Test
    public void testElSiguienteTurnoArrancaCon0Puntos() {
        Jugador jugador = new Jugador("REALI");
        Tienda tienda = this.tiendaPrueba();
        Ronda ronda = new Ronda(1, 5, 10, 1000, tienda);
        ronda.iniciarRonda();
        ronda.avanzarTurno();
        ronda.avanzarTurno();
        int puntosTurno = ronda.puntosTurnoActual();
        int puntajeEsperado = 0;
        assertEquals(puntajeEsperado, puntosTurno);
    }

    @Test
    public void testSeAgreganComodinesARonda() {
        Jugador jugador = new Jugador("ALTOSINMANOS");
        Tienda tienda = this.tiendaPrueba();
        Ronda ronda = new Ronda(1, 5, 10, 1000, tienda);
        Comodin comodin1 = new ComodinRegular("Comodin", "...", 10, 10, new EstrategiaSumarMultiplicar());
        Comodin comodin2 = new ComodinRegular("Comodin", "...", 10, 10, new EstrategiaSumarMultiplicar());
        Comodin comodin3 = new ComodinRegular("Comodin", "...", 10, 10, new EstrategiaSumarMultiplicar());
        List<Comodin> comodines = new ArrayList<>();
        comodines.add(comodin1);
        comodines.add(comodin2);
        comodines.add(comodin3);
        ronda.cargarComodinesRonda(comodines);
        int cantidadComodines = ronda.cantidadComodines();
        int cantidadEsperada = 3;
        assertEquals(cantidadComodines, cantidadEsperada);
    }

    @Test
    public void testAlAvanzarDeTurnoSeGuardaCorrectamente() {
        Tienda tienda = this.tiendaPrueba();
        Ronda ronda = new Ronda(1, 5, 10, 1000, tienda);
        EstrategiaSumarMultiplicar estrategia = new EstrategiaSumarMultiplicar();
        ComodinDescarte comodin1 = new ComodinDescarte("Descarte", "...",10,1,estrategia);
        Mano mano = new Escalera();
        ComodinManoEspecifica comodin2 = new ComodinManoEspecifica("Mano Específica", "...", 10,1,estrategia,"escalera");
        ComodinAleatorio comodin3 = new ComodinAleatorio("Aleatorio", "...", 10,1,estrategia,1);
        List<Comodin> comodines = new ArrayList<>();
        comodines.add(comodin1);
        comodines.add(comodin2);
        comodines.add(comodin3);
        ronda.cargarComodinesRonda(comodines);
        Turno turno = ronda.iniciarRonda();
        //mano.sumarPuntos(20);
        mano.sumarDescartes(1);
        List<Carta> cartas = this.cartasPrueba();
        turno.calcularJugada(cartas,mano);
        ronda.avanzarTurno();
        int puntajeEsperado = 320;
        int puntaje = ronda.getTurno(1).puntajeDelTurno();
        assertEquals(puntaje,puntajeEsperado);
    }

    @Test
    public void testSeCalculaPuntajeDeRonda() {
        Tienda tienda = this.tiendaPrueba();
        Ronda ronda = new Ronda(1, 5, 10, 1000, tienda);
        EstrategiaSumarMultiplicar estrategia = new EstrategiaSumarMultiplicar();
        ComodinDescarte comodin1 = new ComodinDescarte("Descarte", "...", 10, 1, estrategia);
        ComodinManoEspecifica comodin2 = new ComodinManoEspecifica("Mano Específica", "...", 10, 1, estrategia, "escalera");
        ComodinAleatorio comodin3 = new ComodinAleatorio("Aleatorio", "...", 10, 1, estrategia, 1);
        List<Comodin> comodines = new ArrayList<>();
        comodines.add(comodin1);
        comodines.add(comodin2);
        comodines.add(comodin3);
        ronda.cargarComodinesRonda(comodines);
        List<Carta> cartas = this.cartasPrueba();
        ronda.iniciarRonda();
        int contador = 1;
        while (contador < ronda.getTurnos()) { //itere los 5 turnos
            Mano mano = new Escalera();
            mano.sumarDescartes(1);
            ronda.jugarTurno(cartas, mano);
            if (contador < ronda.cantidadTurnos()) { //solo avance hasta el 5 turno (avanza internamente sino)
                ronda.avanzarTurno();
            }
            contador++;
        }
        int puntosRondaFinal = ronda.calcularPuntajeRonda();
        int puntosEsperados = 1280;
        assertEquals(puntosRondaFinal, puntosEsperados);
    }

    @Test
    public void testNoSePuedeAvanzarMasDeLosTurnosDeLaRonda() {
        Tienda tienda = this.tiendaPrueba();
        Ronda ronda = new Ronda(1, 5, 10, 1000, tienda);
        ronda.iniciarRonda();
        while (ronda.turnoActual() < ronda.getTurnos()) {
            ronda.avanzarTurno();
        }
        assert (!ronda.avanzarTurno());
    }

    @Test
    public void testSeSuperaPuntajeDeRonda() {
        Tienda tienda = this.tiendaPrueba();
        Ronda ronda = new Ronda(1, 5, 10, 1000, tienda);
        EstrategiaSumarMultiplicar estrategia = new EstrategiaSumarMultiplicar();
        ComodinDescarte comodin1 = new ComodinDescarte("Descarte", "...", 10, 1, estrategia);
        ComodinManoEspecifica comodin2 = new ComodinManoEspecifica("Mano Específica", "...", 10, 1, estrategia, "escalera");
        ComodinAleatorio comodin3 = new ComodinAleatorio("Aleatorio", "...", 10, 1, estrategia, 1);
        List<Comodin> comodines = new ArrayList<>();
        comodines.add(comodin1);
        comodines.add(comodin2);
        comodines.add(comodin3);
        ronda.cargarComodinesRonda(comodines);
        List<Carta> cartas = this.cartasPrueba();
        ronda.iniciarRonda();
        int contador = 1;
        while (contador < ronda.getTurnos()) { //itere los 5 turnos
            Mano mano = new Escalera();
            mano.sumarDescartes(1);
            ronda.jugarTurno(cartas, mano);
            if (contador < ronda.cantidadTurnos()) { //solo avance hasta el 5 turno (avanza internamente sino)
                ronda.avanzarTurno();
            }
            contador++;
        }
        assert (ronda.seAlcanzoElPuntajeDeRonda());
    }

    @Test
    public void testNoSeSuperaPuntajeDeRonda() {
        Tienda tienda = this.tiendaPrueba();
        Ronda ronda = new Ronda(1, 5, 10, 2000, tienda);
        EstrategiaSumarMultiplicar estrategia = new EstrategiaSumarMultiplicar();
        ComodinDescarte comodin1 = new ComodinDescarte("Descarte", "...", 10, 1, estrategia);
        ComodinManoEspecifica comodin2 = new ComodinManoEspecifica("Mano Específica", "...", 10, 1, estrategia, "escalera");
        ComodinAleatorio comodin3 = new ComodinAleatorio("Aleatorio", "...", 10, 1, estrategia, 1);
        List<Comodin> comodines = new ArrayList<>();
        comodines.add(comodin1);
        comodines.add(comodin2);
        comodines.add(comodin3);
        ronda.cargarComodinesRonda(comodines);
        List<Carta> cartas = this.cartasPrueba();
        ronda.iniciarRonda();
        int contador = 1;
        while (contador < ronda.getTurnos()) { //itere los 5 turnos
            Mano mano = new Escalera();
            mano.sumarDescartes(1);
            ronda.jugarTurno(cartas, mano);
            if (contador < ronda.cantidadTurnos()) { //solo avance hasta el 5 turno (avanza internamente sino)
                ronda.avanzarTurno();
            }
            contador++;
        }
        assert (!ronda.seAlcanzoElPuntajeDeRonda());
    }

    @Test
    public void testAlDescartarSeDevuelvenLaMismaCantidadDeCartas() {
        Tienda tienda = this.tiendaPrueba();
        Ronda ronda = new Ronda(1, 5, 10, 2000, tienda);
        ronda.iniciarRonda();
        Mazo mazo = this.iniciarMazoPrueba();
        List<Carta> cartas = this.cartasPrueba();
        List<Carta> cartasDescarte = new ArrayList<>();
        cartasDescarte.add(cartas.get(1));
        cartasDescarte.add(cartas.get(2));
        cartasDescarte.add(cartas.get(3));
        List<Carta> cartasActuales = ronda.descartar(mazo,cartas,cartasDescarte);
        int cantidadEsperada = 5;
        int cartasCantidad = cartasActuales.size();
        assert(cantidadEsperada == cartasCantidad);
    }

    @Test
    public void testLaRondaReconoceSiExisteManoJugable() {
        Tienda tienda = this.tiendaPrueba();
        Ronda ronda = new Ronda(1, 5, 10, 2000, tienda);
        ronda.iniciarRonda();
        List<Carta> cartas = new ArrayList<>();
        Carta carta1 = new Carta("10 de Corazones", "Corazones", "10", "Jota", 10);
        Carta carta2 = new Carta("9 de Corazones", "Corazones", "9", "10", 9);
        Carta carta3 = new Carta("8 de Corazones", "Corazones", "8", "9", 8);
        Carta carta4 = new Carta("7 de Corazones", "Corazones", "7", "8", 7);
        Carta carta5 = new Carta("6 de Corazones", "Corazones", "6", "7", 6);
        cartas.add(carta1);
        cartas.add(carta2);
        cartas.add(carta3);
        cartas.add(carta4);
        cartas.add(carta5);
        Mano manoEsperada = new EscaleraColor();
        Mano manoRecibida = ronda.existeMano(cartas);
        assert(manoEsperada.esMismaMano(manoRecibida.getNombre()));
    }

    @Test
    public void testUnaRondaTransfiereLosComodinesAOtraCorrectamente() {
        Tienda tienda = this.tiendaPrueba();
        Ronda ronda = new Ronda(1, 5, 10, 2000, tienda);
        List<Comodin> comodines = this.comodinesPrueba();
        ronda.cargarComodinesRonda(comodines);
        ronda.iniciarRonda();
        Ronda ronda2 = new Ronda(1, 5, 10, 2000, tienda);
        ronda.transferirComodines(ronda2);
        int cantidadEsperada = 3;
        int cantidadRecibida = ronda2.cantidadComodines();
        assert(cantidadEsperada == cantidadRecibida);
    }

    @Test
    public void testUnaRondaTransfiereLosTarotsAOtraCorrectamente() {
        Tienda tienda = this.tiendaPrueba();
        Ronda ronda = new Ronda(1, 5, 10, 2000, tienda);
        List<Tarot> tarots = this.tarotsPrueba();
        ronda.cargarTarotsRonda(tarots);
        ronda.iniciarRonda();
        Ronda ronda2 = new Ronda(1, 5, 10, 2000, tienda);
        ronda.transferirTarots(ronda2);
        int cantidadEsperada = 3;
        int cantidadRecibida = ronda2.cantidadTarots();
        assert(cantidadEsperada == cantidadRecibida);
    }
}

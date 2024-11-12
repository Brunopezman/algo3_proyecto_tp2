package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class CasosDeUsoTest {

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
        //DESCOMENTEN SI QUIEREN PROBAR EJEMPLO QUE FUNCIONA
        //Carta ejemplo = obtenido.get(0);
        //System.out.printf("Carta 0 => Palo: %s Valor: %s Puntaje: %d", ejemplo.getPalo(), ejemplo.getValor(), ejemplo.getPuntaje());
        //assert
        assertEquals(esperado, obtenido.size());
    }

    @Test
    public void testSePuedeJugarManoDeUnMazo() {
        //arrange
        Jugador jugador = new Jugador("Bruno");
        Mazo mazo = new Mazo();
        Turno turno = new Turno();
        //act
        List<Carta> cartas = jugador.recibirCartas(mazo);
        boolean respuesta = turno.existeManoJugable(cartas);
        //assert
        assert(respuesta);
    }

    @Test
    public void testJugarManoAplicaValorCorrespondiente() {

        Jugador jugador = new Jugador("Migliore");
        List<Carta> cartas = new ArrayList();
        Flush flush = new Flush();
        Carta carta1 = new Carta("2", "Picas");
        Carta carta2 = new Carta("3", "Picas");
        Carta carta3 = new Carta("4", "Picas");
        Carta carta4 = new Carta("5", "Picas");
        Carta carta5 = new Carta("6", "Picas");
        cartas.addAll(Arrays.asList(carta1, carta2, carta3, carta4, carta5));
        int esperado = 220;
        //act
        int obtenido = jugador.jugarMano(cartas, flush);
        //assert
        assertEquals(esperado, obtenido);
    }

    @Test
    public void testImportaOrdenDeCartas() {
        Jugador jugador1 = new Jugador("Migliore");
        Jugador jugador2 = new Jugador("Palermo");
        Comodin1 comodin1 = new Comodin1();
        Comodin2 comodin2 = new Comodin2();
        List<Carta> cartas = new ArrayList();
        Flush flush = new Flush();
        Carta carta1 = new Carta("2", "Picas");
        Carta carta2 = new Carta("3", "Picas");
        Carta carta3 = new Carta("4", "Picas");
        Carta carta4 = new Carta("5", "Picas");
        Carta carta5 = new Carta("6", "Picas");
        cartas.addAll(Arrays.asList(carta1, carta2, carta3, carta4, carta5));
        jugador1.agregarComodin(comodin1);
        jugador1.agregarComodin(comodin2);
        jugador2.agregarComodin(comodin2);
        jugador2.agregarComodin(comodin1);
        //act
        int resultado1 = jugador1.jugarMano(cartas, flush);
        int resultado2 = jugador2.jugarMano(cartas, flush);
        //assert
        assertNotEquals(resultado1, resultado2);
    }

    @Test
    public void modificarCartaConTarotCambiaPuntos() {
        Jugador jugador = new Jugador("Aleksandra");
        Tarot tarot = new Tarot(10);
        Mazo mazo = new Mazo();
        Carta carta = new Carta("2", "Picas");
        carta = tarot.modificarValorCarta(mazo, carta);
        assertEquals(carta.getPuntaje(), 10);
    }

    @Test
    public void modificarCartaConTarotCambiarMultiplicador() {
        Jugador jugador = new Jugador("Simon");
        Tarot tarot = new Tarot(6);
        Mano flush = new Flush();
        flush = tarot.modificarMultiplicador(flush);
        assertEquals(flush.getMultiplicador(), 6);
    }
}

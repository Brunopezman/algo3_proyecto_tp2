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
        int sumatoria = 0;
        for (Carta carta: cartas) {
            sumatoria += carta.getPuntaje();
        }
        //act
        int obtenido = jugador.jugarMano(sumatoria, flush);
        //assert
        assertEquals(esperado, obtenido);
    }

    @Test
    public void testImportaOrdenDeCartas() {
        Jugador jugador = new Jugador("Migliore");
        Comodin comodin = new Comodin(5);
        List<Carta> cartas = new ArrayList();
        Flush flush = new Flush();
        Carta carta1 = new Carta("2", "Picas");
        Carta carta2 = new Carta("3", "Picas");
        Carta carta3 = new Carta("4", "Picas");
        Carta carta4 = new Carta("5", "Picas");
        Carta carta5 = new Carta("6", "Picas");
        cartas.addAll(Arrays.asList(carta1, carta2, carta3, carta4, carta5));
        int sumatoria = 0;
        for (Carta carta: cartas) {
            sumatoria += carta.getPuntaje();
        }
        //act
        int resultado1 = jugador.jugarMano(sumatoria, flush);
        resultado1 = comodin.modificarValor(resultado1);
        sumatoria = comodin.modificarValor(sumatoria);
        int resultado2 = jugador.jugarMano(sumatoria, flush);
        // System.out.printf("Resultado1: %s Resultado2: %d", resultado1, resultado2);
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

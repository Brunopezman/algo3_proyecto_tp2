package edu.fiuba.algo3.modelo.juego;

import edu.fiuba.algo3.modelo.lector.LectorJson;
import org.junit.jupiter.api.Test;

public class JuegoTest {
    @Test
    public void testSeRepartenLasCartasCorrectamnteAlJugador(){
        Juego juego = Juego.getInstance();
        juego.inicializarJugador("IKER");
        juego.repartirCartasJugador(8);
        int cantidadEsperada = 8;
        int cantidadRecibidas = juego.jugadoresCartasActuales().size();
        assert(cantidadEsperada == cantidadRecibidas);
    }

    @Test
    public void testSeAvanzaDeTurnoCorrectamente(){
        Juego juego = Juego.updateInstance();
        juego.inicializarRonda();
        juego.avanzarTurno();
        juego.avanzarTurno();
        juego.avanzarTurno();
        int turnoEsperado = 3;
        int turnoActual = juego.turnoActual();
        assert(turnoEsperado == turnoActual);
    }

    @Test
    public void testNoSeAvanzaDeTurnoAlLlegarAlUltimo(){
        Juego juego = Juego.updateInstance();
        juego.inicializarRonda();
        juego.avanzarTurno();
        juego.avanzarTurno();
        juego.avanzarTurno();
        assert(!juego.avanzarTurno());
    }

    @Test
    public void testNoSeAvanzaDeTurnoSiSeAlcanzaElPuntajeDeLaRonda(){
        Juego juego = Juego.updateInstance();
        Ronda ronda = juego.getRondaActual();
        ronda.iniciarRonda().setPuntaje(3500);
        assert(!juego.avanzarTurno());
    }

    @Test
    public void testSeAvanzaDeRondaCorrectamenteAlAlcanzarElPuntajeNecesario() {
        Juego juego = Juego.updateInstance();

        Ronda ronda = juego.getRondaActual();
        ronda.iniciarRonda().setPuntaje(3500);
        assert(juego.avanzarRonda());
    }

    @Test
    public void testNoSeAvanzaDeRondaAlNoAlcanzarElPuntajeNecesario() {
        Juego juego = Juego.updateInstance();
        Ronda ronda = juego.getRondaActual();
        ronda.iniciarRonda().setPuntaje(2500);
        assert(!juego.avanzarRonda());
    }

    @Test
    public void testNoSeAvanzaDeRondaAlLlegarALaUltimaRonda() {
        Juego juego = Juego.updateInstance();
        Ronda ronda;
        int contador = 0;
        while(contador < juego.rondasTotales()) {
            ronda = juego.getRondaActual();
            ronda.iniciarRonda().setPuntaje(12000);
            juego.avanzarRonda();
            contador++;
        }
        assert(!juego.avanzarRonda());
    }

    @Test
    public void testAlGanarLaUltimaRondaSeGanaElJuego() {
        Juego juego = Juego.updateInstance();
        Ronda ronda;
        int contador = 0;
        while(contador < juego.rondasTotales()) {
            ronda = juego.getRondaActual();
            ronda.iniciarRonda().setPuntaje(12000);
            juego.avanzarRonda();
            contador++;
        }
        assert(juego.seGanoPartida());
    }

    @Test
    public void testAlPerderAlgunaRondaSePierdeElJuego() {
        Juego juego = Juego.updateInstance();
        Ronda ronda = juego.getRondaActual();
        ronda.iniciarRonda().setPuntaje(12000);
        juego.avanzarRonda();
        ronda = juego.getRondaActual();
        ronda.iniciarRonda().setPuntaje(12000);
        juego.avanzarRonda();
        ronda = juego.getRondaActual();
        ronda.iniciarRonda().setPuntaje(2000);
        juego.avanzarRonda();
        assert(!juego.seGanoPartida());
    }
}

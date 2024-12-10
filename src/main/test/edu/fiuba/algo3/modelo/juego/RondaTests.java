package edu.fiuba.algo3.modelo.juego;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RondaTests {
    /*
    @Test
    public void testSeCreaUnaRondaConLaCantidadDeTurnosCorrecta(){
        Jugador jugador = new Jugador("CHIPA GOMEZ");
        Ronda ronda = new Ronda(5,5,1000,jugador);
        ronda.iniciarRonda();
        int cantidadTurnos = ronda.cantidadTurnos();
        int turnosEsperados = 5;
        assertEquals(cantidadTurnos, turnosEsperados);
    }

    @Test
    public void testAlIniciarUnaRondaSeIniciaEnElPrimerTurno(){
        Jugador jugador = new Jugador("CAMPING");
        Ronda ronda = new Ronda(5,5,1000,jugador);
        ronda.iniciarRonda();
        int numeroTurno = ronda.turnoActual();
        int turnoEsperado = 1;
        assertEquals(numeroTurno, turnoEsperado);
    }

    @Test
    public void testSeAvanzaDeTurnoEnRonda(){
        Jugador jugador = new Jugador("PERRITO");
        Ronda ronda = new Ronda(5,5,1000,jugador);
        ronda.iniciarRonda();
        ronda.avanzarTurno();
        ronda.avanzarTurno();
        int numeroTurno = ronda.turnoActual();
        int turnoEsperado = 3;
        assertEquals(numeroTurno, turnoEsperado);
    }

    @Test
    public void testElSiguienteTurnoArrancaCon0Puntos(){
        Jugador jugador = new Jugador("REALI");
        Ronda ronda = new Ronda(5,5,1000,jugador);
        ronda.iniciarRonda();
        ronda.avanzarTurno();
        ronda.avanzarTurno();
        int puntosTurno = ronda.puntosTurnoActual();
        int puntajeEsperado = 0;
        assertEquals(puntajeEsperado, puntosTurno);
    }

    @Test
    public void testSeAgreganComodinesARonda(){
        Jugador jugador = new Jugador("ALTOSINMANOS");
        Ronda ronda = new Ronda(5,5,1000,jugador);
        EstrategiaComodin estrategia = new EstrategiaSumarPuntos();
        Comodin comodin1 = new ComodinDescarte(10,10,estrategia);
        Comodin comodin2 = new ComodinDescarte(10,10,estrategia);
        Comodin comodin3 = new ComodinDescarte(10,10,estrategia);
        ronda.agregarComodin(comodin1);
        ronda.agregarComodin(comodin2);
        ronda.agregarComodin(comodin3);
        int cantidadComodines = ronda.cantidadComodines();
        int cantidadEsperada = 3;
        assertEquals(cantidadComodines, cantidadEsperada);
    }

    @Test
    public void testAlAvanzarDeTurnoSeGuardaCorrectamente() {
        Jugador jugador = new Jugador("VOMBERGARD");
        Ronda ronda = new Ronda(5,5,1000,jugador);
        EstrategiaComodin estrategia = new EstrategiaSumarPuntos();
        ComodinDescarte comodin1 = new ComodinDescarte(10, 10, estrategia);
        Mano manoEspecifica = new Escalera();
        Mano mano = new Escalera();
        ComodinManoEspecifica comodin2 = new ComodinManoEspecifica(10, 10, estrategia, manoEspecifica);
        ComodinAleatorio comodin3 = new ComodinAleatorio(10, 10, estrategia, 1);
        ronda.agregarComodin(comodin1);
        ronda.agregarComodin(comodin2);
        ronda.agregarComodin(comodin3);
        Turno turno = ronda.iniciarRonda();
        mano.sumarPuntos(20);
        mano.sumarDescartes(1);
        turno.calcularJugada(mano);
        ronda.avanzarTurno();
        int puntajeEsperado = 320;
        int puntaje = ronda.getTurno(1).puntajeDelTurno();
        assertEquals(puntaje,puntajeEsperado);
    }

    @Test
    public void testSeCalculaPuntajeDeRonda() {
        Jugador jugador = new Jugador("TONGA");
        Ronda ronda = new Ronda(5,5,1000,jugador);
        EstrategiaComodin estrategia = new EstrategiaSumarPuntos();
        ComodinDescarte comodin1 = new ComodinDescarte(10, 10, estrategia);
        Mano manoEspecifica = new Escalera();
        ComodinManoEspecifica comodin2 = new ComodinManoEspecifica(10, 10, estrategia, manoEspecifica);
        ComodinAleatorio comodin3 = new ComodinAleatorio(10, 10, estrategia, 1);
        ronda.agregarComodin(comodin1);
        ronda.agregarComodin(comodin2);
        ronda.agregarComodin(comodin3);
        Turno turno = ronda.iniciarRonda();
        Mano mano;
        int contador = 1;
        while (contador < ronda.cantidadDeTurnos()+1) { //itere los 5 turnos
            mano = new Escalera();
            mano.sumarPuntos(20);
            mano.sumarDescartes(1);
            turno.calcularJugada(mano);
            if(contador < ronda.cantidadTurnos()) { //solo avance hasta el 5 turno (avanza internamente sino)
                turno = ronda.avanzarTurno();
            }
            contador++;
        }
        int puntosRondaFinal = ronda.calcularPuntajeRonda();
        int puntosEsperados = 1600;
        assertEquals(puntosRondaFinal, puntosEsperados);
    }

    @Test
    public void testNoSePuedeAvanzarMasDe5TurnosPorRonda() {
        Jugador jugador = new Jugador("RUSSO");
        Ronda ronda = new Ronda(5,5,1000,jugador);
        ronda.iniciarRonda();
        while (ronda.turnoActual() < ronda.cantidadDeTurnos()) {
            ronda.avanzarTurno();
        }
        assertThrows(NoHayMasTurnosException.class, () ->
        {ronda.avanzarTurno();});
    }

    @Test
    public void testSeSuperaPuntajeDeRonda() {
        Jugador jugador = new Jugador("TONGA");
        Ronda ronda = new Ronda(5,5,1000,jugador);
        EstrategiaComodin estrategia = new EstrategiaSumarPuntos();
        ComodinDescarte comodin1 = new ComodinDescarte(10, 10, estrategia);
        Mano manoEspecifica = new Escalera();
        ComodinManoEspecifica comodin2 = new ComodinManoEspecifica(10, 10, estrategia, manoEspecifica);
        ComodinAleatorio comodin3 = new ComodinAleatorio(10, 10, estrategia, 1);
        ronda.agregarComodin(comodin1);
        ronda.agregarComodin(comodin2);
        ronda.agregarComodin(comodin3);
        Turno turno = ronda.iniciarRonda();
        Mano mano;
        int contador = 1;
        while (contador < ronda.cantidadDeTurnos()+1) { //itere los 5 turnos
            mano = new Escalera();
            mano.sumarPuntos(20);
            mano.sumarDescartes(1);
            turno.calcularJugada(mano);
            if(contador < ronda.cantidadTurnos()) { //solo avance hasta el 5 turno (avanza internamente sino)
                turno = ronda.avanzarTurno();
            }
            contador++;
        }
        ronda.calcularPuntajeRonda();
        assert(ronda.seAlcanzoElPuntajeDeRonda());
    }

    @Test
    public void testNoSeSuperaPuntajeDeRonda() {
        Jugador jugador = new Jugador("TONGA");
        Ronda ronda = new Ronda(5, 5, 2000, jugador);
        EstrategiaComodin estrategia = new EstrategiaSumarPuntos();
        ComodinDescarte comodin1 = new ComodinDescarte(10, 10, estrategia);
        Mano manoEspecifica = new Escalera();
        ComodinManoEspecifica comodin2 = new ComodinManoEspecifica(10, 10, estrategia, manoEspecifica);
        ComodinAleatorio comodin3 = new ComodinAleatorio(10, 10, estrategia, 1);
        ronda.agregarComodin(comodin1);
        ronda.agregarComodin(comodin2);
        ronda.agregarComodin(comodin3);
        Turno turno = ronda.iniciarRonda();
        Mano mano;
        int contador = 1;
        while (contador < ronda.cantidadDeTurnos() + 1) { //itere los 5 turnos
            mano = new Escalera();
            mano.sumarPuntos(20);
            mano.sumarDescartes(1);
            turno.calcularJugada(mano);
            if (contador < ronda.cantidadTurnos()) { //solo avance hasta el 5 turno (avanza internamente sino)
                turno = ronda.avanzarTurno();
            }
            contador++;
        }
        ronda.calcularPuntajeRonda();
        assert (!ronda.seAlcanzoElPuntajeDeRonda());
    }

     */
}

package edu.fiuba.algo3.modelo.juego;

import edu.fiuba.algo3.modelo.NoHayMasTurnosException;
import edu.fiuba.algo3.modelo.carta.Carta;
import edu.fiuba.algo3.modelo.comodin.Comodin;
import edu.fiuba.algo3.modelo.mano.Mano;
import edu.fiuba.algo3.modelo.tarot.Tarot;

import java.util.ArrayList;
import java.util.List;

public class Ronda {
    private static final int INICIO = 0;

    private int nroRonda;
    private List<Turno> turnos;
    private List <Comodin> comodines;
    private List <Tarot> tarots;
    private int turnoActual;
    private int cantidadTurnos;
    private int puntajeAlcanzado;
    private int puntajeASuperar;
    private int descartesRestantes;
    private Tienda tienda;

    /*
    public Ronda(int cantTurnos, int cantDescartes, int puntASuperar, Jugador jugadorActual) {
        this.turnos = new ArrayList<Turno>();
        this.turnoActual = INICIO;
        this.comodines = new ArrayList <Comodin>();
        this.cantidadTurnos = cantTurnos;
        this.puntajeASuperar = puntASuperar;
        jugadorActual.setDescartesMaximos(cantDescartes);
    }
    */

    public Ronda(int nro,int manos,int descartes, int puntajeAObtener, Tienda tienda){
        this.nroRonda = nro;
        this.turnos = new ArrayList<Turno>();
        this.descartesRestantes = descartes;
        this.puntajeASuperar = puntajeAObtener;
        this.tienda = tienda;
        this.comodines = new ArrayList <Comodin>();
        this.tarots = new ArrayList<Tarot>();
    }

    public void cargarComodinesRonda(List<Comodin> comodinesElegidos){
        comodines.addAll(comodinesElegidos);
    }

    public void cargarTarotsRonda(ArrayList<Tarot> tarotsElegidos) {
        tarots.addAll(tarotsElegidos);
    }

    public Turno iniciarRonda(){
        for(int i = INICIO; i<cantidadTurnos; i++){
            turnos.add(new Turno(comodines));
        }
        turnoActual++;
        return turnos.get(INICIO);
    }

    public void agregarComodin(Comodin comodin) {
        comodines.add(comodin);
    }

    public boolean avanzarTurno(){
        if (turnoActual >= 5){ //esto debería controlarse desde la entidad que contiene las rondas
            throw new NoHayMasTurnosException();
        }
        turnoActual++;
        return true;
    }

    public int cantidadTurnos(){ return turnos.size(); }

    public int turnoActual(){ return turnoActual; }

    public int puntosTurnoActual(){ return turnos.get(turnoActual-1).puntajeDelTurno(); }

    public int cantidadComodines(){ return comodines.size(); }

    public Turno getTurno(int numeroTurno){ return turnos.get(numeroTurno-1); }

    public int calcularPuntajeRonda() {
        for(Turno turno : turnos){
            puntajeAlcanzado += turno.puntajeDelTurno();
        }
        return puntajeAlcanzado;
    }

    public boolean seAlcanzoElPuntajeDeRonda() { return (puntajeAlcanzado >= puntajeASuperar); }

    public int cantidadDeTurnos(){ return cantidadTurnos; }

    public Tienda getTienda(){ return tienda; }

    public void transferirComodines(Ronda ronda) {
        ronda.cargarComodinesRonda(comodines);
    }

    public int jugarTurno(List<Carta> posibleMano, Jugador jugador) {
        Turno turno = this.getTurno(turnoActual);
        Mano mano = turno.existeManoJugable(posibleMano);

        if(mano != null){
            jugador.jugarMano(posibleMano,mano);
            turno.calcularJugada(mano); //carga puntaje final en turno;
        }

        return turno.puntajeDelTurno();

    }
}

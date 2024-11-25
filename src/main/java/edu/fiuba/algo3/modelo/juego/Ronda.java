package edu.fiuba.algo3.modelo.juego;

import edu.fiuba.algo3.modelo.NoHayMasTurnosException;
import edu.fiuba.algo3.modelo.comodin.Comodin;

import java.util.ArrayList;
import java.util.List;

public class Ronda {
    private static final int INICIO = 0;

    private List<Turno> turnos;
    private List <Comodin> comodines;
    private int turnoActual;
    private int cantidadTurnos;
    private int puntajeAlcanzado;
    private int puntajeASuperar;


    public Ronda(int cantTurnos, int cantDescartes, int puntASuperar, Jugador jugadorActual) {
        this.turnos = new ArrayList<Turno>();
        this.turnoActual = INICIO;
        this.comodines = new ArrayList <Comodin>();
        this.cantidadTurnos = cantTurnos;
        this.puntajeASuperar = puntASuperar;
        jugadorActual.setDescartesMaximos(cantDescartes);
    }

    public Turno iniciarRonda(){
        /*
        ACA SE HARIA LA ELECCION DE LA TIENDA
        */
        for(int i = INICIO; i<cantidadTurnos; i++){
            turnos.add(new Turno(comodines));
        }
        turnoActual++;
        return turnos.get(INICIO);
    }

    public void agregarComodin(Comodin comodin) {
        comodines.add(comodin);
    }

    public Turno avanzarTurno(){
        if (turnoActual >= 5){ //esto debería controlarse desde la entidad que contiene las rondas
            throw new NoHayMasTurnosException();
        }
        turnoActual++;
        return turnos.get(turnoActual-1);
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
}

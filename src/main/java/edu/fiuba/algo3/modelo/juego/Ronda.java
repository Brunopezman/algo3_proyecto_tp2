package edu.fiuba.algo3.modelo.juego;

import edu.fiuba.algo3.modelo.comodin.Comodin;

import java.util.ArrayList;
import java.util.List;

public class Ronda {
    private static final int CANTRONDAS = 5;
    private static final int INICIO = 0;


    List<Turno> turnos;
    private int turnoActual;
    private List <Comodin> comodines;

    public Ronda(){
        turnos = new ArrayList<Turno>();
        turnoActual = INICIO;
        comodines = new ArrayList <Comodin>();
    }

    public Turno iniciarRonda(){
        for(int i = INICIO; i<CANTRONDAS; i++){
            turnos.add(new Turno(comodines));
        }
        return turnos.get(INICIO);
    }

    public void agregarComodin(Comodin comodin) {
        comodines.add(comodin);
    }

    public Turno avanzarTurno(Turno turnoTerminado){
        turnos.add(this.turnoActual,turnoTerminado);
        turnoActual++;
        return turnos.get(turnoActual);
    }
}

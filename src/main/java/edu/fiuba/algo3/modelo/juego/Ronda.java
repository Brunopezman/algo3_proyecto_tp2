package edu.fiuba.algo3.modelo.juego;

import edu.fiuba.algo3.modelo.comodin.Comodin;
import edu.fiuba.algo3.modelo.tarot.Tarot;

import java.util.ArrayList;
import java.util.List;

public class Ronda {
    List<Turno> turnos;
    private int turnoActual;
    private List <Comodin> comodines;

    public Ronda(){
        turnos = new ArrayList<Turno>();
        turnoActual = 0;
        comodines = new ArrayList <Comodin>();
    }

    public Turno iniciarRonda(){
        for(int i = 0; i<5; i++){
            turnos.add(new Turno(comodines));
        }
        return turnos.get(0);
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

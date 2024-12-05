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

    private int descartesActuales;
    private int nroRonda;
    private List<Turno> turnos;
    private List <Comodin> comodines;
    private List <Tarot> tarots;
    private int turnoActual;
    private int cantidadTurnos;
    private int puntajeAlcanzado;
    private int puntajeASuperar;
    private int descartesMaximos;
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

    public Ronda(int nro,int manos,int descartesMaximos, int puntajeAObtener, Tienda tienda){
        this.nroRonda = nro;
        this.turnos = new ArrayList<Turno>();
        this.turnoActual = INICIO;
        this.descartesMaximos = descartesMaximos;
        this.descartesActuales = 0;
        this.puntajeASuperar = puntajeAObtener;
        this.tienda = tienda;
        this.comodines = new ArrayList <Comodin>();
        this.tarots = new ArrayList<Tarot>();
        this.cantidadTurnos = manos;
    }

    public int getDescartesDisponibles(){
        return descartesMaximos;
    }

    public int getDescartesActuales(){
        return descartesActuales;
    }

    public void cargarComodinesRonda(List<Comodin> comodinesElegidos){
        comodines.addAll(comodinesElegidos);
    }

    public void cargarTarotsRonda(List<Tarot> tarotsElegidos) {
        tarots.addAll(tarotsElegidos);
    }

    public Turno iniciarRonda(){
        for(int i = INICIO; i<cantidadTurnos; i++){
            turnos.add(new Turno(comodines));
        }
        turnoActual++;
        return turnos.get(INICIO);
    }

    public boolean avanzarTurno(){
        if (turnoActual >= 5){ //esto debería controlarse desde la entidad que contiene las rondas
            return false;
        }
        turnoActual++;
        return true;
    }

    public int cantidadTurnos(){ return turnos.size(); }

    public int turnoActual(){ return turnoActual; }

    public int puntosTurnoActual(){ return this.getTurno(turnoActual).puntajeDelTurno(); }

    public int cantidadComodines(){ return comodines.size(); }

    public Turno getTurno(int numeroTurno){ return turnos.get(numeroTurno-1); }

    public int getPuntajeNecesario(){
        return puntajeASuperar;
    }

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

    public Mano existeMano(List<Carta> posibleMano){
        Turno turno = this.getTurno(turnoActual);
        return turno.existeManoJugable(posibleMano);
    }

    public int jugarTurno(List<Carta> cartas, Mano mano) {
        /*
        int puntaje = 0;
        for (Carta carta : posibleMano) {;
            puntaje += carta.puntaje();
        }
        mano.sumarPuntos(puntaje);
        mano.sumarDescartes(descartesActuales);
        */
        mano.sumarDescartes(descartesActuales);
        Turno turno = this.getTurno(turnoActual);

        return turno.calcularJugada(cartas,mano); //carga puntaje final en turno y devolvemos valor;
    }

    public List<Carta> descartar(Mazo mazo, List<Carta> cartasActuales, List<Carta> cartasADescartar){
        if (this.descartesActuales >= descartesMaximos ) {
            throw new IllegalArgumentException("No puede realizar más descartes en este turno.");
        }

        this.descartesActuales++;

        // Descartar cada carta
        for (Carta carta : cartasADescartar) {
            cartasActuales.remove(carta);
        }

        //dar nuevamente la cantidad de cartas que descartó
        int cantidadARecibir = cartasADescartar.size();
        List<Carta> nuevasCartas= mazo.darCartas(cantidadARecibir);
        for (int i = 0; i < cantidadARecibir; i++) {
            cartasActuales.add(nuevasCartas.get(i));
        }

        return cartasActuales;
    }

    private void eliminarTarotPorUso(Tarot tarotUsado){
        for (Tarot tarotActual : tarots){
            if(tarotActual.esElegido(tarotUsado)){
                tarots.remove(tarotActual);
                break;
            }
        }
    }

    public void agregarTarotEsteTurno(Tarot tarotElegido){
        this.eliminarTarotPorUso(tarotElegido);
        Turno turno = this.getTurno(turnoActual);
        turno.agregarTarot(tarotElegido);
    }

    public void seleccionarTarotEsteTurno(Tarot tarotElegido, Carta carta){
        this.eliminarTarotPorUso(tarotElegido);
        tarotElegido.modificarAQueAplica(carta.getNombre());
    }


}

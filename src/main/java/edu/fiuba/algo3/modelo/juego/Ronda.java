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

    //Getters y Setters

    public int getDescartesDisponibles(){
        return descartesMaximos;
    }

    public int getDescartesActuales(){
        return descartesActuales;
    }

    public int cantidadTurnos(){ return turnos.size(); }

    public int turnoActual(){ return turnoActual; }

    public int puntosTurnoActual(){ return this.getTurnoActual().puntajeDelTurno(); }

    public int cantidadComodines(){ return comodines.size(); }

    public int cantidadTarots(){ return tarots.size(); }

    public Turno getTurnoActual(){ return turnos.get(turnoActual-1); }

    public int getPuntajeNecesario(){
        return puntajeASuperar;
    }

    public Tienda getTienda(){ return tienda; }

    public int getNro() { return nroRonda; }

    public int getTurnos() { return this.cantidadTurnos; }

    public int getDescartes() { return this.getDescartesDisponibles();}

    public int getPuntajeASuperar() { return puntajeASuperar; }

    public List<Comodin> getComodines() {return comodines; }

    public List<Tarot> getTarots() {return tarots; }

    ////////////////////////////////////

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
        if (this.hayMasTurnos()){ //esto debería controlarse desde la entidad que contiene las rondas
            turnoActual++;
            return true;
        }
        return false;
    }

    private boolean hayMasTurnos(){ return cantidadTurnos > turnoActual; }

    public int calcularPuntajeRonda() {
        for(Turno turno : turnos){
            puntajeAlcanzado += turno.puntajeDelTurno();
        }
        return puntajeAlcanzado;
    }

    public boolean seAlcanzoElPuntajeDeRonda() { return (puntajeAlcanzado >= puntajeASuperar); }

    public void transferirComodines(Ronda ronda) {
        ronda.cargarComodinesRonda(comodines);
    }

    public void transferirTarots(Ronda ronda) {
        ronda.cargarTarotsRonda(tarots);
    }

    public Mano existeMano(List<Carta> posibleMano){
        Turno turno = this.getTurnoActual();
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
        Turno turno = this.getTurnoActual();
        int puntaje = turno.calcularJugada(cartas,mano);
        sumarPuntos(puntaje);
        return puntaje; //carga puntaje final en turno y devolvemos valor;
    }

    public List<Carta> descartar(Mazo mazo, List<Carta> cartasActuales, List<Carta> cartasADescartar){
        if (this.descartesActuales >= descartesMaximos || cartasADescartar.size() > 3) {
            return new ArrayList<>();
        }

        this.descartesActuales++;

        // Descartar cada carta
        for (Carta carta : cartasADescartar) {
            this.quitarCarta(cartasActuales, carta);
        }

        //dar nuevamente la cantidad de cartas que descartó
        int cantidadARecibir = cartasADescartar.size();
        List<Carta> nuevasCartas= mazo.darCartas(cantidadARecibir);
        /*
        for (int i = 0; i < cantidadARecibir; i++) {
            this.agregarCarta(cartasActuales, nuevasCartas.get(i));
        }
        */
        for (Carta carta : nuevasCartas) {
            this.agregarCarta(cartasActuales, carta);
        }

        return cartasActuales;
    }

    private void agregarCarta(List<Carta> cartasActuales, Carta carta){
        cartasActuales.add(carta);
    }

    private void quitarCarta(List<Carta> cartasActuales, Carta carta){
        cartasActuales.remove(carta);
    }

    private void consumirTarot(Tarot tarotUsado){
        for (Tarot tarotActual : tarots){
            if(tarotActual.esElegido(tarotUsado)){
                tarots.remove(tarotActual);
                break;
            }
        }
    }


    public void usarTarotEnEsteTurno(Tarot tarotElegido){
        this.consumirTarot(tarotElegido);
        Turno turno = this.getTurnoActual();
        turno.agregarTarot(tarotElegido);
    }

//    public void usarTarotEnCarta(Tarot tarotElegido, Carta carta){
//        this.consumirTarot(tarotElegido);
//        tarotElegido.modificarAQueAplica(carta.getNombre());
//    }

    private void sumarPuntos(int puntos){ puntajeAlcanzado += puntos;}

    public boolean sePuedeAvanzar() {
        return this.seAlcanzoElPuntajeDeRonda();
    }
}

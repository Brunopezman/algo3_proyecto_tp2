package edu.fiuba.algo3.modelo.juego;

import edu.fiuba.algo3.modelo.ManoInvalidaException;
import edu.fiuba.algo3.modelo.carta.Carta;
import edu.fiuba.algo3.modelo.comodin.Comodin;
import edu.fiuba.algo3.modelo.fabrica.JuegoFabrica;
import edu.fiuba.algo3.modelo.mano.Mano;
import edu.fiuba.algo3.modelo.tarot.Tarot;

import java.util.ArrayList;
import java.util.List;

public class Juego {

    private static final int PRIMERARONDA = 1;

    private List<Ronda> rondas;
    private Mazo mazo;
    private final JuegoFabrica fabrica;
    private int numeroRondaActual;
    private Jugador jugador;

    public Juego(String rutaDeJson) {
        this.fabrica = new JuegoFabrica(rutaDeJson);
        this.rondas = fabrica.inicializarRondas();
        this.mazo = fabrica.inicializarMazo();
        this.numeroRondaActual = PRIMERARONDA;
    }

    // Getters y setters
    public Ronda getRondaActual() {
        return rondas.get((numeroRondaActual - 1));
    }

    public List<Ronda> getRondas() {
        return rondas;
    }

    public void setRondas(List<Ronda> rondas) {
        this.rondas = rondas;
    }

    public Mazo getMazo() {
        return mazo;
    }

    public void setMazo(Mazo mazo) {
        this.mazo = mazo;
    }

    public Ronda siguienteRonda() {
        return rondas.get(numeroRondaActual);
    }

    //JUGADOR

    public void inicializarJugador(String nombreJugador) {
        this.jugador = new Jugador(nombreJugador);
    }

    public List<Carta> repartirCartasJugador() {
        return jugador.recibirCartas(mazo);
    }

    //TIENDA
    public Tienda getTiendaRonda() {
        return this.getRondaActual().getTienda();
    }

    public void cargarElecciones(ArrayList<Comodin> comodinesElegidos, ArrayList<Tarot> tarotsElegidos, ArrayList<Carta> cartasElegidas) {
        jugador.agregarCartas(cartasElegidas);
        getRondaActual().cargarTarotsRonda(tarotsElegidos);
        getRondaActual().cargarComodinesRonda(comodinesElegidos);
    }


    //RONDA
    public Ronda inicializarRonda() {
        return getRondaActual();
    }

    public void cargarComodinesActuales() {
        this.getRondaActual().transferirComodines(this.siguienteRonda());
    }

    public boolean avanzarRonda() {
        if(this.getRondaActual().seAlcanzoElPuntajeDeRonda()) {
            this.cargarComodinesActuales();
            numeroRondaActual++;
            this.resetMazo();
            return true;
        }
        return false;
    }

    private void resetMazo() {
        mazo = fabrica.inicializarMazo();
    }

    public int comodinesRonda() {
        return getRondaActual().cantidadComodines();
    }

    public int puntajeRonda(){
        return this.getRondaActual().calcularPuntajeRonda();
    }

    public int puntajeNecesarioRonda(){
        return this.getRondaActual().getPuntajeNecesario();
    }

    public int descartesDisponibles(){
        return this.getRondaActual().getDescartesDisponibles();
    }

    public int descartesActuales(){
        return this.getRondaActual().getDescartesActuales();
    }

    public int turnosTotales(){
        return this.getRondaActual().cantidadTurnos();
    }

    public int turnoActual(){
        return this.getRondaActual().turnoActual();
    }


    //TURNO
    public boolean avanzarTurno() {
        if(this.getRondaActual().seAlcanzoElPuntajeDeRonda()){
            return false; //se termina la ronda (se gano)
        }
        this.getRondaActual().avanzarTurno();
        return true;
    }

    public int jugarMano(List<Carta> posibleMano, Mano manoJugada) {
        return this.getRondaActual().jugarTurno(posibleMano, manoJugada);
    }

    public Mano queManoEs(List<Carta> cartas) {
        return this.getRondaActual().existeMano(cartas);
    }

    //JUEGO
    public int rondaActual(){
        return this.numeroRondaActual;
    }

    public int rondasTotales(){
        return rondas.size();
    }

    public List<Carta> descartarCartas(List<Carta> cartasActuales, List<Carta> cartasADescartar){
        return this.getRondaActual().descartar(mazo,cartasActuales,cartasADescartar);
    }

    /*

ORDEN:

1- iniciarJugador( nombreJugador) --> UNICA VEZ AL INICIO

CICLO POR CADA RONDA:
2- repartirCartas()
3- getTiendaRonda() --> Mostrar para elegir, acá pueden usar el comodinesRonda(), para saber cuántas dejarle elegir
4- cargarElecciones(...) --> Guardamos elecciones para Ronda
5- iniciarRonda() --> Arranca la primera Ronda, primer Turno

CICLO POR TURNO:
6- jugarMano(List<Carta> posibleMano) --> mandan las cartas seleccionadas y se analiza la mano. Devuelvo el puntaje
por si quieren mostrar que puntaje logró en esa jugada.
7- avanzarTurno --> si devuelve true: avanzó , si devuelve false: se ganó la ronda (se alcanzó puntaje) o no hay más turnos
en la Ronda actual, entonces se debe probar avanzarRonda(), ya que si esta devuelve true significa se supero la ronda o false
en caso que no.

8- en caso de avanzar de ronda, repite CICLO RONDA

9- en caso de iterar todas las rondas del juego (se paso todas) --> Tiran algo por pantalla que se ganó el JUEGO :)

     */
}
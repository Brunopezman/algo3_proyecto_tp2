package edu.fiuba.algo3.modelo.juego;

import edu.fiuba.algo3.modelo.carta.Carta;
import edu.fiuba.algo3.modelo.comodin.Comodin;
import edu.fiuba.algo3.modelo.fabrica.JuegoFabrica;
import edu.fiuba.algo3.modelo.mano.Mano;
import edu.fiuba.algo3.modelo.tarot.Tarot;

import java.util.List;

public class Juego {

    private static final int PRIMERARONDA = 1;

    private static Juego juego;

    private List<Ronda> rondas;
    private Mazo mazo;
    private final JuegoFabrica fabrica;
    private int numeroRondaActual;
    private Jugador jugador;
    private boolean ganado;

    private Juego() {
        this.fabrica = new JuegoFabrica("src/main/java/edu/fiuba/algo3/resources/archivosJson/balatro.json");
        this.rondas = fabrica.inicializarRondas();
        this.mazo = fabrica.inicializarMazo();
        this.numeroRondaActual = PRIMERARONDA;
        this.ganado = false;
    }

    public static Juego getInstance(){
        if (juego == null){
            juego = new Juego();
        }
        return juego;
    }

    public static Juego updateInstance() {
        juego = new Juego();
        return juego;
    }

    // Getters y setters

    public Ronda getRondaActual() {
        return rondas.get((numeroRondaActual - 1));
    }

    public List<Ronda> getRondas() {
        return rondas;
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

    public int getCartasTotalesMazo() {return mazo.cantidadCartasTotales();}

    //JUGADOR

    public void inicializarJugador(String nombreJugador) {
        this.jugador = new Jugador(nombreJugador);
    }

    public List<Carta> repartirCartasJugador(int cantidad) {
        return jugador.recibirCartas(mazo, cantidad);
    }

    public List<Carta> repartirCartasParaIniciar(){
        return jugador.recibirCartas(mazo, 8);
    }

    public void quitarCartasUsadas (List<Carta> cartas) {
        jugador.eliminarCartasUsadas(cartas);
    }

    public void eliminarTodasLasCartas() {
        jugador.getCartasActuales().clear();
    }

    public String getNombreJugador() { return jugador.getNombre();}

    public List<Carta> jugadoresCartasActuales() {return jugador.getCartasActuales(); }


    //TIENDA
    public Tienda getTiendaRonda() {
        return this.getRondaActual().getTienda();
    }

    public void cargarElecciones(List<Comodin> comodinesElegidos, List<Tarot> tarotsElegidos, List<Carta> cartasElegidas) {
        mazo.agregarCartasCompradas(cartasElegidas);
        getRondaActual().cargarTarotsRonda(tarotsElegidos);
        getRondaActual().cargarComodinesRonda(comodinesElegidos);
    }


    //RONDA
    public Ronda inicializarRonda() {
        return getRondaActual();
    }

    public void cargarComodinesTarotsActuales(Ronda rondaActual) {
        Ronda rondaSiguiente = this.siguienteRonda();
        rondaActual.transferirComodines(rondaSiguiente);
        rondaActual.transferirTarots(rondaSiguiente);
    }

    public boolean avanzarRonda() {
        Ronda rondaActual = this.getRondaActual();
        if(rondaActual.seAlcanzoElPuntajeDeRonda()) {
            if(esUltimaRonda()){
                juego.ganado = true;
                return false;
            }
            this.cargarComodinesTarotsActuales(rondaActual);
            numeroRondaActual++;
            this.getRondaActual().iniciarRonda();
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

    public boolean esUltimaRonda(){
        return this.numeroRondaActual >= this.rondasTotales();
    }


    //TURNO
    public boolean avanzarTurno() {
        Ronda rondaActual = this.getRondaActual();
        if(rondaActual.seAlcanzoElPuntajeDeRonda()){
            return false; //se termina la ronda (se gano)
        }
        return rondaActual.avanzarTurno();
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

    public List<Carta> descartarCartas(List<Carta> cartasADescartar){
        List<Carta> cartasActuales = jugador.getCartasActuales();
        List<Carta> nuevasCartas = this.getRondaActual().descartar(mazo,cartasActuales,cartasADescartar);
        if(nuevasCartas.isEmpty()){
            return nuevasCartas;
        }
        return jugador.setCartas(nuevasCartas);
    }

    public boolean seGanoPartida(){
        return juego.ganado;
    }
}
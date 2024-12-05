package edu.fiuba.algo3.modelo.juego;

import edu.fiuba.algo3.modelo.carta.Carta;
import edu.fiuba.algo3.modelo.comodin.Comodin;
import edu.fiuba.algo3.modelo.mano.Mano;
import edu.fiuba.algo3.modelo.tarot.Tarot;

import java.util.ArrayList;
import java.util.List;

public class Jugador {

    private String nombre;
    private List<Carta> cartasActuales;

    public Jugador(String nombre) {
        this.nombre = nombre;
        this.cartasActuales = new ArrayList<>();
    }

    public List<Carta> recibirCartas(Mazo mazo, int cantidad) {
        List<Carta> cartasRecibidas = mazo.darCartas(cantidad);
        //this.setCartasActuales(cartasRecibidas);
        cartasActuales.addAll(cartasRecibidas);
        return cartasRecibidas;
    }

    /*private boolean verificarExistenciaDeCartas(List<Carta> cartas){
        boolean encontrado = false;
        for(Carta carta : cartas){
            for(Carta cartaActual : cartasActuales){
                if(carta.esIgual(cartaActual)){
                    encontrado = true;
                    break;
                }
            }
            if(!encontrado){
                break;
            }
        }
        return encontrado;
    }*/

    private void setCartasActuales(List<Carta> cartas) {
        this.cartasActuales = cartas;
    }

    public boolean pudeJugarAlgunaMano(){
        return this.cartasActuales.size() >= 5;
    }

    public void agregarCartas(ArrayList<Carta> cartasElegidas){ cartasActuales.addAll(cartasElegidas); }

    public String getNombre() { return nombre; }

    public int cantidadCartasActuales(){ return cartasActuales.size(); }

    public List<Carta> setCartas(List<Carta> nuevasCartas) {
        this.cartasActuales = nuevasCartas;
        return this.cartasActuales;
    }

    public void eliminarCartasUsadas(List<Carta> cartas) {
        for (Carta cartaEliminar : cartas) {
            for (Carta cartaPropia : cartasActuales) {
                if (cartaPropia.esIgual(cartaEliminar.getNombre())){
                    cartasActuales.remove(cartaPropia);
                    break;
                }
            }
        }
    }

    public List<Carta> getCartasActuales() {return cartasActuales;}
}

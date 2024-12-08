package edu.fiuba.algo3.controllers;

import edu.fiuba.algo3.modelo.carta.Carta;
import edu.fiuba.algo3.modelo.comodin.Comodin;
import edu.fiuba.algo3.modelo.juego.Juego;
import edu.fiuba.algo3.modelo.tarot.Tarot;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import java.util.List;

public class BotonComprarHandler implements EventHandler<ActionEvent> {
    private List<Carta> cartasEspecificas;
    private List<Tarot> tarotsSeleccionados;
    private List<Comodin> comodinesSeleccionados;

    public BotonComprarHandler(List<Comodin> comodinesSeleccionados, List<Tarot> tarotsSeleccionados, List<Carta> cartasEspecificas) {
        this.comodinesSeleccionados = comodinesSeleccionados;
        this.tarotsSeleccionados = tarotsSeleccionados;
        this.cartasEspecificas = cartasEspecificas;

    }

    @Override
    public void handle(ActionEvent actionEvent) {
        Juego juego = Juego.getInstance();
        juego.cargarElecciones(comodinesSeleccionados, tarotsSeleccionados,cartasEspecificas);
        System.out.println(comodinesSeleccionados.size());
        System.out.println(tarotsSeleccionados.size());
        System.out.println(cartasEspecificas.size());
    }
}

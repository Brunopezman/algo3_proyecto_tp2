package edu.fiuba.algo3.controllers;

import edu.fiuba.algo3.modelo.carta.Carta;
import edu.fiuba.algo3.modelo.comodin.Comodin;
import edu.fiuba.algo3.modelo.juego.Juego;
import edu.fiuba.algo3.modelo.tarot.Tarot;
import edu.fiuba.algo3.vistas.pantalla.PantallaTienda;
import edu.fiuba.algo3.vistas.pantalla.ParteDerecha;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class BotonComprarHandler implements EventHandler<ActionEvent> {
    private Stage tiendaStage;
    private List<Carta> cartasEspecificas;
    private List<Tarot> tarotsSeleccionados;
    private List<Comodin> comodinesSeleccionados;

    public BotonComprarHandler(Stage tiendaStage, List<Comodin> comodinesSeleccionados, List<Tarot> tarotsSeleccionados, List<Carta> cartasEspecificas) {
        this.tiendaStage = tiendaStage;
        this.comodinesSeleccionados = comodinesSeleccionados;
        this.tarotsSeleccionados = tarotsSeleccionados;
        this.cartasEspecificas = cartasEspecificas;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        Juego juego = Juego.getInstance();
        juego.cargarElecciones(comodinesSeleccionados, tarotsSeleccionados,cartasEspecificas);
        ParteDerecha.actualizarVisualMazo();
        ParteDerecha.actualizarVisualComodines();
        ParteDerecha.actualizarVisualTarot();
        tiendaStage.close();
        comodinesSeleccionados.clear();
        tarotsSeleccionados.clear();
        cartasEspecificas.clear();
        PantallaTienda.reiniciarContador();
    }
}

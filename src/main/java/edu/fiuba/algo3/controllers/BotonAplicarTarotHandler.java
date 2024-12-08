package edu.fiuba.algo3.controllers;

import edu.fiuba.algo3.modelo.juego.Juego;
import edu.fiuba.algo3.modelo.juego.Ronda;
import edu.fiuba.algo3.modelo.tarot.Tarot;
import edu.fiuba.algo3.vistas.pantalla.ParteDerecha;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import java.util.ArrayList;
import java.util.List;

public class BotonAplicarTarotHandler implements EventHandler<ActionEvent> {

    private final List<Tarot> tarots;

    public BotonAplicarTarotHandler(List<Tarot> tarots){
        this.tarots = tarots;
    }

    @Override
    public void handle(ActionEvent actionEvent) {

        if (tarots.size() == 1){
            Tarot tarot = tarots.get(0);
            Juego juego = Juego.getInstance();
            Ronda rondaActual = juego.getRondaActual();
            rondaActual.usarTarotEnEsteTurno(tarot);
            System.out.println("Use un tarot");
            ParteDerecha.actualizarVisualTarot();
        }
    }
}

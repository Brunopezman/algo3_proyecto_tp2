package edu.fiuba.algo3.modelo.interfaz;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class BotonHandler implements EventHandler<ActionEvent> {
    private AccionBoton accionBoton;

    public BotonHandler(AccionBoton accionBoton) {
        this.accionBoton = accionBoton;
    }

    @Override
    public void handle(ActionEvent event) {
        accionBoton.ejecutar();
    }
}

package edu.fiuba.algo3.controllers;

import javafx.event.Event;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class EventoTiendaHandler {
    private final Stage tiendaStage;

    public EventoTiendaHandler(Stage tiendaStage) {
        this.tiendaStage = tiendaStage;
        configurarEventos();
    }
    private void configurarEventos() {
        //ventana sin los botones de minimizar, maximizar y cerrar
        tiendaStage.initStyle(StageStyle.UTILITY);  //quitar los botones de cerrar y minimizar

        tiendaStage.setResizable(false);

        tiendaStage.setOnCloseRequest(Event::consume);
    }
}
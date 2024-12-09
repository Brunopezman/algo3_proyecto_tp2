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
        // Configurar la ventana sin los botones de minimizar, maximizar y cerrar
        tiendaStage.initStyle(StageStyle.UTILITY);  // Quitar los botones de cerrar y minimizar

        // Desactivar redimensionamiento
        tiendaStage.setResizable(false);

        // Anular el evento de cierre
        tiendaStage.setOnCloseRequest(Event::consume);
    }
}
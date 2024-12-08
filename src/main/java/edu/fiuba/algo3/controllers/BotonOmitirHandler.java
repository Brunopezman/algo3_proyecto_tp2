package edu.fiuba.algo3.controllers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;


public class BotonOmitirHandler implements EventHandler<ActionEvent> {

    private final Stage tiendaStage;

    public BotonOmitirHandler(Stage tiendaStage) {
        this.tiendaStage = tiendaStage;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        tiendaStage.close();
    }
}

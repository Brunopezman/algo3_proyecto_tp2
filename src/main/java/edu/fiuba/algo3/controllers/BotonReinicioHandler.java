package edu.fiuba.algo3.controllers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;

public class BotonReinicioHandler implements EventHandler<ActionEvent> {

    private final Stage stage;

    public BotonReinicioHandler(Stage stage) {
        this.stage = stage;
    }
    @Override
    public void handle(ActionEvent actionEvent) {
        Controlador controlador = Controlador.getInstance();
        controlador.mostrarPantallaInicial();
        stage.close();
    }
}

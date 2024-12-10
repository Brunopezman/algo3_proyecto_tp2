package edu.fiuba.algo3.controllers;

import edu.fiuba.algo3.vistas.pantalla.PantallaUser;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class BotonComencemosHandler implements EventHandler<ActionEvent> {

    private Stage stage;

    public BotonComencemosHandler(Stage stage) {
        this.stage = stage;
    }

    @Override
    public void handle(ActionEvent event) {
        mostrarPantallaUser();
    }

    private void mostrarPantallaUser() {
        PantallaUser pantallaUser = new PantallaUser();
        Scene escenaUser = new Scene(pantallaUser.getRoot(), 800, 600);
        stage.setScene(escenaUser);
    }
}
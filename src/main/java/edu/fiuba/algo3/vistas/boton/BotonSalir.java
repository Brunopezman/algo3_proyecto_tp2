package edu.fiuba.algo3.vistas.boton;

import edu.fiuba.algo3.Main;
import edu.fiuba.algo3.controllers.AccionBoton;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class BotonSalir implements AccionBoton {
    private Stage stage;
    private Main main;
    public BotonSalir(Stage stage) {
        this.stage = stage;
    }

    @Override
    public void ejecutar() {
        Alert alerta = new Alert(AlertType.CONFIRMATION);
        alerta.setTitle("Confirmación de salida");
        alerta.setHeaderText("¿Seguro que deseas salir?");
        alerta.setContentText("Al salir se perderán los avances actuales.");

        ButtonType botonAceptar = new ButtonType("Aceptar");
        ButtonType botonCancelar = new ButtonType("Cancelar", ButtonBar.ButtonData.CANCEL_CLOSE);
        alerta.getButtonTypes().setAll(botonAceptar, botonCancelar);

        alerta.showAndWait().ifPresent(respuesta -> {
            if (respuesta == botonAceptar) {
                stage.close();
            }
        });
    }
}

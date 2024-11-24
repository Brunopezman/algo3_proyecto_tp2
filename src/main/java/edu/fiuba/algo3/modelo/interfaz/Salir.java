package edu.fiuba.algo3.modelo.interfaz;

import edu.fiuba.algo3.Main;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;

public class Salir implements AccionBoton {
    private Main main;

    public Salir(Main main) {
        this.main = main;
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
                main.mostrarPantallaInicial();
            }
        });
    }
}

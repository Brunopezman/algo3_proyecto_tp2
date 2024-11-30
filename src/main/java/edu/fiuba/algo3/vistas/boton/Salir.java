package edu.fiuba.algo3.vistas.boton;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import javafx.scene.Scene;
import edu.fiuba.algo3.vistas.pantalla.PantallaInicial;

public class Salir implements AccionBoton {
    private Stage stage;

    public Salir(Stage stage) {
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

        //esto es para que cuando toques salir salga del juego por completo, lanza excepcion
        //alerta.showAndWait().ifPresent(respuesta -> {
            //if (respuesta == botonAceptar) {
                //stage.close(); // Cierra la ventana actual
            //}
        //});

        //por el momento dejo que cuando tocas aceptar vuelva a pantalla inicial, no se como hacer que funcione
        alerta.showAndWait().ifPresent(respuesta -> {
            if (respuesta == botonAceptar) {
                //cargar la pantalla inicial y cambiar la escena
                Runnable accionComenzar = () -> {
                    // Aquí se puede agregar la lógica de la acción "Comenzar" si es necesario.
                };
                Runnable accionComoJugar = () -> {
                    // Aquí se puede agregar la lógica de la acción "Cómo Jugar" si es necesario.
                };

                // Crear y mostrar la pantalla inicial
                PantallaInicial pantallaInicial = new PantallaInicial(accionComenzar);
                stage.setScene(new Scene(pantallaInicial.getRoot()));
                stage.show();
            }
        });
    }
}
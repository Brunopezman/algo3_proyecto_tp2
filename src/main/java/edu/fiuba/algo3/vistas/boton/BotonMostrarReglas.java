package edu.fiuba.algo3.vistas.boton;

import edu.fiuba.algo3.controllers.AccionBoton;
import edu.fiuba.algo3.vistas.pantalla.PantallaReglas;
import javafx.stage.Stage;

public class BotonMostrarReglas implements AccionBoton {
    private final Stage owner;

    public BotonMostrarReglas(Stage owner) {
        this.owner = owner;
    }

    @Override
    public void ejecutar() {
        // Crear y mostrar la ventana de reglas
        PantallaReglas pantallaReglas = new PantallaReglas(owner);
        pantallaReglas.mostrar();
    }
}
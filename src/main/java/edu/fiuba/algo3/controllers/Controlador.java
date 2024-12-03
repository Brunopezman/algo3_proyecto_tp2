package edu.fiuba.algo3.controllers;

import edu.fiuba.algo3.modelo.juego.Juego;
import edu.fiuba.algo3.vistas.pantalla.VistaBalatro;

/**
 * Representa al controllador del juego Balatro
 * Gestiona cambios en el modelo y en la vista dados por el input del usuario
 */

public class Controlador {

    private final Juego juego;
    private final VistaBalatro vista;

    public Controlador(Juego juego, VistaBalatro vista) {
        this.juego = juego;
        this.vista = vista;
    }

    public void iniciar() {

    }
}

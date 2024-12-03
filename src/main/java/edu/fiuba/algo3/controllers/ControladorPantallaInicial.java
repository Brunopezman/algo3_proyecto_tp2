package edu.fiuba.algo3.controllers;

import edu.fiuba.algo3.vistas.pantalla.VistaBalatro;

public class ControladorPantallaInicial {
    private final VistaBalatro vistaBalatro;

    public ControladorPantallaInicial(VistaBalatro vistaBalatro) {
        this.vistaBalatro = vistaBalatro;
    }

    public void irAPantallaUsuario() {
        vistaBalatro.mostrarPantallaUser();
    }
}
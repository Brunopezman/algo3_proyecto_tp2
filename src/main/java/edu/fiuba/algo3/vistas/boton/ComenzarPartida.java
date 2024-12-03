package edu.fiuba.algo3.vistas.boton;

import edu.fiuba.algo3.Main;
import edu.fiuba.algo3.vistas.pantalla.VistaBalatro;

public class ComenzarPartida implements AccionBoton {
    private VistaBalatro vistaBalatro;

    public ComenzarPartida(Main main) {
        this.vistaBalatro = vistaBalatro;
    }

    @Override
    public void ejecutar() {
        vistaBalatro.mostrarPantallaUser();
    }
}

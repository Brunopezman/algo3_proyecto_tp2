package edu.fiuba.algo3.modelo.interfaz;

import edu.fiuba.algo3.Main;

public class ComenzarPartida implements AccionBoton {
    private Main main;

    public ComenzarPartida(Main main) {
        this.main = main;
    }

    @Override
    public void ejecutar() {
        main.mostrarPantallaUser();
    }
}

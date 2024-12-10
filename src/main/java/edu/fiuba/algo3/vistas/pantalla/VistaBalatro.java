package edu.fiuba.algo3.vistas.pantalla;

import edu.fiuba.algo3.vistas.menu.MenuJuego;
import javafx.stage.Stage;

public class VistaBalatro {

    private static final int ANCHO = 880;
    private static final int ALTO = 600;
    private static VistaBalatro vistaBalatro;
    private final Stage stage;
    private MenuJuego menuJuego;

    /**
     * Constructor de la vista principal del juego Balatro.
     *
     * @param stage el escenario donde se mostrará el juego
     * @param juego el modelo del juego
     */
    public VistaBalatro(Stage stage) {
        this.stage = stage;
        this.menuJuego = MenuJuego.getInstance(stage);
        // Configuración básica del Stage
        stage.setTitle("Balatro");
        stage.setWidth(ANCHO);
        stage.setHeight(ALTO);
        stage.setResizable(true);
        stage.show();
    }

    public static VistaBalatro getInstance(Stage stage) {
        if (vistaBalatro == null) {
            vistaBalatro = new VistaBalatro(stage);
        }
        return vistaBalatro;
    }

    public Stage getStage() {
        return stage;
    }

    public MenuJuego getMenuJuego() {
        return menuJuego;
    }
}

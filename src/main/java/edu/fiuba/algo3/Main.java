package edu.fiuba.algo3;

import edu.fiuba.algo3.controllers.Controlador;
import edu.fiuba.algo3.modelo.juego.Juego;
import edu.fiuba.algo3.vistas.pantalla.VistaBalatro;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    private Stage stage;
    private VistaBalatro vista;

    /**
     * Inicializa la aplicacion Balatro
     * Instancia el modelo, la vista y controlador, y luego inicia el juego
     * @param stage stage principal del juego donde se va a setear la scene
     */

    @Override
    public void start(Stage stage) throws Exception {
        Juego juego = new Juego("src/main/java/edu/fiuba/algo3/resources/archivosJson/balatro.json");
        vista = new VistaBalatro(stage, juego);
        Controlador controlador = new Controlador(juego, vista);
        controlador.iniciar();
    }

    /**
     * Cierra la aplicacion
     * Detiene el timer cuando la aplicacion se cierra
     */

    @Override
    public void stop() {
        // Detener el timer cuando la aplicación se cierra
        vista.detenerTimer();
    }

    /**
     * Entry point de la aplicación Balatro
     * @param args
     */

    public static void main(String[] args) {
        launch(args);
    }
}

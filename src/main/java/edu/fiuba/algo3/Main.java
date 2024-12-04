package edu.fiuba.algo3;

import edu.fiuba.algo3.controllers.Controlador;
import edu.fiuba.algo3.modelo.juego.Juego;
import edu.fiuba.algo3.vistas.pantalla.VistaBalatro;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception  {
        Juego juego = Juego.getInstance();
        VistaBalatro vistaBalatro = VistaBalatro.getInstance(primaryStage);
        Controlador controlador = Controlador.getInstance();
        controlador.iniciar();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
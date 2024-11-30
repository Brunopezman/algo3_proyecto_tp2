package edu.fiuba.algo3.vistas.menu;

import edu.fiuba.algo3.vistas.boton.AccionBoton;
import edu.fiuba.algo3.vistas.boton.BotonHandler;
import edu.fiuba.algo3.vistas.boton.MostrarReglas;
import edu.fiuba.algo3.vistas.boton.Salir;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;

public class MenuJuego {
    private final MenuBar menuBar;

    public MenuJuego(Stage stage) {
        this.menuBar = new MenuBar();

        Menu menuOpciones = new Menu("Opciones");

        MenuItem menuReglas = new MenuItem("Reglas");
        menuReglas.setOnAction(event -> {
            MostrarReglas accionMostrarReglas = new MostrarReglas(stage);
            accionMostrarReglas.ejecutar();
        });

        MenuItem menuSalir = new MenuItem("Salir del Juego");

        AccionBoton accionSalir = new Salir(stage);
        menuSalir.setOnAction(new BotonHandler(accionSalir));

        menuOpciones.getItems().addAll(menuReglas, menuSalir);

        this.menuBar.getMenus().add(menuOpciones);
    }

    public MenuBar getMenuBar() {
        return menuBar;
    }
}

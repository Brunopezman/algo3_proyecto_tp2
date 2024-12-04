package edu.fiuba.algo3.vistas.pantalla;

import edu.fiuba.algo3.eventos.EventoPantallaInicial;
import edu.fiuba.algo3.vistas.menu.MenuJuego;
import javafx.animation.FadeTransition;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.util.Duration;
import java.nio.file.Paths;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class PantallaInicial {
    private final BorderPane root;
    private final MenuJuego menuJuego;

    public PantallaInicial(EventoPantallaInicial eventosPantallaInicial) {
        Font fuenteTitulo = cargarFuente("src/main/java/edu/fiuba/algo3/resources/fuentes/fuente.ttf", 120);
        Font fuenteComencemos = cargarFuente("src/main/java/edu/fiuba/algo3/resources/fuentes/fuente2.otf", 30);

        String rutaImagen = "src/main/java/edu/fiuba/algo3/resources/fondos/fondo_rya.jpeg";
        Image imagenFondo = new Image(Paths.get(rutaImagen).toUri().toString());
        Background fondo = new Background(new BackgroundImage(
                imagenFondo,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                new BackgroundSize(
                        BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, true
                )
        ));

        // Crear el menú de juego
        this.menuJuego = new MenuJuego(null);

        VBox contenido = new VBox();
        contenido.setAlignment(Pos.CENTER);
        contenido.setSpacing(50);

        Text titulo = new Text("B A L A T R O");
        titulo.setFont(fuenteTitulo);
        titulo.setFill(Color.YELLOW);
        titulo.setStyle("-fx-effect: dropshadow(gaussian, darkred, 5, 0.5, 0, 0);");

        Button botonComencemos = new Button("COMENCEMOS");
        botonComencemos.setFont(fuenteComencemos);
        botonComencemos.setStyle("-fx-background-color: #ffffff; -fx-text-fill: #000000; -fx-border-radius: 15; -fx-padding: 10px 20px;");
        botonComencemos.setOnAction(eventosPantallaInicial);

        FadeTransition fade = new FadeTransition(Duration.seconds(0.8), botonComencemos);
        fade.setFromValue(1.0);
        fade.setToValue(0.3);
        fade.setCycleCount(FadeTransition.INDEFINITE);
        fade.setAutoReverse(true);
        fade.play();

        contenido.getChildren().addAll(titulo, botonComencemos);

        root = new BorderPane();
        root.setBackground(fondo);
        root.setTop(menuJuego.getMenuBar()); // Agregar el menú de opciones
        root.setCenter(contenido);
    }

    private Font cargarFuente(String rutaFuente, int tamaño) {
        try {
            return Font.loadFont(new FileInputStream(rutaFuente), tamaño);
        } catch (FileNotFoundException e) {
            System.err.println("Fuente no encontrada: " + rutaFuente);
            return Font.font("Arial", tamaño);
        }
    }

    public BorderPane getRoot() {
        return root;
    }
}

//anterior version:
//package edu.fiuba.algo3.vistas.pantalla;
//
//import javafx.animation.FadeTransition;
//import javafx.geometry.Pos;
//import javafx.scene.control.Button;
//import javafx.scene.image.Image;
//import javafx.scene.layout.*;
//import javafx.scene.paint.Color;
//import javafx.scene.text.Font;
//import javafx.scene.text.Text;
//import javafx.util.Duration;
//import java.nio.file.Paths;
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//
//public class PantallaInicial {
//    private final BorderPane root;
//
//    public PantallaInicial(Runnable accionComenzar) {
//        // Cargar la fuente externa
//        Font fuenteTitulo = cargarFuente("src/main/java/edu/fiuba/algo3/resources/fuente.ttf", 120);
//        Font fuenteComencemos = cargarFuente("src/main/java/edu/fiuba/algo3/resources/fuente2.otf", 30);
//
//        // Fondo de pantalla
//        String rutaImagen = "src/main/java/edu/fiuba/algo3/resources/fondo_rya.jpeg";
//        Image imagenFondo = new Image(Paths.get(rutaImagen).toUri().toString());
//        BackgroundImage backgroundImage = new BackgroundImage(
//                imagenFondo,
//                BackgroundRepeat.NO_REPEAT,
//                BackgroundRepeat.NO_REPEAT,
//                BackgroundPosition.CENTER,
//                new BackgroundSize(
//                        BackgroundSize.AUTO,
//                        BackgroundSize.AUTO,
//                        false,
//                        false,
//                        true,
//                        true
//                )
//        );
//        Background fondo = new Background(backgroundImage);
//
//        // Contenido principal
//        VBox contenido = new VBox();
//        contenido.setAlignment(Pos.CENTER);
//        contenido.setSpacing(50);
//
//        Text titulo = new Text("B A L A T R O");
//        titulo.setFont(fuenteTitulo);
//        titulo.setFill(Color.YELLOW);
//        titulo.setStyle("-fx-effect: dropshadow(gaussian, darkred, 5, 0.5, 0, 0);");
//
//        Button botonComencemos = new Button("COMENCEMOS");
//        //botonComencemos.setFont(Font.font("Arial", 25));
//        botonComencemos.setFont(fuenteComencemos);
//        botonComencemos.setStyle("-fx-background-color: #ffffff; -fx-text-fill: #000000; -fx-border-radius: 15; -fx-padding: 10px 20px;");
//        botonComencemos.setOnAction(event -> accionComenzar.run());
//
//        // Efecto de transición en el botón
//        FadeTransition fade = new FadeTransition(Duration.seconds(0.8), botonComencemos);
//        fade.setFromValue(1.0);
//        fade.setToValue(0.3);
//        fade.setCycleCount(FadeTransition.INDEFINITE);
//        fade.setAutoReverse(true);
//        fade.play();
//
//        contenido.getChildren().addAll(titulo, botonComencemos);
//
//        // BorderPane para organizar los elementos
//        root = new BorderPane();
//        root.setBackground(fondo);
//        root.setCenter(contenido);
//    }
//
//    private Font cargarFuente(String rutaFuente, int tamaño) {
//        try {
//            // Cargar la fuente desde el archivo y devolverla con el tamaño especificado
//            return Font.loadFont(new FileInputStream(rutaFuente), tamaño);
//        } catch (FileNotFoundException e) {
//            System.err.println("Fuente no encontrada: " + rutaFuente);
//            // Si la fuente no se carga, usar una fuente predeterminada
//            return Font.font("Arial", tamaño);
//        }
//    }
//
//    public BorderPane getRoot() {
//        return root;
//    }
//}
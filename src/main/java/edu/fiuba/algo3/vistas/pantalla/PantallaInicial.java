package edu.fiuba.algo3.vistas.pantalla;

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

public class PantallaInicial {
    private final BorderPane root;

    //musica
    //String musicaRuta = "src/main/java/edu/fiuba/algo3/resources/musica.mp3";
    //Media media = new Media(Paths.get(musicaRuta).toUri().toString());
    //MediaPlayer mediaPlayer = new MediaPlayer(media);
    //mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
    //mediaPlayer.setAutoPlay(true);

    public PantallaInicial(Runnable accionComenzar, Runnable accionComoJugar) {
        //fondo de pantalla
        String rutaImagen = "src/main/java/edu/fiuba/algo3/resources/fondo_rya.jpeg";
        Image imagenFondo = new Image(Paths.get(rutaImagen).toUri().toString());
        BackgroundImage backgroundImage = new BackgroundImage(
                imagenFondo,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                new BackgroundSize(
                        BackgroundSize.AUTO,
                        BackgroundSize.AUTO,
                        false,
                        false,
                        true,
                        true
                )
        );
        Background fondo = new Background(backgroundImage);

        //barra superior (botones como "¿Cómo Jugar?")
        HBox barraSuperior = new HBox();
        barraSuperior.setAlignment(Pos.TOP_RIGHT);
        barraSuperior.setSpacing(10);
        barraSuperior.setPadding(new javafx.geometry.Insets(10));

        Button botonComoJugar = new Button("¿CÓMO JUGAR?");
        botonComoJugar.setFont(Font.font("Arial", 12));
        botonComoJugar.setStyle("-fx-background-color: #ffffff; -fx-text-fill: #000000; -fx-border-radius: 15; -fx-padding: 5px 10px;");
        botonComoJugar.setOnAction(event -> accionComoJugar.run());

        barraSuperior.getChildren().add(botonComoJugar);

        //contenido principal
        VBox contenido = new VBox();
        contenido.setAlignment(Pos.CENTER);
        contenido.setSpacing(50);

        Text titulo = new Text("B A L A T R O");
        titulo.setFont(Font.font("Comic Sans MS", 120));
        titulo.setFill(Color.YELLOW);
        titulo.setStyle("-fx-effect: dropshadow(gaussian, darkred, 5, 0.5, 0, 0);");

        Button botonComencemos = new Button("COMENCEMOS");
        botonComencemos.setFont(Font.font("Arial", 25));
        botonComencemos.setStyle("-fx-background-color: #ffffff; -fx-text-fill: #000000; -fx-border-radius: 15; -fx-padding: 10px 20px;");
        botonComencemos.setOnAction(event -> accionComenzar.run());

        //efecto de transición en el botón
        FadeTransition fade = new FadeTransition(Duration.seconds(0.8), botonComencemos);
        fade.setFromValue(1.0);
        fade.setToValue(0.3);
        fade.setCycleCount(FadeTransition.INDEFINITE);
        fade.setAutoReverse(true);
        fade.play();

        contenido.getChildren().addAll(titulo, botonComencemos);

        //BorderPane para organizar los elementos
        root = new BorderPane();
        root.setBackground(fondo);
        root.setTop(barraSuperior); // Barra superior
        root.setCenter(contenido);  // Contenido principal
    }

    public BorderPane getRoot() {
        return root;
    }
}
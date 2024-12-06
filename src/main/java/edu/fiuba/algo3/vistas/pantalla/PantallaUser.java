package edu.fiuba.algo3.vistas.pantalla;

import edu.fiuba.algo3.controllers.BotonConfirmarHandler;
import edu.fiuba.algo3.vistas.boton.BotonConfirmar;
import edu.fiuba.algo3.vistas.menu.MenuJuego;
import javafx.geometry.Pos;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.media.AudioClip;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.nio.file.Paths;

public class PantallaUser {
    private StackPane root;
    private MenuJuego menuJuego;

    public PantallaUser() {
        // Crear el StackPane que contendrá la imagen de fondo
        StackPane fondo = new StackPane();
        VistaBalatro vistaBalatro = VistaBalatro.getInstance(null);
        this.menuJuego = vistaBalatro.getMenuJuego();

        // Cargar las fuentes
        Font fuenteIngreseNombre = cargarFuente("src/main/java/edu/fiuba/algo3/resources/fuentes/fuente2.otf", 40);
        Font fuenteConfirmar = cargarFuente("src/main/java/edu/fiuba/algo3/resources/fuentes/fuente2.otf", 30);

        // Cargar la imagen de fondo
        String rutaImagen = "src/main/java/edu/fiuba/algo3/resources/fondos/fondo_rya2.jpeg";
        Image imagenFondo = new Image(Paths.get(rutaImagen).toUri().toString());

        // Configurar el fondo
        Background background = new Background(new BackgroundImage(imagenFondo, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT));
        fondo.setBackground(background);

        // Crear el VBox para el contenido y hacer que ocupe todo el espacio disponible
        VBox contenido = new VBox();
        //contenido.setStyle("-fx-background-color: rgba(70, 130, 180, 0.5);");
        contenido.setAlignment(Pos.CENTER);
        contenido.setSpacing(30);
        contenido.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        contenido.setPrefSize(800, 600); // Tamaño preferido del contenido, ajusta según tus necesidades

        // Texto de encabezado
        Text textoIngreseNombre = new Text("Ingrese su nombre");
        textoIngreseNombre.setFont(fuenteIngreseNombre);
        textoIngreseNombre.setFill(Color.YELLOW);
        textoIngreseNombre.setStyle("-fx-fill: white;");

        // Campo de texto para ingresar el nombre
        TextField campoNombre = new TextField();
        campoNombre.setPromptText("Tu nombre...");
        campoNombre.setMaxWidth(300);

        // Botón de confirmar
        BotonConfirmarHandler botonConfirmarHandler = new BotonConfirmarHandler(vistaBalatro.getStage(), campoNombre,textoIngreseNombre);
        BotonConfirmar botonConfirmar = new BotonConfirmar(botonConfirmarHandler);

//        // Cargar y reproducir el sonido al hacer clic en el botón
//        String rutaSonido = "src/main/java/edu/fiuba/algo3/resources/sonidos/click.mp3"; // Cambia "click.mp3" por tu archivo de sonido
//        AudioClip sonido = new AudioClip(Paths.get(rutaSonido).toUri().toString());

        // Evento para el botón confirmar
//        botonConfirmar.setOnAction(event -> {
////            sonido.play();
//            String nombreIngresado = campoNombre.getText().trim();
//            if (nombreIngresado.isEmpty()) {
//                textoIngreseNombre.setText("Por favor ingresa tu nombre");
//            }
//        });

        // Añadir elementos al VBox
        contenido.getChildren().addAll(textoIngreseNombre, campoNombre, botonConfirmar);

        // Crear un contenedor para poner el contenido y el menú
        VBox layoutPrincipal = new VBox();
        layoutPrincipal.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        layoutPrincipal.getChildren().addAll(menuJuego.getMenuBar(), contenido);

        // Agregar el VBox al StackPane (imagen de fondo)
        fondo.getChildren().add(layoutPrincipal);

        // Configurar el root de la pantalla
        this.root = fondo;
    }

    private Font cargarFuente(String rutaFuente, int tamaño) {
        try {
            return Font.loadFont(new FileInputStream(rutaFuente), tamaño);
        } catch (FileNotFoundException e) {
            System.err.println("Fuente no encontrada: " + rutaFuente);
            return Font.font("Arial", tamaño);
        }
    }

    public StackPane getRoot() {
        return root;
    }
}
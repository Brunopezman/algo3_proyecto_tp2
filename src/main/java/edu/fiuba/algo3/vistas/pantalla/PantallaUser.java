package edu.fiuba.algo3.vistas.pantalla;

import edu.fiuba.algo3.vistas.menu.MenuJuego;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
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
import java.util.function.Consumer;

public class PantallaUser {
    private StackPane root;
    private MenuJuego menuJuego;

    public PantallaUser(Consumer<String> onNombreIngresado) {
        // Crear el StackPane que contendrá la imagen de fondo
        StackPane fondo = new StackPane();

        this.menuJuego = new MenuJuego(null);

        // Cargar las fuentes
        Font fuenteIngreseNombre = cargarFuente("src/main/java/edu/fiuba/algo3/resources/fuentes/fuente2.otf", 40);
        Font fuenteConfirmar = cargarFuente("src/main/java/edu/fiuba/algo3/resources/fuentes/fuente2.otf", 30);

        // Cargar la imagen de fondo
        String rutaImagen = "src/main/java/edu/fiuba/algo3/resources/fondos/fondo_rya2.jpeg";
        Image imagenFondo = new Image(Paths.get(rutaImagen).toUri().toString());

        // Configurar el fondo
        BackgroundImage backgroundImage = new BackgroundImage(
                imagenFondo,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, true, true, true, true)
        );
        fondo.setBackground(new Background(backgroundImage));

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
        Button botonConfirmar = new Button("Comenzar Partida");
        botonConfirmar.setFont(fuenteConfirmar);
        botonConfirmar.setStyle("-fx-background-color: #ffffff; -fx-text-fill: #FF0000;");

        // Cargar y reproducir el sonido al hacer clic en el botón
        String rutaSonido = "src/main/java/edu/fiuba/algo3/resources/sonidos/click.mp3"; // Cambia "click.mp3" por tu archivo de sonido
        AudioClip sonido = new AudioClip(Paths.get(rutaSonido).toUri().toString());

        // Evento para el botón confirmar
        botonConfirmar.setOnAction(event -> {
            sonido.play();
            String nombreIngresado = campoNombre.getText().trim();
            if (!nombreIngresado.isEmpty()) {
                // Llamar al Consumer pasado como argumento para notificar al Main
                onNombreIngresado.accept(nombreIngresado);
            } else {
                textoIngreseNombre.setText("Por favor ingresa tu nombre");
            }
        });

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



//sin menu
//package edu.fiuba.algo3.vistas.pantalla;
//
//import javafx.geometry.Pos;
//import javafx.scene.control.Button;
//import javafx.scene.control.TextField;
//import javafx.scene.image.Image;
//import javafx.scene.layout.*;
//        import javafx.scene.paint.Color;
//import javafx.scene.text.Font;
//import javafx.scene.text.Text;
//import javafx.scene.media.AudioClip;
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.nio.file.Paths;
//import java.util.function.Consumer;
//
//public class PantallaUser {
//    private StackPane root;
//
//    public PantallaUser(Consumer<String> onNombreIngresado) {
//        // Crear el StackPane que contendrá la imagen de fondo
//        StackPane fondo = new StackPane();
//
//        Font fuenteIngreseNombre = cargarFuente("src/main/java/edu/fiuba/algo3/resources/fuentes/fuente2.otf", 40);
//        Font fuenteConfirmar = cargarFuente("src/main/java/edu/fiuba/algo3/resources/fuentes/fuente2.otf", 30);
//
//        String rutaImagen = "src/main/java/edu/fiuba/algo3/resources/fondos/fondo_rya2.jpeg";
//        Image imagenFondo = new Image(Paths.get(rutaImagen).toUri().toString());
//
//        // Configurar el fondo
//        BackgroundImage backgroundImage = new BackgroundImage(
//                imagenFondo,
//                BackgroundRepeat.NO_REPEAT,
//                BackgroundRepeat.NO_REPEAT,
//                BackgroundPosition.CENTER,
//                new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, true, true, true, true)
//        );
//        fondo.setBackground(new Background(backgroundImage));
//
//        // Crear el VBox para el contenido
//        VBox contenido = new VBox();
//        contenido.setStyle("-fx-background-color: rgba(70, 130, 180, 0.25);"); // semi-transparente
//
//        // Texto de encabezado
//        Text textoIngreseNombre = new Text("Ingrese su nombre");
//        textoIngreseNombre.setFont(fuenteIngreseNombre);
//        textoIngreseNombre.setFill(Color.YELLOW);
//        textoIngreseNombre.setStyle("-fx-fill: white;");
//
//        TextField campoNombre = new TextField();
//        campoNombre.setPromptText("Tu nombre...");
//        campoNombre.setMaxWidth(300);
//
//        // Botón de confirmar
//        Button botonConfirmar = new Button("Comenzar Partida");
//        botonConfirmar.setFont(fuenteConfirmar);
//        botonConfirmar.setStyle("-fx-background-color: #ffffff; -fx-text-fill: #FF0000;");
//
//        // Cargar y reproducir el sonido al hacer clic en el botón
//        String rutaSonido = "src/main/java/edu/fiuba/algo3/resources/sonidos/click.mp3"; // Cambia "click.mp3" por tu archivo de sonido
//        AudioClip sonido = new AudioClip(Paths.get(rutaSonido).toUri().toString());
//
//        // Evento para el botón confirmar
//        botonConfirmar.setOnAction(event -> {
//            sonido.play();
//            String nombreIngresado = campoNombre.getText().trim();
//            if (!nombreIngresado.isEmpty()) {
//                // Llamar al Consumer pasado como argumento para notificar al Main
//                onNombreIngresado.accept(nombreIngresado);
//            } else {
//                textoIngreseNombre.setText("Por favor, ingresá tu nombre.");
//            }
//        });
//
//        contenido.setAlignment(Pos.CENTER);
//        contenido.setSpacing(30);
//
//        // Añadir elementos al VBox
//        contenido.getChildren().addAll(textoIngreseNombre, campoNombre, botonConfirmar);
//
//        // Agregar el VBox al StackPane (imagen de fondo)
//        fondo.getChildren().add(contenido);
//
//        // Configurar el root de la pantalla
//        this.root = fondo;
//    }
//
//    private Font cargarFuente(String rutaFuente, int tamaño) {
//        try {
//            return Font.loadFont(new FileInputStream(rutaFuente), tamaño);
//        } catch (FileNotFoundException e) {
//            System.err.println("Fuente no encontrada: " + rutaFuente);
//            return Font.font("Arial", tamaño);
//        }
//    }
//
//    public StackPane getRoot() {
//        return root;
//    }
//}
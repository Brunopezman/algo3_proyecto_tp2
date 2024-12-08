package edu.fiuba.algo3.vistas.pantalla;

import edu.fiuba.algo3.controllers.*;

import edu.fiuba.algo3.modelo.carta.Carta;
import edu.fiuba.algo3.modelo.comodin.Comodin;
import edu.fiuba.algo3.modelo.juego.Juego;
import edu.fiuba.algo3.modelo.juego.Ronda;
import edu.fiuba.algo3.modelo.tarot.Tarot;
import edu.fiuba.algo3.modelo.juego.Tienda;
import edu.fiuba.algo3.vistas.boton.BotonComprar;
import edu.fiuba.algo3.vistas.boton.BotonOmitir;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.media.AudioClip;

import java.io.FileInputStream;
import java.nio.file.Paths;

import java.util.ArrayList;
import java.util.List;

public class PantallaTienda {

    private static List<Comodin> comodinesSeleccionados;
    private static ParteDerecha parteDerecha;
    private static int contador;

    public PantallaTienda(ParteDerecha parteDerecha) {
        this.parteDerecha = parteDerecha;
        this.contador = 0;
    }

    public static void mostrarTienda() {
        Stage tiendaStage = new Stage();
        tiendaStage.setTitle("Tienda");

        // Cargar fuente personalizada
        Font fuenteTitulo = cargarFuente("src/main/java/edu/fiuba/algo3/resources/fuentes/fuente2.otf", 60);

        // Crear el título y subtitulo de la tienda
        Text titulo = new Text("Tienda");
        titulo.setFont(fuenteTitulo); // Fuente grande, por ejemplo, tamaño 40
        titulo.setFill(Color.YELLOW);
        titulo.setStyle("-fx-effect: dropshadow(gaussian, darkred, 5, 0.5, 0, 0);");

        Text subtitulo = new Text("Puedes elegir hasta 3 cartas para comenzar la ronda");
        subtitulo.setFont(Font.font(fuenteTitulo.getFamily(), fuenteTitulo.getSize() * 0.3)); // Fuente más pequeña, 60% del tamaño del título
        subtitulo.setFill(Color.YELLOW);
        subtitulo.setStyle("-fx-effect: dropshadow(gaussian, darkred, 5, 0.5, 0, 0);");

        // Crear el contenedor de cartas
        HBox contenedorCartas = new HBox(20);
        contenedorCartas.setAlignment(Pos.CENTER);
        contenedorCartas.setPadding(new Insets(20));

        // Obtener la tienda de la ronda actual
        Juego juego = Juego.getInstance();
        Ronda rondaActual = juego.getRondaActual();
        Tienda tienda = rondaActual.getTienda();

        // Obtener las cartas de comodines y tarots de la tienda
        List<Comodin> comodines = tienda.getComodines();
        List<Comodin> comodinesSeleccionados = new ArrayList<>();
        List<Tarot> tarots = tienda.getTarots();
        List<Tarot> tarotsSeleccionados = new ArrayList<>();
        Carta cartaEspecifica = tienda.getCarta();
        List<Carta> cartasEspecificas = new ArrayList<>();

        String rutaSonido = "src/main/java/edu/fiuba/algo3/resources/sonidos/click.mp3";
        AudioClip sonidoClick = new AudioClip(Paths.get(rutaSonido).toUri().toString());

        // Mostrar cartas de comodines
        HBox contenedorComodines = new HBox(10);
        contenedorComodines.setAlignment(Pos.CENTER_LEFT);

        for (Comodin comodin : comodines) {
            Image cartaImagen = new Image(Paths.get("src/main/java/edu/fiuba/algo3/resources/comodines/" + comodin.getNombre() + ".png").toUri().toString());
            ImageView cartaView = new ImageView(cartaImagen);
            cartaView.setFitWidth(72);
            cartaView.setFitHeight(108);

            ComodinSeleccionadoHandler handler = new ComodinSeleccionadoHandler(comodin, cartaView, sonidoClick, comodinesSeleccionados);
            cartaView.setOnMouseClicked(event -> handler.handle(new ActionEvent()));
            contenedorComodines.getChildren().add(cartaView);
        }

        // Mostrar cartas de tarots
        HBox contenedorTarot = new HBox(10);
        contenedorTarot.setAlignment(Pos.CENTER);
        for (Tarot tarot : tarots) {
            Image cartaImagen = new Image(Paths.get("src/main/java/edu/fiuba/algo3/resources/tarots/" + tarot.getNombre() + ".png").toUri().toString());
            ImageView cartaView = new ImageView(cartaImagen);
            cartaView.setFitWidth(72);
            cartaView.setFitHeight(108);

            TarotSeleccionadoHandler handler = new TarotSeleccionadoHandler(tarot, tarotsSeleccionados, cartaView, sonidoClick);
            cartaView.setOnMouseClicked(event -> handler.handle(new ActionEvent()));
            contenedorTarot.getChildren().add(cartaView);
        }
        HBox contenedorCartaEspecifica = new HBox(10);
        contenedorCartaEspecifica.setAlignment(Pos.CENTER_RIGHT);

        if (cartaEspecifica != null) {
            // Construir la ruta de la imagen basada en el número y el palo de la carta
            String rutaImagenCarta = "src/main/java/edu/fiuba/algo3/resources/cartas/" +
                    cartaEspecifica.numero() + "_" + cartaEspecifica.getPalo() + ".jpg";
            ImageView cartaView = new ImageView(new Image(Paths.get(rutaImagenCarta).toUri().toString()));
            cartaView.setFitWidth(72);
            cartaView.setFitHeight(108);

            // Agregar evento de clic si es necesario
            CartaTiendaSeleccionadaHandler handler = new CartaTiendaSeleccionadaHandler(cartaEspecifica, cartasEspecificas,cartaView, sonidoClick);
            cartaView.setOnMouseClicked(event -> handler.handle(new ActionEvent()));

            // Añadir la carta específica al contenedor
            contenedorCartaEspecifica.getChildren().add(cartaView);
        } else {
            System.out.println("No hay carta específica en la tienda.");
        }

        // Añadir contenedores de cartas al contenedor principal
        contenedorCartas.getChildren().addAll(contenedorComodines, contenedorTarot,contenedorCartaEspecifica);

        // Crear un StackPane para el fondo de pantalla
        StackPane stackPane = new StackPane();
        String rutaFondo = "src/main/java/edu/fiuba/algo3/resources/fondos/fondo_rya.jpeg";
        Image imagenFondo = new Image(Paths.get(rutaFondo).toUri().toString());
        BackgroundImage fondo = new BackgroundImage(imagenFondo, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
        Background background = new Background(fondo);
        stackPane.setBackground(background);

        // Crear botones de compra y omisión
        BotonComprarHandler botonComprarHandler = new BotonComprarHandler(tiendaStage,comodinesSeleccionados,tarotsSeleccionados,cartasEspecificas);
        BotonComprar botonComprar = new BotonComprar(botonComprarHandler);

        BotonOmitirHandler botonOmitirHandler = new BotonOmitirHandler(tiendaStage);
        BotonOmitir botonOmitir = new BotonOmitir(botonOmitirHandler);

        // Organizar los botones
        HBox botonesBox = new HBox(20, botonComprar, botonOmitir);
        botonesBox.setAlignment(Pos.CENTER);

        // Crear el layout principal y añadir los elementos
        VBox layout = new VBox(10, titulo, subtitulo, contenedorCartas, botonesBox);
        layout.setAlignment(Pos.CENTER);
        layout.setPadding(new Insets(10));

        // Añadir el layout al StackPane y mostrar la escena
        stackPane.getChildren().add(layout);
        Scene scene = new Scene(stackPane, 640, 480);
        tiendaStage.setScene(scene);
        tiendaStage.show();
    }

    private static Font cargarFuente(String rutaFuente, int tamano) {
        try {
            return Font.loadFont(new FileInputStream(rutaFuente), tamano);
        } catch (Exception e) {
            System.out.println("No se pudo cargar la fuente: " + rutaFuente);
            return Font.font("Arial", tamano);
        }
    }

    public static boolean sePuedeSeguirEligiendo(){
        return (contador < 3);
    }

    public static void aumentarContador(){
        contador++;
    }

    public static void reducirContador(){
        contador--;
    }

    // Crear un título estilizado para cada sección
    private Text crearTituloSeccion(String texto) {
        Text titulo = new Text(texto);
        titulo.setFont(Font.font("Arial", 20)); // Ajustar el tamaño según necesidades
        titulo.setFill(Color.rgb(255, 255, 255, 0.7)); // Color blanco semitransparente
        titulo.setEffect(new DropShadow(3, Color.BLACK)); // Sombra para mayor visibilidad
        titulo.setStyle("-fx-font-weight: bold;");
        return titulo;
    }
}

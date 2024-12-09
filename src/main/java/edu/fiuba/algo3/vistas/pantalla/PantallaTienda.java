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
import javafx.scene.control.Label;
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

    public static final String FUENTE_TIENDA = "src/main/java/edu/fiuba/algo3/resources/fuentes/fuente2.otf";
    public static final String FONDO_TIENDA = "src/main/java/edu/fiuba/algo3/resources/fondos/fondo_rya.jpeg";
    private static List<Comodin> comodinesSeleccionados;
    private static ParteDerecha parteDerecha;
    private static int contador;
    private static Label mensajeTemporalComodin; //nuevo
    private static Label mensajeTemporalTarot; //nuevo
    private static Label mensajeTemporalCarta; //nuevo

    public PantallaTienda(ParteDerecha parteDerecha) {
        this.parteDerecha = parteDerecha;
        this.contador = 0;
    }

    public static void mostrarTienda() {
        Stage tiendaStage = new Stage();
        tiendaStage.setTitle("Tienda");

        new EventoTiendaHandler(tiendaStage);

        //nuevo
        mensajeTemporalComodin = new Label();
        mensajeTemporalComodin.setStyle("-fx-background-color: rgba(0, 0, 0, 0.7); -fx-text-fill: white; -fx-padding: 10px; -fx-font-size: 14px;");
        mensajeTemporalComodin.setVisible(false);

        mensajeTemporalTarot = new Label();
        mensajeTemporalTarot.setStyle("-fx-background-color: rgba(0, 0, 0, 0.7); -fx-text-fill: white; -fx-padding: 10px; -fx-font-size: 14px;");
        mensajeTemporalTarot.setVisible(false);

        mensajeTemporalCarta = new Label();
        mensajeTemporalCarta.setStyle("-fx-background-color: rgba(0, 0, 0, 0.7); -fx-text-fill: white; -fx-padding: 10px; -fx-font-size: 14px;");
        mensajeTemporalCarta.setVisible(false);
        //

        Font fuenteTitulo = cargarFuente(FUENTE_TIENDA  , 60);
        Text titulo = new Text("Tienda");
        titulo.setFont(fuenteTitulo); // Fuente grande, por ejemplo, tamaño 40
        titulo.setFill(Color.YELLOW);
        titulo.setStyle("-fx-effect: dropshadow(gaussian, darkred, 5, 0.5, 0, 0);");

        Text subtitulo = new Text("Puedes elegir hasta 3 cartas para comenzar la ronda");
        subtitulo.setFont(Font.font(fuenteTitulo.getFamily(), fuenteTitulo.getSize() * 0.3));
        subtitulo.setFill(Color.YELLOW);
        subtitulo.setStyle("-fx-effect: dropshadow(gaussian, darkred, 5, 0.5, 0, 0);");

        // Crear el contenedor de todas las cartas de la pantalla
        HBox seccionTienda = new HBox(20);
        seccionTienda.setAlignment(Pos.CENTER);
        // Crear los títulos
        Text tituloComodines = crearTitulo("Comodines");
        Text tituloTarots = crearTitulo("Tarots");
        Text tituloCarta = crearTitulo("Carta");

        HBox contenedorCartas = new HBox(20);
        contenedorCartas.setAlignment(Pos.CENTER);
        contenedorCartas.setPadding(new Insets(20));

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

        // Crear seccion para todos los comodines
        VBox seccionComodines = new VBox(10);
        seccionComodines.setAlignment(Pos.BOTTOM_CENTER);

        //Comodines
        HBox contenedorComodines = new HBox(10);
        contenedorComodines.setAlignment(Pos.CENTER_LEFT);
        for (Comodin comodin : comodines) {
            Image cartaImagen = new Image(Paths.get("src/main/java/edu/fiuba/algo3/resources/comodines/" + comodin.getNombre() + ".png").toUri().toString());
            ImageView cartaView = new ImageView(cartaImagen);
            cartaView.setFitWidth(72);
            cartaView.setFitHeight(108);

            //nuevo
            ComodinSeleccionadoHandler handler = new ComodinSeleccionadoHandler(comodin, cartaView, sonidoClick, comodinesSeleccionados, mensajeTemporalComodin);
            cartaView.setOnMouseClicked(event -> handler.handle(new ActionEvent()));
            contenedorComodines.getChildren().add(cartaView);
        }

        VBox seccionTarots = new VBox(10);
        seccionTarots.setAlignment(Pos.BOTTOM_CENTER);

        //Tarots
        HBox contenedorTarot = new HBox(10);
        contenedorTarot.setAlignment(Pos.CENTER);
        for (Tarot tarot : tarots) {
            Image cartaImagen = new Image(Paths.get("src/main/java/edu/fiuba/algo3/resources/tarots/" + tarot.getNombre() + ".png").toUri().toString());
            ImageView cartaView = new ImageView(cartaImagen);
            cartaView.setFitWidth(72);
            cartaView.setFitHeight(108);

            //nuevo
            TarotSeleccionadoHandler handler = new TarotSeleccionadoHandler(tarot, cartaView, sonidoClick, tarotsSeleccionados, mensajeTemporalTarot);
            cartaView.setOnMouseClicked(event -> handler.handle(new ActionEvent()));
            contenedorTarot.getChildren().add(cartaView);
        }

        VBox seccionCarta = new VBox(10);
        seccionCarta.setAlignment(Pos.BOTTOM_CENTER);

        //Cartas
        HBox contenedorCartaEspecifica = new HBox(10);
        contenedorCartaEspecifica.setAlignment(Pos.CENTER_RIGHT);
        if (cartaEspecifica != null) {
            String rutaImagenCarta = "src/main/java/edu/fiuba/algo3/resources/cartas/" +
                    cartaEspecifica.numero() + "_" + cartaEspecifica.getPalo() + ".jpg";
            ImageView cartaView = new ImageView(new Image(Paths.get(rutaImagenCarta).toUri().toString()));
            cartaView.setFitWidth(72);
            cartaView.setFitHeight(108);

            // Agregar evento de clic si es necesario
            CartaTiendaSeleccionadaHandler handler = new CartaTiendaSeleccionadaHandler(cartaEspecifica, cartaView, sonidoClick, cartasEspecificas, mensajeTemporalCarta);
            cartaView.setOnMouseClicked(event -> handler.handle(new ActionEvent()));

            // Añadir la carta específica al contenedor
            contenedorCartaEspecifica.getChildren().add(cartaView);
        } else {
            System.out.println("No hay carta específica en la tienda.");
        }

        seccionComodines.getChildren().addAll(tituloComodines, contenedorComodines);
        seccionTarots.getChildren().addAll(tituloTarots, contenedorTarot);
        seccionCarta.getChildren().addAll(tituloCarta, contenedorCartaEspecifica);

        seccionTienda.getChildren().addAll(seccionComodines, seccionTarots, seccionCarta);

        //Fondo
        StackPane stackPane = new StackPane();
        String rutaFondo = FONDO_TIENDA;
        Image imagenFondo = new Image(Paths.get(rutaFondo).toUri().toString());
        BackgroundImage fondo = new BackgroundImage(imagenFondo, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
        Background background = new Background(fondo);
        stackPane.setBackground(background);

        //Botones
        BotonComprarHandler botonComprarHandler = new BotonComprarHandler(tiendaStage,comodinesSeleccionados,tarotsSeleccionados,cartasEspecificas);
        BotonComprar botonComprar = new BotonComprar(botonComprarHandler);

        BotonOmitirHandler botonOmitirHandler = new BotonOmitirHandler(tiendaStage);
        BotonOmitir botonOmitir = new BotonOmitir(botonOmitirHandler);

        HBox botonesBox = new HBox(20, botonComprar, botonOmitir);
        botonesBox.setAlignment(Pos.CENTER);

        VBox layout = new VBox(50, titulo, subtitulo, seccionTienda, botonesBox);
        layout.setAlignment(Pos.CENTER);
        layout.setPadding(new Insets(20));


        stackPane.getChildren().addAll(layout, mensajeTemporalComodin, mensajeTemporalTarot);

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

    public static void reiniciarContador(){
        contador = 0;
    }

    // Método para crear títulos con estilos
    private static Text crearTitulo(String texto) {
        Text titulo = new Text(texto);
        titulo.setFont(cargarFuente(FUENTE_TIENDA,10)); // Tamaño de la fuente ajustable
        titulo.setFill(Color.YELLOW);
        titulo.setStyle("-fx-font-weight: bold; -fx-opacity: 0.8;"); // Estilo semitransparente
        return titulo;
    }
}

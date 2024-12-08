package edu.fiuba.algo3.vistas.pantalla;

import edu.fiuba.algo3.controllers.BotonDescartarHandler;
import edu.fiuba.algo3.controllers.BotonJugarManoHandler;
import edu.fiuba.algo3.controllers.CartaSeleccionadaHandler;
import edu.fiuba.algo3.modelo.carta.Carta;
import edu.fiuba.algo3.modelo.comodin.Comodin;
import edu.fiuba.algo3.modelo.juego.Juego;
import edu.fiuba.algo3.modelo.tarot.Tarot;
import edu.fiuba.algo3.vistas.boton.BotonDescartar;
import edu.fiuba.algo3.vistas.boton.BotonJugarMano;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.media.AudioClip;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ParteDerecha {
    private final BorderPane parteDerecha;
    private final Juego juego;
    private static ParteIzquierda parteIzquierda;
    private static HBox visualCartas;
    private static Text cartasRestantesText;
    private PantallaJuego pantallaJuego;
    private VBox comodinesBox;
    private VBox tarotsBox;

    public ParteDerecha(Juego juego, ParteIzquierda parteIzquierda) {
        this.juego = juego;
        this.parteIzquierda = parteIzquierda;
        this.parteDerecha = new BorderPane();
        inicializarUI();
    }

    private void inicializarUI() {
        StackPane centro = new StackPane();

        // Cartas del jugador: inicialmente vacío, pero se llenará automáticamente
        visualCartas = new HBox();
        visualCartas.setSpacing(5);
        visualCartas.setAlignment(Pos.CENTER);

        // Llama a repartirCartas para inicializar las cartas desde el comienzo
        juego.repartirCartasJugador(8);
        List<Carta> cartasSeleccionadas = new ArrayList<>();

        // Comodines y Tarots
        HBox comodinesTarots = crearComodinesTarots();
        parteDerecha.setTop(comodinesTarots);

        // Botones y Mazo
        HBox contenidoInferior = crearContenidoInferior(cartasSeleccionadas);
        parteDerecha.setBottom(contenidoInferior);

        // Visualizacion de cartas en la mano
        visualizarCartas(cartasSeleccionadas);
        centro.getChildren().add(visualCartas);
        parteDerecha.setCenter(centro);

        parteDerecha.setPadding(new Insets(10));
    }


    private HBox crearComodinesTarots() {
        HBox comodinesTarots = new HBox();
        comodinesTarots.setSpacing(20);
        comodinesTarots.setAlignment(Pos.CENTER);

        // Comodines
        Rectangle comodines = new Rectangle(200, 80);
        comodines.setStyle("-fx-fill: #ffffff; -fx-stroke: black; -fx-stroke-width: 1;");
        int cantidadComodines = juego.comodinesRonda();
        Text cantidadComodinesText = new Text(cantidadComodines + "/5");
        cantidadComodinesText.setStyle("-fx-font-size: 0.8em; -fx-fill: #efe7e7;");
        VBox comodinesBox = new VBox(comodines, cantidadComodinesText);

        // Tarots
        Rectangle tarots = new Rectangle(120, 80);
        tarots.setStyle("-fx-fill: #ffffff; -fx-stroke: black; -fx-stroke-width: 1;");
        int cantidadTarots = 0;
        Text cantidadTarotsText = new Text(cantidadTarots + "/2");
        cantidadTarotsText.setStyle("-fx-font-size: 0.8em; -fx-fill: #ffffff;");
        VBox tarotsBox = new VBox(tarots, cantidadTarotsText);

        comodinesTarots.getChildren().addAll(comodinesBox, tarotsBox);
        return comodinesTarots;
    }

    private HBox crearContenidoInferior(List<Carta> cartasSeleccionadas) {
        HBox contenidoInferior = new HBox();
        HBox botones = new HBox();
        botones.setSpacing(20);
        botones.setAlignment(Pos.CENTER);

        // Boton JugarMano
        BotonJugarManoHandler botonJugarManoHandler = new BotonJugarManoHandler(juego, cartasSeleccionadas, parteIzquierda, cartasRestantesText);
        BotonJugarMano botonJugarMano = new BotonJugarMano(botonJugarManoHandler);

        // Boton Descartar
        BotonDescartarHandler botonDescartarHandler = new BotonDescartarHandler(juego,  cartasSeleccionadas, parteIzquierda, cartasRestantesText);
        BotonDescartar botonDescartar = new BotonDescartar(botonDescartarHandler);

        botones.getChildren().addAll(botonJugarMano, botonDescartar);

        // Mazo
        String rutaImagen = "src/main/java/edu/fiuba/algo3/resources/cartas/reverso.png";
        Image imagen = new Image(Paths.get(rutaImagen).toUri().toString());
        ImageView imageView = new ImageView(imagen);
        imageView.setFitWidth(100);
        imageView.setFitHeight(150);

        cartasRestantesText = new Text(juego.getMazo().cartasRestantes() + "/" + juego.getCartasTotalesMazo());
        cartasRestantesText.setFont(Font.font("Arial", 16));
        cartasRestantesText.setStyle("-fx-font-size: 0.8em; -fx-fill: #ffffff;");

        VBox imagenYTexto = new VBox(10, imageView, cartasRestantesText);
        imagenYTexto.setAlignment(Pos.CENTER_RIGHT);

        HBox botonesYMazo = new HBox(80, botones, imagenYTexto);
        contenidoInferior.getChildren().add(botonesYMazo);

        return contenidoInferior;
    }

    public static void visualizarCartas(List<Carta> cartasSeleccionadas) {
        Juego juego = Juego.getInstance();
        cartasRestantesText.setText(juego.getMazo().cartasRestantes() + "/" + juego.getCartasTotalesMazo());
        actualizarVisualCartas(cartasSeleccionadas);
    }

    public static void actualizarVisualCartas(List<Carta> cartasSeleccionadas) {
        visualCartas.getChildren().clear();
        String rutaSonido = "src/main/java/edu/fiuba/algo3/resources/sonidos/click.mp3";
        AudioClip sonido = new AudioClip(Paths.get(rutaSonido).toUri().toString());
        Juego juego = Juego.getInstance();
        for (Carta carta : juego.jugadoresCartasActuales()) {
            ImageView imagenCarta = new ImageView(new Image(Paths.get("src/main/java/edu/fiuba/algo3/resources/cartas/" + carta.numero() + "_" + carta.getPalo() + ".jpg").toUri().toString()));
            imagenCarta.setFitWidth(56);
            imagenCarta.setFitHeight(84);
            CartaSeleccionadaHandler seleccion = new CartaSeleccionadaHandler(cartasSeleccionadas, carta, imagenCarta, sonido, parteIzquierda);
            imagenCarta.setOnMouseClicked(event -> seleccion.handle(new ActionEvent()));
            visualCartas.getChildren().add(imagenCarta);
        }
    }

    public BorderPane crearParteDerecha() {
        return parteDerecha;
    }

    /*
    public VBox actualizarComodines(List<Comodin> comodinesSeleccionados) {
        this.comodinesBox.getChildren().clear();
        for (Comodin comodin : comodinesSeleccionados) {
            Image comodinImagen = new Image(Paths.get("src/main/java/edu/fiuba/algo3/resources/comodines/" + comodin.getNombre() + ".png").toUri().toString());
            ImageView cartaView = new ImageView(comodinImagen);
            cartaView.setFitWidth(56); // Ancho de las cartas
            cartaView.setFitHeight(84); // Alto de las cartas

            this.comodinesBox.getChildren().add(cartaView);
        }

        return comodinesBox;
    }
    */

    public void actualizarTarots(List<Tarot> tarotsSeleccionados) {
        this.tarotsBox.getChildren().clear();
        for (Tarot tarot : tarotsSeleccionados) {
            Image cartaImagen = new Image(Paths.get("src/main/java/edu/fiuba/algo3/resources/tarots/" + tarot.getNombre() + ".png").toUri().toString());
            ImageView cartaView = new ImageView(cartaImagen);
            cartaView.setFitWidth(56); // Ancho de las cartas
            cartaView.setFitHeight(84); // Alto de las cartas

            this.tarotsBox.getChildren().add(cartaView);
        }
    }
}

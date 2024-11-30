package edu.fiuba.algo3.vistas.pantalla;

import edu.fiuba.algo3.modelo.carta.Carta;
import edu.fiuba.algo3.modelo.juego.Jugador;
import edu.fiuba.algo3.modelo.juego.Mazo;
import edu.fiuba.algo3.modelo.juego.Ronda;
import edu.fiuba.algo3.vistas.boton.AccionBoton;
import edu.fiuba.algo3.vistas.boton.BotonHandler;
import edu.fiuba.algo3.vistas.boton.Descartar;
import edu.fiuba.algo3.vistas.boton.JugarMano;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ParteDerecha {
    private final BorderPane parteDerecha;
    private Mazo mazo;
    private Jugador jugador;
    private Ronda ronda;
    private List<Carta> cartasSeleccionadas;
    private Text cartasRestantesText;
    private HBox visualCartas;
    private List<Carta> cartas;

    public ParteDerecha(Mazo mazo, Ronda ronda, Jugador jugador, List<Carta> cartas, List<Carta> cartasSeleccionadas) {
        this.parteDerecha = new BorderPane();
        this.mazo = mazo;
        this.jugador = jugador;
        this.ronda = ronda;
        this.cartas = cartas;
        this.cartasSeleccionadas = cartasSeleccionadas;

        // Crear un BorderPane para el mensaje inicial
        StackPane mensajeCentro = new StackPane();
        Text mensajeInstruccion = new Text("Tocá el mazo para comenzar");
        mensajeInstruccion.setStyle("-fx-fill: #ff0000; -fx-font-weight: bold;");
        mensajeInstruccion.setFont(new Font(20));
        mensajeCentro.getChildren().add(mensajeInstruccion);
        mensajeCentro.setAlignment(Pos.CENTER);

        // Colocar el StackPane en el centro de la pantalla
        parteDerecha.setCenter(mensajeCentro);

        // Comodines y Tarots
        HBox comodinesTarots = new HBox();
        comodinesTarots.setSpacing(50);
        comodinesTarots.setAlignment(Pos.CENTER);

        int cantidadComodines = ronda.cantidadComodines();
        int cantidadTarots = 0;

        // Comodines
        Rectangle comodines = new Rectangle(200, 80);
        comodines.setStyle("-fx-fill: #ffffff; -fx-stroke: black; -fx-stroke-width: 1;");
        Text cantidadComodinesText = new Text(cantidadComodines + "/5");
        cantidadComodinesText.setStyle("-fx-font-size: 0.8em; -fx-fill: #101010;");
        VBox comodinesBox = new VBox(comodines, cantidadComodinesText);
        comodinesBox.setAlignment(Pos.TOP_LEFT);
        comodinesBox.setSpacing(5);

        // Tarots
        Rectangle tarots = new Rectangle(120, 80);
        tarots.setStyle("-fx-fill: #ffffff; -fx-stroke: black; -fx-stroke-width: 1;");
        Text cantidadTarotsText = new Text(cantidadTarots + "/2");
        cantidadTarotsText.setStyle("-fx-font-size: 0.8em; -fx-fill: #101010;");
        VBox tarotsBox = new VBox(tarots, cantidadTarotsText);
        tarotsBox.setAlignment(Pos.TOP_RIGHT);
        tarotsBox.setSpacing(5);

        comodinesTarots.getChildren().addAll(comodinesBox, tarotsBox);
        parteDerecha.setTop(comodinesTarots);

        // Cartas del jugador: inicialmente vacío
        visualCartas = new HBox();
        visualCartas.setSpacing(10);
        visualCartas.setAlignment(Pos.CENTER);

        // Botones y Mazo
        HBox botones = new HBox();
        botones.setSpacing(20);
        botones.setAlignment(Pos.CENTER_LEFT);

        Button botonJugarMano = new Button("Jugar Mano");
        Button botonDescartar = new Button("Descartar");
        botonJugarMano.setStyle("-fx-font-size: 20px; -fx-background-color: #104ec1;");
        botonDescartar.setStyle("-fx-font-size: 20px; -fx-background-color: #ec1111;");
        AccionBoton accionJugarMano = new JugarMano(jugador, cartasSeleccionadas);
        AccionBoton accionDescartar = new Descartar();
        botonJugarMano.setOnAction(new BotonHandler(accionJugarMano));
        botonDescartar.setOnAction(new BotonHandler(accionDescartar));

        botones.getChildren().addAll(botonJugarMano, botonDescartar);

        // Mazo
        String rutaImagen = "src/main/java/edu/fiuba/algo3/resources/reverso.jpg";
        Image imagen = new Image(Paths.get(rutaImagen).toUri().toString());
        ImageView imageView = new ImageView(imagen);
        imageView.setFitWidth(100);
        imageView.setFitHeight(150);

        int cartasRestantes = mazo.cartasRestantes();
        cartasRestantesText = new Text(cartasRestantes + "/52");
        cartasRestantesText.setFont(Font.font("Arial", 16));

        // Evento al hacer clic en el mazo
        HBox finalVisualCartas = visualCartas;
        imageView.setOnMouseClicked(event -> {
            if (parteDerecha.getCenter() != null) {
                // Eliminar el mensaje de instrucción al hacer clic en el mazo por primera vez
                parteDerecha.setCenter(null);
                // Mostrar las cartas después de hacer clic por primera vez
                parteDerecha.setCenter(finalVisualCartas);
                repartirCartas();
            }
        });

        VBox imagenYTexto = new VBox(10, imageView, cartasRestantesText);
        imagenYTexto.setAlignment(Pos.CENTER_RIGHT);

        // Añadir el HBox con los botones y la imagen
        HBox botonesYMazo = new HBox(40, botones, imagenYTexto);
        VBox contenidoInferior = new VBox(botonesYMazo);
        contenidoInferior.setAlignment(Pos.CENTER_RIGHT);
        parteDerecha.setBottom(contenidoInferior);

        parteDerecha.setPadding(new Insets(10));
    }

    private HBox crearVisualCartas() {
        HBox visualCartas = new HBox();
        visualCartas.setSpacing(10);
        visualCartas.setAlignment(Pos.CENTER);

        for (Carta carta : cartas) {
            ImageView imagenCarta = new ImageView(new Image(Paths.get("src/main/java/edu/fiuba/algo3/resources/" + carta.numero() + "_" + carta.getPalo() + ".jpg").toUri().toString()));
            imagenCarta.setFitWidth(80);
            imagenCarta.setFitHeight(120);

            imagenCarta.setOnMouseClicked(event -> {
                if (cartasSeleccionadas.contains(carta)) {
                    cartasSeleccionadas.remove(carta);
                    imagenCarta.setStyle("-fx-effect: null;");
                } else if (cartasSeleccionadas.size() < 5) {
                    cartasSeleccionadas.add(carta);
                    imagenCarta.setStyle("-fx-effect: dropshadow(gaussian, blue, 10, 0.5, 0, 0);");
                } else {
                    System.out.println("No puedes seleccionar más de 5 cartas.");
                }
            });

            visualCartas.getChildren().add(imagenCarta);
        }

        return visualCartas;
    }

    private void repartirCartas() {
        // Verificar cuántas cartas hay actualmente en pantalla
        if (cartas.size() >= 8) {
            System.out.println("Ya tienes 8 cartas en pantalla, no puedes repartir más.");
            return; // No repartir más cartas si ya hay 8 en pantalla
        }

        // Calcular cuántas cartas necesitamos repartir
        int cartasNecesarias = 8 - cartas.size();

        // Usar un Set para evitar cartas duplicadas
        Set<String> cartasEnPantalla = new HashSet<>(); // Usamos un Set para guardar los identificadores únicos de las cartas

        // Agregar las cartas actuales de la pantalla al Set (con identificador único)
        for (Carta carta : cartas) {
            cartasEnPantalla.add(carta.numero() + "_" + carta.getPalo());
        }

        // Repartir cartas sin duplicados
        List<Carta> nuevasCartas = new ArrayList<>();
        while (nuevasCartas.size() < cartasNecesarias) {
            // Dar una carta desde el mazo
            Carta carta = mazo.darCartas(1).get(0); // darCartas(1) da una carta a la vez

            // Crear un identificador único para la carta
            String idCarta = carta.puntaje() + "_" + carta.getPalo();

            // Verificar si la carta ya ha sido repartida o si ya está en la pantalla
            if (!cartasEnPantalla.contains(idCarta)) {
                nuevasCartas.add(carta);  // Añadir la carta a la lista de nuevas cartas
                cartasEnPantalla.add(idCarta); // Añadir al Set para evitar duplicados en el futuro
            }
        }

        // Si se obtuvieron cartas, agregar al listado de cartas en la pantalla
        if (!nuevasCartas.isEmpty()) {
            cartas.addAll(nuevasCartas); // Agregar las nuevas cartas a la lista
            actualizarVisualCartas();    // Actualizar la visualización de las cartas
        }

        // Actualizar el texto con las cartas restantes
        cartasRestantesText.setText(mazo.cartasRestantes() + "/52");
    }


    private void actualizarVisualCartas() {
        // Limpiar la visualización actual
        visualCartas.getChildren().clear();

        // Agregar las cartas nuevas
        for (Carta carta : cartas) {
            ImageView imagenCarta = new ImageView(new Image(Paths.get("src/main/java/edu/fiuba/algo3/resources/" + carta.puntaje() + "_" + carta.getPalo() + ".jpg").toUri().toString()));
            imagenCarta.setFitWidth(80);
            imagenCarta.setFitHeight(120);

            imagenCarta.setOnMouseClicked(event -> {
                if (cartasSeleccionadas.contains(carta)) {
                    cartasSeleccionadas.remove(carta);
                    imagenCarta.setStyle("-fx-effect: null;");
                } else if (cartasSeleccionadas.size() < 5) {
                    cartasSeleccionadas.add(carta);
                    imagenCarta.setStyle("-fx-effect: dropshadow(gaussian, blue, 10, 0.5, 0, 0);");
                } else {
                    System.out.println("No puedes seleccionar más de 5 cartas.");
                }
            });

            visualCartas.getChildren().add(imagenCarta);
        }
    }

    public BorderPane crearParteDerecha() {
        return parteDerecha;
    }
}

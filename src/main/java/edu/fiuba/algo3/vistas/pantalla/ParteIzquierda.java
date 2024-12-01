package edu.fiuba.algo3.vistas.pantalla;

import edu.fiuba.algo3.modelo.juego.Jugador;
import edu.fiuba.algo3.modelo.juego.Ronda;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class ParteIzquierda {

    private final VBox parteIzquierda;

    public ParteIzquierda(Ronda ronda, Jugador jugador) {
        this.parteIzquierda = new VBox();
        parteIzquierda.setAlignment(Pos.TOP_CENTER);
        parteIzquierda.setSpacing(15);
        parteIzquierda.setPadding(new Insets(10, 10, 10, 5));

        // Estilo y colores definidos
        String estiloTextoBlanco = "-fx-font-size: 16px; -fx-font-weight: bold; -fx-text-fill: white;";

        // Sección puntaje ronda
        VBox puntajeSection = new VBox();
        puntajeSection.setAlignment(Pos.CENTER);
        puntajeSection.setSpacing(5);

        StackPane puntajeBox = crearCuadroConValor("Puntaje Min", "300", 100, 200, "#444444", "#666666");

        puntajeSection.getChildren().add(puntajeBox);

        // Puntaje acumulado
        StackPane puntajeAcumuladoBox = crearCuadroConValor("Puntaje Ronda", String.valueOf(ronda.calcularPuntajeRonda()), 100, 200, "#333333", "#555555");

        // Marcador de cartas
        VBox marcadorSection = new VBox();
        marcadorSection.setAlignment(Pos.CENTER);
        marcadorSection.setSpacing(5);

        Label pairLabel = new Label("Par lvl. 1");
        pairLabel.setStyle(estiloTextoBlanco);

        HBox valoresCartas = new HBox();
        valoresCartas.setAlignment(Pos.CENTER);
        valoresCartas.setSpacing(10);

        Label valor1 = new Label("10");
        valor1.setStyle("-fx-font-size: 20px; -fx-font-weight: bold; -fx-text-fill: #104ec1;");

        Label multiplicador = new Label("x");
        multiplicador.setStyle("-fx-font-size: 20px; -fx-font-weight: bold; -fx-text-fill: white;");

        Label valor2 = new Label("2");
        valor2.setStyle("-fx-font-size: 20px; -fx-font-weight: bold; -fx-text-fill: #ec1111;");

        valoresCartas.getChildren().addAll(valor1, multiplicador, valor2);
        marcadorSection.getChildren().addAll(pairLabel, valoresCartas);
        StackPane marcadorBox = crearCuadroConFondo(marcadorSection, 100, 200, "#333333");

        // Turnos y descartes
        HBox turnosDescartes = new HBox();
        turnosDescartes.setAlignment(Pos.CENTER);
        turnosDescartes.setSpacing(10);

        StackPane turnosBox = crearCuadroConValor("Turnos", String.valueOf(ronda.turnoActual()), 80, 100, "#444444", "#666666");
        StackPane descartesBox = crearCuadroConValor("Descartes", "3", 80, 100, "#444444", "#666666");

        turnosDescartes.getChildren().addAll(turnosBox, descartesBox);

        // Ronda y dinero
        HBox rondaYnombre = new HBox();
        rondaYnombre.setAlignment(Pos.CENTER);
        rondaYnombre.setSpacing(10);

        StackPane nombre = crearCuadroConValor("Nombre", jugador.getNombre(), 80, 100, "#444444", "#666666");
        StackPane rondaBox = crearCuadroConValor("Round", "1 / 8", 80, 100, "#444444", "#666666");

        rondaYnombre.getChildren().addAll(nombre, rondaBox);

        // Agregar todo al contenedor principal
        parteIzquierda.getChildren().addAll(
                puntajeSection,
                puntajeAcumuladoBox,
                marcadorBox,
                turnosDescartes,
                rondaYnombre
        );
    }

    public VBox crearParteIzquierda() {
        return parteIzquierda;
    }

    private StackPane crearCuadroConFondo(Node contenido, int alto, int ancho, String colorFondo) {
        Rectangle fondo = new Rectangle(ancho, alto);
        fondo.setArcWidth(10);
        fondo.setArcHeight(10);
        fondo.setFill(Color.web(colorFondo));
        fondo.setStroke(Color.BLACK);
        fondo.setStrokeWidth(2);

        StackPane stackPane = new StackPane();
        stackPane.getChildren().addAll(fondo, contenido);
        return stackPane;
    }

    private StackPane crearCuadroConValor(String label, String valor, int alto, int ancho, String colorFondo, String colorValor) {
        // Fondo del contenedor principal
        Rectangle fondoLabel = new Rectangle(ancho, alto);
        fondoLabel.setArcWidth(10);
        fondoLabel.setArcHeight(10);
        fondoLabel.setFill(Color.web(colorFondo));
        fondoLabel.setStroke(Color.BLACK);
        fondoLabel.setStrokeWidth(1);

        // Texto principal
        Label textoLabel = new Label(label);
        textoLabel.setStyle("-fx-font-size: 14px; -fx-text-fill: white; -fx-font-weight: bold;");

        // Fondo para el valor numérico
        Rectangle fondoValor = new Rectangle(ancho - 20, alto / 2);
        fondoValor.setArcWidth(10);
        fondoValor.setArcHeight(10);
        fondoValor.setFill(Color.web(colorValor));
        fondoValor.setStroke(Color.BLACK);
        fondoValor.setStrokeWidth(1);

        // Texto del valor
        Label textoValor = new Label(valor);
        textoValor.setStyle("-fx-font-size: 16px; -fx-font-weight: bold;");

        StackPane contenedorValor = new StackPane(fondoValor, textoValor);
        contenedorValor.setMaxSize(ancho - 20, alto / 2);

        VBox contenido = new VBox(textoLabel, contenedorValor);
        contenido.setAlignment(Pos.CENTER);
        contenido.setSpacing(5);

        return new StackPane(fondoLabel, contenido);
    }
}

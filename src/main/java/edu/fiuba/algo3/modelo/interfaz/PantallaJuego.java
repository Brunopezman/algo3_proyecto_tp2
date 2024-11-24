package edu.fiuba.algo3.modelo.interfaz;

import edu.fiuba.algo3.Main;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ButtonBar;

public class PantallaJuego {
    private BorderPane root;

    public PantallaJuego(Main main) {
        root = new BorderPane();

        VBox topArea = new VBox();
        Text titulo = new Text("Pantalla de Juego");
        titulo.setStyle("-fx-font-size: 24px; -fx-fill: black;");
        topArea.getChildren().add(titulo);
        topArea.setAlignment(Pos.CENTER);
        root.setTop(topArea);

        VBox bottomArea = new VBox();
        Text textoInferior = new Text("Área inferior");
        textoInferior.setStyle("-fx-font-size: 16px; -fx-fill: black;");
        bottomArea.getChildren().add(textoInferior);
        bottomArea.setAlignment(Pos.CENTER);
        root.setBottom(bottomArea);

        VBox leftArea = new VBox();
        leftArea.setAlignment(Pos.CENTER_LEFT);
        leftArea.setSpacing(15);

        StackPane puntajeNecesario = crearCuadrado("Puntaje necesario: 50", 50, 150, "lightblue");

        StackPane puntajeAcumulado = crearCuadrado("Puntaje acumulado: 20", 50, 150, "lightgreen");

        StackPane marcador = crearCuadrado("10 x 2", 100, 150, "lightyellow");

        HBox turnosDescartes = new HBox();
        turnosDescartes.setSpacing(10);

        StackPane turnosRestantes = crearCuadrado("Turnos: 3", 100, 100, "lightcoral");
        StackPane descartesRestantes = crearCuadrado("Descartes: 2", 100, 100, "lightpink");

        turnosDescartes.getChildren().addAll(turnosRestantes, descartesRestantes);

        StackPane rondaActual = crearCuadrado("Ronda: 1 / 5", 50, 150, "lightgray");

        StackPane botonSalir = crearCuadradoNodos(new Button("Salir"), 150, 50, "lightseagreen");
        Button salir = (Button) botonSalir.getChildren().get(1);

        salir.setOnAction(event -> mostrarConfirmacionSalir(main));

        salir.setStyle("-fx-font-size: 14px; -fx-background-color: #ffcccc;");

        leftArea.getChildren().addAll(
                puntajeNecesario,
                puntajeAcumulado,
                marcador,
                turnosDescartes,
                rondaActual,
                botonSalir
        );

        root.setLeft(leftArea);

        // derecha - mazo
        VBox rightArea = new VBox();
        rightArea.setAlignment(Pos.CENTER);
        rightArea.setSpacing(10);

        Rectangle mazo = new Rectangle(100, 150);
        mazo.setStyle("-fx-fill: darkblue; -fx-stroke: black; -fx-stroke-width: 2;");
        Text cartasRestantes = new Text("40 / 52");
        cartasRestantes.setFont(Font.font("Arial", 16));

        rightArea.getChildren().addAll(mazo, cartasRestantes);
        root.setRight(rightArea);

        VBox centerArea = new VBox();
        Text textoCentro = new Text("Área central de juego");
        textoCentro.setStyle("-fx-font-size: 20px; -fx-fill: black;");
        centerArea.getChildren().add(textoCentro);
        centerArea.setAlignment(Pos.CENTER);
        root.setCenter(centerArea);
    }

    private void mostrarConfirmacionSalir(Main main) {
        Alert alerta = new Alert(AlertType.CONFIRMATION);
        alerta.setTitle("Confirmación de salida");
        alerta.setHeaderText("¿Seguro que deseas salir?");
        alerta.setContentText("Al salir se perderán los avances actuales.");

        ButtonType botonAceptar = new ButtonType("Aceptar");
        ButtonType botonCancelar = new ButtonType("Cancelar", ButtonBar.ButtonData.CANCEL_CLOSE);
        alerta.getButtonTypes().setAll(botonAceptar, botonCancelar);

        alerta.showAndWait().ifPresent(respuesta -> {
            if (respuesta == botonAceptar) {
                main.mostrarPantallaInicial(); // Volver al inicio
            }
        });
    }

    public BorderPane getRoot() {
        return root;
    }

    private StackPane crearCuadrado(String texto, double altura, double anchura, String color) {
        Rectangle rect = new Rectangle(anchura, altura);
        rect.setStyle("-fx-fill: " + color + "; -fx-stroke: black; -fx-stroke-width: 1;");
        Text text = new Text(texto);
        text.setFont(Font.font("Arial", 12));
        StackPane stack = new StackPane(rect, text);
        return stack;
    }

    private StackPane crearCuadradoNodos(Button boton, double altura, double anchura, String color) {
        Rectangle rect = new Rectangle(anchura, altura);
        rect.setStyle("-fx-fill: " + color + "; -fx-stroke: black; -fx-stroke-width: 1;");
        StackPane stack = new StackPane(rect, boton);
        return stack;
    }
}
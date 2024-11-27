module edu.fiuba.algo3 {
    requires javafx.controls;
    requires json.simple;
    requires java.desktop;
    requires com.google.gson;
    opens edu.fiuba.algo3.modelo.dtos to com.google.gson;
    exports edu.fiuba.algo3;
    exports edu.fiuba.algo3.vistas;

//    requires javafx.media;
    exports edu.fiuba.algo3.modelo.interfaz;
    opens edu.fiuba.algo3.modelo.lector to com.google.gson;
}
package edu.fiuba.algo3.modelo.datos;
import com.google.gson.*;
import java.io.FileReader;

public class LectorJson {
    public LectorJson() {}

    public JsonObject obtenerInformacion(String rutaDelArchivo) {
        JsonObject jsonObject = null;
        try (FileReader reader = new FileReader(rutaDelArchivo)) {
            jsonObject = JsonParser.parseReader(reader).getAsJsonObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonObject;
    }
}

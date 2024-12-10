package edu.fiuba.algo3.modelo.lector;
import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import edu.fiuba.algo3.modelo.carta.Carta;
import edu.fiuba.algo3.modelo.dtos.*;
import edu.fiuba.algo3.modelo.juego.Juego;
import edu.fiuba.algo3.modelo.juego.Mazo;
import edu.fiuba.algo3.modelo.juego.Ronda;

import java.io.FileReader;
import java.util.List;

public class LectorJson {
    private Gson gson;
    private JsonObject jsonObject;

    public LectorJson(String rutaDelArchivo) {
        gson = new GsonBuilder()
                .registerTypeAdapter(ComodinBaseDTO.class, new ComodinDeserializador())
                .create();
        try (FileReader reader = new FileReader(rutaDelArchivo)) {
            jsonObject = JsonParser.parseReader(reader).getAsJsonObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public <T> List<T> obtenerInformacionDe(String seccion) {

        JsonArray jsonArray = jsonObject.getAsJsonArray(seccion);
        if (seccion == "rondas") {
            return gson.fromJson(jsonArray, new TypeToken<List<RondaDTO>>() {
            }.getType());
        } else {
            return gson.fromJson(jsonArray, new TypeToken<List<CartaDTO>>() {
            }.getType());
        }
    }
}

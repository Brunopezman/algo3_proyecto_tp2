package edu.fiuba.algo3.modelo.lector;
import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import edu.fiuba.algo3.modelo.dtos.CartaDTO;
import edu.fiuba.algo3.modelo.dtos.RondaDTO;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class LectorJson {
    private Gson gson;
    private JsonObject jsonObject;

    public LectorJson(String rutaDelArchivo) {
        gson = new GsonBuilder().create();
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

    public void ejemploComoSeGuarda() {
        JsonArray rondasArray = jsonObject.getAsJsonArray("rondas");
        List<RondaDTO> rondasDTO = gson.fromJson(rondasArray, new TypeToken<List<RondaDTO>>() {
        }.getType());
        JsonArray cartasArray = jsonObject.getAsJsonArray("mazo");
        List<CartaDTO> mazoDTO = gson.fromJson(cartasArray, new TypeToken<List<CartaDTO>>() {
        }.getType());
        for (CartaDTO cartaDTO : mazoDTO) {
            System.out.println(cartaDTO.getNombre());
        }
        for (RondaDTO rondaDTO : rondasDTO) {
            System.out.println("===================================");
            System.out.println("Ronda nro: " + rondaDTO.getNro());
            System.out.println("Cantidad de turnos: " + rondaDTO.getTurnos());
            System.out.println("Cantidad de descartes: " + rondaDTO.getDescartes());
            System.out.println("Puntos a superar: " + rondaDTO.getPuntajeASuperar());
            System.out.println("Tienda: ");
            System.out.println(" -Comodin: ");
            System.out.println("    *" + rondaDTO.getTienda().getComodines().get(0).getNombre());
            if (rondaDTO.getTienda().getComodines().get(0).getActivacion().isJsonPrimitive()) {
                // Caso 1: Es una cadena (e.g., "Descarte")
                System.out.println("     " + rondaDTO.getTienda().getComodines().get(0).getActivacion().getAsString());
            } else if (rondaDTO.getTienda().getComodines().get(0).getActivacion().isJsonObject()) {
                // Caso 2: Es un objeto JSON (e.g., { "Mano Jugada": "color" } o { "1 en": 250 })
                JsonObject activacionObj = rondaDTO.getTienda().getComodines().get(0).getActivacion().getAsJsonObject();
                String clave = activacionObj.entrySet().iterator().next().getKey();
                System.out.println("     " + activacionObj.get(clave).getAsString());
            } else {
                throw new IllegalArgumentException("Tipo inesperado en activación: " + rondaDTO.getTienda().getComodines().get(0).getActivacion());
            }

            System.out.println("    *" + rondaDTO.getTienda().getComodines().get(1).getNombre());
            if (rondaDTO.getTienda().getComodines().get(1).getActivacion().isJsonPrimitive()) {
                // Caso 1: Es una cadena (e.g., "Descarte")
                System.out.println("     " + rondaDTO.getTienda().getComodines().get(1).getActivacion().getAsString());
            } else if (rondaDTO.getTienda().getComodines().get(1).getActivacion().isJsonObject()) {
                // Caso 2: Es un objeto JSON (e.g., { "Mano Jugada": "color" } o { "1 en": 250 })
                JsonObject activacionObj = rondaDTO.getTienda().getComodines().get(1).getActivacion().getAsJsonObject();
                String clave = activacionObj.entrySet().iterator().next().getKey();
                System.out.println("     " + activacionObj.get(clave).getAsString());
            } else {
                throw new IllegalArgumentException("Tipo inesperado en activación: " + rondaDTO.getTienda().getComodines().get(1).getActivacion());
            }
            System.out.println(" -Tarots: ");
            System.out.println("    *" + rondaDTO.getTienda().getTarots().get(0).getNombre());
            System.out.println("    *" + rondaDTO.getTienda().getTarots().get(1).getNombre());
            System.out.println(" -Carta: ");
            System.out.println("    *" + rondaDTO.getTienda().getCarta().getNombre());

        }
    }
}

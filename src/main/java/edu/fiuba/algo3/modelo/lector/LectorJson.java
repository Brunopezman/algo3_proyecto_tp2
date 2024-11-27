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
//        JsonObject jsonObject = null;
//        try (FileReader reader = new FileReader(rutaDelArchivo)) {
//            jsonObject = JsonParser.parseReader(reader).getAsJsonObject();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        //return jsonObject.getAsJsonArray(seccion);
        //return jsonObject;

        JsonArray jsonArray = jsonObject.getAsJsonArray(seccion);
        if (seccion == "rondas"){
            return gson.fromJson(jsonArray, new TypeToken<List<RondaDTO>>(){}.getType());
        }else {
            return gson.fromJson(jsonArray, new TypeToken<List<CartaDTO>>(){}.getType());
        }
//        JsonArray rondasArray = jsonObject.getAsJsonArray("rondas");
//        List<RondaDTO> rondasDTO = gson.fromJson(rondasArray, new TypeToken<List<RondaDTO>>(){}.getType());
//        JsonArray cartasArray = jsonObject.getAsJsonArray("mazo");
//        List<CartaDTO> mazoDTO = gson.fromJson(cartasArray, new TypeToken<List<CartaDTO>>(){}.getType());
//        for (CartaDTO cartaDTO : mazoDTO) {
//            System.out.println(cartaDTO.getNombre());
//        }
//        for (RondaDTO rondaDTO : rondasDTO) {
//            System.out.println("===================================");
//            System.out.println("Ronda nro: " + rondaDTO.getNro());
//            System.out.println("Cantidad de turnos: " + rondaDTO.getTurnos());
//            System.out.println("Cantidad de descartes: " + rondaDTO.getDescartes());
//            System.out.println("Puntos a superar: " + rondaDTO.getPuntajeASuperar());
//            System.out.println("Tienda: ");
//            System.out.println(" -Comodin: ");
//            System.out.println("    *" + rondaDTO.getTienda().getComodines().get(0).getNombre());
//            System.out.println("    *" + rondaDTO.getTienda().getComodines().get(1).getNombre());
//            System.out.println(" -Tarots: ");
//            System.out.println("    *" + rondaDTO.getTienda().getTarots().get(0).getNombre());
//            System.out.println("    *" + rondaDTO.getTienda().getTarots().get(1).getNombre());
//            System.out.println(" -Carta: ");
//            System.out.println("    *" + rondaDTO.getTienda().getCarta().getNombre());
//        }
    }
}

package edu.fiuba.algo3.modelo.lector;
import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import edu.fiuba.algo3.modelo.dtos.CartaDTO;
import edu.fiuba.algo3.modelo.dtos.RondaDTO;

import java.io.FileReader;
import java.util.List;

public class LectorJson {
    private Gson gson;

    public LectorJson() {}

    public void obtenerInformacion(String rutaDelArchivo) {
        JsonObject jsonObject = null;
        try (FileReader reader = new FileReader(rutaDelArchivo)) {
            jsonObject = JsonParser.parseReader(reader).getAsJsonObject();
        } catch (Exception e) {
            e.printStackTrace();
        }

        Gson gson = new GsonBuilder().create();

//        for (Map.Entry<String, JsonElement> entry : jsonObject.entrySet()) {
//            String nombreSeccion = entry.getKey();
//            JsonElement contenidoSeccion = entry.getValue();
//            if (nombreSeccion.equals("rondas")) {
//                List<Ronda> rondas = gson.fromJson(contenidoSeccion, new TypeToken<List<Ronda>>() {
//                }.getType());
//                //juego.setRondas(rondas);
//                System.out.println("Cargadas " + rondas.size() + " rondas.");
//            } else if (nombreSeccion.equals("mazo")) {
//                List<Carta> cartas = gson.fromJson(contenidoSeccion, new TypeToken<List<Carta>>() {
//                }.getType());
//                // Mazo mazo = new Mazo(cartas);
//                //juego.setMazo(cartas);
//                System.out.println("Cargadas " + cartas.size() + " cartas en el mazo.");
//            }
//        }
        JsonArray rondasArray = jsonObject.getAsJsonArray("rondas");
        List<RondaDTO> rondasDTO = gson.fromJson(rondasArray, new TypeToken<List<RondaDTO>>(){}.getType());
        JsonArray cartasArray = jsonObject.getAsJsonArray("mazo");
        List<CartaDTO> mazoDTO = gson.fromJson(cartasArray, new TypeToken<List<CartaDTO>>(){}.getType());
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
            System.out.println("    *" + rondaDTO.getTienda().getComodines().get(1).getNombre());
            System.out.println(" -Tarots: ");
            System.out.println("    *" + rondaDTO.getTienda().getTarots().get(0).getNombre());
            System.out.println("    *" + rondaDTO.getTienda().getTarots().get(1).getNombre());
            System.out.println(" -Carta: ");
            System.out.println("    *" + rondaDTO.getTienda().getCarta().getNombre());
        }


    }
}

package edu.fiuba.algo3.modelo.dtos;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

public class ComodinDeserializador implements JsonDeserializer<ComodinBaseDTO> {
    @Override
    public ComodinBaseDTO deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
            throws JsonParseException {
        JsonObject jsonObject = json.getAsJsonObject();

        // Verifica si el JSON tiene el atributo "comodines" (indica un ComodinCompuesto)
        if (jsonObject.has("comodines")) {
            ComodinCombinacionDTO compuesto = new ComodinCombinacionDTO();
            compuesto.setNombre(jsonObject.get("nombre").getAsString());
            compuesto.setDescripcion(jsonObject.get("descripcion").getAsString());

            // Deserializar la lista de comodines dentro de "comodines"
            Type listType = new TypeToken<List<ComodinSimpleDTO>>() {
            }.getType();
            List<ComodinSimpleDTO> comodines = context.deserialize(jsonObject.get("comodines"), listType);
            compuesto.setComodines(comodines);
            return compuesto;
        } else {
            // Si no tiene "comodines", es un ComodinSimple
            ComodinSimpleDTO simple = new ComodinSimpleDTO();
            simple.setNombre(jsonObject.get("nombre").getAsString());
            simple.setDescripcion(jsonObject.get("descripcion").getAsString());
            simple.setActivacion(jsonObject.get("activacion"));
            simple.setEfecto(context.deserialize(jsonObject.get("efecto"), EfectoDTO.class));
            return simple;
        }
    }
}

package edu.fiuba.algo3.modelo.dtos;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.util.List;

public class ComodinCombinacionDTO extends ComodinBaseDTO {
    private String nombre;
    private String descripcion;
    private List<ComodinSimpleDTO> comodines;

    public String getNombre() { return nombre; }
    public String getDescripcion() { return descripcion; }
    public EfectoDTO getEfecto() { return new EfectoDTO(); }
    public JsonElement getActivacion() { return new JsonObject(); }
    public List<ComodinSimpleDTO> getComodines() {
        return comodines;
    }
    public void setComodines(List<ComodinSimpleDTO> comodines) {
        this.comodines = comodines;
    }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
    public void setActivacion(JsonElement activacion) { ; }
    public void setEfecto(EfectoDTO efecto) {}
}

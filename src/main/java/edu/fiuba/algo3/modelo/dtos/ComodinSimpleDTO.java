package edu.fiuba.algo3.modelo.dtos;

import com.google.gson.JsonElement;

import java.util.List;

public class ComodinSimpleDTO extends ComodinBaseDTO {
    private String nombre;
    private String descripcion;
    private JsonElement activacion;
    private EfectoDTO efecto;


    public List<ComodinSimpleDTO> getComodines() {
        return List.of();
    }
    public void setComodines(List<ComodinSimpleDTO> comodines) {

    }
    public String getNombre() { return nombre; }
    public String getDescripcion() { return descripcion; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
    public JsonElement getActivacion() { return activacion; }
    public EfectoDTO getEfecto() { return efecto; }
    public void setActivacion(JsonElement activacion) { this.activacion = activacion; }
    public void setEfecto(EfectoDTO efecto) { this.efecto = efecto; }
}

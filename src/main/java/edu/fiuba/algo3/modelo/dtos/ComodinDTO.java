package edu.fiuba.algo3.modelo.dtos;

import com.google.gson.JsonElement;

public class ComodinDTO {
    private String nombre;
    private String descripcion;
    private JsonElement activacion;
    private EfectoDTO efecto;

    public String getNombre() { return nombre; }
    public String getDescripcion() { return descripcion; }
    public JsonElement getActivacion() { return activacion; }
    public EfectoDTO getEfecto() { return efecto; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
    public void setActivacion(JsonElement activacion) { this.activacion = activacion; }
    public void setEfecto(EfectoDTO efecto) { this.efecto = efecto; }
}

package edu.fiuba.algo3.modelo.dtos;

import com.google.gson.JsonElement;

import java.util.List;

public abstract class ComodinBaseDTO {




    public abstract String getNombre();
    public abstract String getDescripcion();
    public abstract JsonElement getActivacion();
    public abstract EfectoDTO getEfecto();
    public abstract List<ComodinSimpleDTO> getComodines();

    public abstract void setNombre(String nombre);
    public abstract void setDescripcion(String descripcion);
    public abstract void setActivacion(JsonElement activacion);
    public abstract void setEfecto(EfectoDTO efecto);
    public abstract void setComodines(List<ComodinSimpleDTO> comodines);


}

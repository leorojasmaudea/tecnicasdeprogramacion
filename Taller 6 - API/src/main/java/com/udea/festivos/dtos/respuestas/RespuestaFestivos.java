package com.udea.festivos.dtos.respuestas;

import com.udea.festivos.entidades.Festivo;

import java.util.Date;
import java.util.List;

public class RespuestaFestivos {
    private String festivo;
    private String fecha;

    public RespuestaFestivos(String festivo, String fecha){
        this.festivo = festivo;
        this.fecha = fecha;
    }

    public String getFecha() {
        return fecha;
    }

    public String getFestivo() {
        return festivo;
    }
}

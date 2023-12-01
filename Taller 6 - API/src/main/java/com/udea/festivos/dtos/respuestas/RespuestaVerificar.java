package com.udea.festivos.dtos.respuestas;

public class RespuestaVerificar {
    boolean esFestivo;
    String mensaje;

    public RespuestaVerificar(boolean esFestivo, String mensaje){
        this.esFestivo = esFestivo;
        this.mensaje = mensaje;
    }

    public boolean getEsFestivo(){
        return esFestivo;
    }

    public String getMensaje() {
        return mensaje;
    }
}

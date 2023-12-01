package com.udea.festivos.controladores;

import com.udea.festivos.dtos.respuestas.RespuestaFestivos;
import com.udea.festivos.dtos.respuestas.RespuestaVerificar;
import com.udea.festivos.servicios.FestivoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/festivos") //URL Base del controlador
public class ControladorFestivos {

    @Autowired
    private FestivoServicio festivoServicio;

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/verificar/{ano}/{mes}/{dia}", method = RequestMethod.GET)
    @ResponseBody
    public RespuestaVerificar verificar(@PathVariable int ano, @PathVariable int mes, @PathVariable int dia) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setLenient(false); // Esto hace que la validación sea más estricta

        try {
            // Intenta parsear la fecha
            Date fecha = sdf.parse(String.format("%d/%d/%d", dia, mes, ano));
            // Si el parseo es exitoso, la fecha es válida, validar si es festivo.
            if (festivoServicio.esFestivo(fecha))
                return new RespuestaVerificar(true, "Es festivo");
            else
                return new RespuestaVerificar(false, "No es festivo");
        } catch (ParseException e) {
            // Si ocurre una excepción, la fecha no es válida
            return new RespuestaVerificar(false, "Fecha no válida");
        }
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/obtener/{ano}", method = RequestMethod.GET)
    @ResponseBody
    public List<RespuestaFestivos> obtener(@PathVariable int ano) {
        return festivoServicio.obtenerFestivos(ano);
    }
}

package com.udea.festivos.controladores;

import com.udea.festivos.FestivosApplication;
import com.udea.festivos.servicios.DatosIniciales;
import com.udea.festivos.servicios.FestivoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@RequestMapping("/festivos") //URL Base del controlador
public class ControladorFestivos {

    @Autowired
    private FestivoServicio festivoServicio;

    @RequestMapping(value="/verificar/{ano}/{mes}/{dia}", method = RequestMethod.GET)
    public String verificar(@PathVariable int ano, @PathVariable int mes, @PathVariable int dia) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setLenient(false); // Esto hace que la validación sea más estricta

        try {
            // Intenta parsear la fecha
            Date fecha = sdf.parse(String.format("%d/%d/%d", dia, mes, ano));
            // Si el parseo es exitoso, la fecha es válida, validar si es festivo.

            return festivoServicio.esFestivo(fecha)?"Es festivo":"No es festivo";
        } catch (ParseException e) {
            // Si ocurre una excepción, la fecha no es válida
            return "Fecha no valida";
        }
    }
}

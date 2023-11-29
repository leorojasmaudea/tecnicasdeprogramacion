package com.udea.festivos.interfaces;
import com.udea.festivos.dtos.Fecha;

import java.util.Date;

public interface IFestivoServicio {
    public boolean esFestivo(Date fecha);
}

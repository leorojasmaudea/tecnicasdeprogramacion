package com.udea.festivos.servicios;

import com.udea.festivos.entidades.Festivo;
import com.udea.festivos.entidades.Tipo;
import com.udea.festivos.repositorios.IFestivoRepositorio;
import com.udea.festivos.repositorios.RepTipo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DatosIniciales {
    private final RepTipo repTipo;
    private final IFestivoRepositorio iFestivoRepositorio;

    @Autowired
    public DatosIniciales(RepTipo repTipo, IFestivoRepositorio iFestivoRepositorio) {
        this.repTipo = repTipo;
        this.iFestivoRepositorio = iFestivoRepositorio;
    }

    public void inicializarDatos(){
        //Inicializacion de datos
        List<Tipo> tipos=new ArrayList<Tipo>();
        tipos.add(new Tipo(1,"Fijo"));
        tipos.add(new Tipo(2,"Ley Puente Festivo"));
        tipos.add(new Tipo(3,"Basado en Pascua"));
        tipos.add(new Tipo(4,"Basado en Pascua y Ley Puente Festivo"));
        repTipo.saveAll(tipos);

        List<Festivo> festivos=new ArrayList<Festivo>();
        festivos.add(new Festivo(1, 1, "Año nuevo", new Tipo(1), 0));
        festivos.add(new Festivo(6, 1, "Santos Reyes", new Tipo(2), 0));
        festivos.add(new Festivo(19, 3, "San José", new Tipo(2), 0));
        festivos.add(new Festivo(0, 0, "Jueves Santo", new Tipo(3), -3));
        festivos.add(new Festivo(0, 0, "Viernes Santo", new Tipo(3), -2));
        festivos.add(new Festivo(0, 0, "Domingo de Pascua", new Tipo(3), 0));
        festivos.add(new Festivo(1, 5, "Día del Trabajo", new Tipo(1), 0));
        festivos.add(new Festivo(0, 0, "Ascensión del Señor", new Tipo(4), 40));
        festivos.add(new Festivo(0, 0, "Corpus Christi", new Tipo(4), 61));
        festivos.add(new Festivo(0, 0, "Sagrado Corazón de Jesús", new Tipo(4), 68));
        festivos.add(new Festivo(29, 6, "San Pedro y San Pablo", new Tipo(2), 0));
        festivos.add(new Festivo(20, 7, "Independencia Colombia", new Tipo(1), 0));
        festivos.add(new Festivo(7, 8, "Batalla de Boyacá", new Tipo(1), 0));
        festivos.add(new Festivo(15, 8, "Asunción de la Virgen", new Tipo(2), 0));
        festivos.add(new Festivo(12, 10, "Día de la Raza", new Tipo(2), 0));
        festivos.add(new Festivo(1, 11, "Todos los santos", new Tipo(2), 0));
        festivos.add(new Festivo(11, 11, "Independencia de Cartagena", new Tipo(2), 0));
        festivos.add(new Festivo(8, 12, "Inmaculada Concepción", new Tipo(1), 0));
        festivos.add(new Festivo(25, 12, "Navidad", new Tipo(1), 0));
        iFestivoRepositorio.saveAll(festivos);
    }

}

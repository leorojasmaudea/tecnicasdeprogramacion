package com.udea.festivos;

import com.udea.festivos.entidades.Tipo;
import com.udea.festivos.servicios.DatosIniciales;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@EnableWebMvc
public class FestivosApplication {
	public static ConfigurableApplicationContext context;

	public static void main(String[] args) {
		context = SpringApplication.run(FestivosApplication.class, args);
		//Inicializacion de datos
		DatosIniciales datosIniciales=context.getBean(DatosIniciales.class);
		datosIniciales.inicializarDatos();
	}

}

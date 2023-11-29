package com.udea.festivos.entidades;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;
@Entity
public class Tipo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "secuencia_tipo")
    @GenericGenerator(name = "secuencia_tipo", strategy = "increment")
    private int id;

    @Column(length = 100, unique = true)
    private String tipo;

    public Tipo() {
    }
    public Tipo(int id, String nombre) {
        this.id = id;
        this.tipo = nombre;
    }

    public Tipo(int id) {
        this.id= id;
    }

    public int getId() {
        return id;
    }
}

package com.udea.festivos.entidades;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Festivo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "secuencia_festivo")
    @GenericGenerator(name = "secuencia_festivo", strategy = "increment")
    private long id;

    @Column(length = 100, nullable = false)
    private String nombre;

    @Column(nullable = false)
    private int dia;

    @Column(nullable = false)
    private int mes;

    @Column(nullable = false)
    private int diasPascua;

    @ManyToOne
    @JoinColumn(name = "idTipo", referencedColumnName = "id")
    private Tipo idTipo;

    @Transient
    private Date date;

    public Festivo(){}
    public Festivo(int dia, int mes, String nombre, Tipo idTipo, int diaspascua) {
        this.dia = dia;
        this.mes = mes;
        this.nombre = nombre;
        this.idTipo = idTipo;
        this.diasPascua = diaspascua;
    }

    public Tipo getTipo() {
        return idTipo;
    }

    public int getDiasPascua() {
        return diasPascua;
    }

    public int getMes() {
        return mes;
    }

    public int getDia() {
        return dia;
    }

    public Date getFecha() {
        return date;
    }

    public void setFecha(Date date) {
        this.date = date;
    }
}

/*
@Entity
@Table(name = "campeonato")
public class Campeonato {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "secuencia_campeonato")
    @GenericGenerator(name = "secuencia_campeonato", strategy = "increment")
    @Column(name = "id")
    private long id;

    @Column(name = "campeonato", length = 100, unique = true)
    private String nombre;

    @ManyToOne
    @JoinColumn(name = "idpais", referencedColumnName = "id")
    private Seleccion seleccion;

    @Column(name = "año", nullable = false)
    private int año;

    @JsonIgnore
    @OneToMany(mappedBy = "campeonato")
    private List<Grupo> grupos = new ArrayList<>();

    public Campeonato() {
    }

    public Campeonato(long id, String nombre, Seleccion seleccion, int año) {
        this.id = id;
        this.nombre = nombre;
        this.seleccion = seleccion;
        this.año = año;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Seleccion getSeleccion() {
        return seleccion;
    }

    public void setSeleccion(Seleccion seleccion) {
        this.seleccion = seleccion;
    }

    public int getAño() {
        return año;
    }

    public void setAño(int año) {
        this.año = año;
    }

    public List<Grupo> getGrupos() {
        return grupos;
    }

    public void setGrupos(List<Grupo> grupos) {
        this.grupos = grupos;
    }
}*/

package com.udea.festivos.dtos;

public class Fecha {
    private long ano;
    private long mes;
    private long dia;

    public Fecha() {
    }

    public Fecha(long ano, long mes, long dia) {
        this.ano = ano;
        this.mes = mes;
        this.dia = dia;
    }

    public long getAno() {
        return ano;
    }

    public void setAno(long ano) {
        this.ano = ano;
    }

    public long getMes() {
        return mes;
    }

    public void setMes(long mes) {
        this.mes = mes;
    }

    public long getDia() {
        return dia;
    }

    public void setDia(long dia) {
        this.dia = dia;
    }
}

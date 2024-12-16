package com.fundacao.ponto.entity.DTO;

import java.time.YearMonth;

public class PontosMensaisDTO {
    private String projetoNome;
    private YearMonth mes;
    private Double horas;

    public PontosMensaisDTO() {
    }

    public PontosMensaisDTO(String projetoNome, YearMonth mes, Double horas) {
        this.projetoNome = projetoNome;
        this.mes = mes;
        this.horas = horas;
    }

    public String getProjetoNome() {
        return projetoNome;
    }

    public void setProjetoNome(String projetoNome) {
        this.projetoNome = projetoNome;
    }

    public YearMonth getMes() {
        return mes;
    }

    public void setMes(YearMonth mes) {
        this.mes = mes;
    }

    public Double getHoras() {
        return horas;
    }

    public void setHoras(Double horas) {
        this.horas = horas;
    }
}

package com.fundacao.ponto.entity.DTO;

import java.time.LocalDate;
import java.time.LocalTime;


public class PontoComUsuarioDTO {
    private long pontoId;
    private LocalTime horaInicial;
    private LocalTime horaFinal;
    private LocalDate data;
    private Double horasFeitas;
    private String descricao;
    private boolean ativo;

    private Integer usuarioId;
    private String usuarioNome;

    public PontoComUsuarioDTO() {
    }

    public PontoComUsuarioDTO(long pontoId, LocalTime horaInicial, LocalTime horaFinal, LocalDate data, Double horasFeitas, String descricao, boolean ativo, Integer usuarioId, String usuarioNome) {
        this.pontoId = pontoId;
        this.horaInicial = horaInicial;
        this.horaFinal = horaFinal;
        this.data = data;
        this.horasFeitas = horasFeitas;
        this.descricao = descricao;
        this.ativo = ativo;
        this.usuarioId = usuarioId;
        this.usuarioNome = usuarioNome;
    }

    public long getPontoId() {
        return pontoId;
    }

    public void setPontoId(long pontoId) {
        this.pontoId = pontoId;
    }

    public LocalTime getHoraInicial() {
        return horaInicial;
    }

    public void setHoraInicial(LocalTime horaInicial) {
        this.horaInicial = horaInicial;
    }

    public LocalTime getHoraFinal() {
        return horaFinal;
    }

    public void setHoraFinal(LocalTime horaFinal) {
        this.horaFinal = horaFinal;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public Double getHorasFeitas() {
        return horasFeitas;
    }

    public void setHorasFeitas(Double horasFeitas) {
        this.horasFeitas = horasFeitas;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public Integer getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Integer usuarioId) {
        this.usuarioId = usuarioId;
    }

    public String getUsuarioNome() {
        return usuarioNome;
    }

    public void setUsuarioNome(String usuarioNome) {
        this.usuarioNome = usuarioNome;
    }
}
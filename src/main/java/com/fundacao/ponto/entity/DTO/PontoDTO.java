package com.fundacao.ponto.entity.DTO;

import java.time.LocalDate;
import java.time.LocalTime;

public class PontoDTO {
    private long id;
    private LocalTime horaInicial;
    private LocalTime horaFinal;
    private LocalDate data;
    private String usuarioRfid;
    private Integer usuarioId;
    private Double horasFeitas;
    private String descricao;
    private boolean ativo;

    public PontoDTO(LocalTime horaInicial, LocalDate data, String usuarioRfid, Integer usuarioId, String descricao, boolean ativo) {
        this.usuarioRfid = usuarioRfid;
        this.usuarioId = usuarioId;
        this.horaInicial = horaInicial;
        this.data = data;
        this.descricao = descricao;
        this.ativo = ativo;
    }

    public PontoDTO(String descricao, String usuarioRfid, Integer usuarioId, LocalDate data, LocalTime horaFinal, LocalTime horaInicial, boolean ativo) {
        this.descricao = descricao;
        this.usuarioRfid = usuarioRfid;
        this.usuarioId = usuarioId;
        this.data = data;
        this.horaFinal = horaFinal;
        this.horaInicial = horaInicial;
        this.ativo = ativo;
    }

    public PontoDTO() {
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getHorasFeitas() {
        return horasFeitas;
    }

    public void setHorasFeitas(Double horasFeitas) {
        this.horasFeitas = horasFeitas;
    }

    public Integer getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Integer usuarioId) {
        this.usuarioId = usuarioId;
    }

    public String getUsuarioRfid() {
        return usuarioRfid;
    }

    public void setUsuarioRfid(String usuarioRfid) {
        this.usuarioRfid = usuarioRfid;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public LocalTime getHoraFinal() {
        return horaFinal;
    }

    public void setHoraFinal(LocalTime horaFinal) {
        this.horaFinal = horaFinal;
    }

    public LocalTime getHoraInicial() {
        return horaInicial;
    }

    public void setHoraInicial(LocalTime horaInicial) {
        this.horaInicial = horaInicial;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}


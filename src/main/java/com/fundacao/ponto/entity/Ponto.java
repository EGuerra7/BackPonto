package com.fundacao.ponto.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;


@Table(name = "bancodehoras")
@Entity
public class Ponto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "HoraInicial")
    private LocalTime horaInicial;

    @Column(name = "HoraFinal")
    private LocalTime horaFinal;

    @Column(name = "data")
    private LocalDate data;

    @Column(name = "usuarioRfid")
    private String usuarioRfid;

    @Column(name = "usuarioId")
    private Integer usuarioId;

    @Column(name = "HorasFeitas")
    private Double horasFeitas;

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "ativo")
    private boolean ativo;



    public Ponto(LocalTime horaInicial, LocalDate data, String usuarioRfid, Integer usuarioIdentificador ,String descricao, boolean ativo) {
        this.usuarioRfid = usuarioRfid;
        this.usuarioId = usuarioIdentificador;
        this.horaInicial = horaInicial;
        this.data = data;
        this.descricao = descricao;
        this.ativo = ativo;
    }

    public void calcularHoras(LocalTime horaInicial,LocalTime horaFinal){
        this.horaFinal = horaFinal;

        // Calcular a diferença em minutos entre Hora Inicial e Hora Final
        double minutes = java.time.Duration.between(horaInicial, horaFinal).toMinutes();
        this.horasFeitas = minutes;
    }

    public Ponto(String descricao, String usuarioRfid, Integer usuarioIdentificador, LocalDate data, LocalTime horaFinal, LocalTime horaInicial, boolean ativo) {
        this.descricao = descricao;
        this.usuarioRfid = usuarioRfid;
        this.usuarioId = usuarioIdentificador;
        this.data = data;
        this.horaFinal = horaFinal;
        this.horaInicial = horaInicial;
        this.ativo = ativo;
    }

    public Ponto() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public String getUsuarioRfid() {
        return usuarioRfid;
    }

    public void setUsuarioRfid(String usuarioRfid) {
        this.usuarioRfid = usuarioRfid;
    }

    public Integer getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Integer usuarioId) {
        this.usuarioId = usuarioId;
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
}

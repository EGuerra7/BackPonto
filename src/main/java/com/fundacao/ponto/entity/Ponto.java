package com.fundacao.ponto.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;


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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "projeto_id", nullable = false)
    private Projeto projeto;




    public Ponto(LocalTime horaInicial, LocalDate data, String usuarioRfid, Integer usuarioIdentificador ,String descricao, boolean ativo, Projeto projeto) {
        this.usuarioRfid = usuarioRfid;
        this.usuarioId = usuarioIdentificador;
        this.horaInicial = horaInicial;
        this.data = data;
        this.descricao = descricao;
        this.ativo = ativo;
        this.projeto = projeto;
    }

    public void calcularHoras(LocalTime horaInicial,LocalTime horaFinal){
        this.horaFinal = horaFinal;

        // Calcular a diferença em minutos entre Hora Inicial e Hora Final
        double minutes = java.time.Duration.between(horaInicial, horaFinal).toMinutes();
        this.horasFeitas = minutes;
    }

    public Ponto(LocalTime horaInicial, LocalTime horaFinal, LocalDate data, String usuarioRfid, Integer usuarioId, Double horasFeitas, String descricao, boolean ativo, Projeto projeto) {
        this.horaInicial = horaInicial;
        this.horaFinal = horaFinal;
        this.data = data;
        this.usuarioRfid = usuarioRfid;
        this.usuarioId = usuarioId;
        this.horasFeitas = horasFeitas;
        this.descricao = descricao;
        this.ativo = ativo;
        this.projeto = projeto;
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

    public Projeto getProjeto() {
        return projeto;
    }

    public void setProjeto(Projeto projeto) {
        this.projeto = projeto;
    }
}

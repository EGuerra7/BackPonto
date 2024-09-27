package com.fundacao.ponto.entity.DTO;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@NoArgsConstructor
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
}

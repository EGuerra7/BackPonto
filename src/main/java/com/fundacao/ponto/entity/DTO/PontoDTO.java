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
    private String usuarioId;
    private Integer usuarioIdentificador;
    private Double horasFeitas;
    private String descricao;

    public PontoDTO(LocalTime horaInicial, LocalDate data, String usuarioId, Integer usuarioIdentificador, String descricao) {
        this.usuarioId = usuarioId;
        this.usuarioIdentificador = usuarioIdentificador;
        this.horaInicial = horaInicial;
        this.data = data;
        this.descricao = descricao;
    }

    public PontoDTO(String descricao, String usuarioId, Integer usuarioIdentificador, LocalDate data, LocalTime horaFinal, LocalTime horaInicial) {
        this.descricao = descricao;
        this.usuarioId = usuarioId;
        this.usuarioIdentificador = usuarioIdentificador;
        this.data = data;
        this.horaFinal = horaFinal;
        this.horaInicial = horaInicial;
    }
}

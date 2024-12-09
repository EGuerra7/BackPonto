package com.fundacao.ponto.entity.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;


@Data
@AllArgsConstructor
@NoArgsConstructor
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
}
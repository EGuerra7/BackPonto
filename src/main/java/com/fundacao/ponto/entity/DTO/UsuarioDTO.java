package com.fundacao.ponto.entity.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioDTO {
    private Integer Identificador;
    private String id;
    private String nome;
    private LocalTime cargaHoraria;
    private String cargo;
    private String email;
    private String senha;
    private boolean ativo;
    private String permissao;
}

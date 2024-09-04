package com.fundacao.ponto.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalTime;

@Entity
@Table(name = "usuarios")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer identificador;

    @Column(name = "uid")
    private String id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "cargahoraria")
    private LocalTime cargaHoraria;

    @Column(name = "cargo")
    private String cargo;

    @Column(name = "email")
    private String email;

    @Column(name = "senha")
    private String senha;

    @Column(name = "ativo")
    private boolean ativo;

    @Column(name = "permissao")
    private String permissao;

}

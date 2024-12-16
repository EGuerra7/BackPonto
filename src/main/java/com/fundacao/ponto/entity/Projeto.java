package com.fundacao.ponto.entity;

import jakarta.persistence.*;
import jakarta.persistence.GenerationType;


import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "projetos")
public class Projeto {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "ativo")
    private Boolean ativo;

    @ManyToMany(mappedBy = "projetos")
    private List<Usuario> usuarios = new ArrayList<>();

    @OneToMany(mappedBy = "projeto", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Ponto> pontos = new ArrayList<>();



    public Projeto() {
    }

    public Projeto(Integer id, String nome, Boolean ativo, List<Usuario> usuarios, List<Ponto> pontos) {
        this.id = id;
        this.nome = nome;
        this.ativo = ativo;
        this.usuarios = usuarios;
        this.pontos = pontos;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public List<Ponto> getPontos() {
        return pontos;
    }

    public void setPontos(List<Ponto> pontos) {
        this.pontos = pontos;
    }
}




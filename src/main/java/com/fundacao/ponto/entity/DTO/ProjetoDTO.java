package com.fundacao.ponto.entity.DTO;

import java.util.List;

public class ProjetoDTO {

    private Integer id;

    private String nome;

    private Boolean ativo;


    public ProjetoDTO() {
    }

    public ProjetoDTO(Integer id, String nome, Boolean ativo, List<UsuarioDTO> usuarios) {
        this.id = id;
        this.nome = nome;
        this.ativo = ativo;
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
}

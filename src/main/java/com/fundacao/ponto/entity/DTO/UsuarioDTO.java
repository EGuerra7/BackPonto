package com.fundacao.ponto.entity.DTO;

import com.fundacao.ponto.entity.Projeto;

import java.time.LocalTime;
import java.util.List;


public class UsuarioDTO {
    private Integer id;

    private String rfid;

    private String nome;

    private LocalTime cargaHoraria;

    private String cargo;

    private String email;

    private String senha;

    private boolean ativo;

    private String permissao;

    private List<ProjetoDTO> projetos;


    public UsuarioDTO() {
    }

    public UsuarioDTO(Integer id, String rfid, String nome, LocalTime cargaHoraria, String cargo, String email, String senha, boolean ativo, String permissao, List<ProjetoDTO> projetos) {
        this.id = id;
        this.rfid = rfid;
        this.nome = nome;
        this.cargaHoraria = cargaHoraria;
        this.cargo = cargo;
        this.email = email;
        this.senha = senha;
        this.ativo = ativo;
        this.permissao = permissao;
        this.projetos = projetos;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRfid() {
        return rfid;
    }

    public void setRfid(String rfid) {
        this.rfid = rfid;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalTime getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(LocalTime cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public String getPermissao() {
        return permissao;
    }

    public void setPermissao(String permissao) {
        this.permissao = permissao;
    }

    public List<ProjetoDTO> getProjetos() {
        return projetos;
    }

    public void setProjetos(List<ProjetoDTO> projetos) {
        this.projetos = projetos;
    }
}

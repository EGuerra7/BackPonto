package com.fundacao.ponto.entity.DTO;

import java.time.LocalTime;


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

    public UsuarioDTO() {
    }

    public UsuarioDTO(Integer id, String rfid, String nome, LocalTime cargaHoraria, String cargo, String email, String senha, boolean ativo, String permissao) {
        this.id = id;
        this.rfid = rfid;
        this.nome = nome;
        this.cargaHoraria = cargaHoraria;
        this.cargo = cargo;
        this.email = email;
        this.senha = senha;
        this.ativo = ativo;
        this.permissao = permissao;
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
}

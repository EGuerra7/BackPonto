package com.fundacao.ponto.entity;

import jakarta.persistence.*;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "usuarios")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "rfid")
    private String rfid;

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

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "usuario_projeto",
            joinColumns = @JoinColumn(name = "usuario_id") ,
            inverseJoinColumns =  @JoinColumn(name = "projeto_id")
    )
    private List<Projeto> projetos = new ArrayList<>();

    @Column(name = "permissao")
    private String permissao;



    public Usuario() {
    }

    public Usuario(Integer id, String rfid, String nome, LocalTime cargaHoraria, String cargo, String email, String senha, boolean ativo, String permissao, List<Projeto> projetos) {
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

    public List<Projeto> getProjetos() {
        return projetos;
    }

    public void setProjetos(List<Projeto> projetos) {
        this.projetos = projetos;
    }
}

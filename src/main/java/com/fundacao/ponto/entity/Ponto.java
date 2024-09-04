package com.fundacao.ponto.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Table(name = "bancodehoras")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Ponto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "HoraInicial")
    private LocalTime horaInicial;

    @Column(name = "HoraFinal")
    private LocalTime horaFinal;

    @Column(name = "data")
    private LocalDate data;

    @Column(name = "usuarioRfid")
    private String usuarioRfid;

    @Column(name = "usuarioId")
    private Integer usuarioId;

    @Column(name = "HorasFeitas")
    private Double horasFeitas;

    @Column(name = "descricao")
    private String descricao;



    public Ponto(LocalTime horaInicial, LocalDate data, String usuarioRfid, Integer usuarioIdentificador ,String descricao) {
        this.usuarioRfid = usuarioRfid;
        this.usuarioId = usuarioIdentificador;
        this.horaInicial = horaInicial;
        this.data = data;
        this.descricao = descricao;
    }

    public void calcularHoras(LocalTime horaInicial,LocalTime horaFinal){
        this.horaFinal = horaFinal;

        // Calcular a diferença em minutos entre Hora Inicial e Hora Final
        double minutes = java.time.Duration.between(horaInicial, horaFinal).toMinutes();
        this.horasFeitas = minutes;
    }

    public Ponto(String descricao, String usuarioRfid, Integer usuarioIdentificador, LocalDate data, LocalTime horaFinal, LocalTime horaInicial) {
        this.descricao = descricao;
        this.usuarioRfid = usuarioRfid;
        this.usuarioId = usuarioIdentificador;
        this.data = data;
        this.horaFinal = horaFinal;
        this.horaInicial = horaInicial;
    }
}

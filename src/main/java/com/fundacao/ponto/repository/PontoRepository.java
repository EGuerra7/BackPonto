package com.fundacao.ponto.repository;

import com.fundacao.ponto.entity.DTO.PontoDTO;
import com.fundacao.ponto.entity.Ponto;
import com.fundacao.ponto.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface PontoRepository extends JpaRepository<Ponto, Long> {
    Ponto findByUsuarioIdAndDataAndHoraFinalIsNull(String usuarioId, LocalDate data);
}

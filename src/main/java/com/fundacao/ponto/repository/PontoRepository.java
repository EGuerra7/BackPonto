package com.fundacao.ponto.repository;

import com.fundacao.ponto.entity.DTO.PontoDTO;
import com.fundacao.ponto.entity.Ponto;
import com.fundacao.ponto.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PontoRepository extends JpaRepository<Ponto, Long> {
    Ponto findByUsuarioIdAndDataAndHoraFinalIsNull(String usuarioId, LocalDate data);
    List<Ponto> findByUsuarioIdOrderByDataDesc(String usuarioId);
}

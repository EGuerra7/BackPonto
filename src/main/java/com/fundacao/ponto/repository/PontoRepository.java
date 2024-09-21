package com.fundacao.ponto.repository;


import com.fundacao.ponto.entity.Ponto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.time.LocalDate;
import java.util.List;

@Repository
public interface PontoRepository extends JpaRepository<Ponto, Long> {
    Ponto findByUsuarioRfidAndDataAndHoraFinalIsNull(String usuarioRfid, LocalDate data);
    List<Ponto> findByUsuarioIdOrderByDataDesc(Integer usuarioId);
}

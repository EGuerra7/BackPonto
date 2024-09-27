package com.fundacao.ponto.service;

import com.fundacao.ponto.entity.DTO.PontoDTO;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.List;
import java.util.Map;


public interface PontoService {
    PontoDTO registrarEntrada(PontoDTO ponto);

    PontoDTO registrarSaida(PontoDTO ponto);

    List<PontoDTO> listarPontos();

    List<PontoDTO> listarPontosIndividuais(Integer id);

    Map<YearMonth, Double> listarPorMes(Integer usuarioId);

    PontoDTO ativo(long id, boolean ativo);
}

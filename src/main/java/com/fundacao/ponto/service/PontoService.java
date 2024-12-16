package com.fundacao.ponto.service;

import java.time.YearMonth;
import java.util.List;
import java.util.Map;

import com.fundacao.ponto.entity.DTO.PontoComUsuarioDTO;
import com.fundacao.ponto.entity.DTO.PontoDTO;
import com.fundacao.ponto.entity.DTO.PontosMensaisDTO;
import com.fundacao.ponto.entity.Projeto;


public interface PontoService {
    PontoDTO registrarEntrada(PontoDTO ponto);

    PontoDTO registrarSaida(PontoDTO ponto);

    List<PontoComUsuarioDTO> listarPontos();

    List<PontoDTO> listarPontosIndividuais(Integer id);

    List<PontosMensaisDTO> listarPorMes(Integer usuarioId);

    PontoDTO ativo(long id, boolean ativo);
}

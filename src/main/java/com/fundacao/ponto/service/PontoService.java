package com.fundacao.ponto.service;

import com.fundacao.ponto.entity.DTO.PontoDTO;

import java.util.List;


public interface PontoService {
    PontoDTO registrarEntrada(PontoDTO ponto);

    PontoDTO registrarSaida(PontoDTO ponto);

    List<PontoDTO> listarPontos();

}

package com.fundacao.ponto.service;

import com.fundacao.ponto.entity.DTO.ProjetoDTO;

import java.util.List;

public interface ProjetoService {
    ProjetoDTO criarNovoProjeto(ProjetoDTO projetoDTO);

    List<ProjetoDTO> listarProjetos();

    ProjetoDTO ativo(Integer id, boolean ativo);
}

package com.fundacao.ponto.service;

import java.util.List;

import com.fundacao.ponto.entity.DTO.UsuarioDTO;

public interface UsuarioService {
    UsuarioDTO cadastrar(UsuarioDTO usuarioDTO);
    List<UsuarioDTO> listar();
    UsuarioDTO buscarPorRfid(String rfid);
    UsuarioDTO buscarPorId(Integer id);
    UsuarioDTO login(String email, String senha);
}

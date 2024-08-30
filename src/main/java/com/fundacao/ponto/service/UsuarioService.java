package com.fundacao.ponto.service;

import com.fundacao.ponto.entity.DTO.UsuarioDTO;
import com.fundacao.ponto.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface UsuarioService {
    UsuarioDTO cadastrar(UsuarioDTO usuarioDTO);
    List<UsuarioDTO> listar();
    UsuarioDTO listarUm(String id);
    boolean deletar(String id);
    UsuarioDTO login(String email, String senha);
}

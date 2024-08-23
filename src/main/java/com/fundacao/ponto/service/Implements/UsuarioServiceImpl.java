package com.fundacao.ponto.service.Implements;

import com.fundacao.ponto.entity.DTO.UsuarioDTO;
import com.fundacao.ponto.entity.Usuario;
import com.fundacao.ponto.repository.PontoRepository;
import com.fundacao.ponto.repository.UsuarioRepository;
import com.fundacao.ponto.service.UsuarioService;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UsuarioServiceImpl implements UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private ModelMapper modelMapper;


    public UsuarioDTO cadastrar(UsuarioDTO usuarioDTO){
        Usuario usuario = modelMapper.map(usuarioDTO, Usuario.class);
        usuarioRepository.save(usuario);
        UsuarioDTO DTO = modelMapper.map(usuario, UsuarioDTO.class);
        return DTO;
    }

    public List<UsuarioDTO> listar(){
        Sort ordenar = Sort.by("nome").ascending();
        List<Usuario> usuarios = usuarioRepository.findAll(ordenar).stream().toList();

        return usuarios
            .stream()
            .map(usuario -> modelMapper.map(usuario, UsuarioDTO.class))
            .collect(Collectors.toList());
    }

    @Transactional
    public boolean deletar(String id){
        try {
            usuarioRepository.deleteById(id);
            return true;
        } catch (Exception e){
            return false;
        }
    }
}

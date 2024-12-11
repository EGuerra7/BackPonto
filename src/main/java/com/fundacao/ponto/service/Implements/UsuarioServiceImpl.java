package com.fundacao.ponto.service.Implements;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.fundacao.ponto.entity.DTO.UsuarioDTO;
import com.fundacao.ponto.entity.Usuario;
import com.fundacao.ponto.repository.UsuarioRepository;
import com.fundacao.ponto.service.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public UsuarioDTO cadastrar(UsuarioDTO usuarioDTO){
        Usuario usuario = modelMapper.map(usuarioDTO, Usuario.class);
        usuarioRepository.save(usuario);
        UsuarioDTO DTO = modelMapper.map(usuario, UsuarioDTO.class);
        return DTO;
    }

    @Override
    public List<UsuarioDTO> listar(){
        Sort ordenar = Sort.by(
            Sort.Order.desc("ativo"),
            Sort.Order.asc("nome")
        );
        List<Usuario> usuarios = usuarioRepository.findAll(ordenar).stream().toList();

        return usuarios
            .stream()
            .map(usuario -> modelMapper.map(usuario, UsuarioDTO.class))
            .collect(Collectors.toList());
    }

    @Override
    public UsuarioDTO buscarPorRfid(String rfid){
        Optional<Usuario> usuario = Optional.ofNullable(usuarioRepository.findByRfidAndAtivoIsTrue(rfid));
        UsuarioDTO DTO = modelMapper.map(usuario, UsuarioDTO.class);

        return DTO;
    }

    @Override
    public UsuarioDTO buscarPorId(Integer id) {
        Optional<Usuario> usuario = usuarioRepository.findById(id);
        UsuarioDTO DTO = modelMapper.map(usuario, UsuarioDTO.class);

        return DTO;
    }

    @Override
    public UsuarioDTO login(String email, String senha){
        Usuario usuario = usuarioRepository.findByEmail(email);
        if(usuario == null){
            throw new RuntimeException("Usuário não cadastrado!");
        } else if(!senha.equals(usuario.getSenha())){
            throw new RuntimeException("Senha errada!");
        } else{
            UsuarioDTO DTO = modelMapper.map(usuario, UsuarioDTO.class);
            return DTO;
        }
    }
}

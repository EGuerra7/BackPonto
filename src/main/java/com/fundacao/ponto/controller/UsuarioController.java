package com.fundacao.ponto.controller;

import com.fundacao.ponto.entity.DTO.LoginDTO;
import com.fundacao.ponto.entity.DTO.UsuarioDTO;
import com.fundacao.ponto.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    public UsuarioDTO cadastrar(@RequestBody UsuarioDTO usuarioDTO){
        return usuarioService.cadastrar(usuarioDTO);
    }

    @GetMapping
    public List<UsuarioDTO> listar(){
        return usuarioService.listar();
    }

    @GetMapping("{rfid}")
    public UsuarioDTO listarUm(@PathVariable String rfid){ return usuarioService.listarUm(rfid); }

    @GetMapping("/identificador/{id}")
    public UsuarioDTO listarPorIdentificador(@PathVariable Integer id){ return  usuarioService.listarPorId(id); }

    @PutMapping
    public UsuarioDTO editar(@RequestBody UsuarioDTO usuarioDTO){ return usuarioService.cadastrar(usuarioDTO);}

    @PostMapping("/login")
    public UsuarioDTO login(@RequestBody LoginDTO login){
        return usuarioService.login(login.getEmail(), login.getSenha());
    }

}

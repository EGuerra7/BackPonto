package com.fundacao.ponto.controller;

import com.fundacao.ponto.entity.DTO.UsuarioDTO;
import com.fundacao.ponto.service.PontoService;
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

    @DeleteMapping("{id}")
    public boolean deletar(@PathVariable("id") String id){
        return usuarioService.deletar(id);
    }
}

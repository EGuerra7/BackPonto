package com.fundacao.ponto.controller;

import com.fundacao.ponto.entity.DTO.ProjetoDTO;
import com.fundacao.ponto.service.ProjetoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/projeto")
public class ProjetoController {

    @Autowired
    public ProjetoService projetoService;

    @PostMapping
    public ProjetoDTO criarNovoProjeto(@RequestBody ProjetoDTO projetoDTO){
        return  projetoService.criarNovoProjeto(projetoDTO);
    }

    @GetMapping
    public List<ProjetoDTO> listarProjetos(){
        return  projetoService.listarProjetos();
    }

    @PutMapping("/{id}")
    public ProjetoDTO ativo(@PathVariable Integer id, @RequestBody Map<String, Boolean> ativo){
        return projetoService.ativo(id, ativo.get("ativo"));
    }

}

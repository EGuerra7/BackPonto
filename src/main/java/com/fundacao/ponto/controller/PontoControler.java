package com.fundacao.ponto.controller;

import java.time.YearMonth;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fundacao.ponto.entity.DTO.PontoComUsuarioDTO;
import com.fundacao.ponto.entity.DTO.PontoDTO;
import com.fundacao.ponto.service.PontoService;

@RestController
@RequestMapping("/ponto")
public class PontoControler {

    @Autowired
    private PontoService pontoService;

    @PostMapping
    public PontoDTO registrarEntrada(@RequestBody PontoDTO pontoDTO){
        return pontoService.registrarEntrada(pontoDTO);
    }

    @PutMapping
    public PontoDTO registrarSaida(@RequestBody PontoDTO pontoDTO){
        return pontoService.registrarSaida(pontoDTO);
    }

    @PutMapping("/{id}")
    public PontoDTO ativo(@PathVariable long id, @RequestBody Map<String, Boolean> ativo){ return pontoService.ativo(id, ativo.get("ativo")); }
    
    @GetMapping
    public List<PontoComUsuarioDTO> listarPontos(){
        return pontoService.listarPontos();
    }

    @GetMapping("{usuarioId}")
    public List<PontoDTO> listarPontosIndividuais(@PathVariable Integer usuarioId){
        return pontoService.listarPontosIndividuais(usuarioId);
    }

    @GetMapping("/mensal/{usuarioId}")
    public Map<YearMonth, Double> listarMensal(@PathVariable Integer usuarioId){
        return pontoService.listarPorMes(usuarioId);
    }
}

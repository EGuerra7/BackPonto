package com.fundacao.ponto.controller;

import com.fundacao.ponto.entity.DTO.PontoDTO;
import com.fundacao.ponto.service.PontoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping
    public List<PontoDTO> listarPontos(){
        return pontoService.listarPontos();
    }
}

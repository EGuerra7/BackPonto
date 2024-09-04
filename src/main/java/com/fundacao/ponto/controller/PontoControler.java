package com.fundacao.ponto.controller;

import com.fundacao.ponto.entity.DTO.PontoDTO;
import com.fundacao.ponto.service.PontoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.YearMonth;
import java.util.List;
import java.util.Map;

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

    @GetMapping("{usuarioIdentificador}")
    public List<PontoDTO> listarPontosIndividuais(@PathVariable Integer usuarioIdentificador){
        return pontoService.listarPontosIndividuais(usuarioIdentificador);
    }

    @GetMapping("/mensal/{usuarioIdentificador}")
    public Map<YearMonth, Double> listarMensal(@PathVariable Integer usuarioIdentificador){
        return pontoService.listarPorMes(usuarioIdentificador);
    }
}

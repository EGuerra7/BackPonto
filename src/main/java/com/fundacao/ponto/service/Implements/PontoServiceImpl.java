package com.fundacao.ponto.service.Implements;

import com.fundacao.ponto.entity.DTO.PontoDTO;
import com.fundacao.ponto.entity.Ponto;
import com.fundacao.ponto.repository.PontoRepository;
import com.fundacao.ponto.service.PontoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PontoServiceImpl implements PontoService {
    @Autowired
    private PontoRepository pontoRepository;
    @Autowired
    private ModelMapper modelMapper;

    public PontoDTO registrarEntrada(PontoDTO pontoDTO){
        Ponto buscaPonto = pontoRepository.findByUsuarioIdAndDataAndHoraFinalIsNull(pontoDTO.getUsuarioId(), pontoDTO.getData());
        if(buscaPonto == null) {
            Ponto ponto = modelMapper.map(pontoDTO, Ponto.class);
            if (pontoDTO.getHoraFinal() != null) {
                ponto.calcularHoras(pontoDTO.getHoraInicial(), pontoDTO.getHoraFinal());
                pontoRepository.save(ponto);
            } else {
                pontoRepository.save(ponto);
            }
            PontoDTO DTO = modelMapper.map(ponto, PontoDTO.class);
            return DTO;
        } else {
            throw new RuntimeException("Usuário com ponto em aberto!");
        }
    }

    public PontoDTO registrarSaida(PontoDTO pontoDTO) {

        Ponto buscaPonto = pontoRepository.findByUsuarioIdAndDataAndHoraFinalIsNull(pontoDTO.getUsuarioId(), pontoDTO.getData());

        if (buscaPonto != null) {
            buscaPonto.setHoraFinal(pontoDTO.getHoraFinal());
            buscaPonto.calcularHoras(buscaPonto.getHoraInicial() ,pontoDTO.getHoraFinal());

            Ponto ponto = modelMapper.map(buscaPonto, Ponto.class);
            pontoRepository.save(ponto);
            PontoDTO DTO = modelMapper.map(ponto, PontoDTO.class);
            return DTO;
        } else {
            throw new RuntimeException("Usuário sem ponto em aberto!");
        }
    }

    public List<PontoDTO> listarPontos(){
        Sort ordenarPorData = Sort.by("data").descending();
        List<Ponto> pontos = pontoRepository.findAll(ordenarPorData).stream().toList();

        return pontos
            .stream()
            .map(ponto -> modelMapper.map(ponto, PontoDTO.class))
            .collect(Collectors.toList());
    }

}

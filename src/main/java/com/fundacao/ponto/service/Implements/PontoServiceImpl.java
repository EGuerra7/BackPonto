package com.fundacao.ponto.service.Implements;

import java.time.YearMonth;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.fundacao.ponto.entity.DTO.PontosMensaisDTO;
import com.fundacao.ponto.entity.DTO.ProjetoDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.fundacao.ponto.entity.DTO.PontoComUsuarioDTO;
import com.fundacao.ponto.entity.DTO.PontoDTO;
import com.fundacao.ponto.entity.Ponto;
import com.fundacao.ponto.entity.Usuario;
import com.fundacao.ponto.repository.PontoRepository;
import com.fundacao.ponto.repository.UsuarioRepository;
import com.fundacao.ponto.service.PontoService;

@Service
public class PontoServiceImpl implements PontoService {
    @Autowired
    private PontoRepository pontoRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public PontoDTO registrarEntrada(PontoDTO pontoDTO){
        Ponto buscaPonto = pontoRepository.findByUsuarioRfidAndDataAndHoraFinalIsNullAndAtivoIsTrue(pontoDTO.getUsuarioRfid(), pontoDTO.getData());
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

    @Override
    public PontoDTO registrarSaida(PontoDTO pontoDTO) {

        Ponto buscaPonto = pontoRepository.findByUsuarioRfidAndDataAndHoraFinalIsNullAndAtivoIsTrue(pontoDTO.getUsuarioRfid(), pontoDTO.getData());

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

    @Override
    public List<PontoComUsuarioDTO> listarPontos(){
        Sort ordenarPorData = Sort.by("data").descending();
        List<Ponto> pontos = pontoRepository.findAll(ordenarPorData).stream().toList();

        return pontos.stream()
            .map(ponto -> {
                Usuario usuario = usuarioRepository.findById(ponto.getUsuarioId())
                    .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

                ProjetoDTO projeto = modelMapper.map(ponto.getProjeto(), ProjetoDTO.class);

                return new PontoComUsuarioDTO(
                        ponto.getId(),
                        ponto.getHoraInicial(),
                        ponto.getHoraFinal(),
                        ponto.getData(),
                        ponto.getHorasFeitas(),
                        ponto.getDescricao(),
                        ponto.isAtivo(),
                        usuario.getId(),
                        usuario.getNome(),
                        projeto
                );
            })
            .collect(Collectors.toList());
    }

    @Override
    public List<PontoDTO> listarPontosIndividuais(Integer usuarioId){
        List<Ponto> pontos = pontoRepository.findByUsuarioIdOrderByDataAsc(usuarioId);

        return pontos.stream()
                .map(ponto -> modelMapper.map(ponto, PontoDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<PontosMensaisDTO> listarPorMes(Integer usuarioId){
        List<Ponto> pontos = pontoRepository.findByUsuarioIdOrderByDataAsc(usuarioId);
        return pontos.stream()
            .filter(ponto -> ponto.getHorasFeitas() != null && ponto.isAtivo())
            .collect(Collectors.groupingBy(
                ponto -> YearMonth.from(ponto.getData())
            ))
            .entrySet().stream()
            .flatMap(entry -> entry.getValue().stream()
                .collect(Collectors.groupingBy(
                    Ponto::getProjeto,
                    Collectors.summingDouble(Ponto::getHorasFeitas)
                ))
                .entrySet().stream()
                .map(projetoEntry -> new PontosMensaisDTO(
                    projetoEntry.getKey().getNome(),
                    entry.getKey(),
                    projetoEntry.getValue()
                ))
            )
            .collect(Collectors.toList());
    }

    @Override
    public PontoDTO ativo(long id, boolean ativo){
        Ponto ponto = pontoRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Ponto não encontrado com o id:" + id));
        ponto.setAtivo(ativo);
        pontoRepository.save(ponto);
        PontoDTO DTO = modelMapper.map(ponto, PontoDTO.class);
        return DTO;
    }


}

package com.fundacao.ponto.service.Implements;

import com.fundacao.ponto.entity.DTO.ProjetoDTO;
import com.fundacao.ponto.entity.Projeto;
import com.fundacao.ponto.repository.ProjetoRepository;
import com.fundacao.ponto.service.ProjetoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class ProjetoServiceImpl implements ProjetoService{

    @Autowired
    public ProjetoRepository projetoRepository;

    @Autowired
    public ModelMapper modelMapper;

    @Override
    public ProjetoDTO criarNovoProjeto(ProjetoDTO projetoDTO){
        Projeto projeto = modelMapper.map(projetoDTO, Projeto.class);
        projetoRepository.save(projeto);

        return modelMapper.map(projeto, ProjetoDTO.class);
    }

    @Override
    public List<ProjetoDTO> listarProjetos(){
        Sort organizarPorNome = Sort.by("nome").ascending();
        List<Projeto> projetos = projetoRepository.findAll(organizarPorNome).stream().toList();

        return projetos.stream()
                .map(projeto -> modelMapper.map(projeto, ProjetoDTO.class))
                .collect(Collectors.toList());
    }



    @Override
    public ProjetoDTO ativo(Integer id, boolean ativo){
        Projeto projeto = projetoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Projeto não encontrado com o id:" + id));
        projeto.setAtivo(ativo);
        projetoRepository.save(projeto);

        return modelMapper.map(projeto, ProjetoDTO.class);
    }
}

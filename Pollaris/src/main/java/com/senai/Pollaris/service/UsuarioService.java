package com.senai.Pollaris.service;

import com.senai.Pollaris.dto.HistoricoResponseDTO;
import com.senai.Pollaris.dto.PesquisaRequestDTO;
import com.senai.Pollaris.model.HistoricoPesquisa;
import com.senai.Pollaris.repository.HistoricoPesquisaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsuarioService {

    private final HistoricoPesquisaRepository repository;

    public UsuarioService(HistoricoPesquisaRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public void registrarPesquisa(PesquisaRequestDTO request) {
        if (request.termo() == null || request.termo().isBlank()) {
            throw new IllegalArgumentException("O termo de pesquisa não pode ser vazio.");
        }

        HistoricoPesquisa historico = new HistoricoPesquisa();
        historico.setTermo(request.termo());
        historico.setPerfil(request.perfil());
        historico.setDataPesquisa(LocalDateTime.now());

        repository.save(historico);
    }

    @Transactional(readOnly = true)
    public List<HistoricoResponseDTO> buscarHistorico() {
        return repository.findAll().stream()
                .map(hist -> new HistoricoResponseDTO(
                        hist.getId(),
                        hist.getTermo(),
                        hist.getPerfil(),
                        hist.getDataPesquisa()
                ))
                .collect(Collectors.toList());
    }
}
package com.senai.Pollaris.controller;

import com.senai.Pollaris.dto.HistoricoResponseDTO;
import com.senai.Pollaris.dto.PesquisaRequestDTO;
import com.senai.Pollaris.service.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pesquisas")
public class UsuarioController {

    private final UsuarioService service;

    public UsuarioController(UsuarioService service) {
        this.service = service;
    }

    @PostMapping("/registrar")
    public ResponseEntity<Void> registrarBusca(@RequestBody PesquisaRequestDTO request2) {
        service.registrarPesquisa(request2);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/historico")
    public ResponseEntity<List<HistoricoResponseDTO>> listarHistorico() {
        List<HistoricoResponseDTO> historico = service.buscarHistorico();
        return ResponseEntity.ok(historico);
    }
}
package com.senai.Pollaris.dto;

import com.senai.Pollaris.model.TipoUsuario;
import java.time.LocalDateTime;

public record HistoricoResponseDTO(
        Long id,
        String termo,
        TipoUsuario perfil,
        LocalDateTime dataPesquisa
) {}
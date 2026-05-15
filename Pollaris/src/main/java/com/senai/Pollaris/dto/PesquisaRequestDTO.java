package com.senai.Pollaris.dto;

import com.senai.Pollaris.model.TipoUsuario;

public record PesquisaRequestDTO(
        String termo,
        TipoUsuario perfil
) {}
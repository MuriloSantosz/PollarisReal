package com.senai.Pollaris.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class HistoricoPesquisa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String termo;

    @Enumerated(EnumType.STRING)
    private TipoUsuario perfil;

    private LocalDateTime dataPesquisa;
}
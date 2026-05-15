package com.senai.Pollaris.model;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter

public class Usuario {
    private String nome;
    private String email;
    private String senha;
    private TipoUsuario usuario;

    public Usuario(String nome, String email, String senha, TipoUsuario usuario) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.usuario = usuario;
    }
    public Usuario(){}



}

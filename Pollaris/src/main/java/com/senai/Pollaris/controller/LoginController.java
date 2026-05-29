package com.senai.Pollaris.controller;

import com.senai.Pollaris.model.Usuario;
import com.senai.Pollaris.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping("/login")
    public String mostrarLogin() {
        return "login";
    }

    @PostMapping("/login")
    public String processarLogin(
            @RequestParam("email") String email,
            @RequestParam("senha") String senha,
            Model model) {

        Usuario usuarioEncontrado = usuarioRepository.findByEmail(email);

        if (usuarioEncontrado != null && usuarioEncontrado.getSenha().equals(senha)) {
            return "redirect:/modo";
        } else {
            model.addAttribute("erro", "E-mail ou senha incorretos. Tente novamente.");
            return "login";
        }
    }
}